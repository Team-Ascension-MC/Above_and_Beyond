package net.ascension.aboveandbeyond.event;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = AboveAndBeyond.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class AABEvents {
    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 2),
                new ItemStack(Blocks.BAMBOO, 2), 8, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 2),
                new ItemStack(Items.GLOW_BERRIES, 1), 8, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 3),
                new ItemStack(AABBlocks.PUFFGRASS_BLOCK.get(), 2), 12, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(AABBlocks.ZEN_GRAVEL.get(), 6), 12, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(AABItems.KOI_BUCKET.get(), 1), 4, 5, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(AABItems.CLOUD_BUCKET.get(), 1), 12, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(AABBlocks.WELKIN_SAPLING.get(), 1), 8, 3, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(AABBlocks.SHORT_PUFFGRASS.get(), 1), 16, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(AABBlocks.STARFLOWER.get(), 1), 16, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(AABBlocks.SKYACINTH.get(), 1), 16, 1, 0.05f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 11),
                new ItemStack(Items.OMINOUS_BOTTLE, 1), 2, 10, 0.2f));

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.FEATHER, 2),
                new ItemStack(Items.EMERALD, 1), 12, 1, 0.05f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(AABItems.CLOUD_BERRIES, 4),
                new ItemStack(Items.EMERALD, 1), 12, 3, 0.05f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(AABItems.STORMY_CLOUD_BUCKET, 1),
                new ItemStack(Items.EMERALD, 3), 8, 5, 0.05f));
    }
}