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
	public Campaign campaign; // made public for testing, if this stays in submitted project.... sorry
	private Menu menu;
	private ControlGui controlGui;
	
	public Game(){		
		hittables = new ArrayList<Hittable>();
		
		this.setTitle("Storm the Castle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 900, 678);
		this.setResizable(false);
	}
	
	public void createPanels(){
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		campaign = new Campaign(EnumLauncher.TREBUCHET);
		campaign.setVisible(false);
		/*controlGui = new ControlGui();
		//controlGui.setLocation(0,600);
		controlGui.setVisible(true);
		add(controlGui, BorderLayout.SOUTH);*/
		//controls = new ControlGui();
		menu = new Menu();
		contentPane.add(menu, BorderLayout.CENTER);
		//this.add(controls, BorderLayout.SOUTH);
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
					if(campaign.castleDead()){
						win();
					}
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
	
	private void win(){
		System.out.println("YOU WIN!!!");
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
