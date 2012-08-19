package me.furt.goldmine;

import com.xemsdoom.mexdb.MexDB;

public class GMAPI {
	MexDB db = new MexDB("plugin/GoldMine", "goldmine");
	public GMAPI() {
		db.autopush(false);
	}
	
	public boolean hasAccount(String s) {
		if(db.hasIndex(s))
			return true;
		
		return false;
	}
	
	public double getAmount(String s) {
		return db.getDouble(s, "amount");
	}
	
	public void setAmount(String s, double d) {
		db.setValue(s, "amount", d);
		db.push();
	}
}
