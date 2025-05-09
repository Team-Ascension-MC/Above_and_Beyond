package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.sound.AABSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AABItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AboveAndBeyond.MOD_ID);

    /* Cloud Islands */
    public static final DeferredItem<Item> STARFLOWER = ITEMS.register("starflower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MUSIC_DISC_GALE = ITEMS.register("music_disc_gale",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(AABSounds.GALE_KEY).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_VIVID = ITEMS.register("music_disc_vivid",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(AABSounds.VIVID_KEY).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}