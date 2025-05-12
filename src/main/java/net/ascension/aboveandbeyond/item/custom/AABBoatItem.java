package net.ascension.aboveandbeyond.item.custom;

import net.ascension.aboveandbeyond.entity.AABEntityTypes;
import net.ascension.aboveandbeyond.entity.custom.AABBoatEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class AABBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final boolean hasChest;

    public AABBoatItem(boolean hasChest, Properties properties) {
        super(properties);
        this.hasChest = hasChest;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 view = player.getViewVector(1.0F);
            List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(view.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vec3 eyePosition = player.getEyePosition();

                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (aabb.contains(eyePosition)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == HitResult.Type.BLOCK) {
                Boat boat = createBoat(level, hitresult);
                boat.setYRot(player.getYRot());
                
                if (!level.noCollision(boat, boat.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!level.isClientSide) {
                        level.addFreshEntity(boat);
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                        if (!player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }

    private AABBoatEntity createBoat(Level level, HitResult hitResult) {
        AABBoatEntity boat = AABEntityTypes.AAB_BOAT.get().create(level);
        
        if (boat != null) {
            boat.setPos(hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
            boat.setHasChest(this.hasChest);
        }
        
        return boat;
    }
}