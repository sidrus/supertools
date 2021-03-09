package com.ejafi.supertools.data;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Consumer;

public class MiscellaneousRecipeProvider extends RecipeProvider {
    private final Logger logger = LogManager.getLogger();

    public MiscellaneousRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        super.registerRecipes(consumer);

        registerSlimeRecipe(consumer);
    }

    private void registerSlimeRecipe(Consumer<IFinishedRecipe> consumer) {
        String recipeName = "slime_ball_from_crafting";
        try {
            ShapelessRecipeBuilder.shapelessRecipe(Items.SLIME_BALL, 4)
                    .addIngredient(Items.CLAY_BALL, 4)
                    .addIngredient(Items.WATER_BUCKET)
                    .addIngredient(Items.LIME_DYE)
                    .addCriterion("has_clay_ball", hasItem(Items.CLAY_BALL))
                    .addCriterion("has_lime_dye", hasItem(Items.LIME_DYE))
                    .build(consumer, recipeName);
        } catch (Exception e) {
            logRecipeError(recipeName, e.getMessage());
        }
    }

    private void logRecipeError(String name, String error) {
        logger.error(String.format("Error trying to generate '%s': %s", name, error));
    }
}
