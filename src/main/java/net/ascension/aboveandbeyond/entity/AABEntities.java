package net.ascension.aboveandbeyond.entity;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.custom.FlooferEntity;
import net.ascension.aboveandbeyond.entity.custom.KoiEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AboveAndBeyond.MOD_ID);

    /*public static final Supplier<EntityType<AABBoatEntity>> WELKIN_BOAT =
            ENTITY_TYPES.register("welkin_boat", () -> EntityType.Builder.<AABBoatEntity>of(AABBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("welkin_boat"));
    public static final Supplier<EntityType<AABChestBoatEntity>> WELKIN_CHEST_BOAT =
            ENTITY_TYPES.register("welkin_chest_boat", () -> EntityType.Builder.<AABChestBoatEntity>of(AABChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("welkin_chest_boat"));*/

    public static final Supplier<EntityType<KoiEntity>> KOI =
            ENTITY_TYPES.register("koi", () -> EntityType.Builder.of(KoiEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.5f, 0.25f).build("koi"));
    public static final Supplier<EntityType<FlooferEntity>> FLOOFER =
            ENTITY_TYPES.register("floofer", () -> EntityType.Builder.of(FlooferEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f).build("floofer"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}