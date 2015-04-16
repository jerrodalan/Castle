import java.util.ArrayList;


public abstract class Launcher extends Player implements Hittable{
	
	private int angle, power;
	private ArrayList<Projectile> bullet;
	
	

	public Launcher(int angle, int power, ArrayList<Projectile> bullet) {
		super();
		this.angle = angle;
		this.power = power;
		this.bullet = bullet;
	}

	public void shoot(){
		
	}
	
	public void draw(){
		
	}

}
