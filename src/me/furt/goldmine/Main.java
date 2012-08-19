package me.furt.goldmine;

import org.spout.api.Engine;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.plugin.ServiceManager.ServicePriority;
import org.spout.api.plugin.services.EconomyService;

public class Main extends CommonPlugin {
	public final EconService econ = new EconService();
	public Main instance;
	public Engine engine;
	
	@Override
	public void onEnable() {
		getEngine().getServiceManager().register(EconomyService.class, econ, this, ServicePriority.Highest);
		getLogger().info("v" + getDescription().getVersion() + " enabled.");
	}

	@Override
	public void onDisable() {
		getEngine().getLogger().info("Disabled.");
		
	}
	
	@Override
	public void onLoad() {
		instance = this;
		engine = getEngine();
		getEngine().getLogger().info("Loaded.");
	}
}
