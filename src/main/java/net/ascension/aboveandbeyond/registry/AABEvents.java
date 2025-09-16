package net.ascension.aboveandbeyond.registry;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.FlooferEntity;
import net.ascension.aboveandbeyond.entity.KoiEntity;
import net.ascension.aboveandbeyond.entity.model.FlooferModel;
import net.ascension.aboveandbeyond.entity.model.KoiModel;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@Mod(value = AboveAndBeyond.ID) @EventBusSubscriber(modid = AboveAndBeyond.ID)
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
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(AABItems.FLOOF, 1),
                new ItemStack(Items.EMERALD, 2), 8, 5, 0.05f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(AABItems.STORMY_CLOUD_BUCKET, 1),
                new ItemStack(Items.EMERALD, 3), 8, 5, 0.05f));
    }

    public static final ModelLayerLocation WELKIN_BOAT_LAYER = new ModelLayerLocation(AboveAndBeyond.asResource("boat/welkin"), "main");
    public static final ModelLayerLocation WELKIN_CHEST_BOAT_LAYER = new ModelLayerLocation(AboveAndBeyond.asResource("chest_boat/welkin"), "main");
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WELKIN_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(WELKIN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

        event.registerLayerDefinition(FlooferModel.LAYER_LOCATION, FlooferModel::createBodyLayer);
        event.registerLayerDefinition(KoiModel.LAYER_LOCATION, KoiModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(AABEntities.FLOOFER.get(), FlooferEntity.createAttributes().build());
        event.put(AABEntities.KOI.get(), KoiEntity.createAttributes().build());
    }

    @Mod(value = AboveAndBeyond.ID, dist = Dist.CLIENT) @EventBusSubscriber(modid = AboveAndBeyond.ID, value = Dist.CLIENT)
    public static class AABEventClientBusEvents {
        @net.neoforged.bus.api.SubscribeEvent
        public static void registerBER(net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(AABBlockEntities.WELKIN_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(AABBlockEntities.WELKIN_HANGING_SIGN.get(), HangingSignRenderer::new);
        }
    }
}
