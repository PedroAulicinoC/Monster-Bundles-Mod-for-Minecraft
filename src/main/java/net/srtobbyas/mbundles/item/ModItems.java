package net.srtobbyas.mbundles.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.srtobbyas.mbundles.MonsterBundlesMOD;
import net.srtobbyas.mbundles.block.ModBlocks;
import net.srtobbyas.mbundles.item.custom.BlazeBlockFuel;
import net.srtobbyas.mbundles.item.custom.StringBlockFuel;
import net.srtobbyas.mbundles.item.custom.WearableBlockItem;

public class ModItems
{
    //Helper
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MonsterBundlesMOD.MOD_ID);

    //Items
    public static final RegistryObject<Item> SKULL_BLOCK = ITEMS.register("skull_block",
            () -> new WearableBlockItem(ModBlocks.SKULL_BLOCK.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> FIRE_SKULL_BLOCK = ITEMS.register("fire_skull_block",
            () -> new WearableBlockItem(ModBlocks.FIRE_SKULL_BLOCK.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> BLAZE_BLOCK = ITEMS.register("blaze_block",
            () -> new BlazeBlockFuel(ModBlocks.BLAZE_BLOCK.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> STRING_BLOCK = ITEMS.register("string_block",
            () -> new StringBlockFuel(ModBlocks.STRING_BLOCK.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
