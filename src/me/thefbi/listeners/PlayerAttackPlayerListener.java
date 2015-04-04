package me.thefbi.listeners;

import java.util.Random;

import me.thefbi.Crystals;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerAttackPlayerListener implements Listener{
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent e)
	{
		Player attacker = (Player) e.getDamager();
		Player v = (Player) e.getEntity();
		
		
		if(attacker.getInventory().getItemInHand().getType().equals(Material.DIAMOND_SWORD))
		{
			if(attacker.getItemInHand().getItemMeta().getLore().contains(ChatColor.DARK_GREEN + "Poison"))
			{
				Random rnd = new Random();
				int[] chance = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1, 1, 1};
				int result;
				result = (chance[rnd.nextInt(chance.length)]);
				Bukkit.broadcastMessage("Result: " + result);
				
				if(result == 0)
				{
					v.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 3));
					attacker.sendMessage(Crystals.prefix + "You gave " + ChatColor.RED + v.getName() + ChatColor.DARK_GREEN + " Poison IV " + ChatColor.GRAY + " for " + ChatColor.RED + "5" + ChatColor.GRAY + " seconds.");
				}
				
				
			}
		}
	}

}
