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
    private final ModelPart frontBody;

    public KoiModel(ModelPart root) {
        this.koi = root.getChild("koi");
        this.frontBody = this.koi.getChild("FrontBody");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition koi = partdefinition.addOrReplaceChild("koi", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 19.0F, -5.0F, 0.0F, -0.0029F, 0.0F));

        PartDefinition FrontBody = koi.addOrReplaceChild("FrontBody", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(14, 30).addBox(-2.0F, -1.0F, -9.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 8).addBox(0.0F, -6.0F, -5.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0014F, -1.0F, 6.0F));

        PartDefinition RightFrontFin = FrontBody.addOrReplaceChild("RightFrontFin", CubeListBuilder.create(), PartPose.offset(-4.0F, 4.0F, -2.0F));

        PartDefinition cube_r1 = RightFrontFin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(17, 25).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition RightWhisker = FrontBody.addOrReplaceChild("RightWhisker", CubeListBuilder.create(), PartPose.offset(-2.0F, 1.0F, -8.0F));

        PartDefinition cube_r2 = RightWhisker.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(17, 20).addBox(-6.0F, 0.0F, -1.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition LeftWhisker = FrontBody.addOrReplaceChild("LeftWhisker", CubeListBuilder.create(), PartPose.offset(2.0F, 1.0F, -8.0F));

        PartDefinition cube_r3 = LeftWhisker.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(19, 0).addBox(0.0F, 0.0F, -1.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition LeftFrontFin = FrontBody.addOrReplaceChild("LeftFrontFin", CubeListBuilder.create(), PartPose.offset(4.0F, 4.0F, -2.0F));

        PartDefinition cube_r4 = LeftFrontFin.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(23, 25).addBox(0.0F, 0.0F, -2.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition BackBody = koi.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -3.0F, 0.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0014F, -1.0F, 6.0F, 0.0F, 0.0264F, 0.0F));

        PartDefinition BackLeftFin = BackBody.addOrReplaceChild("BackLeftFin", CubeListBuilder.create(), PartPose.offset(2.5F, 3.0F, 4.0F));

        PartDefinition cube_r5 = BackLeftFin.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -6.0F, -2.0F, 0.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.0F, 0.0117F, 0.0F));

        PartDefinition BackRightFin = BackBody.addOrReplaceChild("BackRightFin", CubeListBuilder.create(), PartPose.offset(-2.5F, 3.0F, 4.0F));

        PartDefinition cube_r6 = BackRightFin.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 4).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        if (entity.isInWater()) {
            this.applyHeadRotation(netHeadYaw, headPitch);
            this.animateWalk(KoiAnimation.Swim, limbSwing, limbSwingAmount, 2f, 2.5f);
            this.animate(entity.idleAnimationState, KoiAnimation.Idle, ageInTicks, 1f);
        } else {
            this.animate(entity.flopAnimationState, KoiAnimation.Flop, ageInTicks, 1f);
        }

    }

    protected void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);

        this.frontBody.yRot = headYaw * ((float)Math.PI / 180f);
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