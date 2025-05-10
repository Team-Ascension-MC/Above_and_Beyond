package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class AABBlockLootTableProvider extends BlockLootSubProvider {
    protected AABBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(AABBlocks.AEROSOIL.get());
        dropSelf(AABBlocks.COARSE_AEROSOIL.get());
        dropSelf(AABBlocks.ZEN_GRAVEL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AABBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}