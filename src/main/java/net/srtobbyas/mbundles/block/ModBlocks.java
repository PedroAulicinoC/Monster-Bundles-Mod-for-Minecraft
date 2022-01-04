package net.srtobbyas.mbundles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.srtobbyas.mbundles.MonsterBundlesMOD;
import net.srtobbyas.mbundles.block.custom.MagmaCubeBlock;
import net.srtobbyas.mbundles.block.custom.TearBlock;
import net.srtobbyas.mbundles.block.custom.TeleportBlock;
import net.srtobbyas.mbundles.item.ModItems;

import java.util.Random;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MonsterBundlesMOD.MOD_ID);

    // Blocks

    public static final RegistryObject<Block> BLAZE_BLOCK = BLOCKS.register
            ("blaze_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of
                    (Material.METAL).sound(SoundType.NETHER_BRICKS).strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SKULL_BLOCK = BLOCKS.register
            ("skull_block", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of
                    (Material.STONE).sound(SoundType.BONE_BLOCK).strength(2.5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FIRE_SKULL_BLOCK = BLOCKS.register
            ("fire_skull_block", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of
                    (Material.STONE).sound(SoundType.BONE_BLOCK).strength(2.5f).requiresCorrectToolForDrops()
                    .lightLevel(state -> 15)));

        public static final RegistryObject<Block> GUNPOWDER_BLOCK = registerBlock("gunpowder_block",
            () -> new GravelBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(1f).sound(SoundType.SAND)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> ROTTEN_BLOCK = registerBlock("rotten_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.1f).sound(SoundType.CORAL_BLOCK))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 2;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 1;
                }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> TEAR_BLOCK = registerBlock("tear_block",
            () -> new TearBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .lightLevel(state -> state.getValue(TearBlock.CLICKED) ? 2 : 0 )),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> STRING_BLOCK = BLOCKS.register
            ("string_block", () -> new Block(BlockBehaviour.Properties.of
                    (Material.WOOL).sound(SoundType.WOOL).strength(0.8f))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }});

    public static final RegistryObject<Block> ENDER_PEARL_BLOCK = registerBlock("ender_pearl_block",
            () -> new TeleportBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).sound(SoundType.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> EYE_BLOCK = registerBlock("eye_block",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(1f).sound(SoundType.FUNGUS)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> MAGMA_CUBE_BLOCK = registerBlock("magma_cube_block",
            () -> new MagmaCubeBlock(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(0f).sound(SoundType.SLIME_BLOCK).lightLevel(state -> 6)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> PHANTOM_BLOCK = registerBlock("phantom_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(2.2f).sound(SoundType.STONE).requiresCorrectToolForDrops())
            {
                @Override
                public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
                    return true;
                }
            },
            CreativeModeTab.TAB_DECORATIONS);

    // Helpers
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
