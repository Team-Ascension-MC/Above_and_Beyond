package net.ascension.aboveandbeyond.item;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class CloudBucket extends SolidBucketItem {
    private final SoundEvent placeSound;

    public CloudBucket(Block block, SoundEvent placeSound, Item.Properties properties) {
        super(block, placeSound, properties);
        this.placeSound = placeSound;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult interactionresult = super.useOn(context);
        Player player = context.getPlayer();
        if (interactionresult.consumesAction() && player != null) {
            player.setItemInHand(context.getHand(), BucketItem.getEmptySuccessItem(context.getItemInHand(), player));
        }

        return interactionresult;
    }

    @Override
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    @Override
    protected SoundEvent getPlaceSound(BlockState state) {
        return this.placeSound;
    }

    @Override
    public boolean emptyContents(@Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult result) {
        if (level.isInWorldBounds(pos) && level.isEmptyBlock(pos)) {
            if (!level.isClientSide) {
                level.setBlock(pos, this.getBlock().defaultBlockState(), 3);
            }
            level.gameEvent(player, GameEvent.FLUID_PLACE, pos);
            level.playSound(player, pos, this.placeSound, SoundSource.BLOCKS, 1.0F, 1.0F);
            return true;
        } else {
            return false;
        }
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        double scale = player.blockInteractionRange() * (player.isShiftKeyDown() ? (double)0.5F : (double)1.0F);
        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = eyePos.add(player.calculateViewVector(player.getXRot(), player.getYRot()).scale(scale));
        BlockHitResult rayTrace = level.clip(new ClipContext(eyePos, lookVec, net.minecraft.world.level.ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
        return new InteractionResultHolder<>(this.useOn(new UseOnContext(player, usedHand, rayTrace)), player.getItemInHand(usedHand));
    }
}