package me.thefbi.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.thefbi.CrystalStrings;
import me.thefbi.CrystalUtils;
import me.thefbi.Crystals;
import me.thefbi.crystaltypes.Beheaded;
import me.thefbi.crystaltypes.Poison;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickPoison implements Listener{
	
	public static List<String> newSwordLore = new ArrayList<String>();

	
	@EventHandler
	public void onPlayerClick(InventoryClickEvent e)
	{
		Player player = (Player) e.getWhoClicked();
				
		if(PoisonListener.players.contains(player.getUniqueId()))
		{
			if(!(player.getInventory().contains(Material.DIAMOND_SWORD)))
			{
				player.sendMessage(Crystals.prefix + "You must have a sword in your inventory!");
				return;
			} else {
				ItemStack clickedSword = e.getCurrentItem();
				ItemStack newSword = new ItemStack(Material.DIAMOND_SWORD, 1);
				Map<Enchantment, Integer> newSwordEnchants = clickedSword.getEnchantments();
				ItemMeta newSwordMeta = clickedSword.getItemMeta();
				newSwordLore.add(ChatColor.GREEN + "Special Item");
				newSwordLore.add(CrystalStrings.getStrings.poisonLoreFirst);
				newSwordLore.add(ChatColor.RED + "vCrystals");
				
				newSwordMeta.setLore(newSwordLore);			
				newSword.setItemMeta(newSwordMeta);
				newSword.addEnchantments(newSwordEnchants);
				
				player.getInventory().remove(Poison.poisonCrystal);
				player.getInventory().addItem(newSword);
				e.setCancelled(true);
				player.getInventory().remove(clickedSword);
				
				PoisonListener.players.remove(player.getUniqueId());
				
				newSwordLore.clear();
				player.sendMessage(Crystals.prefix + "Here you go! Have fun!");
				return;
			}
		}
	}

}
