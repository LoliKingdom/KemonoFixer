package com.rong.kemonofixer;

import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.fml.relauncher.CoreModManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.DependsOn("kemonocraft")
public class KemonoFixerCoreMod implements IFMLLoadingPlugin {

	static File modFile;

	public KemonoFixerCoreMod() {
		// TODO Hack to bring up KemonoCraft for some finger-licking-good mixins
		// Thanks to ClientHax
		try {
			loadModJar(new File("./mods/".concat(Configuration.TECHNICAL.FILENAME)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		MixinBootstrap.init();
		Mixins.addConfiguration("mixins.kemonofixer.json");
	}

	private void loadModJar(File jar) throws Exception {
		((LaunchClassLoader) this.getClass().getClassLoader()).addURL(jar.toURI().toURL());
		CoreModManager.getReparseableCoremods().add(jar.getName());
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[] {};
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Nullable
	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		modFile = (File) data.get("coremodLocation");
		if (modFile == null) {
			modFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
		}
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}