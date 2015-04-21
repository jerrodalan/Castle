package launchers;

import java.awt.Rectangle;

public class Catapult extends Launcher {

	public Catapult(int x, int y) {
		super(0, 20, 3, new Rectangle(x, y, 50, 20));
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getHitBox() {
		return super.getLocation();
	}

}
