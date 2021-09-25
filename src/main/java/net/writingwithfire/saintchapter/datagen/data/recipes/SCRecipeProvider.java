package net.writingwithfire.saintchapter.datagen.data.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.writingwithfire.saintchapter.datagen.data.recipes.vanilla.VanillaTypeRecipeProvider;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class SCRecipeProvider extends RecipeProvider {
    public SCRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(@Nonnull Consumer<IFinishedRecipe> registrar) {
        VanillaTypeRecipeProvider.registerCookingRecipes(registrar);
        VanillaTypeRecipeProvider.registerCustomRecipes(registrar);
        VanillaTypeRecipeProvider.registerShapedRecipes(registrar);
        VanillaTypeRecipeProvider.registerStoneCutterRecipes(registrar);
    }
}
