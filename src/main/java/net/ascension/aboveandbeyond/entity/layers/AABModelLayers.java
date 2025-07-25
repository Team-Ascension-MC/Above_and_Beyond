package net.ascension.aboveandbeyond.entity.layers;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class AABModelLayers {
   /* public static final ModelLayerLocation WELKIN_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "boat/welkin"), "main");
    public static final ModelLayerLocation WELKIN_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "chest_boat/welkin"), "main");*/

  /*  public static final ModelLayerLocation WELKIN_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(AboveAndBeyond.MOD_ID, "boat/welkin"), "main");
    public static final ModelLayerLocation WELKIN_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(AboveAndBeyond.MOD_ID, "chest_boat/welkin"), "main");*/

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
   /*     event.registerLayerDefinition(WELKIN_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(WELKIN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);*/
    }
}