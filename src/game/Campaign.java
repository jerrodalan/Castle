package game;

import hittables.Castle;
import hittables.Blocks;
import hittables.Projectile;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import launchers.Launcher;
import launchers.Trebuchet;

public class Campaign extends ImagePanel {

	private Castle castle;
	private Launcher launcher;
	private ControlGui controlGui;
	
	public Campaign(){
		super("lib/hills.png");
		setLayout(null);
	
		launcher = new Trebuchet(730, 490);
		this.add(launcher);
		launcher.setAngle(45);
		launcher.setPower(30);
		//this.add(trebuchet.shoot());
		//Projectile p = new Projectile(500, 500, x_velocity, y_velocity)
		
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
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
