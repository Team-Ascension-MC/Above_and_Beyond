package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.SparkingSkies;
import net.ascension.aboveandbeyond.registry.AABEntities;
import net.ascension.aboveandbeyond.registry.AABItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class AABEntityLootTableProvider extends EntityLootSubProvider {

	public AABEntityLootTableProvider(HolderLookup.Provider registries) {
		super(FeatureFlags.REGISTRY.allFlags(), registries);
	}

	@Override
	public void generate() {
		this.add(AABEntities.FLOOFER.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(AABItems.FLOOF.get())
							.apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
							.apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0, 1)))
						).when(LootItemKilledByPlayerCondition.killedByPlayer())
				)
		);
		this.add(AABEntities.KOI.get(), LootTable.lootTable()
//				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
//						.add(LootItem.lootTableItem(Items.COD)
//								.apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
//						)
//				)
//				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
//						.add(LootItem.lootTableItem(Items.BONE_MEAL)).when(LootItemRandomChanceCondition.randomChance(0.05F))
//				)
		);
	}

	@Override
	protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
		return BuiltInRegistries.ENTITY_TYPE.stream()
				.filter(entry -> BuiltInRegistries.ENTITY_TYPE.getKey(entry).getNamespace().equals(SparkingSkies.ID));
	}

}
