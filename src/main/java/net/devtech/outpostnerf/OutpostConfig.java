package net.devtech.outpostnerf;

import org.bukkit.configuration.file.YamlConfiguration;

public class OutpostConfig {
	public double nerfHealth = 20;
	public float normalSpawns = 0.0f;
	public boolean slowness = false;
	public boolean wither = true;
	public void save(YamlConfiguration configuration) {
		configuration.set("outpostnerf.nerfHealth", this.nerfHealth);
		configuration.set("outpostnerf.normalSpawns", this.normalSpawns);
		configuration.set("outpostnerf.slow", this.slowness);
		configuration.set("outpostnerf.wither", this.wither);
	}

	public void load(YamlConfiguration configuration) {
		this.nerfHealth = configuration.getDouble("outpostnerf.nerfHealth");
		this.normalSpawns = (float) configuration.getDouble("outpostnerf.normalSpawns", this.normalSpawns);
		this.slowness = configuration.getBoolean("outpostnerf.slow", this.slowness);
		this.wither = configuration.getBoolean("outpostnerf.wither", this.wither);
	}
}
