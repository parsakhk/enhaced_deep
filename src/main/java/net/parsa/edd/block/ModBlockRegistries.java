package net.parsa.edd.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.block.custom.DeepBoard;
import net.parsa.edd.block.custom.SculkyGrower;
import net.parsa.edd.item.ModItemGroups;
import net.parsa.edd.item.ModItemRegistries;
import net.parsa.edd.item.SculkRemover;

import java.util.function.Supplier;

public class ModBlockRegistries {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedDeepDark.MODID);

    public static final RegistryObject<Block> SCULK_MUSHROOM = registerBlock("sculk_mushroom", () -> new FlowerBlock(MobEffects.DARKNESS, 3, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion().noCollission()), ModItemGroups.EDD_TAB);
    public static final RegistryObject<Block> SCULK_GROWER = registerBlock("sculk_grower", () -> new SculkyGrower(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), ModItemGroups.EDD_TAB);
    public static final RegistryObject<Block> DEEP_BOARD = registerBlock("deep_board", () -> new DeepBoard(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), ModItemGroups.EDD_TAB);


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItemRegistries.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
