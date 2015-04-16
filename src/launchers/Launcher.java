package launchers;
import hittables.Hittable;

import java.util.ArrayList;


public abstract class Launcher implements Hittable{
	
	private int angle, power;
	private int lowpower, highpower;

	public Launcher(int lowpower, int highpower) {
		super();
		this.power = lowpower;
		this.angle = 0;
		this.lowpower = lowpower;
		this.highpower= highpower;
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

}
