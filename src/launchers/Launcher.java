package launchers;
import hittables.Hittable;

import java.awt.Rectangle;
import java.util.ArrayList;


public abstract class Launcher implements Hittable{
	
	private int angle, power;
	private int lowpower, highpower;
	private int health;
	private Rectangle location;

	public Launcher(int lowpower, int highpower, int health, Rectangle r) {
		super();
		this.power = lowpower;
		this.angle = 0;
		this.lowpower = lowpower;
		this.highpower= highpower;
		this.health = health;
		this.location = r;
	}

	public void shoot(){
		
	}
	
	abstract public void draw();
	
	public void setAngle(int angle){
		
	}
	
	public int getAngle(){
		return angle;
	}
	
	public void setPower(int power){
		
	}
	
	public int getPower(){
		return power;
	}

	public int getLowpower() {
		return lowpower;
	}

	public int getHighpower() {
		return highpower;
	}
	
	public int getHealth(){
		return health;
	}

	public void decrementHealth(){
		health--;
	}
	
	public Rectangle getLocation(){
		return new Rectangle(location);
	}
}
