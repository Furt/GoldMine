package me.furt.goldmine;

import org.spout.api.plugin.services.EconomyService;

public class EconService extends EconomyService {

	@Override
	public boolean has(String name, double amount) {
		GMAPI api = new GMAPI();
		if(api.getAmount(name) >= amount)
			return true;
		
		return false;
	}

	@Override
	public double get(String name) {
		GMAPI api = new GMAPI();
		return api.getAmount(name);
	}

	@Override
	public boolean withdraw(String name, double amount) {
		GMAPI api = new GMAPI();
		double currency = api.getAmount(name);
		if(currency >= amount) {
			api.setAmount(name, currency-amount);
			return true;
		}
		return false;
	}

	@Override
	public boolean deposit(String name, double amount) {
		GMAPI api = new GMAPI();
		double currency = api.getAmount(name);
		api.setAmount(name, currency+amount);
		return true;
	}

	@Override
	public boolean exists(String name) {
		GMAPI api = new GMAPI();
		if(!api.hasAccount(name))
			return false;
		
		return true;
	}

	@Override
	public String getCurrencyNameSingular() {
		return GMConfig.NAME_SINGULAR.getString();
	}

	@Override
	public String getCurrencyNamePlural() {
		return GMConfig.NAME_PLURAL.getString();
	}

	@Override
	public String getCurrencySymbol() {
		if(GMConfig.SYMBOL_USE.getBoolean())
			return GMConfig.CURRENCY_SYMBOL.getString();
		
		return null;
	}

	@Override
	public String format(double amount) {
		String s = "";
		if (amount > 1)
			s = GMConfig.NAME_PLURAL.getString();
		else
			s = GMConfig.NAME_SINGULAR.getString();
		return "" + amount + " " + s;
	}

	@Override
	public String formatShort(double amount) {
		if(GMConfig.SYMBOL_USE.getBoolean())
			return "" + GMConfig.CURRENCY_SYMBOL.getString() + amount;
		
		return null;
	}

	@Override
	public int numSignificantDigits() {
		return 2;
	}

}
