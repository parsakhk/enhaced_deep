package net.parsa.edd.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SculkPrisoners extends RisingParticle {

    private final SpriteSet sprites;
    protected boolean isGlowing;

    SculkPrisoners(ClientLevel p_107631_, double p_107632_, double p_107633_, double p_107634_, double p_107635_, double p_107636_, double p_107637_, SpriteSet sprites) {
        super(p_107631_, p_107632_, p_107633_, p_107634_, p_107635_, p_107636_, p_107637_);
        this.sprites = sprites;
        this.scale(1.8F);
        this.setSpriteFromAge(sprites);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
    }
    @OnlyIn(Dist.CLIENT)
    public static class EmissiveProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public EmissiveProvider(SpriteSet p_234083_) {
            this.sprite = p_234083_;
        }

        public Particle createParticle(SimpleParticleType p_234094_, ClientLevel p_234095_, double p_234096_, double p_234097_, double p_234098_, double p_234099_, double p_234100_, double p_234101_) {
            SculkPrisoners sculkprisoners = new SculkPrisoners(p_234095_, p_234096_, p_234097_, p_234098_, p_234099_, p_234100_, p_234101_, this.sprite);
            sculkprisoners.setAlpha(1.0F);
            sculkprisoners.isGlowing = true;
            return sculkprisoners;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet p_107739_) {
            this.sprite = p_107739_;
        }

        public Particle createParticle(SimpleParticleType p_107750_, ClientLevel p_107751_, double p_107752_, double p_107753_, double p_107754_, double p_107755_, double p_107756_, double p_107757_) {
            SculkPrisoners sculkprisoners = new SculkPrisoners(p_107751_, p_107752_, p_107753_, p_107754_, p_107755_, p_107756_, p_107757_, this.sprite);
            sculkprisoners.setAlpha(1.0F);
            return sculkprisoners;
        }
    }
}
