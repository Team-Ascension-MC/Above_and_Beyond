package net.ascension.aboveandbeyond.util;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class AABTags {
    public static class Blocks {
        public static final TagKey<Block> CLOUD_BLOCKS = createTag("cloud_blocks");
        public static final TagKey<Block> WELKIN_LOGS = createTag("welkin_logs");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CLOUD_BUCKETS = createTag("cloud_buckets");
        public static final TagKey<Item> WELKIN_LOGS = createTag("welkin_logs");

        public static final TagKey<Item> COBALT_CROSSBOW_BOLTS = createTag("cobalt_crossbow_bolts");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.ID, name));
        }
    }
}