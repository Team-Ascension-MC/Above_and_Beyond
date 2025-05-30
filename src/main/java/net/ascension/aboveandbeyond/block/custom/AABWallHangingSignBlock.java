package net.ascension.aboveandbeyond.block.custom;

import net.ascension.aboveandbeyond.block.entity.AABHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AABWallHangingSignBlock extends WallHangingSignBlock {
    public AABWallHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new AABHangingSignBlockEntity(pPos, pState);
    }
}
