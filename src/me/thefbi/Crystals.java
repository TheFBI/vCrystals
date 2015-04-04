package me.thefbi;

import me.thefbi.crystals.CrystalManager;
import me.thefbi.crystals.CrystalType;
import me.thefbi.crystals.CrystalsRegister;
import me.thefbi.crystaltypes.Beheaded;
import me.thefbi.crystaltypes.Poison;
import me.thefbi.listeners.BeheadedCrystalInteract;
import me.thefbi.listeners.ClickPoison;
import me.thefbi.listeners.PlayerAttackPlayerListener;
import me.thefbi.listeners.PlayerClickItemListener;
import me.thefbi.listeners.PlayerDeathListener;
import me.thefbi.listeners.PoisonListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * Author: TheFBI
 */

public class Crystals extends JavaPlugin{
	
	public static Crystals instance;
	static CrystalManager manager;
	static CrystalsRegister register;
	public static Beheaded beheaded;
	public static Poison poison;
	
	public static String prefix = ChatColor.GREEN + "Venom " + ChatColor.DARK_GRAY + "// " + ChatColor.GRAY;
	
	public static int i;
	
	private static String lP = "[vCrystals] ";
	
	void registerEvents()
	{
		Bukkit.getServer().getPluginManager().registerEvents(new BeheadedCrystalInteract(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerClickItemListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerAttackPlayerListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PoisonListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ClickPoison(), this);

	}
		
	@Override
	public void onEnable()
	{
		long startTime = System.currentTimeMillis();
		
		getLogger().info(lP + "Instantiating instances...");
		
		instance = this;
		register = new CrystalsRegister();
		beheaded = new Beheaded();
		poison = new Poison();
		manager = new CrystalManager("Initialize", false, "Main", "None");
		
		getLogger().info(lP + "Registering events...");
		
		registerEvents();
		
		getLogger().info(lP + "Done!");
		
		long endTime = System.currentTimeMillis();
		long completeTime = endTime - startTime;
		
		getLogger().info(lP + "Finished loading plugin in " + completeTime + " ms");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			return true;
		}
		
		Player player = (Player) sender;
		
		if(command.getName().equalsIgnoreCase("vcrystals") && args.length == 0)
		{
			player.sendMessage(prefix + "/vcrystals give <crystal>");
			player.sendMessage(prefix + "/vcrystals setminingrate <rate>");
			player.sendMessage(prefix + "/vcrystals <crystal> <param>");
			player.sendMessage(prefix + "/vcrystals list");
			return true;
		}
		
		if(args.length == 2)
		{			
			if(args[0].equalsIgnoreCase("give"))
			{
				if(args[1].equalsIgnoreCase("beheaded"))
				{
					givePlayerCrystal(player, CrystalType.BEAHADED);
					getLogger().info(lP + "Gave " + player.getName() + " BEHEADED Crystal.");
					return true;
				} else if (args[1].equalsIgnoreCase("poison"))
				{
					givePlayerCrystal(player, CrystalType.POISON);
					getLogger().info(lP + "Gave " + player.getName() + " POISON Crystal.");
					return true;
				}
			}
		} else if(command.getName().equalsIgnoreCase("vcrystals") && args.length == 1)
		{
			if(args[0].equalsIgnoreCase("list"))
			{
				long startTime = System.currentTimeMillis();
		
				getAllCrystalAttributes(player);
								
				long endTime = System.currentTimeMillis();
				
				long timeTaken = endTime - startTime;

				player.sendMessage(prefix + "Sorted " + register.crystals.size() + " Crystals in " + ChatColor.RED + timeTaken + " ms");
				getLogger().severe("Took " + timeTaken + " to sort " + register.crystals.size() + " Crystals.");
				return true;
			}
		}
		
		return false;
	}

	
	@SuppressWarnings("deprecation")
	public static void getAllCrystalAttributes(final Player player)
	{	
		i = Bukkit.getScheduler().scheduleAsyncRepeatingTask(instance, new Runnable(){

			@Override
			public void run() {				
				for(CrystalManager c : register.crystals)
				{
					player.sendMessage(prefix + "NAME | SWORDS-ONLY | CATEGORY | RARITY");
					player.sendMessage(prefix + c.getName() + " | " + c.getSwordsOnly() + " | " + c.getCategory() + " | " + c.getRarity());
				}
								
				Bukkit.getScheduler().cancelTask(i);
			}
			
		}, 1, 1);
	}
	
	public void givePlayerCrystal(Player player, CrystalType type)
	{
		if(type.equals(CrystalType.BEAHADED))
		{
			beheaded.getBeheadedCrystal(player);
		} else if (type.equals(CrystalType.POISON))
		{
			poison.getBeheadedCrystal(player);
		}
	}
}
