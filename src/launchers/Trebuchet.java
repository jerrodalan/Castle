package launchers;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Trebuchet extends Launcher{

	public Trebuchet(int x, int y) {
		super(0, 40, 3, new Rectangle(x, y, 150, 110), new ImageIcon("lib/Trebuchet_Launcher.png"), 133, 25);
	}

	

}
