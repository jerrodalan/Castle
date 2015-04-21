package Tests;

import static org.junit.Assert.*;
import game.Game;
import hittables.Projectile;
import launchers.Cannon;
import launchers.Catapult;
import launchers.Launcher;
import launchers.Trebuchet;

import org.junit.BeforeClass;
import org.junit.Test;

public class FiringTests {
	
	@BeforeClass
	public void setupGame(){
		Game.GAME = new Game();
	}

	@Test
	public void powerChange() { // Stays within limited range
		Launcher launcher = new Catapult(0, 0);
		launcher.setPower(launcher.getLowpower()-5);
		assertEquals(launcher.getLowpower(), launcher.getPower());
		launcher.setPower(launcher.getHighpower()+5);
		assertEquals(launcher.getHighpower(), launcher.getPower());
		launcher = new Trebuchet(0, 0);
		launcher.setPower(launcher.getLowpower()-5);
		assertEquals(launcher.getLowpower(), launcher.getPower());
		launcher.setPower(launcher.getHighpower()+5);
		assertEquals(launcher.getHighpower(), launcher.getPower());
		launcher = new Cannon(0, 0);
		launcher.setPower(launcher.getLowpower()-5);
		assertEquals(launcher.getLowpower(), launcher.getPower());
		launcher.setPower(launcher.getHighpower()+5);
		assertEquals(launcher.getHighpower(), launcher.getPower());
	}
	
	@Test
	public void angleChange() { // stay within 0 and 90
		Launcher launcher = new Catapult(0, 0);
		launcher.setAngle(-5);
		assertEquals(0, launcher.getAngle());
		launcher.setAngle(95);
		assertEquals(90, launcher.getAngle());
	}
	
	
	@Test
	public void projectileMovement() {
		Projectile fire = new Projectile(0, 0, 20*Math.cos(Math.PI/2.0), 20*Math.sin(Math.PI/2.0));
		while (fire.timer.isRunning()) {}
		assertEquals(500, fire.getX(), 0.001);
		
		fire = new Projectile(0, 0, 35*Math.cos(Math.PI/6.0), 35*Math.sin(Math.PI/6.0));
		while (fire.timer.isRunning()) {}
		assertEquals(1326.1014, fire.getX(), 0.001);
		
		fire = new Projectile(0, 0, 50*Math.cos(Math.PI/3.0), 50*Math.sin(Math.PI/3.0));
		while (fire.timer.isRunning()) {}
		assertEquals(2706.3294, fire.getX(), 0.001);
		
		fire = new Projectile(0, 0, 27*Math.cos(0.8), 27*Math.sin(0.8));
		while (fire.timer.isRunning()) {}
		assertEquals(91.86145, fire.getX(), 0.001);
	}
	
	//Write a test that checks if the projectile tops on collision other than ground
	
	@Test
	public void launcherToProjectile(){
		Launcher cannon = new Cannon(0, 0);
		cannon.setAngle(45);
		cannon.setPower(40);
		Projectile fire = cannon.shoot();
		while (fire.timer.isRunning()) {}
		assertEquals(2000, fire.getX(), 0.001);
	}

}
