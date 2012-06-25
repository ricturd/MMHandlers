import net.morematerials.morematerials.Main;
import net.morematerials.morematerials.handlers.GenericHandler;
import net.morematerials.morematerials.materials.SMCustomBlock;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ReplaceBlockHandler extends GenericHandler {
	
	public void init(Main main) {
  	}

  	public void onActivation(Location loc, SpoutPlayer player) {
  		if (loc == null) return;
  		Block b = loc.getBlock();
  		if (b instanceof SMCustomBlock) {
  			//b.breakNaturally();
  			//b.setType(Material.GLOWSTONE);
  			SpoutBlock b2 = (SpoutBlock) b;
  			SpoutManager.getMaterialManager().overrideBlock(b, (CustomBlock) b2);
  		} else {
  			b.setType(Material.GLOWSTONE);
  		}	
  	}

  	public void shutdown() {
  	}
}