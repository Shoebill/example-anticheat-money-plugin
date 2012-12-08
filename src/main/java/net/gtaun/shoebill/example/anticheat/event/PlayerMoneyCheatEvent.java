package net.gtaun.shoebill.example.anticheat.event;

import net.gtaun.shoebill.event.player.PlayerEvent;
import net.gtaun.shoebill.object.Player;

public class PlayerMoneyCheatEvent extends PlayerEvent
{
	private final int cheatMoney;
	private final int actualMoney;
	
	
	public PlayerMoneyCheatEvent(Player player, int cheatMoney, int actualMoney)
	{
		super(player);
		this.cheatMoney = cheatMoney;
		this.actualMoney = actualMoney;
	}
	
	public int getCheatMoney()
	{
		return cheatMoney;
	}
	
	public int getActualMoney()
	{
		return actualMoney;
	}
}
