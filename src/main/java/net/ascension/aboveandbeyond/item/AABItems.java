package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AABItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AboveAndBeyond.MOD_ID);

    //Cloud Islands
    public static final DeferredItem<Item> COMPACTED_WHITE_STUFF_BRICK = ITEMS.register("compacted_white_stuff_brick",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}