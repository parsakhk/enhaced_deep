package net.parsa.edd.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.block.ModBlockRegistries;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, EnhancedDeepDark.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlockRegistries.SCULK_MUSHROOM.get());
        simpleBlock(ModBlockRegistries.SCULKY_GOLD_ORE.get());
        simpleBlock(ModBlockRegistries.SCULKY_IRON_ORE.get());
        simpleBlock(ModBlockRegistries.SCULKY_DIAMOND_ORE.get());
    }
}
