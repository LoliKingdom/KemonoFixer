package com.rong.kemonofixer.mixins.entity;

import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rong.kemonofixer.Helper;
import com.rong.kemonofixer.ct.KemonoTweaker;

import erx.kemonocraft.entity.EntityKomodo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(EntityKomodo.class)
public class MixinEntityKomodo {
    
    @Inject(method = "isSpItem", at = @At("HEAD"), remap = false)
    private void addSpecialItems(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if (!stack.isEmpty()) {
            info.setReturnValue(Helper.containsItem(EntityKomodo.class, stack, "SPECIAL_ITEM"));
        }
        else {
            info.setReturnValue(false);
        }
    }
    
}
