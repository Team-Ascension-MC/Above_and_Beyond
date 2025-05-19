package net.ascension.aboveandbeyond.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;

public class KoiBucket extends MobBucketItem {

    public KoiBucket(EntityType<?> entityType, Fluid fluid, SoundEvent soundEvent, Item.Properties properties) {
        super(entityType, fluid, soundEvent, properties);
    }
}