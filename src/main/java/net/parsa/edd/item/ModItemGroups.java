package net.parsa.edd.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab EDD_TAB = new CreativeModeTab("edd") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItemRegistries.SCULK_REMOVER.get());
        }
    };
}
