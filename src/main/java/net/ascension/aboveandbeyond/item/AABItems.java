package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.entity.AABEntities;
import net.ascension.aboveandbeyond.item.custom.CloudBucket;
import net.ascension.aboveandbeyond.item.custom.KoiBucket;
import net.ascension.aboveandbeyond.sound.AABSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AABItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AboveAndBeyond.MOD_ID);

    /* Cloud Islands */
    public static final DeferredItem<Item> PUFFGRASS = ITEMS.register("puffgrass",
            () -> new BlockItem(AABBlocks.PUFFGRASS.get(), new Item.Properties()));
    public static final DeferredItem<Item> STARFLOWER = ITEMS.register("starflower",
            () -> new BlockItem(AABBlocks.STARFLOWER.get(), new Item.Properties()));
    public static final DeferredItem<Item> SKYACINTH = ITEMS.register("skyacinth",
            () -> new BlockItem(AABBlocks.SKYACINTH.get(), new Item.Properties()));
    public static final DeferredItem<Item> CLOUD_BUCKET = ITEMS.register("cloud_bucket",
            () -> new CloudBucket(AABBlocks.CLOUD_BLOCK.get(), SoundEvents.SNOW_PLACE, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> KOI_BUCKET = ITEMS.register("koi_bucket",
            () -> new KoiBucket(AABEntities.KOI.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH,
                new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CLOUD_BERRY = ITEMS.register("cloud_berry",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationModifier(0.2f)
                            .build())));
    public static final DeferredItem<Item> MUSIC_DISC_GALE = ITEMS.register("music_disc_gale",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(AABSounds.GALE_KEY).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_VIVID = ITEMS.register("music_disc_vivid",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(AABSounds.VIVID_KEY).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_HEIST = ITEMS.register("music_disc_heist",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(AABSounds.HEIST_KEY).stacksTo(1)));

    public static final DeferredItem<SwordItem> KATANA = ITEMS.register("katana",
            () -> new SwordItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, 6, -2.2f))
                    .durability(1562)
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final DeferredItem<Item> KOI_SPAWN_EGG = ITEMS.register("koi_spawn_egg",
            () -> new DeferredSpawnEggItem(AABEntities.KOI, 0x31afaf, 0xddac00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}