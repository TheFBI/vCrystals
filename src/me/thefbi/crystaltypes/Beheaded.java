package me.thefbi.crystaltypes;

import java.util.ArrayList;
import java.util.List;

import me.thefbi.CrystalInterface;
import me.thefbi.crystals.CrystalManager;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
 * Author: TheFBI
 */

public class Beheaded extends CrystalManager implements CrystalInterface {
	
	List<String> beheadedLore = new ArrayList<String>();
	
	public static ItemStack beheadedCrystal = new ItemStack(Material.NETHER_STAR, 1);

	public Beheaded() {
		super("Beheaded", true, "Combat", "Low");
	}

	public void getBeheadedCrystal(Player player)
	{
		Inventory playerInventory = player.getInventory();
		
		ItemMeta beheadedCrystalMeta = beheadedCrystal.getItemMeta();
		
		beheadedCrystalMeta.setDisplayName("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Beheaded");
		
		beheadedLore.add(ChatColor.RED + "25% Chance to get a player head upoun death.");
		beheadedLore.add(ChatColor.RED + "Can only be added to Swords.");
		beheadedLore.add(ChatColor.AQUA + "Shift and Left Click to apply.");
		beheadedLore.add(ChatColor.RED + "vCrystal");
		beheadedLore.add(ChatColor.GOLD + "Original Owner : " + ChatColor.RED + player.getName());
		
		beheadedCrystalMeta.setLore(beheadedLore);
		beheadedCrystal.setItemMeta(beheadedCrystalMeta);
		playerInventory.addItem(beheadedCrystal);
	}

	@Override
	public List<String> getItemLore() {
		return beheadedLore;
	}	
}
