package game;
import hittables.Hittable;
import hittables.Projectile;

import java.util.ArrayList;

import javax.swing.JFrame;


public class Game extends JFrame{
	
	private ArrayList<Hittable> hittables;
	
	public Game(){
		hittables = new ArrayList<Hittable>();
	}
	
	public boolean detectCollision(Projectile p){
		for(Hittable h: hittables){
			if(h != p){
				if(p.getHitBox().intersects(h.getHitBox()))
					//p = null;
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	}
	
	
	/**********/
	// Just for testing
	
	public void addHitObject(Hittable h){
		hittables.add(h);
	}
	
	public void resetHittables(){
		hittables = new ArrayList<Hittable>();
	}
}
