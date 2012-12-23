package me.furt.goldmine;

import java.util.List;

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
		return 3;
	}

	@Override
	public boolean create(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getTopAccounts(int start, int end, boolean playersOnly) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMulticurrencySupport() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getCurrencyNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrencyNamePlural(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrencySymbol(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String format(String name, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatShort(String name, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean withdraw(String name, double amount, String currency) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(String name, double amount, String currency) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean has(String name, double amount, String currency) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double get(String name, String currency) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getTopAccounts(int start, int end, String currency,
			boolean playersOnly) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getExchangeRate(String currencyFrom, String currencyTo) {
		// TODO Auto-generated method stub
		return 0;
	}

}