package hittables;

import game.Game;

import java.awt.Rectangle;

import launchers.ThreadTimer;

public class Projectile implements Hittable{
	
	private double x, y, x_velocity, y_velocity;
	private int radius = 15;
	
	public static double g = -4/5;
	private double time;
	private double timeStep = 0.5;
	
	public ThreadTimer timer;
	
	public Projectile(double x, double y, double x_velocity, double y_velocity){
		this.x = x;
		this.y = y;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		time = 0;
		timer = new ThreadTimer((int)(timeStep*1000), new Runnable(){
			public void run(){
				advance();
			}
		}, ThreadTimer.FOREVER);
	}
	
	private void advance(){
		y += y_velocity*timeStep;
		x += x_velocity*timeStep;
		y_velocity += g*timeStep;
		time += timeStep;
		boolean colide = Game.GAME.detectCollision(this);
		if (y < 0 || colide){ //or we hit something
			//setVisible(false);
			timer.Stop();
		}
	}
	
	public void draw(){
		
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public Rectangle getHitBox(){
		return new Rectangle((int)x, (int)y, radius*2, radius*2);
	}
}
