package net.srtobbyas.mbundles.block.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class WearableBlock extends BlockItem
{
    public WearableBlock(Block block, Item.Properties properties)
    {
        super(block, properties);
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack)
    {
        return EquipmentSlot.HEAD;
    }
}
