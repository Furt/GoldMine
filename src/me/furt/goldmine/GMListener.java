package me.furt.goldmine;

import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.player.PlayerJoinEvent;

public class GMListener implements Listener {

	private Main plugin;

	public GMListener(Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
	}
}
