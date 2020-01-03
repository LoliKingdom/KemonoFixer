package com.rong.kemonofixer;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresWorldRestart;

@Config(modid = KemonoFixer.MODID)
public class Configuration {

	public static Biomes BIOMES = new Biomes();
	public static Technical TECHNICAL = new Technical();

	@Comment("Disable all Cellien Spawns")
	public boolean DISABLE_CELLIEN_SPAWNS = false;

	public static class Biomes {
		
		@RequiresWorldRestart
		@Comment("Enable Komodo Islands")
		public boolean ENABLE_KOMODO_ISLAND = true;
		
		@RequiresWorldRestart
		@Comment("Komodo Island's Biome Weight. Default = 24")
		public int KOMODO_ISLAND_BIOME_WEIGHT = 24;
		
		@RequiresWorldRestart
		@Comment("Enable Kemono Savannas")
		public boolean ENABLE_SAVANNA = true;
		
		@RequiresWorldRestart
		@Comment("Savanna's Biome Weight. Default = 14")
		public int SAVANNA_BIOME_WEIGHT = 14;
		
		@RequiresWorldRestart
		@Comment("Enable Sandstar Fields")
		public boolean ENABLE_SANDSTAR_FIELD = true;
		
		@RequiresWorldRestart
		@Comment("Sandstar Field's Biome Weight. Default = 8")
		public int SANDSTAR_FIELD_BIOME_WEIGHT = 8;
		
		@RequiresWorldRestart
		@Comment("Enable Sandstar Volcanoes")
		public boolean ENABLE_SANDSTAR_VOLCANO = true;
		
		@RequiresWorldRestart
		@Comment("Sandstar Volcano's Biome Weight. Default = 0 (as it spawns inside of Sandstar Fields)")
		public int SANDSTAR_VOLCANO_BIOME_WEIGHT = 0;
		
	}
	
	public static class Technical {
		
		@Comment("DO NOT TOUCH UNLESS YOU HAVEN'T CHANGED YOUR KEMONOCRAFT FILE NAME!")
		public String FILENAME = "KemonoCraft-1.12.2-0.2.7a.jar";
		
	}

}
