package me.furt.goldmine;

import java.io.File;

import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationHolder;
import org.spout.api.util.config.ConfigurationHolderConfiguration;
import org.spout.api.util.config.yaml.YamlConfiguration;

public class GMConfig extends ConfigurationHolderConfiguration {
	public static final ConfigurationHolder NAME_SINGULAR = new ConfigurationHolder("Dollar", "general", "currency", "name", "singular");
	public static final ConfigurationHolder NAME_PLURAL = new ConfigurationHolder("Dollars", "general", "currency", "name", "plural");
	public static final ConfigurationHolder CURRENCY_SYMBOL = new ConfigurationHolder("$", "general", "currency", "symbol", "key");
	public static final ConfigurationHolder SYMBOL_USE = new ConfigurationHolder(false, "general", "currency", "symbol", "use");
	public static final ConfigurationHolder CREATE_ON_JOIN = new ConfigurationHolder(false, "general", "createOnJoin");
	
	public GMConfig(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}
	
	@Override
	public void load() throws ConfigurationException {
		super.load();
		super.save();
	}

	@Override
	public void save() throws ConfigurationException {
		super.save();
	}

}
