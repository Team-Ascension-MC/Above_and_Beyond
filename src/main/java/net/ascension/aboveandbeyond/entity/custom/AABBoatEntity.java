package net.ascension.aboveandbeyond.entity.custom;

import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.entity.AABEntities;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class AABBoatEntity { /*extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public AABBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public AABBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(AABEntities.WELKIN_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        switch (getModVariant()) {
            case WELKIN -> {
                return AABItems.WELKIN_BOAT.get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(AABBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public AABBoatEntity.Type getModVariant() {
        return AABBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData() {
        this.entityData.set(DATA_ID_TYPE, Type.WELKIN.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(AABBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public static enum Type implements StringRepresentable {
        WELKIN(AABBlocks.WELKIN_PLANKS.get(), "welkin");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<AABBoatEntity.Type> CODEC = StringRepresentable.fromEnum(AABBoatEntity.Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static AABBoatEntity.Type byId(int pId) {
            return BY_ID.apply(pId);
        }

        public static AABBoatEntity.Type byName(String pName) {
            return CODEC.byName(pName, WELKIN);
        }
    }*/
}