package net.ascension.aboveandbeyond.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.KoiVariant;
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
                map.put(KoiVariant.DEFAULT, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_default.png"));
                map.put(KoiVariant.WHITE_RED, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_white_red.png"));
                map.put(KoiVariant.WHITE_BLUE, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_white_blue.png"));
                map.put(KoiVariant.WHITE_PURPLE, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_white_purple.png"));
                map.put(KoiVariant.RED, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_red.png"));
                map.put(KoiVariant.PURPLE, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_purple.png"));
                map.put(KoiVariant.YELLOW, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_yellow.png"));
                map.put(KoiVariant.GOLD, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_gold.png"));
                map.put(KoiVariant.END, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_end.png"));
                map.put(KoiVariant.THUNDER, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_thunder.png"));
                map.put(KoiVariant.WARDEN, ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "textures/entity/koi/koi_warden.png"));
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
