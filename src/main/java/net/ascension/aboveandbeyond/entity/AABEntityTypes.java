package net.ascension.aboveandbeyond.entity;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.custom.AABBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AABEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
            DeferredRegister.create(net.minecraft.core.registries.Registries.ENTITY_TYPE, AboveAndBeyond.MOD_ID);

    public static final DeferredEntityType<AABBoatEntity> AAB_BOAT = ENTITY_TYPES.register("boat",
            () -> EntityType.Builder.<AABBoatEntity>of(AABBoatEntity::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .clientTrackingRange(10)
                    .build("boat"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}