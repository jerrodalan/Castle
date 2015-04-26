package game;
import hittables.Hittable;
import hittables.Projectile;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame {
	
	public static Game GAME;
	private JPanel contentPane;
	
	private ArrayList<Hittable> hittables;
	private Campaign campaign;
	private Menu menu;
	
	public Game(){		
		hittables = new ArrayList<Hittable>();
		
		this.setTitle("Storm the Castle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 900, 600);
		this.setResizable(false);
	}
	
	public void createPanels(){
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		campaign = new Campaign();
		campaign.setVisible(false);
		
		menu = new Menu();
		contentPane.add(menu, BorderLayout.CENTER);
		menu.setVisible(true);
	}
	
	public void showCampaign(){
		menu.setVisible(false);
		contentPane.add(campaign, BorderLayout.CENTER);
		campaign.setVisible(true);
	}

	public boolean detectCollision(Hittable p){
		for(Hittable h: hittables){
			if(h != p){
				if(p.getHitBox().intersects(h.getHitBox())){
					h.hit();
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GAME = new Game();
		GAME.createPanels();
		GAME.setVisible(true);
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
