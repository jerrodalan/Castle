package hittables;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Blocks implements Hittable{
	
	private int x, y, height, width;
	private ImageIcon image;
	
	private boolean isHit = false;
	
	public Blocks(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		image = new ImageIcon(Blocks.class.getResource("/cracks.png"));
		Game.GAME.addHitObject(this);
	}

	public void draw(Graphics g){
		if(isHit){
			g.drawImage(image.getImage(), x, y, null);
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
