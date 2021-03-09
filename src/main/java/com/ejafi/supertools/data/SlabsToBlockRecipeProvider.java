package com.ejafi.supertools.data;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Consumer;

public class SlabsToBlockRecipeProvider extends RecipeProvider {
    private final HashMap<Block, Block> transformations = new HashMap<>();
    private final Logger logger = LogManager.getLogger();

    public SlabsToBlockRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);

        // Planks
        transformations.put(Blocks.ACACIA_SLAB, Blocks.ACACIA_PLANKS);
        transformations.put(Blocks.BIRCH_SLAB, Blocks.BIRCH_PLANKS);
        transformations.put(Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS);
        transformations.put(Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS);
        transformations.put(Blocks.JUNGLE_SLAB, Blocks.JUNGLE_PLANKS);
        transformations.put(Blocks.OAK_SLAB, Blocks.OAK_PLANKS);
        transformations.put(Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS);
        transformations.put(Blocks.WARPED_SLAB, Blocks.WARPED_PLANKS);

        // Blocks
        transformations.put(Blocks.ANDESITE_SLAB, Blocks.ANDESITE);
        transformations.put(Blocks.BLACKSTONE_SLAB, Blocks.BLACKSTONE);
        transformations.put(Blocks.BRICK_SLAB, Blocks.BRICKS);
        transformations.put(Blocks.COBBLESTONE_SLAB, Blocks.COBBLESTONE);
        transformations.put(Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.CUT_RED_SANDSTONE);
        transformations.put(Blocks.CUT_SANDSTONE_SLAB, Blocks.CUT_SANDSTONE);
        transformations.put(Blocks.DARK_PRISMARINE_SLAB, Blocks.DARK_PRISMARINE);
        transformations.put(Blocks.DIORITE_SLAB, Blocks.DIORITE);
        transformations.put(Blocks.END_STONE_BRICK_SLAB, Blocks.END_STONE_BRICKS);
        transformations.put(Blocks.GRANITE_SLAB, Blocks.GRANITE);
        transformations.put(Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE);
        transformations.put(Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICKS);
        transformations.put(Blocks.NETHER_BRICK_SLAB, Blocks.NETHER_BRICKS);
        transformations.put(Blocks.POLISHED_ANDESITE_SLAB, Blocks.POLISHED_ANDESITE);
        transformations.put(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_BRICKS);
        transformations.put(Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE);
        transformations.put(Blocks.POLISHED_DIORITE_SLAB, Blocks.POLISHED_DIORITE);
        transformations.put(Blocks.POLISHED_GRANITE_SLAB, Blocks.POLISHED_GRANITE);
        transformations.put(Blocks.PRISMARINE_BRICK_SLAB, Blocks.PRISMARINE_BRICKS);
        transformations.put(Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE);
        transformations.put(Blocks.PURPUR_SLAB, Blocks.PURPUR_BLOCK);
        transformations.put(Blocks.QUARTZ_SLAB, Blocks.QUARTZ_BLOCK);
        transformations.put(Blocks.RED_NETHER_BRICK_SLAB, Blocks.RED_NETHER_BRICKS);
        transformations.put(Blocks.RED_SANDSTONE_SLAB, Blocks.RED_SANDSTONE);
        transformations.put(Blocks.SANDSTONE_SLAB, Blocks.SANDSTONE);
        transformations.put(Blocks.SMOOTH_QUARTZ_SLAB, Blocks.SMOOTH_QUARTZ);
        transformations.put(Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.SMOOTH_RED_SANDSTONE);
        transformations.put(Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_SANDSTONE);
        transformations.put(Blocks.SMOOTH_STONE_SLAB, Blocks.SMOOTH_STONE);
        transformations.put(Blocks.STONE_BRICK_SLAB, Blocks.STONE_BRICKS);
        transformations.put(Blocks.STONE_SLAB, Blocks.STONE);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        super.registerRecipes(consumer);

        Set<Block> keys = transformations.keySet();
        for (Block inputBlock : keys) {
            Block outputBlock = transformations.get(inputBlock);
            String recipeName = String.format("%s_from_%s", outputBlock.getRegistryName().getPath(), inputBlock.getRegistryName().getPath());
            try {
                ShapedRecipeBuilder.shapedRecipe(outputBlock, 1)
                        .key('#', inputBlock)
                        .patternLine(" # ")
                        .patternLine(" # ")
                        .addCriterion(String.format("has_%s", inputBlock.getRegistryName().getPath()), hasItem(inputBlock))
                        .build(consumer, recipeName);
            } catch (Exception e) {
                logger.error(String.format("Error trying to generate '%s': %s", recipeName, e.getMessage()));
            }
        }
    }
}
