package game;
import hittables.Hittable;
import hittables.Projectile;

import java.util.ArrayList;

import javax.swing.JFrame;


public class Game extends JFrame{
	
	private ArrayList<Hittable> hittables;
	
	public Game(){
		
	}
	
	public boolean detectCollision(Projectile p){
		return false;
	}
	
	public static void main(String[] args) {
		
	}
	
	
	/**********/
	// Just for testing
	
	public void addHitObject(Hittable h){
		hittables.add(h);
	}
}
