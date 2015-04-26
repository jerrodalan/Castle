package launchers;
import hittables.Hittable;
import hittables.Projectile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public abstract class Launcher extends JPanel implements Hittable{
	
	private int angle, power;
	private int lowpower, highpower;
	private int health;
	private Rectangle location;
	private boolean isHit = false;
	
	protected ImageIcon picture;

	public Launcher(int lowpower, int highpower, int health, Rectangle r, ImageIcon picture) {
		super();
		this.power = lowpower;
		this.angle = 0;
		this.lowpower = lowpower;
		this.highpower= highpower;
		this.health = health;
		this.location = r;
		this.picture = picture;
		super.setBounds(r);
	}

	public Projectile shoot(){
		double x_vel = -power*Math.cos(Math.toRadians(angle));
		double y_vel = power*Math.sin(Math.toRadians(angle));
		return new Projectile(location.getX(), location.getY(), x_vel, y_vel);
	}
	
	@Override
	public void paintComponent(Graphics g){
		paintSuper(g);
		//g.drawImage(picture, location.getX(), location.getY(), null);
	}
	
	protected final void paintSuper(Graphics g){
		super.paintComponent(g);
	}
	
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
		if (power < lowpower){
			power = lowpower;
		}
		if (power > highpower){
			power = highpower;
		}
		this.power = power;
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
	
	@Override
	public void hit() {
		isHit = true;		
	}	
	public final Rectangle getHitBox(){
		return new Rectangle(location);
	}
}
