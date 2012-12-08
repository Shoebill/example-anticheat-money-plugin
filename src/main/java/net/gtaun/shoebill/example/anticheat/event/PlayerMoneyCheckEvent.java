package net.gtaun.shoebill.example.anticheat.event;

import net.gtaun.shoebill.event.player.PlayerEvent;
import net.gtaun.shoebill.object.Player;

public class PlayerMoneyCheckEvent extends PlayerEvent
{
	private final int lastTimeMoney;
	private final int nowMoney;
	private boolean isAllow = false;
	
	
	public PlayerMoneyCheckEvent(Player player, int lastTimeMoney, int nowMoney)
	{
		super(player);
		this.lastTimeMoney = lastTimeMoney;
		this.nowMoney = nowMoney;
	}
	
	public int getLastTimeMoney()
	{
		return lastTimeMoney;
	}
	
	public int getNowMoney()
	{
		return nowMoney;
	}
	
	public boolean isAllow()
	{
		return isAllow;
	}
	
	public void setAllow(boolean allow)
	{
		isAllow = isAllow || allow;
	}
}
