package net.ascension.aboveandbeyond.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AABHangingSignBlockEntity extends SignBlockEntity {
    public AABHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AABBlockEntities.WELKIN_HANGING_SIGN.get(), blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AABBlockEntities.WELKIN_HANGING_SIGN.get();
    }
}