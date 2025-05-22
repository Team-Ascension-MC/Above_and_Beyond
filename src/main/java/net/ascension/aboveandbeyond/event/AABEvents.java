package net.ascension.aboveandbeyond.event;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = AboveAndBeyond.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class AABEvents {
    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
 //maybe we could have some rare wandy t trade for a katana or something?       List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(AABItems.CLOUD_BERRY, 4),
                new ItemStack(Items.EMERALD, 1), 12, 3, 0.05f));

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(AABBlocks.WELKIN_SAPLING.get(), 1), 8, 10, 0.05f));
    }
}