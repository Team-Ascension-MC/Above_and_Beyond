package net.ascension.aboveandbeyond.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;

public class AABBoatEntity extends Boat {
    public AABBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }
}
