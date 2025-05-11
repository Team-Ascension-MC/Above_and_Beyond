package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class AABBlockLootTableProvider extends BlockLootSubProvider {
protected AABBlockLootTableProvider(HolderLookup.Provider registries) {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
}

@Override
protected void generate() {
    this.dropWhenSilkTouch(AABBlocks.PUFFGRASS_BLOCK.get());
    this.dropSelf(AABBlocks.AEROSOIL.get());
    this.dropSelf(AABBlocks.COARSE_AEROSOIL.get());
    this.dropSelf(AABBlocks.ZENSTONE.get());
    this.dropSelf(AABBlocks.ZENSTONE_STAIRS.get());
    this.dropSelf(AABBlocks.ZENSTONE_SLAB.get());
    this.dropSelf(AABBlocks.ZENSTONE_WALL.get());
    this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICKS.get());
    this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICK_STAIRS.get());
    this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICK_SLAB.get());
    this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICK_WALL.get());
    this.dropSelf(AABBlocks.ZEN_GRAVEL.get());
    this.dropSelf(AABBlocks.CLOUD_BLOCK.get());
    this.dropSelf(AABBlocks.WELKIN_LOG.get());
    this.dropSelf(AABBlocks.WELKIN_WOOD.get());
    this.dropSelf(AABBlocks.STRIPPED_WELKIN_LOG.get());
    this.dropSelf(AABBlocks.STRIPPED_WELKIN_WOOD.get());
    this.dropSelf(AABBlocks.WELKIN_PLANKS.get());
    this.dropSelf(AABBlocks.WELKIN_STAIRS.get());
    this.dropSelf(AABBlocks.WELKIN_SLAB.get());
    this.dropSelf(AABBlocks.WELKIN_PRESSURE_PLATE.get());
    this.dropSelf(AABBlocks.WELKIN_BUTTON.get());
    this.dropSelf(AABBlocks.WELKIN_FENCE.get());
    this.dropSelf(AABBlocks.WELKIN_FENCE_GATE.get());
    add(AABBlocks.WELKIN_DOOR.get(),
            block -> createDoorTable(AABBlocks.WELKIN_DOOR.get()));
    this.dropSelf(AABBlocks.WELKIN_TRAPDOOR.get());
}

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
    HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
    return this.createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                    .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
   }
@Override
protected @NotNull Iterable<Block> getKnownBlocks() {
    return AABBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
}
}