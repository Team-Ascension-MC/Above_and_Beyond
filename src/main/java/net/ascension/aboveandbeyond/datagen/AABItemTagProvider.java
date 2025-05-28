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
        tag(AABTags.Items.CLOUD_BUCKETS)
                .add(AABItems.CLOUD_BUCKET.get())
                .add(AABItems.STORMY_CLOUD_BUCKET.get());
        tag(AABTags.Items.WELKIN_LOGS)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());

        tag(ItemTags.LOGS)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(AABBlocks.WELKIN_LOG.get().asItem())
                .add(AABBlocks.WELKIN_WOOD.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_LOG.get().asItem())
                .add(AABBlocks.STRIPPED_WELKIN_WOOD.get().asItem());
        tag(ItemTags.PLANKS)
                .add(AABBlocks.WELKIN_PLANKS.asItem());
        tag(ItemTags.LEAVES)
                .add(AABBlocks.WELKIN_LEAVES.asItem());
        tag(ItemTags.SAPLINGS)
                .add(AABBlocks.WELKIN_SAPLING.asItem());
        tag(ItemTags.STONE_BRICKS)
                .add(AABBlocks.POLISHED_ZENSTONE_BRICKS.asItem());
        tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(AABBlocks.ZENSTONE.asItem());

        tag(ItemTags.SWORDS)
                .add(AABItems.KATANA.get())
                .add(AABItems.COBALT_SWORD.get());
        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(AABItems.KATANA.get())
                .add(AABItems.COBALT_SWORD.get());

        tag(ItemTags.PICKAXES)
                .add(AABItems.COBALT_PICKAXE.get());

        tag(ItemTags.AXES)
                .add(AABItems.COBALT_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(AABItems.COBALT_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(AABItems.COBALT_HOE.get());

        this.tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(AABItems.COBALT_HELMET.get())
                .add(AABItems.COBALT_CHESTPLATE.get())
                .add(AABItems.COBALT_LEGGINGS.get())
                .add(AABItems.COBALT_BOOTS.get());
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(AABItems.COBALT_HELMET.get())
                .add(AABItems.COBALT_CHESTPLATE.get())
                .add(AABItems.COBALT_LEGGINGS.get())
                .add(AABItems.COBALT_BOOTS.get());
        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(AABItems.COBALT_HELMET.get());
        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(AABItems.COBALT_CHESTPLATE.get());
        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(AABItems.COBALT_LEGGINGS.get());
        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(AABItems.COBALT_BOOTS.get());
    }
}