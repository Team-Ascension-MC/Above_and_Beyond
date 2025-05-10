package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AboveAndBeyond.MOD_ID);

    public static final Supplier<CreativeModeTab> ABOVE_AND_BEYOND_TAB = CREATIVE_MODE_TAB.register("above_and_beyond_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AABBlocks.PUFFGRASS_BLOCK.get()))
                    .title(Component.translatable("creativetab.aboveandbeyond.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        /* Cloud Islands */
                        output.accept(AABBlocks.PUFFGRASS_BLOCK);
                        output.accept(AABBlocks.AEROSOIL);
                        output.accept(AABBlocks.COARSE_AEROSOIL);
                        output.accept(AABBlocks.ZEN_GRAVEL);
                        output.accept(AABItems.STARFLOWER);
                        output.accept(AABBlocks.WELKIN_LOG);
                        output.accept(AABBlocks.WELKIN_WOOD);
                        output.accept(AABBlocks.STRIPPED_WELKIN_LOG);
                        output.accept(AABBlocks.STRIPPED_WELKIN_WOOD);
                        output.accept(AABBlocks.WELKIN_PLANKS);
                        output.accept(AABBlocks.WELKIN_STAIRS);
                        output.accept(AABBlocks.WELKIN_SLAB);
                        output.accept(AABBlocks.WELKIN_PRESSURE_PLATE);
                        output.accept(AABBlocks.WELKIN_BUTTON);
                        output.accept(AABBlocks.WELKIN_FENCE);
                        output.accept(AABBlocks.WELKIN_FENCE_GATE);
                        output.accept(AABBlocks.WELKIN_DOOR);
                        output.accept(AABBlocks.WELKIN_TRAPDOOR);
                        output.accept(AABItems.MUSIC_DISC_GALE);
                        output.accept(AABItems.MUSIC_DISC_VIVID);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
