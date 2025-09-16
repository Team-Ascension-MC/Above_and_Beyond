package net.ascension.aboveandbeyond.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.model.FlooferModel;
import net.ascension.aboveandbeyond.entity.FlooferEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FlooferRenderer extends MobRenderer<FlooferEntity, FlooferModel<FlooferEntity>> {
    public FlooferRenderer(EntityRendererProvider.Context context) {
        super(context, new FlooferModel<>(context.bakeLayer(FlooferModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(FlooferEntity entity) {
        return AboveAndBeyond.asResource("textures/entity/floofer.png");
    }

    @Override
    public void render(FlooferEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {poseStack.scale(0.45f, 0.45f, 0.45f); } else {poseStack.scale(1f, 1f, 1f); }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
