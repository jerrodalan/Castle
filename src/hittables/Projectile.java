package hittables;

public class Projectile {
	
	private double x, y, x_velocity, y_velocity;
	private int radius = 15;
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
}
