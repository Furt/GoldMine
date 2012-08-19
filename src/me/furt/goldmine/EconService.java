package me.furt.goldmine;

import org.spout.api.plugin.services.EconomyService;

public class EconService extends EconomyService {

	@Override
	public boolean has(String name, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double get(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean withdraw(String name, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(String name, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCurrencyNameSingular() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrencyNamePlural() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrencySymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String format(double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatShort(double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numSignificantDigits() {
		// TODO Auto-generated method stub
		return 2;
	}

}
