package game;

import hittables.Castle;
import hittables.Blocks;
import hittables.Projectile;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import launchers.Trebuchet;

public class Campaign extends ImagePanel {

	private Castle castle;
	private Trebuchet trebuchet;
	private ControlGui controlGui;
	
	public Campaign(){
		super("lib/hills.png");
		setLayout(null);
	
		controlGui = new ControlGui();
		controlGui.setLocation(0,600);
		controlGui.setVisible(true);
		add(controlGui);
		
		castle = new Castle();
		this.add(castle);
		castle.setLocation(0, 0);
		
		trebuchet = new Trebuchet(730, 450);
		this.add(trebuchet);
		trebuchet.setAngle(45);
		trebuchet.setPower(30);
		this.add(trebuchet.shoot());
		//Projectile p = new Projectile(500, 500, x_velocity, y_velocity)
		
		
		
	}
	
	public void testShoot(){
		this.add(trebuchet.shoot());
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
