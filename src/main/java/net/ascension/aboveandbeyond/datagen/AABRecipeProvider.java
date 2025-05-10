package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AABBlocks.WELKIN_PLANKS.get(), 4)
                .requires(AABBlocks.WELKIN_LOG)
                .unlockedBy("has_welkin_log", has(AABBlocks.WELKIN_LOG))
                .save(recipeOutput, "aboveandbeyond:welkin_planks_from_welkin_log");
//        List<ItemLike> COBALT_SMELTABLES = List.of(AABItems.COBALT_SCRAP,
//                AABBlocks.COBALT_DEBRIS);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AABBlocks.COBALT_SCRAP_BLOCK.get())
//                .pattern("CCC")
//                .pattern("CCC")
//                .pattern("CCC")
//                .define('C', AABItems.COBALT_SCRAP.get())
//                .unlockedBy("has_bismuth", has(AABItems.BISMUTH)).save(recipeOutput);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AABItems.BISMUTH.get(), 9)
//                .requires(AABBlocks.COBALT_BLOCK)
//                .unlockedBy("has_bismuth_block", has(AABBlocks.BISMUTH_BLOCK)).save(recipeOutput);
//
//        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, AABItems.COBALT_SCRAP.get(), 0.25f, 200, "bismuth");
//        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, AABItems.COBALT_SCRAP.get(), 0.25f, 100, "bismuth");
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