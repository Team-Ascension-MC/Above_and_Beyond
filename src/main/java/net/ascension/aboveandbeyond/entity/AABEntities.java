package net.ascension.aboveandbeyond.entity;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.custom.KoiEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AboveAndBeyond.MOD_ID);

    public static final Supplier<EntityType<KoiEntity>> FLOOFER =
            ENTITY_TYPES.register("floofer", () -> EntityType.Builder.of(FlooferEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.65f).build("floofer"));
    public static final Supplier<EntityType<KoiEntity>> KOI =
            ENTITY_TYPES.register("koi", () -> EntityType.Builder.of(KoiEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.65f).build("koi"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
