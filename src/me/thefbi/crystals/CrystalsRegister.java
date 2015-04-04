package me.thefbi.crystals;

import java.util.ArrayList;

import me.thefbi.crystaltypes.Beheaded;
import me.thefbi.crystaltypes.Poison;

public class CrystalsRegister {
	
	public ArrayList<CrystalManager> crystals = new ArrayList<CrystalManager>();
	
	public CrystalsRegister()
	{
		crystals.add(new Beheaded());
		crystals.add(new Poison());
	}

}
