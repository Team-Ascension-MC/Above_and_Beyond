package net.ascension.aboveandbeyond.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AABSignBlockEntity extends SignBlockEntity {
    public AABSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<AABSignBlockEntity> getType() {
        return AABBlockEntities.WELKIN_SIGN.get();
    }
}