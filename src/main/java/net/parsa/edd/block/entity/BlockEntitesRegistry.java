package net.parsa.edd.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.block.ModBlockRegistries;
import net.parsa.edd.block.entity.custom.SculkyGrowerBlockEntity;

public class BlockEntitesRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, EnhancedDeepDark.MODID);

    public static final RegistryObject<BlockEntityType<SculkyGrowerBlockEntity>> SCULKY_GROWER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("sculk_grower_block_entity", () ->
                    BlockEntityType.Builder.of(SculkyGrowerBlockEntity::new,
                            ModBlockRegistries.SCULK_GROWER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
