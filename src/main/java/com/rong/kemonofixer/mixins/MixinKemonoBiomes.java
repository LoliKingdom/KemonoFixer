package com.rong.kemonofixer.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rong.kemonofixer.Configuration;
import com.rong.kemonofixer.Configuration.Biomes;
import com.rong.kemonofixer.KemonoFixer;

import erx.kemonocraft.init.KemonoBiomes;
import erx.kemonocraft.world.biome.BiomeKomodoIsland;
import erx.kemonocraft.world.biome.BiomeSandstarField;
import erx.kemonocraft.world.biome.BiomeSandstarVolcano;
import erx.kemonocraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.registries.IForgeRegistry;

@Mixin(KemonoBiomes.class)
public class MixinKemonoBiomes {

	private static final Biomes biomesConfig = Configuration.BIOMES;
	
	@Shadow @Final public static final BiomeSandstarField SANDSTAR_FIELD = KemonoBiomes.SANDSTAR_FIELD;
	  
    @Shadow @Final public static final BiomeSandstarVolcano SANDSTAR_VOLCANO = KemonoBiomes.SANDSTAR_VOLCANO;
	  
	@Shadow @Final public static final BiomeKomodoIsland KOMODO = KemonoBiomes.KOMODO;
	  
	@Shadow @Final public static final BiomeSavanna SAVANNA = KemonoBiomes.SAVANNA;
	
	@Inject(method = "registerBiomes", at = @At("HEAD"), cancellable = true, remap = false)
	private static void onRegisterBiomes(IForgeRegistry<Biome> registry, CallbackInfo info) {
		if (biomesConfig.ENABLE_KOMODO_ISLAND) {
			//KOMODO = new BiomeKomodoIsland();
			registry.register(KOMODO.setRegistryName("komodo_island"));
			BiomeDictionary.addTypes(KOMODO, Type.HOT, Type.WET, Type.FOREST, Type.DENSE, Type.LUSH);
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(KOMODO, biomesConfig.KOMODO_ISLAND_BIOME_WEIGHT));
		}
		if (biomesConfig.ENABLE_SAVANNA) {
			//SAVANNA = new BiomeSavanna();
			registry.register(SAVANNA.setRegistryName("savanna"));
			BiomeDictionary.addTypes(SAVANNA, Type.HOT, Type.DRY, Type.SAVANNA, Type.SANDY);
			BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(SAVANNA, biomesConfig.SAVANNA_BIOME_WEIGHT));
		}
		if (biomesConfig.ENABLE_SANDSTAR_FIELD) {
			//SANDSTAR_FIELD = new BiomeSandstarField();
			registry.register(SANDSTAR_FIELD.setRegistryName("sandstar_field"));
			BiomeDictionary.addTypes(SANDSTAR_FIELD, Type.HOT, Type.WET, Type.JUNGLE, Type.RARE);
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(SANDSTAR_FIELD, biomesConfig.SANDSTAR_FIELD_BIOME_WEIGHT));
		}
		if (biomesConfig.ENABLE_SANDSTAR_VOLCANO) {
			//SANDSTAR_VOLCANO = new BiomeSandstarVolcano();
			registry.register(SANDSTAR_VOLCANO.setRegistryName("sandstar_volcano"));
			BiomeDictionary.addTypes(SANDSTAR_VOLCANO, Type.RARE, Type.DEAD, Type.WASTELAND, Type.HOT);
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(SANDSTAR_VOLCANO, biomesConfig.SANDSTAR_VOLCANO_BIOME_WEIGHT));
		}
		info.cancel();
	}

	
}
