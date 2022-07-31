package net.parsa.edd.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodRegistries {

    public static final FoodProperties SCULK_SOUP = (new FoodProperties.Builder()).fast().nutrition(5).saturationMod(3.2F).effect(new MobEffectInstance(MobEffects.DARKNESS, 2, 400), 1F).build();

}
