package net.ascension.aboveandbeyond.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class FloofBlock extends Block {
    public FloofBlock(Properties properties) {
        super(properties);
    }

    public void fallOn(Level p_153362_, BlockState blockState, BlockPos blockPos, Entity entity, float p_153366_) {
        entity.causeFallDamage(p_153366_, 0.0F, p_153362_.damageSources().fall());
    }
}
