package me.furt.goldmine;

import com.xemsdoom.mexdb.MexDB;
import com.xemsdoom.mexdb.exception.EmptyIndexException;
import com.xemsdoom.mexdb.system.Entry;

public class GMAPI {
	MexDB db = new MexDB("plugins/GoldMine", "goldmine");
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

	public void createAccount(String name) throws EmptyIndexException {
		Entry e = new Entry(name);
		e.addValue("amount", 0.00);
		db.addEntry(e);
		db.push();
	}
	
	public void removeAccount(String name) throws EmptyIndexException {
		if(db.hasIndex(name)) {
			db.removeEntry(name);
			db.push();
		}
	}
}
