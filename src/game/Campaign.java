package game;

import hittables.Castle;
import hittables.Blocks;
import hittables.Projectile;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import launchers.Cannon;
import launchers.Catapult;
import launchers.Launcher;
import launchers.Trebuchet;

public class Campaign extends ImagePanel {

	private Castle castle;
	private Launcher launcher;
	private ControlGui controlGui;
	
	public Campaign(EnumLauncher selection){
		super("lib/hills.png");
		setLayout(null);
		
		switch(selection){
		case TREBUCHET: 
			launcher = new Trebuchet(730, 490);
			this.add(launcher);
			break;
		case CATAPULT:
			launcher = new Catapult(730, 518);
			this.add(launcher);
			break;
		case CANNON:
			launcher = new Cannon(730, 507);
			this.add(launcher);
			break;
		}
		launcher.setPower(300);
		launcher.setAngle(20);

	
		controlGui = new ControlGui();
		controlGui.setLocation(0,600);
		controlGui.setVisible(true);
		add(controlGui);
		
		castle = new Castle();
		this.add(castle);
		castle.setLocation(0, 0);
		

		controlGui.angle.setText(launcher.getAngle() + "");
		controlGui.power.setText(launcher.getPower() + "");
		controlGui.power.setEditable(false);
		
	}
	
	public Launcher getLauncher(){
		return launcher;
	}
	
	public boolean castleDead(){
		return castle.isDestroyed();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
