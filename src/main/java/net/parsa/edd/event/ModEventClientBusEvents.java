package net.parsa.edd.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.particle.ModParticles;
import net.parsa.edd.particle.custom.SculkPrisoners;


@Mod.EventBusSubscriber(modid = EnhancedDeepDark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SCULK_PRISONERS.get(),
                SculkPrisoners.Provider::new);
    }
}
