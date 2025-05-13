package net.ascension.aboveandbeyond.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.custom.KoiEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KoiRenderer extends MobRenderer<KoiEntity, KoiModel<KoiEntity>> {
    public KoiRenderer(EntityRendererProvider.Context context) {
        super(context, new KoiModel<>(context.bakeLayer(KoiModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(KoiEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_default.png");
    }

    @Override
    public void render(KoiEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
