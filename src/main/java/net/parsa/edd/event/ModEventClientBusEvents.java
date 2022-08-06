package net.parsa.edd.event;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.entity.ModEntityTypes;
import net.parsa.edd.entity.custom.SculkEnderman;
import net.parsa.edd.particle.ModParticles;
import net.parsa.edd.particle.custom.SculkPrisoners;

import net.parsa.edd.recipe.SculkyGrowerRecipe;

import javax.annotation.Nonnull;


@Mod.EventBusSubscriber(modid = EnhancedDeepDark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SCULK_PRISONERS.get(),
                SculkPrisoners.Provider::new);
    }
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(EnhancedDeepDark.MODID, SculkyGrowerRecipe.Type.ID),
                    SculkyGrowerRecipe.Type.INSTANCE);
        });
    }

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.SCULK_ENDERMAN.get(), SculkEnderman.setAttributes());
    }
}
