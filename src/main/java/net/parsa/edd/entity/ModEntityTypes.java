package net.parsa.edd.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.entity.custom.SculkEnderman;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, EnhancedDeepDark.MODID);

    public static final RegistryObject<EntityType<SculkEnderman>> SCULK_ENDERMAN =
            ENTITY_TYPES.register("sculk_enderman",
                    () -> EntityType.Builder.of(SculkEnderman::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(EnhancedDeepDark.MODID, "sculk_enderman").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
