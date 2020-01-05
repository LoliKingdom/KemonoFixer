package com.rong.kemonofixer.mixins.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rong.kemonofixer.Helper;

import erx.kemonocraft.entity.EntityCaracal;
import net.minecraft.item.ItemStack;

@Mixin(EntityCaracal.class)
public class MixinEntityCaracal {

    @Inject(method = "isMinor", at = @At("HEAD"), remap = false)
    private void addMinorFoods(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if (!stack.isEmpty()) {
            info.setReturnValue(Helper.containsItem(EntityCaracal.class, stack, "MINOR_FOOD"));
        }
        else {
            info.setReturnValue(false);
        }
    }
    
}
