package net.srtobbyas.mbundles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class TearBlock extends Block
{
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public TearBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
    }

    @Override
    public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_,
                                 Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_)
    {
        if(!p_60504_.isClientSide() && p_60507_ == InteractionHand.MAIN_HAND)
        {
            boolean currentState = p_60503_.getValue(CLICKED);
            p_60504_.setBlock(p_60505_, p_60503_.setValue(CLICKED,!currentState), 3);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_)
    {
        p_49915_.add(CLICKED);
    }
}
