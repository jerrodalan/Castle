package Tests;

import static org.junit.Assert.*;
import game.Game;
import hittables.Projectile;
import launchers.Cannon;
import launchers.Catapult;
import launchers.Launcher;
import launchers.Trebuchet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FiringTests {
	
	//This will take about 15 sec to run
	
	@Before
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
	public void projectileMovement() throws InterruptedException {
		Projectile fire = new Projectile(0, 0, -20*Math.cos(Math.PI/4.0), 20*Math.sin(Math.PI/4.0));
		while (fire.timer.isRunning()) {
			Thread.sleep(1);
		}
		assertEquals(-500, fire.getX(), 15);
		
		Projectile fire2 = new Projectile(0, 0, -35*Math.cos(Math.PI/6.0), 35*Math.sin(Math.PI/6.0));
		while (fire2.timer.isRunning()) {
			Thread.sleep(1);
		}
		System.out.println("moving on");
		assertEquals(-1326.1014, fire2.getX(), 15);
		
		fire = new Projectile(0, 0, -50*Math.cos(Math.PI/3.0), 50*Math.sin(Math.PI/3.0));
		while (fire.timer.isRunning()) {
			Thread.sleep(1);
		}
		assertEquals(-2706.3294, fire.getX(), 15);
		
		fire = new Projectile(0, 0, -27*Math.cos(0.8), 27*Math.sin(0.8));
		while (fire.timer.isRunning()) {
			Thread.sleep(1);
		}
		assertEquals(-918.6145, fire.getX(), 15);
	}
	
	//Write a test that checks if the projectile tops on collision other than ground
	
	@Test
	public void launcherToProjectile() throws InterruptedException{
		Launcher cannon = new Cannon(0, 0);
		cannon.setAngle(45);
		cannon.setPower(40);
		Projectile fire = cannon.shoot();
		while (fire.timer.isRunning()) {
			Thread.sleep(1);
		}
		assertEquals(-2000, fire.getX(), 15);
	}

}
