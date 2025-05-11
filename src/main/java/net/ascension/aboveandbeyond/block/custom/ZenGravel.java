package net.ascension.aboveandbeyond.block.custom;

import com.mojang.serialization.MapCodec;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ZenGravel extends FallingBlock {
    private static final IntegerProperty STYLE = IntegerProperty.create("zen_gravel_style", 0, 2);

    public ZenGravel(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull MapCodec<? extends FallingBlock> codec() {
        return null;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(STYLE);
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer, @NotNull BlockHitResult pHitResult) {
        ItemStack heldItem = pPlayer.getMainHandItem();

        // Check if the held item is a hoe (any type of hoe)
        if (heldItem.getItem() instanceof net.minecraft.world.item.HoeItem) {
            if (pPlayer.isCrouching()) {
                BlockState newState = pState.setValue(STYLE, 0);
                pLevel.setBlock(pPos, newState, 3);
            } else {
                if (pState.getValue(STYLE) == 1) {
                    BlockState newState = pState.setValue(STYLE, 2);
                    pLevel.setBlock(pPos, newState, 3);
                } else {
                    BlockState newState = pState.setValue(STYLE, 1);
                    pLevel.setBlock(pPos, newState, 3);
                }
            }

            pLevel.playSound(null, pPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);

            // Return SUCCESS to indicate the interaction was successful
            return InteractionResult.SUCCESS;
        }

        // If not a hoe, call the super method for default behavior
        return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
    }
}