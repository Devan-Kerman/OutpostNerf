package net.devtech.outpostnerf;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;

public final class OutpostNerf extends JavaPlugin implements Listener {
	public static final OutpostConfig CONFIG = new OutpostConfig();
	@Override
	public void onEnable() {
		try {
			File config = new File(this.getDataFolder(), "config.yml");
			YamlConfiguration configuration = new YamlConfiguration();
			if (config.exists()) {
				configuration.load(config);
				CONFIG.load(configuration);
				System.out.println("loaded" + CONFIG.nerfHealth);
			} else {
				CONFIG.save(configuration);
				configuration.save(config);
			}
		} catch (IOException | InvalidConfigurationException e) {
			throw new RuntimeException(e);
		}

		Bukkit.getPluginManager().registerEvents(new SpawnListener(), this);

		// Plugin startup logic
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
