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

public class Poison extends CrystalManager implements CrystalInterface{
	
	public Poison() {
		super("POISON", true, "Combat", "Low");
	}

	public List<String> poisonLore = new ArrayList<String>();
	
	public static ItemStack poisonCrystal = new ItemStack(Material.NETHER_STAR, 1);

	
		public void getBeheadedCrystal(Player player) {
		
		Inventory playerInv = player.getInventory();
		ItemMeta poisonCrystalMeta = poisonCrystal.getItemMeta();
		
		poisonCrystalMeta.setDisplayName("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "Poison");
		poisonLore.add(ChatColor.RED + "20% Chance to give the enemy the poison effect for 5 seconds");
		poisonLore.add(ChatColor.RED + "Can only be applied to swords");
		poisonLore.add(ChatColor.AQUA + "Shift and Left Click to apply.");
		poisonLore.add(ChatColor.RED + "vCrystal");
		
		poisonCrystalMeta.setLore(poisonLore);
		poisonCrystal.setItemMeta(poisonCrystalMeta);

		playerInv.addItem(poisonCrystal);
		player.updateInventory();
		this.poisonLore.clear();
	}

	@Override
	public List<String> getItemLore() {
		// TODO Auto-generated method stub
		return poisonLore;
	}

	
	
}
