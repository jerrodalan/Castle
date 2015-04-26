package launchers;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Trebuchet extends Launcher{

	public Trebuchet(int x, int y) {
		super(0, 35, 3, new Rectangle(x, y, 500, 500), new ImageIcon("/lib/trebucet1.png"));
		
	}

	@Override
	public void paintComponent(Graphics g) {
		paintSuper(g);
		// TODO Auto-generated method stub
		
	}

}
