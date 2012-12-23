package me.furt.goldmine;

import org.spout.api.chat.ChatArguments;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;
import org.spout.api.plugin.services.EconomyService;

public class GMCommands {
	@SuppressWarnings("unused")
	private final Main plugin;

	public GMCommands(Main instance) {
		this.plugin = instance;
	}
	@Command(aliases = "test", usage = "", desc = "Just a test command")
	public void map(CommandContext args, CommandSource source)
			throws CommandException {
		if (args.length() != 0) {
			throw new CommandException(
					"This command does not require arguments");
		} else if (!(source instanceof Player)) {
			throw new CommandException("You must be a player.");
		}
		Player p = (Player) source;
		p.sendMessage(new ChatArguments("This is a test"));
	}

	@Command(aliases = "goldmine", usage = "<set:give:take> <account> <amount>", desc = "All GoldMine commands use this.", min = 3, max = 3)
	public void goldmine(CommandContext args, CommandSource source)
			throws CommandException {
		if (!(source instanceof Player)) {
			throw new CommandException("You must be a player to use GoldMine.");
		}
		Player p = (Player) source;

		EconomyService es = EconomyService.getEconomy();
		if (!es.exists(args.getString(1))) {
			throw new CommandException("Cannot find account.");
		}

		if (!es.exists(p.getName())) {
			throw new CommandException("You do not have a account.");
		}

		if (args.getString(0).equalsIgnoreCase("give") && args.length() == 3) {
			if (!p.hasPermission("goldmine.give"))
				throw new CommandException(
						"You do not have permission to give money.");

			if (p.getName().equalsIgnoreCase(args.getString(1)))
				throw new CommandException(
						"You cannot send money to yourself, doh!");

			if (es.exists(args.getString(1))
					&& es.has(p.getName(), args.getDouble(2))) {
				es.withdraw(p.getName(), args.getDouble(2));
				es.deposit(args.getString(1), args.getDouble(2));;
				p.sendMessage("You have sent " + args.getString(1) + " "
						+ getFormat(es, args.getDouble(2)));
			} else {
				throw new CommandException(
						"You do not have enough funds for this.");
			}
		}
	}
	
	private String getFormat(EconomyService es, double d) {
		String format = es.formatShort(d);
		if (format == null)
			format = es.format(d);
		return format;
	}

}
