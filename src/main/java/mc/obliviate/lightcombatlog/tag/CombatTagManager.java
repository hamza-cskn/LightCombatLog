package mc.obliviate.lightcombatlog.tag;

import mc.obliviate.lightcombatlog.LightCombatLog;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CombatTagManager {

	private final LightCombatLog plugin;

	public final Map<Player, CombatTag> tagMap = new HashMap<>();

	public CombatTagManager(LightCombatLog plugin) {
		this.plugin = plugin;
	}

	public void tag(final Player attacker, final Player victim, final long time) {
		if (!isTagged(attacker)) {
			attacker.sendMessage(plugin.getConfigMessage("you-are-tagged"));
		}
		if (!isTagged(victim)) {
			victim.sendMessage(plugin.getConfigMessage("you-are-tagged"));
		}
		tagMap.put(attacker, new CombatTag(attacker, time));
		tagMap.put(victim, new CombatTag(attacker, time));
	}

	public void untag(final Player player) {
		tagMap.keySet().removeIf(player1 -> player1.equals(player));

		player.sendMessage(plugin.getConfigMessage("you-are-untagged"));
	}

	public boolean isTagged(final Player player) {
		return tagMap.containsKey(player);
	}

}
