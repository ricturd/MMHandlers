/**
 * @version 1.1
 * @author tristan Roche (Stan_fear)
 * 
 * for MoreMaterials 1.8 and later
 */

import java.util.Map;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireHandler extends GenericHandler {
	

	@Override
	public void init(MoreMaterials arg0) {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public void onActivation(Event event, Map<String, Object> config) {

		
		World world = null;
		Location loc = null;
		
		// checking all possible way to make the block gets set on fire
		// (so we can get the location of the block) 
		if(event instanceof PlayerInteractEvent)
		{
			if (((PlayerInteractEvent) event).hasBlock()) // if the event involve a block
			{
				world = ((PlayerInteractEvent) event).getClickedBlock().getWorld();
				loc = ((PlayerInteractEvent) event).getClickedBlock().getLocation();
			}
			else // we use the player position
			{
				world = ((PlayerInteractEvent) event).getPlayer().getWorld();
				loc = ((PlayerInteractEvent) event).getPlayer().getLocation();
			}
		}
		else if(event instanceof BlockBurnEvent) // if we want the fire to expand
		{
			world = ((BlockBurnEvent) event).getBlock().getWorld();
			loc = ((BlockBurnEvent) event).getBlock().getLocation();
		}
		else if(event instanceof BlockRedstoneEvent) // ideal for a lantern turned on with redstone
		{
			world = ((BlockRedstoneEvent) event).getBlock().getWorld();
			loc = ((BlockRedstoneEvent) event).getBlock().getLocation();
		}
		else if(event instanceof BlockIgniteEvent) // if we want the fire to expand
		{
			world = ((BlockIgniteEvent) event).getBlock().getWorld();
			loc = ((BlockIgniteEvent) event).getBlock().getLocation();			
		}
		else return; // if this is not one of these events, the block is not supposed to be set on fire 

		
		world.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 0);
		
	}

	public void shutdown() {
	}


}