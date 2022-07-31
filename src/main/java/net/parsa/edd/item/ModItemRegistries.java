package net.parsa.edd.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.parsa.edd.EnhancedDeepDark;

public class ModItemRegistries {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedDeepDark.MODID);

    public static final RegistryObject<Item> SCULK_REMOVER = ITEMS.register("sculk_remover",
            () -> new SculkRemover(new Item.Properties().tab(ModItemGroups.EDD_TAB)));

    
    public static final RegistryObject<Item> SCULK_SOUP = ITEMS.register("sculk_soup",
            () -> new Item(new Item.Properties().tab(ModItemGroups.EDD_TAB).food(ModFoodRegistries.SCULK_SOUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
