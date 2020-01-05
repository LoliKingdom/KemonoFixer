package com.rong.kemonofixer;

import org.apache.logging.log4j.Logger;

import erx.kemonocraft.init.KemonoBiomes;
import erx.kemonocraft.init.KemonoBlocks;
import erx.kemonocraft.init.KemonoItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = KemonoFixer.MODID, name = KemonoFixer.MODNAME, version = KemonoFixer.VERSION, useMetadata = true, dependencies = "required-after:kemonocraft")
@EventBusSubscriber
public class KemonoFixer {

	@Instance
	public static KemonoFixer instance;
	public static Logger logger;

	public static final String MODID = "kemonofixer";
	public static final String MODNAME = "KemonoFixer";
	public static final String VERSION = "1.1";

	@EventHandler
	public void construct(FMLConstructionEvent event) {

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	/*
	 * //Bad KemonoCraft
	 * 
	 * @EventHandler public void onModsLoaded(FMLLoadCompleteEvent event) { if
	 * (Configuration.DISABLE_CELLIEN_SPAWNS)
	 * KemonoSpawner.SPAWN_LIST_CELLIEN.clear(); }
	 */

	/*
	 * @SubscribeEvent public static void onEnteringChunk(EntityEvent.EnteringChunk
	 * event) { final Entity entity = event.getEntity(); final World world =
	 * entity.getEntityWorld(); if (entity instanceof EntityCellien) {
	 * entity.setInvisible(true); entity.setSilent(true);
	 * world.removeEntity(entity); } }
	 */

}
