package launchers;
import hittables.Hittable;
import hittables.Projectile;

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

	public Projectile shoot(){
		return null;
	}
	
	abstract public void draw();
	
	public void setAngle(int angle){
		if (angle <= 0)
			this.angle = 0;
		else if (angle >= 90){
			this.angle = 90;
		}
		else
			this.angle = angle;
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
