package net.ascension.aboveandbeyond.worldgen.tree;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.worldgen.AABConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class AABTreeGrowers {
    public static final TreeGrower WELKIN = new TreeGrower(AboveAndBeyond.MOD_ID + ":welkin",
            Optional.empty(), Optional.of(AABConfiguredFeatures.WELKIN_KEY), Optional.empty());
}
