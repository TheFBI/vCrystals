package me.thefbi.listeners;

import java.util.ArrayList;
import java.util.UUID;

import me.thefbi.CrystalUtils;
import me.thefbi.Crystals;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PoisonListener implements Listener{
	
	public static ArrayList<UUID> players = new ArrayList<UUID>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction().equals(Action.LEFT_CLICK_AIR) && event.getItem().getType().equals(Material.NETHER_STAR) && CrystalUtils.getUtil.isCrystal(event.getItem()) && event.getPlayer().isSneaking() && event.getItem().getItemMeta().getLore().contains(ChatColor.RED + "20% Chance to give the enemy the poison effect for 5 seconds"))
		{
			if(!(event.getPlayer().getInventory().contains(Material.DIAMOND_SWORD)))
			{
				event.getPlayer().sendMessage(Crystals.prefix + "You must have a Diamond Sword in your inventory!");
				return;
			} else {
				event.getPlayer().sendMessage(Crystals.prefix + "Open your inventory and click the sword you wish to apply " + ChatColor.DARK_GREEN + "Poison" + ChatColor.GRAY + " to.");
				players.add(event.getPlayer().getUniqueId());
				
			}
		}
	}

}
