package hittables;

public class Projectile {
	
	private int x, y;
	private double x_velocity, y_velocity;
	private int radius = 15;
	
	public Projectile(int x, int y, double x_velocity, double y_velocity){
		this.x = x;
		this.y = y;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
	}
	
	public void draw(){
		
	}
}
