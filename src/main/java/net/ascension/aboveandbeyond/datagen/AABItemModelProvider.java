package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SaplingBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class AABItemModelProvider extends ItemModelProvider {
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

        withExistingParent(AABItems.KOI_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
    private ItemModelBuilder saplingItem(DeferredBlock<SaplingBlock> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID,"block/" + item.getId().getPath()));
    }
}