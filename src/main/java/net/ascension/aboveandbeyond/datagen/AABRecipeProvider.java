package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.ascension.aboveandbeyond.util.AABTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AABRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public AABRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AABBlocks.COARSE_AEROSOIL.get(), 4)
                .pattern("AZ")
                .pattern("ZA")
                .define('A', AABBlocks.AEROSOIL.get())
                .define('Z', AABBlocks.ZEN_GRAVEL.get())
                .unlockedBy("has_aerosoil", has(AABBlocks.AEROSOIL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AABBlocks.WELKIN_WOOD.get(), 3)
                .pattern("LL")
                .pattern("LL")
                .define('L', AABBlocks.WELKIN_LOG.get())
                .unlockedBy("has_welkin_log", has(AABBlocks.WELKIN_LOG)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AABBlocks.STRIPPED_WELKIN_WOOD.get(), 3)
                .pattern("LL")
                .pattern("LL")
                .define('L', AABBlocks.STRIPPED_WELKIN_LOG.get())
                .unlockedBy("has_stripped_welkin_log", has(AABBlocks.STRIPPED_WELKIN_LOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AABBlocks.WELKIN_PLANKS.get(), 4)
                .requires(AABTags.Items.WELKIN_LOGS)
                .unlockedBy("has_welkin_log", has(AABBlocks.WELKIN_LOG))
                .save(recipeOutput, "aboveandbeyond:welkin_planks_from_welkin_logs");

        stairBuilder(AABBlocks.WELKIN_STAIRS.get(), Ingredient.of(AABBlocks.WELKIN_PLANKS)).group("welkin")
                .unlockedBy("has_welkin_planks", has(AABBlocks.WELKIN_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, AABBlocks.WELKIN_SLAB.get(), AABBlocks.WELKIN_PLANKS.get());

        buttonBuilder(AABBlocks.WELKIN_BUTTON.get(), Ingredient.of(AABBlocks.WELKIN_PLANKS.get())).group("welkin")
                .unlockedBy("has_welkin_planks", has(AABBlocks.WELKIN_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, AABBlocks.WELKIN_PRESSURE_PLATE.get(), AABBlocks.WELKIN_PLANKS.get());

        fenceBuilder(AABBlocks.WELKIN_FENCE.get(), Ingredient.of(AABBlocks.WELKIN_PLANKS.get())).group("welkin")
                .unlockedBy("has_welkin_planks", has(AABBlocks.WELKIN_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(AABBlocks.WELKIN_FENCE_GATE.get(), Ingredient.of(AABBlocks.WELKIN_PLANKS.get())).group("welkin")
                .unlockedBy("has_welkin_planks", has(AABBlocks.WELKIN_PLANKS.get())).save(recipeOutput);

        doorBuilder(AABBlocks.WELKIN_DOOR.get(), Ingredient.of(AABBlocks.WELKIN_PLANKS.get())).group("welkin")
                .unlockedBy("has_welkin_planks", has(AABBlocks.WELKIN_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(AABBlocks.WELKIN_TRAPDOOR.get(), Ingredient.of(AABBlocks.WELKIN_PLANKS.get())).group("welkin")
                .unlockedBy("has_welkin_planks", has(AABBlocks.WELKIN_PLANKS.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.YELLOW_DYE, 1)
                .requires(AABItems.STARFLOWER)
                .unlockedBy("has_starflower", has(AABBlocks.STARFLOWER))
                .save(recipeOutput, "aboveandbeyond:yellow_dye_from_starflower");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, 1)
                .requires(AABItems.SKYACINTH)
                .unlockedBy("has_skyacinth", has(AABBlocks.SKYACINTH))
                .save(recipeOutput, "aboveandbeyond:light_blue_dye_from_skyacinth");

        List<ItemLike> COBALT_SMELTABLES = List.of(AABBlocks.STATIC_DEBRIS);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AABItems.COBALT_INGOT.get())
                .pattern("CC")
                .define('C', AABItems.COBALT_SCRAP.get())
                .unlockedBy("has_cobalt_scrap", has(AABItems.COBALT_SCRAP)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AABBlocks.COBALT_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', AABItems.COBALT_INGOT.get())
                .unlockedBy("has_cobalt_ingot", has(AABItems.COBALT_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AABItems.COBALT_INGOT.get(), 9)
                .requires(AABBlocks.COBALT_BLOCK)
                .unlockedBy("has_cobalt_block", has(AABBlocks.COBALT_BLOCK)).save(recipeOutput, "aboveandbeyond:cobalt_ingot_from_cobalt_block");


        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_SWORD),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_SWORD.get());
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_PICKAXE),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_PICKAXE.get());
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_AXE),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_AXE.get());
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_SHOVEL),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_SHOVEL.get());
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_HOE),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_HOE.get());

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_HELMET),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_HELMET.get());
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_CHESTPLATE),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_CHESTPLATE.get());
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_LEGGINGS),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_LEGGINGS.get());
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(AABItems.COBALT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_BOOTS),
                Ingredient.of(AABItems.COBALT_INGOT), RecipeCategory.MISC,
                AABItems.COBALT_BOOTS.get());

        oreSmelting(recipeOutput, COBALT_SMELTABLES, RecipeCategory.MISC, AABItems.COBALT_SCRAP.get(), 2.0f, 200, "cobalt");
        oreBlasting(recipeOutput, COBALT_SMELTABLES, RecipeCategory.MISC, AABItems.COBALT_SCRAP.get(), 2.0f, 100, "cobalt");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, AboveAndBeyond.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}