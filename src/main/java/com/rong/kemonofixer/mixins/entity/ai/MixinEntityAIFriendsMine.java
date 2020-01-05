package com.rong.kemonofixer.mixins.entity.ai;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rong.kemonofixer.Configuration;

import erx.kemonocraft.entity.ai.EntityAIFriendsMine;
import net.minecraft.entity.ai.EntityAIBase;

@Mixin(EntityAIFriendsMine.class)
public abstract class MixinEntityAIFriendsMine extends EntityAIBase {

    //EntityAIBase#shouldExecute()
    @Inject(method = "func_75250_a", at = @At("HEAD"), cancellable = true)
    private void onShouldExecute(CallbackInfoReturnable<Boolean> info) {
        if (!Configuration.AI.AI_CAN_MINE) {
            info.setReturnValue(false);
        }
    }
    
}
