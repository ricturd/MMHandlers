import net.morematerials.morematerials.Main;
import net.morematerials.morematerials.handlers.GenericHandler;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.getspout.spoutapi.player.SpoutPlayer;

public class FireHandler extends GenericHandler {
	
	public void init(Main main) {
	}

	public void onActivation(Location location, SpoutPlayer player) {
		Location loc = player.getLocation();
		player.setFireTicks(80);
		player.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 0, 2);
	}

	public void shutdown() {
	}
}