package net.ascension.aboveandbeyond.registry;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AABWoodTypes {
    public static final WoodType WELKIN = WoodType.register(new WoodType(AboveAndBeyond.ID + ":welkin", BlockSetType.OAK));
}