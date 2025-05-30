package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
        this.dropWhenSilkTouch(AABBlocks.AEROSOIL_PATH.get());
        this.dropSelf(AABBlocks.COARSE_AEROSOIL.get());
        this.dropSelf(AABBlocks.ZENSTONE.get());
        this.dropSelf(AABBlocks.ZENSTONE_STAIRS.get());
        this.dropSelf(AABBlocks.ZENSTONE_SLAB.get());
        this.dropSelf(AABBlocks.ZENSTONE_WALL.get());
        this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICKS.get());
        this.dropSelf(AABBlocks.CRACKED_POLISHED_ZENSTONE_BRICKS.get());
        this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICK_STAIRS.get());
        this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICK_SLAB.get());
        this.dropSelf(AABBlocks.POLISHED_ZENSTONE_BRICK_WALL.get());
        this.dropSelf(AABBlocks.CHISELED_POLISHED_ZENSTONE_BRICKS.get());
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
        this.dropWhenSilkTouch(AABBlocks.PUFFGRASS.get());
        this.dropSelf(AABBlocks.STARFLOWER.get());
        this.dropSelf(AABBlocks.SKYACINTH.get());
        add(AABBlocks.WELKIN_DOOR.get(),
                block -> createDoorTable(AABBlocks.WELKIN_DOOR.get()));
        this.dropSelf(AABBlocks.WELKIN_TRAPDOOR.get());
        this.add(AABBlocks.WELKIN_SIGN.get(), block ->
                createSingleItemTable(AABItems.WELKIN_SIGN.get()));
        this.add(AABBlocks.WELKIN_WALL_SIGN.get(), block ->
                createSingleItemTable(AABItems.WELKIN_SIGN.get()));
        this.add(AABBlocks.WELKIN_HANGING_SIGN.get(), block ->
                createSingleItemTable(AABItems.WELKIN_HANGING_SIGN.get()));
        this.add(AABBlocks.WELKIN_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(AABItems.WELKIN_HANGING_SIGN.get()));
        this.add(AABBlocks.WELKIN_LEAVES.get(), block ->
                createLeavesDrops(block, AABBlocks.WELKIN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(AABBlocks.WELKIN_SAPLING.get());

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(AABBlocks.CLOUD_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(AABBlocks.CLOUD_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(AABItems.CLOUD_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(AABBlocks.CLOUD_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(AABItems.CLOUD_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

        //Nimbus Islands
        this.dropWhenSilkTouch(AABBlocks.NIMBUS_PUFFGRASS_BLOCK.get());
        this.dropSelf(AABBlocks.SHOCKROCK.get());
        this.dropSelf(AABBlocks.STATIC_SHOCKROCK.get());
        this.dropSelf(AABBlocks.SHOCKROCK_COPPER_ORE.get());
        this.dropSelf(AABBlocks.STATIC_DEBRIS.get());
        this.dropSelf(AABBlocks.STORMY_CLOUD_BLOCK.get());
        this.dropSelf(AABBlocks.COBALT_BLOCK.get());

        //Ridge Temples
        this.dropWhenSilkTouch(AABBlocks.EXPLOSIVE_BARREL.get());
    }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks () {
            return AABBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
        }
    }