/*package net.ascension.aboveandbeyond.entity.custom;

import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.entity.AABEntities;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class WelkinChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(WelkinChestBoatEntity.class, EntityDataSerializers.INT);

    public WelkinChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public WelkinChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
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

    public void setVariant(WelkinBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, WelkinBoatEntity.Type.WELKIN.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(WelkinBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public WelkinBoatEntity.Type getModVariant() {
        return WelkinBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}*/