package net.ascension.aboveandbeyond.entity.client.renderer;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.variants.KoiVariant;
import net.ascension.aboveandbeyond.entity.client.model.KoiModel;
import net.ascension.aboveandbeyond.entity.custom.KoiEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class KoiRenderer extends MobRenderer<KoiEntity, KoiModel<KoiEntity>> {
    private static final Map<KoiVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(KoiVariant.class), map -> {
                map.put(KoiVariant.KOHAKU, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.ID, "textures/entity/koi/koi_kohaku.png"));
                map.put(KoiVariant.SANKE, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.ID, "textures/entity/koi/koi_sanke.png"));
                map.put(KoiVariant.SHOWA, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.ID, "textures/entity/koi/koi_showa.png"));
                map.put(KoiVariant.SHERBERT, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.ID, "textures/entity/koi/koi_sherbert.png"));
            });

    public KoiRenderer(EntityRendererProvider.Context context) {
        super(context, new KoiModel<>(context.bakeLayer(KoiModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(KoiEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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
