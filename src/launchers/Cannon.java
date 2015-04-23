package launchers;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Cannon extends Launcher{

	public Cannon(int x, int y) {
		super(0, 50, 3, new Rectangle(x, y, 50, 20));
		
	}

	@Override
	public void paintComponent(Graphics g) {
		paintSuper(g);
		// TODO Auto-generated method stub
		
	}	
	
}
