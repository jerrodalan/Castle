package hittables;

import java.awt.Rectangle;

public interface Hittable {
	
	public Rectangle getHitBox();
	public void hit();
	public boolean isHit();

}
