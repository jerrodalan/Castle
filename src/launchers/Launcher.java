package launchers;
import game.ImagePanel;
import hittables.Hittable;
import hittables.Projectile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public abstract class Launcher extends ImagePanel implements Hittable{
	
	private int angle, power;
	private int lowpower, highpower;
	private int health;
	private Rectangle location;
	private boolean isHit = false;
	private Projectile rock;
	private int xOffset, yOffset;

	public Launcher(int lowpower, int highpower, int health, Rectangle r, String picture, int xOff, int yOff) {
		super(picture);
		this.power = lowpower;
		this.angle = 0;
		this.lowpower = lowpower;
		this.highpower= highpower;
		this.health = health;
		this.location = r;
		xOffset = xOff;
		yOffset = yOff;
		super.setBounds(r);
		super.setOpaque(false);
	}

	public Projectile shoot(){
		double x_vel = -power*Math.cos(Math.toRadians(angle));
		double y_vel = power*Math.sin(Math.toRadians(angle));
		rock = new Projectile(location.getX()+xOffset, location.getY()+yOffset, x_vel, y_vel);
		try {
			this.getParent().add(rock);
		} catch (NullPointerException e){
			//System.err.println("The launcher is not added to a panel");
			//e.printStackTrace();
		}
		return rock;
	}
	
	public void shootToWin(){
		for(int i = 0; i <= 90; i++){
			
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		if(rock != null){
//			rock.draw(g);
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
	
	@Override
	public boolean isHit(){
		return isHit();
	}
	public final Rectangle getHitBox(){
		return new Rectangle(location);
	}

	public int getXOffset() {
		return xOffset;
	}

	public int getYOffset() {
		return yOffset;
	}
	
	
}
