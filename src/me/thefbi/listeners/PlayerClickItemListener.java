package me.thefbi.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.thefbi.CrystalStrings;
import me.thefbi.CrystalUtils;
import me.thefbi.Crystals;
import me.thefbi.crystaltypes.Beheaded;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerClickItemListener implements Listener{
	
	List<String> newSwordLore = new ArrayList<String>();
	
	@EventHandler
	public void onPlayerClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		
		
		if(!(BeheadedCrystalInteract.players.contains(player.getUniqueId())))
		{
			return;
		}

		if(!(event.getCurrentItem().getType() == Material.DIAMOND_SWORD) && player.getInventory().getItemInHand() == Beheaded.beheadedCrystal)
		{
			player.sendMessage(Crystals.prefix + "You must click a sword!");
			BeheadedCrystalInteract.players.remove(player.getUniqueId());
			return;
			
		} else {
			
			ItemStack clickedSword = event.getCurrentItem();
			
			ItemStack newSword = new ItemStack(Material.DIAMOND_SWORD, 1);
			
			Map<Enchantment, Integer> newSwordEnchants = clickedSword.getEnchantments();
			
			ItemMeta newSwordMeta = clickedSword.getItemMeta();
			
			newSwordLore.add("");
			newSwordLore.add(ChatColor.GREEN + "Special Item");
			newSwordLore.add(CrystalStrings.getStrings.beheadedLoreFirst);
			newSwordLore.add("");
			
			newSwordMeta.setLore(newSwordLore);			
			newSword.setItemMeta(newSwordMeta);
			newSword.addEnchantments(newSwordEnchants);
			
			player.getInventory().remove(Beheaded.beheadedCrystal);
			player.getInventory().addItem(newSword);
			
			event.setCancelled(true);
			
			player.getInventory().remove(clickedSword);
			
			BeheadedCrystalInteract.players.remove(player.getUniqueId());
			
			newSwordLore.clear();
			
			player.sendMessage(Crystals.prefix + "Here you go! Have fun!");

		}		
	}

}
