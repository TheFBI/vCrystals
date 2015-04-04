package me.thefbi.listeners;

import java.util.Random;

import me.thefbi.CrystalUtils;
import me.thefbi.Crystals;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener{
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event)
	{
		Random rnd = new Random();
		int chance[] = {1, 1, 1, 0};
		int result;
				
		Player player = (Player) event.getEntity();
		Player killer = (Player) event.getEntity().getKiller();
		
		result = (chance[rnd.nextInt(chance.length)]);
		
		if(result == 0 && killer.getItemInHand().getItemMeta().getLore().contains(ChatColor.GREEN + "Special Item") && killer.getItemInHand().getItemMeta().getLore().contains(ChatColor.AQUA  + "Beheaded"))
		{
			Bukkit.broadcastMessage(Crystals.prefix + ChatColor.GREEN + "[vCrystals] " + ChatColor.GRAY + ChatColor.RED + player.getName() + ChatColor.GRAY + " was killed by " + ChatColor.RED + killer.getName() + ChatColor.GRAY + " and he dropped his head!");
			player.sendMessage(Crystals.prefix + ChatColor.GREEN + "[vCrystals] " + ChatColor.GRAY + "You were killed by " + ChatColor.RED + killer.getName() + ChatColor.GRAY + " and you dropped your head.");
			killer.sendMessage(Crystals.prefix + ChatColor.GREEN + "[vCrystals] " + ChatColor.GRAY + " You killed " + ChatColor.RED + player.getName() + ChatColor.GRAY + " and got his head.");
			CrystalUtils.getUtil.givePlayerHead(player, killer);
		} else {
			return;
		}
	}

}
