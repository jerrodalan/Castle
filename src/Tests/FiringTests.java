package Tests;

import static org.junit.Assert.*;
import launchers.Cannon;
import launchers.Catapult;
import launchers.Launcher;
import launchers.Trebuchet;

import org.junit.Test;

public class FiringTests {

	@Test
	public void powerChange() { // Stays within limited range
		Launcher launcher = new Catapult();
		launcher.setPower(launcher.getLowpower()-5);
		assertEquals(launcher.getLowpower(), launcher.getPower());
		launcher.setPower(launcher.getHighpower()+5);
		assertEquals(launcher.getHighpower(), launcher.getPower());
		launcher = new Trebuchet();
		launcher.setPower(launcher.getLowpower()-5);
		assertEquals(launcher.getLowpower(), launcher.getPower());
		launcher.setPower(launcher.getHighpower()+5);
		assertEquals(launcher.getHighpower(), launcher.getPower());
		launcher = new Cannon();
		launcher.setPower(launcher.getLowpower()-5);
		assertEquals(launcher.getLowpower(), launcher.getPower());
		launcher.setPower(launcher.getHighpower()+5);
		assertEquals(launcher.getHighpower(), launcher.getPower());
	}
	
	@Test
	public void angleChange() { // stay within 0 and 90
		Launcher launcher = new Catapult();
		launcher.setAngle(-5);
		assertEquals(0, launcher.getAngle());
		launcher.setAngle(95);
		assertEquals(90, launcher.getAngle());
	}
	
	

}
