package com.rong.kemonofixer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import erx.kemonocraft.KemonoCraft;
import erx.kemonocraft.item.SandstarBreaker;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mixin(SandstarBreaker.class)
public abstract class MixinSandstarBreaker extends SandstarBreaker {

	public MixinSandstarBreaker(ToolMaterial material) {
		super(material);
	}
	
}
