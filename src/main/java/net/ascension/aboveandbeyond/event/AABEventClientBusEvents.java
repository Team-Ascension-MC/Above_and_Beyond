package net.ascension.aboveandbeyond.event;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.entity.AABBlockEntities;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = AboveAndBeyond.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AABEventClientBusEvents {
    @net.neoforged.bus.api.SubscribeEvent
    public static void registerBER(net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers event) {

        event.registerBlockEntityRenderer(AABBlockEntities.WELKIN_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(AABBlockEntities.WELKIN_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}