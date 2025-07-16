package net.ascension.aboveandbeyond.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.custom.KoiEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class KoiModel<T extends KoiEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "koi"), "main");
    private final ModelPart koi;

    public KoiModel(ModelPart root) {
        this.koi = root.getChild("koi");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition koi = partdefinition.addOrReplaceChild("koi", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, -2.0F));

        PartDefinition body = koi.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 5).addBox(0.0F, -4.0F, -2.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

        PartDefinition left_barbel = body.addOrReplaceChild("left_barbel", CubeListBuilder.create(), PartPose.offset(1.5F, 1.0F, -4.5F));

        PartDefinition left_barbel2 = left_barbel.addOrReplaceChild("left_barbel2", CubeListBuilder.create().texOffs(-1, 4).addBox(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_barbel = body.addOrReplaceChild("right_barbel", CubeListBuilder.create(), PartPose.offset(-1.5F, 1.0F, -4.5F));

        PartDefinition right_barbel2 = right_barbel.addOrReplaceChild("right_barbel2", CubeListBuilder.create().texOffs(-1, 4).mirror().addBox(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_fin = body.addOrReplaceChild("left_fin", CubeListBuilder.create(), PartPose.offset(2.0F, 2.0F, 0.0F));

        PartDefinition left_fin2 = left_fin.addOrReplaceChild("left_fin2", CubeListBuilder.create().texOffs(24, 8).addBox(0.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_fin = body.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offset(-2.0F, 2.0F, 0.0F));

        PartDefinition right_fin2 = right_fin.addOrReplaceChild("right_fin2", CubeListBuilder.create().texOffs(24, 8).mirror().addBox(-2.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back_fin1 = body.addOrReplaceChild("back_fin1", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

        PartDefinition back_fin2 = back_fin1.addOrReplaceChild("back_fin2", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        if (entity.isInWater()) {
            this.animateWalk(KoiAnimation.Swim, limbSwing, limbSwingAmount, 2f, 2.5f);
            this.animate(entity.idleAnimationState, KoiAnimation.Idle, ageInTicks, 1f);
        } else {
            this.animate(entity.flopAnimationState, KoiAnimation.Flop, ageInTicks, 1f);
        }

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        koi.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return koi;
    }
}