package net.ascension.aboveandbeyond.block.custom;

import net.ascension.aboveandbeyond.block.entity.AABSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AABStandingSignBlock extends StandingSignBlock {
    public AABStandingSignBlock(WoodType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AABSignBlockEntity(pos, state);
    }
}