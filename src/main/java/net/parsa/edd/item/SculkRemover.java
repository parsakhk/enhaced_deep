package net.parsa.edd.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class SculkRemover extends Item {
    public SculkRemover(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {

        ItemStack stack = p_41427_.getItemInHand();

        if(!p_41427_.getLevel().isClientSide()) {
            BlockState posClicked = p_41427_.getLevel().getBlockState(p_41427_.getClickedPos());
            Player playerEntity = p_41427_.getPlayer();

            rightClickOnCertainBlockState(posClicked, p_41427_, playerEntity);
            stack.hurtAndBreak(1, playerEntity, (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
        }

        return super.useOn(p_41427_);
    }

    private void rightClickOnCertainBlockState(BlockState posClicked, UseOnContext p_41427_, Player player) {
        Random r = new Random();
        if(r.nextFloat() < 0.001) {
            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 1, 60));
        } else if(blocksValid(posClicked)) {
            p_41427_.getLevel().destroyBlock(p_41427_.getClickedPos(), false);
        }
    }

    private boolean blocksValid(BlockState posClicked) {
        return posClicked.getBlock() == Blocks.SCULK || posClicked.getBlock() == Blocks.SCULK_SENSOR
                || posClicked.getBlock() == Blocks.SCULK_CATALYST || posClicked.getBlock() == Blocks.SCULK_SHRIEKER;
    }
}
