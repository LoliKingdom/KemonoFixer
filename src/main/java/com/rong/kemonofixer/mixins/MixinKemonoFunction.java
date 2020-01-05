package com.rong.kemonofixer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import erx.kemonocraft.utility.KemonoFunction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(KemonoFunction.class)
public class MixinKemonoFunction {

    /**
     * Checks against Material#AIR instead of Blocks#AIR
     */
    @Overwrite(remap = false)
    public static boolean isGround(World world, IBlockState state, BlockPos pos) {
        Material mat = state.getMaterial();
        return mat != Material.VINE && mat != Material.LEAVES && mat != Material.WOOD && mat != Material.AIR;
    }
    
}
