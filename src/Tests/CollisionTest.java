package Tests;

import static org.junit.Assert.*;
import game.Game;
import hittables.Blocks;
import hittables.Projectile;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollisionTest {
	
	private Game game;

	@BeforeClass
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
		
		Assert.assertTrue(game.detectCollision(new Projectile(500,520,0,0))); // projectile within block, (x,y) of block not in projectile
		Assert.assertFalse(game.detectCollision(new Projectile(500,5,0,0)));
		
		Assert.assertTrue(game.detectCollision(new Projectile(220,220,0,0)));
		Assert.assertFalse(game.detectCollision(new Projectile(250,250,0, 0)));
		
	}
}
