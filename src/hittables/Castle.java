package hittables;
import game.ImagePanel;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Castle extends ImagePanel {
	
	private ArrayList<Blocks> structure;
	
	public Castle(){
		super("lib/castle_cross_section.png");
		this.setSize(365, 708);
		createBlocks();
	}
	
	private void createBlocks(){
		structure = new ArrayList<Blocks>();
		for (int i = 0; i < 6; i++){
			structure.add(new Blocks(130,600 - (i+1)*60,106,60));
		}
		
	}
	
	public boolean isDestroyed(){
		for(Blocks b: structure){
			if(!(b.isHit())){
				return false;
			}
		}
		return true;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Blocks b: structure){
			b.draw(g);
		}
	}
	
}
