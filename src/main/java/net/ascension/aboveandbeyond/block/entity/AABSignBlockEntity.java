package net.ascension.aboveandbeyond.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AABSignBlockEntity extends SignBlockEntity {
    public AABSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(AABBlockEntities.WELKIN_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AABBlockEntities.WELKIN_SIGN.get();
    }
}