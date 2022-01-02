package net.srtobbyas.mbundles.item.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.block.Block;
import net.srtobbyas.mbundles.item.ModItems;

import javax.annotation.Nullable;

public class WearableBlockItem extends BlockItem
{

    public WearableBlockItem(Block p_40565_, Properties p_40566_)
    {
        super(p_40565_, p_40566_);
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack)
    {
        return EquipmentSlot.HEAD;
    }
}
