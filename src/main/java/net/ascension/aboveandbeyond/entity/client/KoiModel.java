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
    private final ModelPart front;

    public KoiModel(ModelPart root) {
        this.koi = root.getChild("koi");
        this.front = this.koi.getChild("front");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition koi = partdefinition.addOrReplaceChild("koi", CubeListBuilder.create(), PartPose.offset(0.0F, 22.5F, 4.0F));

        PartDefinition back = koi.addOrReplaceChild("back", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(0.0F, -3.0F, 1.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition middle = koi.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(10, 5).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -3.0F));

        PartDefinition front = koi.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.5F, -8.5F));

        PartDefinition cube_r1 = front.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-1, 4).mirror().addBox(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition cube_r2 = front.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-1, 4).addBox(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition rightFin = koi.addOrReplaceChild("rightFin", CubeListBuilder.create(), PartPose.offset(-2.0F, 1.5F, -5.0F));

        PartDefinition cube_r3 = rightFin.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 8).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition leftFin = koi.addOrReplaceChild("leftFin", CubeListBuilder.create(), PartPose.offset(2.0F, 1.5F, -5.0F));

        PartDefinition cube_r4 = leftFin.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 8).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

        return LayerDefinition.create(meshdefinition, 32, 32);
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

        this.front.yRot = headYaw * ((float)Math.PI / 180f);
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