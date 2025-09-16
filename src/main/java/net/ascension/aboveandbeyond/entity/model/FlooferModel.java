package net.ascension.aboveandbeyond.entity.model;

import net.ascension.aboveandbeyond.SparkingSkies;
import net.ascension.aboveandbeyond.entity.animation.FlooferAnimation;
import net.ascension.aboveandbeyond.entity.FlooferEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class FlooferModel<T extends FlooferEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SparkingSkies.ID, "floofer"), "main");
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head_sneeze;
    private final ModelPart nose;
    private final ModelPart left_ear;
    private final ModelPart le_default;
    private final ModelPart right_ear;
    private final ModelPart re_default;
    private final ModelPart left_wing;
    private final ModelPart lw_default;
    private final ModelPart right_wing;
    private final ModelPart rw_default;
    private final ModelPart tail;
    private final ModelPart leg0;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;

    public FlooferModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.head_sneeze = this.body.getChild("head_sneeze");
        this.nose = this.body.getChild("nose");
        this.left_ear = this.body.getChild("left_ear");
        this.le_default = this.left_ear.getChild("le_default");
        this.right_ear = this.body.getChild("right_ear");
        this.re_default = this.right_ear.getChild("re_default");
        this.left_wing = this.body.getChild("left_wing");
        this.lw_default = this.left_wing.getChild("lw_default");
        this.right_wing = this.body.getChild("right_wing");
        this.rw_default = this.right_wing.getChild("rw_default");
        this.tail = this.body.getChild("tail");
        this.leg0 = this.root.getChild("leg0");
        this.leg1 = this.root.getChild("leg1");
        this.leg2 = this.root.getChild("leg2");
        this.leg3 = this.root.getChild("leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 18.5F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -6.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

        PartDefinition head_sneeze = body.addOrReplaceChild("head_sneeze", CubeListBuilder.create().texOffs(44, 12).addBox(-5.0F, -4.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -5.01F));

        PartDefinition nose = body.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(28, 26).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -6.0F));

        PartDefinition left_ear = body.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(2.5F, -6.5F, -4.5F));

        PartDefinition le_default = left_ear.addOrReplaceChild("le_default", CubeListBuilder.create().texOffs(18, 30).mirror().addBox(-1.5F, -4.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_ear = body.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-2.5F, -6.5F, -4.5F));

        PartDefinition re_default = right_ear.addOrReplaceChild("re_default", CubeListBuilder.create().texOffs(18, 30).addBox(-1.5F, -4.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(3.5F, -6.5F, 0.0F));

        PartDefinition lw_default = left_wing.addOrReplaceChild("lw_default", CubeListBuilder.create().texOffs(0, 20).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-3.5F, -6.5F, 0.0F));

        PartDefinition rw_default = right_wing.addOrReplaceChild("rw_default", CubeListBuilder.create().texOffs(0, 20).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(18, 20).addBox(0.0F, -4.5F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 6.0F));

        PartDefinition leg0 = root.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(28, 20).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 2.5F, -3.5F));

        PartDefinition leg1 = root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(28, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 2.5F, -3.5F));

        PartDefinition leg2 = root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(28, 20).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 2.5F, 3.5F));

        PartDefinition leg3 = root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(28, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 2.5F, 3.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateWalk(FlooferAnimation.ANIM_FLOOFER_MOVE, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(entity.idleAnimationState, FlooferAnimation.ANIM_FLOOFER_IDLE, ageInTicks, 1f);
        this.animate(entity.flappingAnimationState, FlooferAnimation.ANIM_FLOOFER_FLAP, ageInTicks, 1f);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
