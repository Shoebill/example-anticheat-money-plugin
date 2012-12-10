package net.gtaun.shoebill.example.anticheat.event;

import net.gtaun.util.event.AbstractEventHandler;

public abstract class AntiCheatMoneyEventHandler extends AbstractEventHandler
{
	public AntiCheatMoneyEventHandler()
	{
		super(AntiCheatMoneyEventHandler.class);
	}
	
	public void onAntiCheatMoneyCheck(AntiCheatMoneyCheckEvent event)
	{
		
	}
	
	public void onAntiCheatMoneyCheat(AntiCheatMoneyCheatEvent event)
	{
		
	}
}
