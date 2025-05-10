package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(AABBlocks.PUFFGRASS_BLOCK.get())
                .add(AABBlocks.AEROSOIL.get())
                .add(AABBlocks.COARSE_AEROSOIL.get())
                .add(AABBlocks.ZEN_GRAVEL.get());

        tag(BlockTags.DIRT)
                .add(AABBlocks.PUFFGRASS_BLOCK.get())
                .add(AABBlocks.AEROSOIL.get())
                .add(AABBlocks.COARSE_AEROSOIL.get());

        tag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(AABBlocks.PUFFGRASS_BLOCK.get())
                .add(AABBlocks.AEROSOIL.get())
                .add(AABBlocks.COARSE_AEROSOIL.get());
    }
}