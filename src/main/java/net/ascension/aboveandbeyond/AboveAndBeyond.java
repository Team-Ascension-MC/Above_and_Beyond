package net.ascension.aboveandbeyond;

import net.ascension.aboveandbeyond.entity.renderer.FlooferRenderer;
import net.ascension.aboveandbeyond.entity.renderer.KoiRenderer;
import net.ascension.aboveandbeyond.entity.renderer.WelkinBoatRenderer;
import net.ascension.aboveandbeyond.registry.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod(AboveAndBeyond.ID)
public class AboveAndBeyond {
    public static final String ID = "aboveandbeyond";

    public AboveAndBeyond(IEventBus modEventBus/*, ModContainer modContainer*/)
    {
        modEventBus.addListener(this::commonSetup);
        //NeoForge.EVENT_BUS.register(this);

        AABCreativeTabs.register(modEventBus);
        AABBlocks.register(modEventBus);
        AABItems.register(modEventBus);
        AABBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        AABEntities.register(modEventBus);
        AABSounds.register(modEventBus);
        //AABDataComponents.register(modEventBus);
    }
    public static ResourceLocation asResource(String path) {return ResourceLocation.fromNamespaceAndPath(ID, path); }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(AABEntities.WELKIN_BOAT.get(), pContext -> new WelkinBoatRenderer(pContext, false));
            EntityRenderers.register(AABEntities.WELKIN_CHEST_BOAT.get(), pContext -> new WelkinBoatRenderer(pContext, true));

            EntityRenderers.register(AABEntities.KOI.get(), KoiRenderer::new);
            EntityRenderers.register(AABEntities.FLOOFER.get(), FlooferRenderer::new);
        }

        public static final ModelLayerLocation WELKIN_BOAT_LAYER = new ModelLayerLocation(AboveAndBeyond.asResource("boat/welkin"), "main");
        public static final ModelLayerLocation WELKIN_CHEST_BOAT_LAYER = new ModelLayerLocation(AboveAndBeyond.asResource("chest_boat/welkin"), "main");

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(WELKIN_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(WELKIN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        }
    }

