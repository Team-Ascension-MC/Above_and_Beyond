package net.ascension.aboveandbeyond;

import net.ascension.aboveandbeyond.entity.renderer.FlooferRenderer;
import net.ascension.aboveandbeyond.entity.renderer.KoiRenderer;
import net.ascension.aboveandbeyond.entity.renderer.WelkinBoatRenderer;
import net.ascension.aboveandbeyond.registry.*;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(SparkingSkies.ID)
public class SparkingSkies {
    public static final String ID = "aboveandbeyond";

    public SparkingSkies(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        AABCreativeTabs.register(modEventBus);
        AABBlocks.register(modEventBus);
        AABItems.register(modEventBus);
        AABBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        AABEntities.register(modEventBus);
        AABSounds.register(modEventBus);
        AABDataComponents.register(modEventBus);
    }
    public static ResourceLocation asResource(String path) {return ResourceLocation.fromNamespaceAndPath(ID, path); }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod(value = SparkingSkies.ID, dist = Dist.CLIENT) @EventBusSubscriber(modid = SparkingSkies.ID, value = Dist.CLIENT)
    public static class AABClient {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(AABEntities.WELKIN_BOAT.get(), pContext -> new WelkinBoatRenderer(pContext, false));
            EntityRenderers.register(AABEntities.WELKIN_CHEST_BOAT.get(), pContext -> new WelkinBoatRenderer(pContext, true));

            EntityRenderers.register(AABEntities.KOI.get(), KoiRenderer::new);
            EntityRenderers.register(AABEntities.FLOOFER.get(), FlooferRenderer::new);
        }
    }
}