package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.SparkingSkies;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod(value = SparkingSkies.ID) @EventBusSubscriber(modid = SparkingSkies.ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new AABBlockTagProvider(packOutput, lookupProvider, existingFileHelper);

        List<LootTableProvider.SubProviderEntry> subProviderEntries = List.of(
                new LootTableProvider.SubProviderEntry(AABBlockLootTableProvider::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(AABEntityLootTableProvider::new, LootContextParamSets.ENTITY)
        );
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), subProviderEntries, lookupProvider));
        generator.addProvider(event.includeServer(), new AABRecipeProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new AABItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new AABItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new AABBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new AABDatapackProvider(packOutput, lookupProvider));
    }
}