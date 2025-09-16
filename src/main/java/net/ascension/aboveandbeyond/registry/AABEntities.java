package net.ascension.aboveandbeyond.registry;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.FlooferEntity;
import net.ascension.aboveandbeyond.entity.KoiEntity;
import net.ascension.aboveandbeyond.entity.WelkinBoatEntity;
import net.ascension.aboveandbeyond.entity.WelkinChestBoatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AboveAndBeyond.ID);

    public static final DeferredHolder<EntityType<?>, EntityType<WelkinBoatEntity>> WELKIN_BOAT =
            ENTITY_TYPES.register("welkin_boat", () -> EntityType.Builder.<WelkinBoatEntity>of(WelkinBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("welkin_boat"));
    public static final DeferredHolder<EntityType<?>, EntityType<WelkinChestBoatEntity>> WELKIN_CHEST_BOAT =
            ENTITY_TYPES.register("welkin_chest_boat", () -> EntityType.Builder.<WelkinChestBoatEntity>of(WelkinChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("welkin_chest_boat"));

    public static final Supplier<EntityType<FlooferEntity>> FLOOFER =
            ENTITY_TYPES.register("floofer", () -> EntityType.Builder.of(FlooferEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.75f).build("floofer"));
    public static final Supplier<EntityType<KoiEntity>> KOI =
            ENTITY_TYPES.register("koi", () -> EntityType.Builder.of(KoiEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.5f, 0.25f).build("koi"));

    public static void register(IEventBus eventBus) {ENTITY_TYPES.register(eventBus); }
}
