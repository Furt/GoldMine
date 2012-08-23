package me.furt.goldmine;

import java.util.logging.Level;

import org.spout.api.Engine;
import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.command.annotated.SimpleInjector;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.plugin.ServiceManager.ServicePriority;
import org.spout.api.plugin.services.EconomyService;

public class Main extends CommonPlugin {
	private final EconService econ = new EconService();
	private static Main instance;
	private GMConfig config;
	private Engine engine;

	@Override
	public void onEnable() {
		try {
			config.load();
		} catch (ConfigurationException e) {
			getLogger().log(Level.WARNING,
					"Error loading GoldMine configuration: ", e);
		}
		engine.getServiceManager().register(EconomyService.class, econ,
				this, ServicePriority.Highest);
		CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(
				new SimpleInjector(this),
				new SimpleAnnotatedCommandExecutorFactory());
		engine.getRootCommand().addSubCommands(this, GMCommands.class,
				commandRegFactory);
		engine.getEventManager()
				.registerEvents(new GMListener(this), this);
		getLogger().info("v" + getDescription().getVersion() + " enabled.");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled.");

	}

	@Override
	public void onLoad() {
		instance = this;
		engine = getEngine();
		config = new GMConfig(getDataFolder());
		getLogger().info("Loaded.");
	}

	public static Main getInstance() {
		return instance;
	}
}
