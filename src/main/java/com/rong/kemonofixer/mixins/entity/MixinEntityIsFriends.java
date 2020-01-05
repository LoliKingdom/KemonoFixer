package com.rong.kemonofixer.mixins.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.rong.kemonofixer.Configuration;

import erx.kemonocraft.entity.EntityIsFriends;
import erx.kemonocraft.init.KemonoStat;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

@Mixin(EntityIsFriends.class)
public abstract class MixinEntityIsFriends extends EntityLiving implements IEntityOwnable {

    public MixinEntityIsFriends(World world) {
        super(world);
    }

    //Band-aid fix
    @Overwrite(remap = false)
    public int getFriendsKiller(EntityLivingBase entity) {
        if (Configuration.ENTITY.BE_A_CUCK) return 0;
        else {
            if (entity instanceof EntityPlayer) return KemonoStat.getFriendsKiller((EntityPlayerMP) entity);
            else return 0;
        }
    }

}
