package net.ascension.aboveandbeyond.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AABHangingSignBlockEntity extends HangingSignBlockEntity {
    public AABHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<AABHangingSignBlockEntity> getType() {
        return AABBlockEntities.WELKIN_HANGING_SIGN.get();
    }
}