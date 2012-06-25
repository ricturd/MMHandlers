import net.morematerials.morematerials.Main;
import net.morematerials.morematerials.handlers.GenericHandler;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.getspout.spoutapi.player.SpoutPlayer;


public class ReplaceBlockHandler extends GenericHandler {
	
	public void init(Main main) {
  	}

  	public void onActivation(Location loc, SpoutPlayer player) {
  		if (loc == null) return;
  		Block b = loc.getBlock();
  		b.setType(Material.GLOWSTONE);
  	}

  	public void shutdown() {
  	}
}