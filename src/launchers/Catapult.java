package launchers;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Catapult extends Launcher {

	public Catapult(int x, int y) {
		super(0, 20, 3, new Rectangle(x, y, 50, 20));
		
	}

	@Override
	public void paintComponent(Graphics g) {
		paintSuper(g);
		// TODO Auto-generated method stub

	}

}
