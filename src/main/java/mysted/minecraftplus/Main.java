package mysted.minecraftplus;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static mysted.minecraftplus.Config.HIDDEN_MODS;

@Environment(EnvType.CLIENT)
public class Main implements ModInitializer {

	public static final String MOD_ID = "minecraft-plus";
	public static final Logger LOGGER = LoggerFactory.getLogger("MinecraftPlus");

	@Override
	public void onInitialize() {

		Collection<ModContainer> allMods = new ArrayList<ModContainer>(FabricLoader.getInstance().getAllMods());
		ArrayList<ModContainer> mods = new ArrayList<ModContainer>();

		for (ModContainer modContainer : allMods) {

			// Format Fabric Loader mods
			String modId = modContainer.getMetadata().getId();
			if (modId.endsWith("-v0") || modId.endsWith("-v1") || modId.endsWith("-v2")) {
				modId = modId.split("-v")[0];
			}

			// Add non-Fabric mods to array
			if (!(HIDDEN_MODS.contains(modId))) {
				mods.add(modContainer);
			}
		}

		LOGGER.info(mods.toString());

		LOGGER.info("Initialising Minecraft");

	}
}
