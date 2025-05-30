package net.ascension.aboveandbeyond.block.custom;

import net.ascension.aboveandbeyond.block.entity.AABSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AABWallSignBlock extends WallSignBlock {
    public AABWallSignBlock(Properties pProperties, WoodType pType) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new AABSignBlockEntity(pPos, pState);
    }
}
