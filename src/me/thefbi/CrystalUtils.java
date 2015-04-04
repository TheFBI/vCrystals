package me.thefbi;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CrystalUtils {
	
	public static final CrystalUtils getUtil = new CrystalUtils();
	
	public ItemMeta getItemMeta(ItemStack item)
	{
		return item.getItemMeta();
	}
	
	public boolean isCrystal(ItemStack item)
	{
		if(!item.getItemMeta().getLore().contains(ChatColor.RED + "vCrystal"))
		{
			return false;
		}
		return true;
	}

	public String getPlayerName(Player player)
	{
		return player.getName();
	}
	
	public void givePlayerHead(Player player, Player killer)
	{
		String playerName = player.getName();
		
		@SuppressWarnings("deprecation")
		ItemStack head = new ItemStack(397, 1, (short) 3);
		SkullMeta headMeta = (SkullMeta) head.getItemMeta();
		headMeta.setOwner(playerName);
		head.setItemMeta(headMeta);
		killer.getInventory().addItem(head);
	}
	
}
