package Tests;

import static org.junit.Assert.*;
import launchers.Cannon;
import game.Game;
import hittables.Blocks;
import hittables.Projectile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollisionTest {
	
	private static Game game;

	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void stillProjectileOneBlock(){
		game.addHitObject(new Blocks(50, 50, 10, 10));
		Assert.assertTrue(game.detectCollision(new Projectile(49,49,0,0)));
		Assert.assertFalse(game.detectCollision(new Projectile(500, 500, 0, 0)));
	}
	
	@Test
	public void stillProjectileMultipleBlocks(){
		game.addHitObject(new Blocks(50, 50, 10, 10));
		game.addHitObject(new Blocks(500, 500, 10, 10));
		game.addHitObject(new Blocks(100, 100, 10, 10));
		game.addHitObject(new Blocks(200, 200, 10, 10));
		Assert.assertTrue(game.detectCollision(new Projectile(49,49,0,0)));
		Assert.assertFalse(game.detectCollision(new Projectile(500,484,0,0))); // x-cord is on block, y is not
		
		Assert.assertTrue(game.detectCollision(new Projectile(99,99,0,0)));
		Assert.assertFalse(game.detectCollision(new Projectile(484,499,0,0))); // x-cord is not on block, y is
		
		Assert.assertTrue(game.detectCollision(new Projectile(500,520,0,0))); // projectile within block, (x,y) of block not in projectile (off by y)
		Assert.assertFalse(game.detectCollision(new Projectile(500,5,0,0)));
		
		Assert.assertTrue(game.detectCollision(new Projectile(520,500,0,0))); // projectile within block, (x,y) of block not in projectile (off by x)
		Assert.assertFalse(game.detectCollision(new Projectile(250,250,0, 0)));
		
		Assert.assertTrue(game.detectCollision(new Projectile(220,220,0,0))); // projectile withis block, (x,y) of block not in projectile (off by x and y)
		Assert.assertFalse(game.detectCollision(new Projectile(150,150,0, 0)));
	}
	
	//This test is written assuming that the player's projectile is not in the hittable array
	@Test
	public void multipleProjectilesStill(){
		game.addHitObject(new Projectile(50,50,0,0));
		Assert.assertTrue(game.detectCollision(new Projectile(40,50,0,0)));
		// In this test, the center of the projectiles are between 14 and 15 units away from each other. The radius is 15 
		//projectile being passed is left of projectile in Array
		Assert.assertTrue(game.detectCollision(new Projectile(60,50,0,0)));
		//right
		Assert.assertTrue(game.detectCollision(new Projectile(50,40,0,0)));
		//up
		Assert.assertTrue(game.detectCollision(new Projectile(50,60,0,0)));
		//down
		
		Assert.assertTrue(game.detectCollision(new Projectile(70.85,70.85,0,0)));
		//The projectiles are colliding by less than 1 unit
		
		//Assert.assertFalse(game.detectCollision(new Projectile(71.56,71.56,0,0)));
		//The projectiles are missing by less than 1 unit
		
		Assert.assertTrue(game.detectCollision(new Projectile(70.4,70.4,0,0)));
		//The projectiles are colliding by less than 2 units but more than 1
		
		//Assert.assertFalse(game.detectCollision(new Projectile(72,72,0,0)));
		//The projectiles are missing by less than 2 unit but more than 1
	}
	
	//This tests if the projectile is deleted after the collision
	@Test
	public void ProjectileDeleted(){
		game.addHitObject(new Blocks(50,50,0,0));
		Projectile p = new Projectile(49,49,0,0); 
		game.detectCollision(p);
		Assert.assertTrue(p.equals(null));
		
		game.resetHittables();
		game.addHitObject(new Projectile(50,50,0,0));
		p = new Projectile(49,49,0,0); 
		game.detectCollision(p);
		Assert.assertTrue(p.equals(null));
	}
	
	@Test
	public void CatapultCollision(){
		game.addHitObject(new Cannon(0,0));
		Assert.assertTrue(game.detectCollision(new Projectile(5,5,0,0)));
	}
	
	@Test
	public void notHitSelf(){
		Projectile p = new Projectile(50,50,0,0);
		game.addHitObject(p);
		Assert.assertFalse(game.detectCollision(p));
	}
}
