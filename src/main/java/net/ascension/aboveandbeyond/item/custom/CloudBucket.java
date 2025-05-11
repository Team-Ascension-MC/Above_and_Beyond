package net.ascension.aboveandbeyond.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.data.SoundDefinition;


import javax.annotation.Nullable;

public class CloudBucket extends SolidBucketItem {
    private final SoundEvent placeSound;

    public CloudBucket() {
        super(block, SoundEvent, placeSound);
        this.placeSound = placeSound;
    }

    public InteractionResult useOn(UseOnContext context) {
        InteractionResult interactionresult = super.useOn(context);
        Player player = context.getPlayer();
        if (interactionresult.consumesAction() && player != null) {
            player.setItemInHand(context.getHand(), BucketItem.getEmptySuccessItem(context.getItemInHand(), player));
        }

        return interactionresult;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    protected SoundEvent getPlaceSound(BlockState state) {
        return this.placeSound;
    }

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
}
