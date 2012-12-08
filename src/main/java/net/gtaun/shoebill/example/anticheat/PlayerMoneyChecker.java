package net.gtaun.shoebill.example.anticheat;

import net.gtaun.shoebill.example.anticheat.event.PlayerMoneyCheatEvent;
import net.gtaun.shoebill.example.anticheat.event.PlayerMoneyCheckEvent;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

class PlayerMoneyChecker
{
	private final AntiCheatMoneyService service;
	private final EventManager eventManager;
	private final Player player;
	
	private boolean isCheckEnabled;
	private boolean isSkipProxying;
	private int money;
	private long updateTick;
	
	
	PlayerMoneyChecker(Player player, AntiCheatMoneyService service, EventManager eventManager)
	{
		this.player = player;
		this.service = service;
		this.eventManager = eventManager;
		
		isCheckEnabled = true;
	}
	
	public boolean isCheckEnabled()
	{
		return isCheckEnabled;
	}
	
	public void setCheckEnabled(boolean isCheckEnabled)
	{
		this.isCheckEnabled = isCheckEnabled;
	}
	
	public boolean isSkipProxying()
	{
		return isSkipProxying;
	}
	
	public void setSkipProxying(boolean isInProxying)
	{
		this.isSkipProxying = isInProxying;
	}
	
	public void update()
	{
		boolean savedIsSkipProxy = isSkipProxying;
		isSkipProxying = true;
		
		try
		{
			this.money = player.getMoney();
			updateTick = System.currentTimeMillis();
		}
		finally
		{
			isSkipProxying = savedIsSkipProxy;
		}
	}
	
	public void check()
	{
		boolean savedIsSkipProxy = isSkipProxying;
		isSkipProxying = true;
		
		try
		{
			int nowMoney = player.getMoney();
			if(nowMoney < money)
			{
				long tick = System.currentTimeMillis();
				if (updateTick+3000 > tick) return;
				update();
			}
			if (nowMoney > money)
			{
				PlayerMoneyCheckEvent event = new PlayerMoneyCheckEvent(player, money, nowMoney);
				eventManager.dispatchEvent(event, player, service);
				
				if (event.isAllow()) update();
				else
				{
					player.setMoney(money);
					
					PlayerMoneyCheatEvent cheatEvent = new PlayerMoneyCheatEvent(player, nowMoney, money);
					eventManager.dispatchEvent(cheatEvent, player, service);
				}
			}
		}
		finally
		{
			isSkipProxying = savedIsSkipProxy;
		}
	}
}
