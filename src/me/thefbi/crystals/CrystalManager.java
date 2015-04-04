package me.thefbi.crystals;

/*
 Author: TheFBI
/*
 To any future Developers, or whom may be reading this.
 To implement a new Crystal, Create a class with the name of your crystal, and let it extend this class.
 Let it implement CrystalInterface for the required methods.
 Create the crystal inside the given method, and add it to the Crystals ArrayList inside CrystalsRegister.
 You MUST make the constructor parameters the real information about this crystal to avoid confusion.
 */

public class CrystalManager {
	
	CrystalManager manager;
	
	public String crystalName;
	
	public boolean swordsOnly;
	
	public String category;
	
	public String rarity;
	
	public String getRarity()
	{
		return this.rarity;
	}
	
	public String getName()
	{
		return this.crystalName;
	}

	public boolean getSwordsOnly()
	{
		return this.swordsOnly;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public CrystalManager(String crystalName, boolean swordsOnly, String category, String rarity)
	{
		this.crystalName = crystalName;
		this.swordsOnly = swordsOnly;
		this.category = category;
		this.rarity = rarity;
	}
	
}
