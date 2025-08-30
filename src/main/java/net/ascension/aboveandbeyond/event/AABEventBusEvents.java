package net.ascension.aboveandbeyond.event;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.AABEntities;
import net.ascension.aboveandbeyond.entity.client.FlooferModel;
import net.ascension.aboveandbeyond.entity.client.FlooferRenderer;
import net.ascension.aboveandbeyond.entity.client.KoiModel;
import net.ascension.aboveandbeyond.entity.custom.FlooferEntity;
import net.ascension.aboveandbeyond.entity.custom.KoiEntity;
import net.ascension.aboveandbeyond.entity.layers.AABModelLayers;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = AboveAndBeyond.MOD_ID, bus = EventBusSubscriber.Bus.MOD)

public class AABEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(KoiModel.LAYER_LOCATION, KoiModel::createBodyLayer);
        event.registerLayerDefinition(FlooferModel.LAYER_LOCATION, FlooferModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(AABEntities.KOI.get(), KoiEntity.createAttributes().build());
        event.put(AABEntities.FLOOFER.get(), FlooferEntity.createAttributes().build());
    }
}