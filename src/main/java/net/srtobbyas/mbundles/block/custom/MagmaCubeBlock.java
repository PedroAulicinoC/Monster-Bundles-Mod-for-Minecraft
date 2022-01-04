package net.srtobbyas.mbundles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MagmaCubeBlock extends CarvedPumpkinBlock
{
    public MagmaCubeBlock(Properties p_53985_)
    {
        super(p_53985_);
    }

    public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity p_153780_)
    {
        if (!p_153780_.fireImmune() && p_153780_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_153780_)) {
            p_153780_.hurt(DamageSource.ON_FIRE, 1.0F);
        }

        super.stepOn(p_153777_, p_153778_, p_153779_, p_153780_);
    }

    @Override
    public boolean isStickyBlock(BlockState state)
    {
        return true;
    }

}

