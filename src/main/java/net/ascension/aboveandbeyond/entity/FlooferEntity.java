package net.ascension.aboveandbeyond.entity;

import net.ascension.aboveandbeyond.entity.ai.goal.FlooferRecoverGoal;
import net.ascension.aboveandbeyond.registry.AABEntities;
import net.ascension.aboveandbeyond.registry.AABLootTables;
import net.ascension.aboveandbeyond.registry.AABSounds;
import net.ascension.aboveandbeyond.registry.AABTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

public class FlooferEntity extends Chicken {

    public static final EntityDataAccessor<Boolean> DATA_SNOTTY_ID = SynchedEntityData.defineId(FlooferEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState flappingAnimationState = new AnimationState();
    private boolean isFalling;
    protected float sneezeCounter = -1;

    public FlooferEntity(EntityType<? extends Chicken> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_SNOTTY_ID, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1, stack -> stack.is(AABTags.Items.FLOOFER_FOOD), false));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1, 40));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new FlooferRecoverGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Pig.createAttributes()
                .add(Attributes.MAX_HEALTH, 9.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.getRandom().nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        Vec3 vec3 = this.getDeltaMovement();
        boolean currentlyFalling = !this.onGround() && vec3.y < (double) 0;

        this.isFalling = currentlyFalling;
        if (this.isFalling) {
            this.flappingAnimationState.start(this.tickCount);
        } else {
            this.flappingAnimationState.stop();
        }
    }

    public boolean isSneezing() {
        return this.sneezeCounter > 0;
    }

    public boolean isSnotty() {
        return this.entityData.get(DATA_SNOTTY_ID);
    }

    public void setSnotty(boolean snotty) {
        this.entityData.set(DATA_SNOTTY_ID, snotty);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Snotty",  this.isSnotty());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setSnotty(compound.getBoolean("Snotty"));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.isFood(player.getItemInHand(hand))) {
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(Items.FEATHER)) {
                this.prepareSneeze();
                return InteractionResult.SUCCESS;
            }
        }

        return super.mobInteract(player, hand);
    }

    public void prepareSneeze() {
        this.sneezeCounter = 20;
    }

    public void sneeze() {
        Vec3 vec3 = this.getDeltaMovement();
        Level level = this.level();
        this.level().addParticle(ParticleTypes.SNEEZE,
                this.getX() - (double)(this.getBbWidth() + 1) * (double)0.5F * (double) Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)),
                this.getEyeY() - (double)0.1F,
                this.getZ() + (double)(this.getBbWidth() + 1) * (double)0.5F * (double)Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)),
                vec3.x, 0, vec3.z
        );
        this.playSound(AABSounds.ENTITY_FLOOFER_SNEEZE.get(), 1, 1);
        this.recoil(0.4F);

        if (this.isSnotty()) return;

        this.setSnotty(true);

        if (!level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) return;
        if (level instanceof ServerLevel serverLevel) {
            LootTable table = serverLevel.getServer().reloadableRegistries().getLootTable(AABLootTables.FLOOFER_SNEEZE);
            LootParams parameters = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.ORIGIN, this.position())
                    .withParameter(LootContextParams.THIS_ENTITY, this)
                    .create(LootContextParamSets.GIFT);

            table.getRandomItems(parameters).forEach(this::spawnAtLocation);
        }
    }

    public void recoil(float power) {
        Vec3 vec3 = this.getDeltaMovement();
        float angle = this.yBodyRot * ((float)Math.PI / 180F);
        double knockbackX = Mth.sin(angle) * power;
        double knockbackZ = -Mth.cos(angle) * power;

        this.setDeltaMovement(vec3.add(knockbackX, power / 2, knockbackZ));
        this.hasImpulse = true;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(AABTags.Items.FLOOFER_FOOD);
    }

    @Override
    public FlooferEntity getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return AABEntities.FLOOFER.get().create(level);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }


        if (this.sneezeCounter >= 0) {
            this.sneezeCounter--;
        }
        if (this.sneezeCounter == 0) this.sneeze();
    }

}