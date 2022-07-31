package net.parsa.edd;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.parsa.edd.block.ModBlockRegistries;
import net.parsa.edd.block.entity.BlockEntitesRegistry;
import net.parsa.edd.item.ModItemRegistries;
import net.parsa.edd.particle.ModParticles;
import net.parsa.edd.screen.ModMenuTypes;
import net.parsa.edd.screen.SculkyGrowerScreen;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedDeepDark.MODID)
public class EnhancedDeepDark
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "edd";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public EnhancedDeepDark()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::commonSetup);

        ModItemRegistries.register(modEventBus);
        ModBlockRegistries.register(modEventBus);
        ModParticles.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        BlockEntitesRegistry.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void clientSetup(final FMLClientSetupEvent event) {


        ItemBlockRenderTypes.setRenderLayer(ModBlockRegistries.SCULK_MUSHROOM.get(), RenderType.cutout());


        MenuScreens.register(ModMenuTypes.SCULKY_GROWER_MENU.get(), SculkyGrowerScreen::new);

    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
