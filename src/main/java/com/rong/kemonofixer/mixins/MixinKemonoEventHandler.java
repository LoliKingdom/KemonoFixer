package com.rong.kemonofixer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import erx.kemonocraft.event.KemonoEventHandler;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mixin(KemonoEventHandler.class)
public class MixinKemonoEventHandler {

	@Redirect(method = "onEntityJoin", at = @At(value = "INVOKE", target = "removeRes", ordinal = 0), remap = false)
	public void onEntityJoin(EntityJoinWorldEvent event) {
		dummy();
	}
	
	private void dummy() {}
	
}
