package game;
import hittables.Hittable;
import hittables.Projectile;

import java.util.ArrayList;

import javax.swing.JFrame;


public class Game extends JFrame{
	
	public static Game GAME;
	
	private ArrayList<Hittable> hittables;
	
	public Game(){
		hittables = new ArrayList<Hittable>();
	}
	
	public boolean detectCollision(Hittable p){
		for(Hittable h: hittables){
			if(h != p){
				if(p.getHitBox().intersects(h.getHitBox())){
					this.removeHittable(p);
					return true;
			}
		}
		}
		return false;
	}
	
	public static void main(String[] args) {
		GAME = new Game();
	}
	
	
	/**********/
	// Just for testing
	
	public void addHitObject(Hittable h){
		hittables.add(h);
	}
	
	public void resetHittables(){
		hittables = new ArrayList<Hittable>();
	}
	
	public void removeHittable(Hittable h){
		hittables.remove(h);
	}
	
	public boolean containsHittable(Hittable p){
		if(hittables.contains(p)){
			return true;
		}
		return false;
	}
}
