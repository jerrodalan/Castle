package launchers;
import hittables.Hittable;

import java.util.ArrayList;


public abstract class Launcher implements Hittable{
	
	protected int angle, power;
	private int lowpower, highpower;

	public Launcher(int lowpower, int highpower) {
		super();
		this.power = 0;
		this.angle = 0;
		this.lowpower = lowpower;
		this.highpower= highpower;
	}

	abstract void shoot();
	
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

}
