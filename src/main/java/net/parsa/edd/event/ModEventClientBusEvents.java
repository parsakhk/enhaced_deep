package net.parsa.edd.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.block.ModBlockRegistries;
import net.parsa.edd.particle.ModParticles;
import net.parsa.edd.particle.custom.SculkPrisoners;
import net.parsa.edd.recipe.DeepBoardRecipe;
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

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(EnhancedDeepDark.MODID, DeepBoardRecipe.Type.ID),
                    DeepBoardRecipe.Type.INSTANCE);
        });
    }
}
