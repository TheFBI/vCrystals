package me.thefbi.listeners;

import java.util.ArrayList;
import java.util.UUID;

import me.thefbi.CrystalUtils;
import me.thefbi.Crystals;
import me.thefbi.crystaltypes.Beheaded;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class BeheadedCrystalInteract implements Listener{
	
	public static ArrayList<UUID> players = new ArrayList<UUID>();
			
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		
		Inventory playerInventory = player.getInventory();
		if((event.getAction() == Action.LEFT_CLICK_AIR) && event.getItem().getItemMeta().equals(CrystalUtils.getUtil.getItemMeta(Beheaded.beheadedCrystal)) && CrystalUtils.getUtil.isCrystal(Beheaded.beheadedCrystal) && player.isSneaking())
		{
			if(!(playerInventory.contains((Material.DIAMOND_SWORD))))
			{
				player.sendMessage(Crystals.prefix + "You must have a Diamond Sword in your inventory.");
				return;
			} else {
				player.sendMessage(Crystals.prefix + "Open your inventory and click the sword you wish to apply " + ChatColor.RED + "Beheaded" + ChatColor.GRAY + " to.");
				players.add(player.getUniqueId());
			}
				
			
		} else {
			return;
		}
	}

}
