package com.rong.kemonofixer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rong.kemonofixer.ExtraMobEggs;

import erx.kemonocraft.KemonoCraft;
import erx.kemonocraft.init.KemonoChunk;
import erx.kemonocraft.init.KemonoEntityRegistry;
import erx.kemonocraft.init.KemonoItems;
import erx.kemonocraft.init.KemonoMoves;
import erx.kemonocraft.init.KemonoRecipes;
import erx.kemonocraft.init.KemonoReflect;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mixin(KemonoCraft.class)
public class MixinKemonoCraft {
    
    @Shadow public static KemonoChunk chunkLoader = new KemonoChunk();
	
	@Overwrite(remap = false)
	public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
	    KemonoRecipes.init();
	}
	
	//Moved lots of init code from FMLLoadCompleteEvent to here
	@Inject(method = "init", at = @At("TAIL"), remap = false)
	public void onInit(FMLInitializationEvent event, CallbackInfo info) {
	    KemonoItems.registerSmelting();
	    KemonoItems.registerBrewing();
	    KemonoEntityRegistry.registerEntities();
	    new ExtraMobEggs(); //Didn't even know you could do it this way, alternative = EntityRegistry#registerEgg
	    KemonoMoves.init();
	    ForgeChunkManager.setForcedChunkLoadingCallback(this, (ForgeChunkManager.LoadingCallback)chunkLoader);
	    chunkLoader.init();
	    if (event.getSide().isClient()) {
	        KemonoItems.setClientSetting();
	    } 
	}

	@Overwrite(remap = false)
	public void onLoadComplete(FMLLoadCompleteEvent event) {
		KemonoReflect.init();
	}
	
	@Overwrite(remap = false)
	public void postInit(FMLPostInitializationEvent event) {}

}
