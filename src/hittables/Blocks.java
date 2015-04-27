package hittables;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Blocks implements Hittable{
	
	private int x, y, height, width;
	private BufferedImage image;
	
	private boolean isHit = false;
	
	public Blocks(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		try {
			image = ImageIO.read(new File("lib/cracks.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Game.GAME.addHitObject(this);
	}

	public void draw(Graphics g){
		if(isHit){
			g.drawImage(image, x, y, null);
		}
	}

	@Override
	public Rectangle getHitBox() {
		return new Rectangle(x, y, width, height);
	}

	@Override
	public void hit() {
		isHit = true;		
	}

	@Override
	public boolean isHit() {
		return isHit;
	}

	
}
