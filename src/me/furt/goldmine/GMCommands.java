package me.furt.goldmine;

import org.spout.api.chat.style.ChatStyle;
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

		if (args.getString(0).equalsIgnoreCase("test"))
			p.sendMessage(ChatStyle.RED.toString() + "Test Command works"
					+ ChatStyle.BLUE.toString() + "!!!");
	}

}
