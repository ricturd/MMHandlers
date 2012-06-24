import net.morematerials.morematerials.Main;
import net.morematerials.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.getspout.spoutapi.player.SpoutPlayer;

public class VirtualEnchantingTableHandler extends GenericHandler {
	
	public void init(Main main) {
	}

	public void onActivation(Location location, SpoutPlayer player) {
		if (location != null) {
			Material mat = location.getBlock().getType();
			if (mat.equals(Material.WOODEN_DOOR) || mat.equals(Material.IRON_DOOR) || mat.equals(Material.TRAP_DOOR)) return;
		}
		player.openEnchanting(null, true);
	}

	public void shutdown() {
	}
}