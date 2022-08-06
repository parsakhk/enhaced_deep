package net.parsa.edd.datagen.loot;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.parsa.edd.block.ModBlockRegistries;
import net.parsa.edd.item.ModItemRegistries;

public class ModBlockLootTables extends BlockLoot {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[] { 0.05F, 0.0625F, 0.083333336F, 0.1F };

    @Override
    protected void addTables() {
        this.dropSelf(ModBlockRegistries.DEEP_BOARD.get());
        this.dropSelf(ModBlockRegistries.SCULK_GROWER.get());
        this.dropSelf(ModBlockRegistries.SCULK_MUSHROOM.get());

        this.add(ModBlockRegistries.SCULKY_IRON_ORE.get(),
                (block) -> createOreDrop(ModBlockRegistries.SCULKY_IRON_ORE.get(), Items.RAW_IRON));
        this.add(ModBlockRegistries.SCULKY_GOLD_ORE.get(),
                (block) -> createOreDrop(ModBlockRegistries.SCULKY_GOLD_ORE.get(), Items.RAW_GOLD));
        this.add(ModBlockRegistries.SCULKY_DIAMOND_ORE.get(),
                (block) -> createOreDrop(ModBlockRegistries.SCULKY_DIAMOND_ORE.get(), Items.DIAMOND));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlockRegistries.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
