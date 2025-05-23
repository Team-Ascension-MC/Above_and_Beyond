package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.util.AABTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AABBlockTagProvider extends BlockTagsProvider {
    public AABBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AboveAndBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(AABBlocks.ZENSTONE.get())
                .add(AABBlocks.ZENSTONE_STAIRS.get())
                .add(AABBlocks.ZENSTONE_SLAB.get())
                .add(AABBlocks.ZENSTONE_WALL.get())
                .add(AABBlocks.POLISHED_ZENSTONE_BRICKS.get())
                .add(AABBlocks.CRACKED_POLISHED_ZENSTONE_BRICKS.get())
                .add(AABBlocks.POLISHED_ZENSTONE_BRICK_STAIRS.get())
                .add(AABBlocks.POLISHED_ZENSTONE_BRICK_SLAB.get())
                .add(AABBlocks.POLISHED_ZENSTONE_BRICK_WALL.get())
                .add(AABBlocks.CHISELED_POLISHED_ZENSTONE_BRICKS.get())
                .add(AABBlocks.COBALT_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(AABBlocks.WELKIN_LOG.get())
                .add(AABBlocks.WELKIN_WOOD.get())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get())
                .add(AABBlocks.WELKIN_PLANKS.get())
                .add(AABBlocks.WELKIN_STAIRS.get())
                .add(AABBlocks.WELKIN_SLAB.get())
                .add(AABBlocks.WELKIN_PRESSURE_PLATE.get())
                .add(AABBlocks.WELKIN_BUTTON.get())
                .add(AABBlocks.WELKIN_DOOR.get())
                .add(AABBlocks.WELKIN_TRAPDOOR.get())
                .add(AABBlocks.WELKIN_FENCE.get())
                .add(AABBlocks.WELKIN_FENCE_GATE.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(AABBlocks.PUFFGRASS_BLOCK.get())
                .add(AABBlocks.AEROSOIL.get())
                .add(AABBlocks.COARSE_AEROSOIL.get())
                .add(AABBlocks.ZEN_GRAVEL.get())
                .add(AABBlocks.NIMBUS_PUFFGRASS_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(AABBlocks.WELKIN_LEAVES.get());

        tag(AABTags.Blocks.CLOUD_BLOCKS)
                .add(AABBlocks.CLOUD_BLOCK.get())
                .add(AABBlocks.STORMY_CLOUD_BLOCK.get());
        tag(AABTags.Blocks.WELKIN_LOGS)
                .add(AABBlocks.WELKIN_LOG.get())
                .add(AABBlocks.WELKIN_WOOD.get())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get());

        tag(BlockTags.LOGS)
                .add(AABBlocks.WELKIN_LOG.get())
                .add(AABBlocks.WELKIN_WOOD.get())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get());
        tag(BlockTags.LOGS_THAT_BURN)
                .add(AABBlocks.WELKIN_LOG.get())
                .add(AABBlocks.WELKIN_WOOD.get())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get());
        tag(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(AABBlocks.WELKIN_LOG.get())
                .add(AABBlocks.WELKIN_WOOD.get())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get());

        tag(BlockTags.DIRT)
                .add(AABBlocks.PUFFGRASS_BLOCK.get())
                .add(AABBlocks.AEROSOIL.get())
                .add(AABBlocks.COARSE_AEROSOIL.get())
                .add(AABBlocks.NIMBUS_PUFFGRASS_BLOCK.get());

        tag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(AABBlocks.PUFFGRASS_BLOCK.get())
                .add(AABBlocks.AEROSOIL.get())
                .add(AABBlocks.COARSE_AEROSOIL.get());

        tag(BlockTags.STAIRS)
                .add(AABBlocks.WELKIN_STAIRS.get())
                .add(AABBlocks.ZENSTONE_STAIRS.get())
                .add(AABBlocks.POLISHED_ZENSTONE_BRICK_STAIRS.get());
        tag(BlockTags.WOODEN_STAIRS)
                .add(AABBlocks.WELKIN_STAIRS.get());
        tag(BlockTags.SLABS)
                .add(AABBlocks.WELKIN_SLAB.get())
                .add(AABBlocks.ZENSTONE_SLAB.get())
                .add(AABBlocks.POLISHED_ZENSTONE_BRICK_SLAB.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(AABBlocks.WELKIN_SLAB.get());
        tag(BlockTags.FENCES).add(AABBlocks.WELKIN_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(AABBlocks.WELKIN_FENCE_GATE.get());
        tag(BlockTags.LEAVES)
                .add(AABBlocks.WELKIN_LEAVES.get());
        tag(BlockTags.SAPLINGS)
                .add(AABBlocks.WELKIN_SAPLING.get());
        tag(BlockTags.WALLS)
                .add(AABBlocks.ZENSTONE_WALL.get())
                .add(AABBlocks.POLISHED_ZENSTONE_BRICK_WALL.get());
    }
}