package net.devtech.outpostnerf;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pillager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.SplittableRandom;

import static java.lang.Integer.MAX_VALUE;

public class SpawnListener implements Listener {
	private static final SplittableRandom RANDOM = new SplittableRandom();
	@EventHandler
	public void spawn(CreatureSpawnEvent event) {
		CreatureSpawnEvent.SpawnReason reason = event.getSpawnReason();
		if (reason == CreatureSpawnEvent.SpawnReason.NATURAL) {
			LivingEntity entity = event.getEntity();
			if (entity instanceof Pillager) {
				EntityEquipment equipment = entity.getEquipment();
				if (equipment.getHelmet().getType() == Material.AIR) {
					if(RANDOM.nextDouble() > OutpostNerf.CONFIG.normalSpawns) {
						event.setCancelled(true);
						return;
					}
				}
				if (OutpostNerf.CONFIG.wither) {
					entity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, MAX_VALUE, 0));
				}
				if (OutpostNerf.CONFIG.slowness) {
					entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, MAX_VALUE, 0));
				}
				entity.setHealth(OutpostNerf.CONFIG.nerfHealth);
			}
		}
	}
}
