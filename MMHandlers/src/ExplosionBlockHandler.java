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
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ExplosionBlockHandler extends GenericHandler {
	
	@Override
	public void init(MoreMaterials plugin) {
	}

	@Override
	public void onActivation(Event event, Map<String, Object> config) 
	{
		
		World world = null;
		Location loc = null;
		
		// checking all possible way to make the block explode
		// (so we can get the location of the block) 
		if(event instanceof PlayerInteractEvent)
		{
			if (((PlayerInteractEvent) event).hasBlock()) // if the event involve a block
			{
				world = ((PlayerInteractEvent) event).getClickedBlock().getWorld();
				loc = ((PlayerInteractEvent) event).getClickedBlock().getLocation();
			}
			else // we use the player position (this might be a gunpowder like item that explode when right clicked)
			{
				world = ((PlayerInteractEvent) event).getPlayer().getWorld();
				loc = ((PlayerInteractEvent) event).getPlayer().getLocation();
			}
		}
		else if(event instanceof BlockBurnEvent)
		{
			world = ((BlockBurnEvent) event).getBlock().getWorld();
			loc = ((BlockBurnEvent) event).getBlock().getLocation();
		}
		else if(event instanceof BlockRedstoneEvent)
		{
			world = ((BlockRedstoneEvent) event).getBlock().getWorld();
			loc = ((BlockRedstoneEvent) event).getBlock().getLocation();
		}
		else if(event instanceof BlockIgniteEvent)
		{
			world = ((BlockIgniteEvent) event).getBlock().getWorld();
			loc = ((BlockIgniteEvent) event).getBlock().getLocation();			
		}
		else return; // if this is not one of these events, the block is not supposed to explode 

		//creating the explosion
		world.createExplosion(loc, (float) config.get("power"), (boolean) config.get("setOnFire"));
	}

	public void shutdown() {
	}

}