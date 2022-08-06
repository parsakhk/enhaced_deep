package net.parsa.edd.entity.client.sculk_enderman;

import net.minecraft.resources.ResourceLocation;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.entity.custom.SculkEnderman;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SculkyEndermanModel extends AnimatedGeoModel<SculkEnderman> {
    @Override
    public ResourceLocation getModelResource(SculkEnderman object) {
        return new ResourceLocation(EnhancedDeepDark.MODID, "geo/sculk_enderman.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkEnderman object) {
        return new ResourceLocation(EnhancedDeepDark.MODID, "textures/entity/sculk_enderman/sculk_enderman.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkEnderman animatable) {
        return new ResourceLocation(EnhancedDeepDark.MODID, "animations/sculk_enderman.animation.json");
    }

}
