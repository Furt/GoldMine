package me.furt.goldmine;

import org.spout.api.entity.Player;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.player.PlayerJoinEvent;
import org.spout.api.plugin.services.EconomyService;

import com.xemsdoom.mexdb.exception.EmptyIndexException;

public class GMListener implements Listener {

	private Main plugin;

	public GMListener(Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (GMConfig.CREATE_ON_JOIN.getBoolean()) {
			EconomyService es = EconomyService.getEconomy();
			if (!es.exists(p)) {
				GMAPI api = new GMAPI();
				try {
					api.createAccount(p.getName());
				} catch (EmptyIndexException e) {
					plugin.getLogger().warning(
							"GoldMine was not able to create a new account.");
				}
			}
		}

	}
}
