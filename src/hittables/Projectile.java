package hittables;

import java.awt.Rectangle;

public class Projectile implements Hittable{
	
	private double x, y, x_velocity, y_velocity;
	private int radius = 15;
	
	public static double g = -4/5;
	private int time;
	
	public Projectile(double x, double y, double x_velocity, double y_velocity){
		this.x = x;
		this.y = y;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		time = 0;
	}
	
	private void advance(){
		
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
		return new Rectangle((int)x - radius, (int)y - radius, radius*2, radius*2);
	}
}
