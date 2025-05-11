package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.ascension.aboveandbeyond.util.AABTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AABItemTagProvider extends ItemTagsProvider {
    public AABItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, AboveAndBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(AABTags.Items.WELKIN_LOGS)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());

        this.tag(ItemTags.LOGS)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());
        this.tag(ItemTags.PLANKS)
                .add(AABBlocks.WELKIN_PLANKS.asItem());
        this.tag(ItemTags.STONE_BRICKS)
                .add(AABBlocks.POLISHED_ZENSTONE_BRICKS.asItem());
    }
}