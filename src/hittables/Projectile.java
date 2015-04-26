package hittables;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import launchers.ThreadTimer;

public class Projectile extends JPanel implements Hittable{
	
	private ImageIcon picture;
	
	private double x_pos, y_pos, x_velocity, y_velocity;
	private int radius = 15;
	
	public static double g = -4/5.0;
	private double time;
	private double timeStep = 0.1;
	
	public ThreadTimer timer;
	
	public Projectile(double x, double y, double x_velocity, double y_velocity){
		this.x_pos = x;
		this.y_pos = y;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		//System.out.println(x_velocity + "\t" + y_velocity);
		time = 0;
		timer = new ThreadTimer(5, new Runnable(){
			public void run(){
				advance();
			}
		}, ThreadTimer.FOREVER);
	}
	
	private void advance(){
		y_pos += y_velocity*timeStep;
		x_pos += x_velocity*timeStep;
		y_velocity += g*timeStep;
		time += timeStep;
		//System.out.println(x + "\t" + y);
		boolean colide = Game.GAME.detectCollision(this);
		if (y_pos < 0 || colide){ //or we hit something
			//setVisible(false);
			//System.out.println("stop");
			timer.Stop();
		}
		repaint();
		System.out.println("Advancing");
	}
	
	/*@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillOval((int)x_pos - radius, (int)y_pos - radius, radius*2, radius*2);
		//g.drawImage(picture.getImage(), 0, 0, picture.getIconWidth(), picture.getIconHeight(), null);
		//TODO draw function
	}*/
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval((int)x_pos - radius, (int)y_pos - radius, radius*2, radius*2);
	}
	
	public double getXPosition(){
		return x_pos;
	}
	
	public double getYPosition(){
		return y_pos;
	}
	
	public Rectangle getHitBox(){
		return new Rectangle((int)x_pos - radius, (int)y_pos - radius, radius*2, radius*2);
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		
	}


}
