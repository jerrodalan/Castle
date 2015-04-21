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
	
	public boolean detectCollision(Projectile p){
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
}
