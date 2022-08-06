package net.parsa.edd.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.block.Blocks;
import net.parsa.edd.block.ModBlockRegistries;
import net.parsa.edd.datagen.custom.SculkyGrowerRecipeBuilder;
import net.parsa.edd.item.ModItemRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> p_176532_) {

        new SculkyGrowerRecipeBuilder(Blocks.STONE, Blocks.SCULK, 2)
                .unlockedBy("has_sculk", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.SCULK).build())).save(p_176532_);

        new SculkyGrowerRecipeBuilder(ModBlockRegistries.SCULKY_GOLD_ORE.get(), Blocks.DEEPSLATE_GOLD_ORE, 1)
                .unlockedBy("has_sculk", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.SCULK).build())).save(p_176532_);

        new SculkyGrowerRecipeBuilder(ModBlockRegistries.SCULKY_IRON_ORE.get(), Blocks.DEEPSLATE_IRON_ORE, 1)
                .unlockedBy("has_sculk", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.SCULK).build())).save(p_176532_);

        new SculkyGrowerRecipeBuilder(ModBlockRegistries.SCULKY_DIAMOND_ORE.get(), Blocks.DEEPSLATE_DIAMOND_ORE, 1)
                .unlockedBy("has_sculk", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.SCULK).build())).save(p_176532_);
    }
}
