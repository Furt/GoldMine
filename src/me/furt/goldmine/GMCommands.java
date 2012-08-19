package me.furt.goldmine;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;
import org.spout.api.plugin.services.EconomyService;

public class GMCommands {
	private Main plugin;

	public GMCommands(Main instance) {
		this.plugin = instance;
	}

	@Command(aliases = { "goldmine", "gm" }, usage = "<set:give:take> <account> <amount>", desc = "All GoldMine commands use this.", min = 0, max = 3)
	public void rollCredits(CommandContext args, CommandSource source)
			throws CommandException {
		if (!(source instanceof Player)) {
			throw new CommandException("You must be a player to use GoldMine.");
		}
		Player p = (Player) source;

		EconomyService es = EconomyService.getEconomy();
		if (es.exists(p)) {

		}
		
		if (args.getString(0).equalsIgnoreCase("give") && args.length() == 3) {
			if(GMConfig.SYMBOL_USE.getBoolean()) {
				p.sendMessage("You have sent " + args.getString(1) + " " + GMConfig.CURRENCY_SYMBOL.getString() + args.getString(2));
			}else{
				if (args.getInteger(2) > 1)
					p.sendMessage("You have sent " + args.getString(1) + " " + args.getString(2) + " " + GMConfig.NAME_PLURAL.getString());
				else
					p.sendMessage("You have sent " + args.getString(1) + " " + args.getString(2) + " " + GMConfig.NAME_SINGULAR.getString());
			}
		}
		

		if (args.getString(0).equalsIgnoreCase("test"))
			p.sendMessage("Test Command works!!!");
	}

}
