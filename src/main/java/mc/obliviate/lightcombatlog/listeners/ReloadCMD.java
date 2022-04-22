package mc.obliviate.lightcombatlog.listeners;

import mc.obliviate.lightcombatlog.LightCombatLog;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {

	private final LightCombatLog plugin;

	public ReloadCMD(LightCombatLog plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
		if (commandSender instanceof Player) {
			if (!commandSender.isOp()) return false;
		}
		commandSender.sendMessage("§aConfiguration reloading...");
		plugin.loadConfig();
		commandSender.sendMessage("§aConfiguration reloaded successfully");
		return true;
	}
}
