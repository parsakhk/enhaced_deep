package net.parsa.edd.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.parsa.edd.EnhancedDeepDark;

public class ModTags {

    public static class ModBlockTags {
        public static final TagKey<Block> CAN_GROW_ON_PLANTER = BlockTags.create(new ResourceLocation(EnhancedDeepDark.MODID, "sculk_growing/can_grow_on_planter"));

    }

}
