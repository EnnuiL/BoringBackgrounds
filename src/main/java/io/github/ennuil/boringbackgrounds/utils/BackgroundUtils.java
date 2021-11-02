package io.github.ennuil.boringbackgrounds.utils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.util.Identifier;

public class BackgroundUtils {
	// The logger, used to inform the user
	public static final Logger logger = LogManager.getFormatterLogger("Boring Backgrounds");
	// The path to the global background_settings.json equivalent
	public static final Path globalConfigPath = FabricLoader.getInstance().getConfigDir().resolve("boringbackgrounds.json");

	// The list of textures storing all the potential background IDs
	public static List<Identifier> textures = new ArrayList<>();
	// The list of textures storing all the potential background IDs
	public static List<Integer> textureIndices = new ArrayList<>();
	// The current background, overrides the vanilla one
	public static Identifier backgroundTexture;
	// The "randomize_on_new_screen" option's value
	public static boolean randomizeOnNewScreen;

	// Chooses a random background
	public static Identifier updateBackground() {
		//If there's no texture IDs, just use the vanilla one
		if (textures.size() == 0) {
			return backgroundTexture = DrawableHelper.OPTIONS_BACKGROUND_TEXTURE;
		}

		return backgroundTexture = textures.get(textureIndices.get(new Random().nextInt(textureIndices.size())));
	}
}
