package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.entity.AABEntities;
import net.ascension.aboveandbeyond.item.custom.CloudBucket;
import net.ascension.aboveandbeyond.item.custom.KoiBucket;
import net.ascension.aboveandbeyond.sound.AABSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AABItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AboveAndBeyond.MOD_ID);

    /* SKY ISLANDS */

    //Cloud Islands
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
    public static final DeferredItem<Item> CLOUD_BERRIES = ITEMS.register("cloud_berries",
            () -> new ItemNameBlockItem(AABBlocks.CLOUD_BERRY_BUSH.get(), new Item.Properties()
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
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, 3.5f, -2.2f))
                    .durability(1762)
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final DeferredItem<Item> FLOOF = ITEMS.register("floof",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KOI_SPAWN_EGG = ITEMS.register("koi_spawn_egg",
            () -> new DeferredSpawnEggItem(AABEntities.KOI, 0x31afaf, 0xddac00,
                    new Item.Properties()));

    //Nimbus Islands
    public static final DeferredItem<Item> COBALT_CHUNK = ITEMS.register("cobalt_chunk",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STORMY_CLOUD_BUCKET = ITEMS.register("stormy_cloud_bucket",
            () -> new CloudBucket(AABBlocks.STORMY_CLOUD_BLOCK.get(), SoundEvents.WOOL_PLACE, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<SwordItem> COBALT_SWORD = ITEMS.register("cobalt_sword",
            () -> new SwordItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, 3, -2.35f))
                    .durability(1562)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON)
            ));
    public static final DeferredItem<PickaxeItem> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, 1, -2.75f))
                    .durability(1562)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON)
            ));
    public static final DeferredItem<AxeItem> COBALT_AXE = ITEMS.register("cobalt_axe",
            () -> new AxeItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, 5, -2.95f))
                    .durability(1562)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON)
            ));
    public static final DeferredItem<ShovelItem> COBALT_SHOVEL = ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, 1.5f, -2.95f))
                    .durability(1562)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON)
            ));
    public static final DeferredItem<HoeItem> COBALT_HOE = ITEMS.register("cobalt_hoe",
            () -> new HoeItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.DIAMOND, -3, -0.0f))
                    .durability(1562)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON)
            ));
    public static final DeferredItem<Item> COBALT_CROSSBOW = ITEMS.register("cobalt_crossbow",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<ArmorItem> COBALT_HELMET = ITEMS.register("cobalt_helmet",
            () -> new ArmorItem(AABArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> COBALT_CHESTPLATE = ITEMS.register("cobalt_chestplate",
            () -> new ArmorItem(AABArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> COBALT_LEGGINGS = ITEMS.register("cobalt_leggings",
            () -> new ArmorItem(AABArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> COBALT_BOOTS = ITEMS.register("cobalt_boots",
            () -> new ArmorItem(AABArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));
    public static final DeferredItem<Item> COBALT_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("cobalt_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BUZZ_POWDER = ITEMS.register("buzz_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STORMBRINGER_STAFF = ITEMS.register("stormbringer_staff",
            () -> new Item(new Item.Properties().durability(8).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}