package net.ascension.aboveandbeyond.block.custom;

import com.mojang.serialization.MapCodec;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ZenGravelFarm extends FallingBlock {
    public ZenGravelFarm(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull MapCodec<? extends FallingBlock> codec() {
        return null;
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer, @NotNull BlockHitResult pHitResult) {
        ItemStack heldItem = pPlayer.getMainHandItem();

        // Check if the held item is a hoe (any type of hoe)
        if (heldItem.getItem() instanceof net.minecraft.world.item.HoeItem) {
            // Server-side check to prevent desync issues
            if (!pLevel.isClientSide) {
                // Replace ZenGravel with ZenGravelFarm
                // Replace YourModBlocks.ZEN_GRAVEL_FARM with your actual ZenGravelFarm block reference
                pLevel.setBlockAndUpdate(pPos, AABBlocks.ZEN_GRAVEL.get().defaultBlockState());

            }
            // Return SUCCESS to indicate the interaction was successful
            return InteractionResult.SUCCESS;
        }

        // If not a hoe, call the super method for default behavior
        return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
    }
}