package net.gtaun.shoebill.example.anticheat;

import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.service.Service;

public interface AntiCheatMoneyService extends Service
{
	/**
	 * bla bla
	 * 
	 * @param player
	 */
	boolean isMoneyCheckEnabled(Player player);

	/**
	 * bla bla bla
	 * 
	 * @param player
	 * @param enable
	 */
	void setMoneyCheckEnabled(Player player, boolean enable);

	/**
	 * bla bla bla bla ...
	 * 
	 * @param ms
	 */
	void setMoneyCheckTimerInterval(int ms);
}
