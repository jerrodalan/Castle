package hittables;

import java.awt.Rectangle;

public class Blocks implements Hittable{
	
	private int x, y, height, width;
	
	public Blocks(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public void draw(){
		
	}

	@Override
	public Rectangle getHitBox() {
		return new Rectangle(x, y, width, height);
	}

}
