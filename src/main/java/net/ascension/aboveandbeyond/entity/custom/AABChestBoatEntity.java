package net.ascension.aboveandbeyond.entity.custom;

import net.ascension.aboveandbeyond.entity.AABEntities;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class AABChestBoatEntity { /*extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public AABChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public AABChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(AABEntities.WELKIN_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        switch (getModVariant()) {
            case WELKIN -> {
                return AABItems.WELKIN_CHEST_BOAT.get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(AABBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    protected void defineSynchedData() {
        this.entityData.set(DATA_ID_TYPE, AABBoatEntity.Type.WELKIN.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(AABBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public AABBoatEntity.Type getModVariant() {
        return AABBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }*/
}