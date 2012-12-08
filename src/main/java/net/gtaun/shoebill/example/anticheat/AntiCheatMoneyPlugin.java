package net.gtaun.shoebill.example.anticheat;

import net.gtaun.shoebill.resource.Plugin;
import net.gtaun.util.event.EventManager;

import org.slf4j.Logger;

public class AntiCheatMoneyPlugin extends Plugin
{
	private static Logger logger;
	public static Logger logger()
	{
		return logger;
	}
	
	
	private AntiCheatMoneyServiceImpl antiCheatMoneyService;
	
	
	@Override
	protected void onEnable() throws Throwable
	{
		logger = getLogger();
		EventManager eventManager = getEventManager();
		
		antiCheatMoneyService = new AntiCheatMoneyServiceImpl(getShoebill(), eventManager);
		registerService(AntiCheatMoneyService.class, antiCheatMoneyService);

		logger().info(getDescription().getName() + " Enabled.");
	}
	
	@Override
	protected void onDisable() throws Throwable
	{
		unregisterService(AntiCheatMoneyService.class);
		antiCheatMoneyService.uninitialize();
		
		logger().info(getDescription().getName() + " Disabled.");
	}
}
