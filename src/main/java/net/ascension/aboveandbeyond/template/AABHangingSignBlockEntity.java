package net.ascension.aboveandbeyond.template;

import net.ascension.aboveandbeyond.registry.AABBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
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