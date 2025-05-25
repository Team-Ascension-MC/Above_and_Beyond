package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.SaplingBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class AABItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public AABItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AboveAndBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AABItems.MUSIC_DISC_GALE.get());
        basicItem(AABItems.MUSIC_DISC_VIVID.get());
        basicItem(AABItems.MUSIC_DISC_HEIST.get());
        basicItem(AABBlocks.CLOUD_BLOCK.asItem());
        basicItem(AABItems.CLOUD_BUCKET.get());
        basicItem(AABItems.KOI_BUCKET.get());
        basicItem(AABBlocks.WELKIN_DOOR.asItem());
        saplingItem(AABBlocks.WELKIN_SAPLING);
        basicItem(AABItems.CLOUD_BERRIES.get());
        basicItem(AABItems.FLOOF.get());
        withExistingParent(AABItems.KOI_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        //Nimbus Islands
        basicItem(AABItems.STORMY_CLOUD_BUCKET.get());
        basicItem(AABItems.COBALT_SCRAP.get());
        basicItem(AABItems.COBALT_INGOT.get());
        handheldItem(AABItems.COBALT_SWORD.get());
        handheldItem(AABItems.COBALT_PICKAXE.get());
        handheldItem(AABItems.COBALT_AXE.get());
        handheldItem(AABItems.COBALT_SHOVEL.get());
        handheldItem(AABItems.COBALT_HOE.get());
        handheldItem(AABItems.COBALT_CROSSBOW.get());

        trimmedArmorItem(AABItems.COBALT_HELMET);
        trimmedArmorItem(AABItems.COBALT_CHESTPLATE);
        trimmedArmorItem(AABItems.COBALT_LEGGINGS);
        trimmedArmorItem(AABItems.COBALT_BOOTS);

        basicItem(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE.get());

        basicItem(AABItems.BUZZ_POWDER.get());
        handheldItem(AABItems.STORMBRINGER_STAFF.get());
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = AboveAndBeyond.MOD_ID;

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
    private ItemModelBuilder saplingItem(DeferredBlock<SaplingBlock> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID,"block/" + item.getId().getPath()));
    }
}