package net.ascension.aboveandbeyond.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;

public class ZenGravel extends FallingBlock {
    public ZenGravel(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<? extends FallingBlock> codec() {
        return null; // For basic falling blocks, returning null is sufficient
    }
}