package net.ascension.aboveandbeyond.component;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.entity.KoiVariant;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.text.NumberFormat;
import java.util.function.UnaryOperator;

public class AABDataComponent {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
        DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, AboveAndBeyond.MOD_ID);

    /* DATA */

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<KoiVariant>> KOI_VARIANT = register("koi_variant",
            builder -> builder.persistent(KoiVariant.CODEC));

    /*      */

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderUnaryOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}