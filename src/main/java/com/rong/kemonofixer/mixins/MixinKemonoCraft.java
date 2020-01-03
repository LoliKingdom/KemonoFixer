package com.rong.kemonofixer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rong.kemonofixer.Configuration;
import com.rong.kemonofixer.KemonoFixer;

import erx.kemonocraft.KemonoCraft;
import erx.kemonocraft.init.KemonoBiomes;
import erx.kemonocraft.init.KemonoRecipes;
import erx.kemonocraft.init.KemonoReflect;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mixin(KemonoCraft.class)
public class MixinKemonoCraft {
	
	@Overwrite(remap = false)
	public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
	    KemonoRecipes.init();
	}

	@Overwrite(remap = false)
	public void onLoadComplete(FMLLoadCompleteEvent event) {
		KemonoReflect.init();
	}

}
