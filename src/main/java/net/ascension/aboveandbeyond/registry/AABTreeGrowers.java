package net.ascension.aboveandbeyond.registry;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class AABTreeGrowers {
    public static final TreeGrower WELKIN = new TreeGrower(AboveAndBeyond.ID + ":welkin",
            Optional.empty(), Optional.of(AABConfiguredFeatures.WELKIN_KEY), Optional.empty());
}
