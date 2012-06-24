import net.morematerials.morematerials.Main;
import net.morematerials.morematerials.handlers.GenericHandler;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.particle.Particle;
import org.getspout.spoutapi.particle.Particle.ParticleType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class HealingHandler extends GenericHandler {
	
	public void init(Main main) {
  	}

  	public void onActivation(Location location, SpoutPlayer player) {
  	Location loc = player.getLocation();
    	if (player.getHealth() == 20) return;
    	if (player.getHealth() >= 15) player.setHealth(20); else
    	player.setHealth(player.getHealth() + 5);
    	Particle healParticle = new Particle(ParticleType.DRIPWATER, loc, new Vector(0.5D, 3.0D, 0.5D));
    	healParticle.setParticleBlue(0.0F).setParticleGreen(0.0F).setParticleRed(1.0F);
    	healParticle.setMaxAge(40).setAmount(15).setGravity(1.1F);
    	healParticle.spawn();
  	}

  	public void shutdown() {
  	}
}