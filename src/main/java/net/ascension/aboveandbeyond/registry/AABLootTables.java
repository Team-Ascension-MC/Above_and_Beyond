package net.ascension.aboveandbeyond.registry;

import net.ascension.aboveandbeyond.SparkingSkies;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class AABLootTables {

	public static final ResourceKey<LootTable> FLOOFER_SNEEZE = register("gameplay/floofer_sneeze");

	public static ResourceKey<LootTable> register(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(SparkingSkies.ID, path));
	}

}
