/**
 * @version 1.1
 * @author tristan Roche (Stan_fear)
 * 
 * for MoreMaterials 1.8 and later
 */

import java.util.Map;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;


import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class FireBallItemHandler extends GenericHandler {

	@Override
	public void init(MoreMaterials plugin) {		
	}
	
	
	public void onActivation(Event event, Map<String, Object> config) 
	{
		// check if the handler (event part) is well configured
		if(!(event instanceof PlayerInteractEvent))
			return;
		
		// casting the event to have all necessary data
		PlayerInteractEvent castedEvent = (PlayerInteractEvent) event;
		
		// getting the player (to set the origin of the fireball and the direction)
		Player shooter = castedEvent.getPlayer();
		
		// getting the direction the player is looking at
		Vector playerLookingat = shooter.getEyeLocation().getDirection();
		
		// creating the fireball (and launching it ?)
		Fireball fireball = (Fireball) shooter.getWorld().spawn(
				shooter.getLocation(), Fireball.class);

		// setting up all never changing parameters
		fireball.setBounce(false);
		fireball.setDirection(playerLookingat);
		fireball.setShooter(shooter);
		
		// setting up all parameters set in the config
		fireball.setYield((float) config.get("power")); // the radius of the explosion
		fireball.setIsIncendiary((boolean) config.get("setOnFire")); // if the explosion must create fire
		fireball.setVelocity(new Vector(1,1,1).multiply((float) config.get("velocity")));
		
		
	}
	
	public void shutdown() {
	}

}