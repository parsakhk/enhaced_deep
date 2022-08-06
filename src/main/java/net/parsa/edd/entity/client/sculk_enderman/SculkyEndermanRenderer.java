package net.parsa.edd.entity.client.sculk_enderman;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.parsa.edd.EnhancedDeepDark;
import net.parsa.edd.entity.custom.SculkEnderman;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SculkyEndermanRenderer extends GeoEntityRenderer<SculkEnderman> {
    public SculkyEndermanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SculkyEndermanModel());
        this.shadowRadius = 1f;
    }
    @Override
    public ResourceLocation getTextureLocation(SculkEnderman instance) {
        return new ResourceLocation(EnhancedDeepDark.MODID, "textures/entity/sculk_enderman");
    }
    @Override
    public RenderType getRenderType(SculkEnderman animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
