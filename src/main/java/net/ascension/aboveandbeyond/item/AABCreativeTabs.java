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
                        output.accept(AABBlocks.BLEACHED_GRAVEL);
                        output.accept(AABItems.STARFLOWER);
                        output.accept(AABItems.MUSIC_DISC_GALE);
                        output.accept(AABItems.MUSIC_DISC_VIVID);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
