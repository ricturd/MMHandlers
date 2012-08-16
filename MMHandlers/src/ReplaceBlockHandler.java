/**
 * @version 1.1
 * @author tristan Roche (Stan_fear)
 * 
 * for MoreMaterials 1.8 and later
 */


import java.util.Map;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.Material;

public class ReplaceBlockHandler extends GenericHandler {
	

	private MoreMaterials plugin;

	@Override
	public void init(MoreMaterials plugin) {
		this.plugin = plugin;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onActivation(Event event, Map<String, Object> config) {
		
		Location loc = null;
		
		// checking all possible way to make the block explode
		// (so we can get the location of the block) 
		if(event instanceof PlayerInteractEvent)
		{
			if (((PlayerInteractEvent) event).hasBlock()) // if the event involve a block
			{
				loc = ((PlayerInteractEvent) event).getClickedBlock().getLocation();
			}
			else // we use the player position (this might be a gunpowder like item that explode when right clicked)
			{
				loc = ((PlayerInteractEvent) event).getPlayer().getLocation();
			}
		}
		else if(event instanceof BlockBurnEvent)
		{
			loc = ((BlockBurnEvent) event).getBlock().getLocation();
		}
		else if(event instanceof BlockRedstoneEvent)
		{
			loc = ((BlockRedstoneEvent) event).getBlock().getLocation();
		}
		else if(event instanceof BlockIgniteEvent)
		{
			loc = ((BlockIgniteEvent) event).getBlock().getLocation();			
		}
		else return; // if this is not one of these events, the block is not supposed to explode 

		// getting the configured block
		Material block = this.plugin.getSmpManager().getMaterial((String) config.get("SMPname"), (String) config.get("blockName"));
		// replacing the block by the new one
		((SpoutBlock) loc.getBlock()).setCustomBlock((CustomBlock) block);
		
	}

  	public void shutdown() {
  	}
}