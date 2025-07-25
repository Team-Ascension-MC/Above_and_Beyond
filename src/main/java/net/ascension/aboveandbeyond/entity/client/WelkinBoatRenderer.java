/*package net.ascension.aboveandbeyond.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.custom.WelkinBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import org.joml.Quaternionf;

import java.util.Map;
import java.util.stream.Stream;

public class WelkinBoatRenderer extends EntityRenderer<WelkinBoatEntity> {
    private final Map<WelkinBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public WelkinBoatRenderer(EntityRendererProvider.Context context, boolean chest) {
        super(context);
        this.shadowRadius = 0.8F;
        this.boatResources = Stream.of(WelkinBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap((type) -> type, (type) -> Pair.of(AboveAndBeyond.asResource(getTextureLocation(type, chest)), this.createBoatModel(context, type, chest))));
    }

    private static ModelLayerLocation createLocation(String path, String model) {
        return new ModelLayerLocation(AboveAndBeyond.asResource(path), model);
    }

    public static ModelLayerLocation createBoatModelName(WelkinBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(WelkinBoatEntity.Type type) {
        return createLocation("chest_boat/" + type.getName(), "main");
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, WelkinBoatEntity.Type type, boolean chest) {
        ModelLayerLocation modellayerlocation = chest ? createChestBoatModelName(type) : createBoatModelName(type);
        return chest ? new ChestBoatModel(context.bakeLayer(modellayerlocation)) : new BoatModel(context.bakeLayer(modellayerlocation));
    }

    private static String getTextureLocation(WelkinBoatEntity.Type type, boolean chest) {
        return chest ? "textures/entity/chest_boat/" + type.getName() + ".png" : "textures/entity/boat/" + type.getName() + ".png";
    }

    @Override
    public void render(WelkinBoatEntity boat, float boatYaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int light) {
        stack.pushPose();
        stack.translate(0.0F, 0.375F, 0.0F);
        stack.mulPose(Axis.YP.rotationDegrees(180.0F - boatYaw));
        float f = (float) boat.getHurtTime() - partialTicks;
        float f1 = boat.getDamage() - partialTicks;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            stack.mulPose(Axis.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float) boat.getHurtDir()));
        }

        float f2 = boat.getBubbleAngle(partialTicks);
        if (!Mth.equal(f2, 0.0F)) {
            stack.mulPose((new Quaternionf()).setAngleAxis(boat.getBubbleAngle(partialTicks) * ((float) Math.PI / 180F), 1.0F, 0.0F, 1.0F));
        }

        Pair<ResourceLocation, ListModel<Boat>> pair = this.getModelWithLocation(boat);
        ResourceLocation resourcelocation = pair.getFirst();
        ListModel<Boat> model = pair.getSecond();
        stack.scale(-1.0F, -1.0F, 1.0F);
        stack.mulPose(Axis.YP.rotationDegrees(90.0F));
        model.setupAnim(boat, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = buffer.getBuffer(model.renderType(resourcelocation));
        model.renderToBuffer(stack, vertexconsumer, light, OverlayTexture.NO_OVERLAY);
        if (model instanceof BoatModel boatModel && !boat.isUnderWater()) {
            VertexConsumer vertexconsumer1 = buffer.getBuffer(RenderType.waterMask());
            boatModel.waterPatch().render(stack, vertexconsumer1, light, OverlayTexture.NO_OVERLAY);
        }

        stack.popPose();
        super.render(boat, boatYaw, partialTicks, stack, buffer, light);
    }

    @Override
    public ResourceLocation getTextureLocation(WelkinBoatEntity entity) {
        return this.boatResources.get(entity.getWelkinBoatEntityType()).getFirst();
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(WelkinBoatEntity boat) {
        return this.boatResources.get(boat.getWelkinBoatEntityType());
    }
}*/