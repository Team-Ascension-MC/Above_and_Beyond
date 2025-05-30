package net.ascension.aboveandbeyond.block.entity;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AboveAndBeyond.MOD_ID);

    public static final Supplier<BlockEntityType<AABSignBlockEntity>> WELKIN_SIGN =
            BLOCK_ENTITIES.register("welkin_sign", () ->
                    BlockEntityType.Builder.of(AABSignBlockEntity::new,
                            AABBlocks.WELKIN_SIGN.get(), AABBlocks.WELKIN_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<AABHangingSignBlockEntity>> WELKIN_HANGING_SIGN =
            BLOCK_ENTITIES.register("welkin_hanging_sign", () ->
                    BlockEntityType.Builder.of(AABHangingSignBlockEntity::new,
                            AABBlocks.WELKIN_HANGING_SIGN.get(), AABBlocks.WELKIN_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}