package game;

import java.awt.Dimension;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends ImagePanel {
	JButton campaignButton;
	JButton challengeButton;
	JButton multiplayerButton;
	
	
	
	public Menu(){
		super("lib/MainMenu2.png");
		setLayout(null);
		//SplashScreen splash = new SplashScreen();
		//add(imagePanel);
		ButtonListener navigation = new ButtonListener();
		campaignButton = makeButtons(253, 182, 429, 98);
		campaignButton.addActionListener(navigation);
		add(campaignButton);
		challengeButton = makeButtons(253, 308, 429, 98);
		challengeButton.addActionListener(navigation);
		add(challengeButton);
		multiplayerButton = makeButtons(253, 428, 429, 98);
		multiplayerButton.addActionListener(navigation);
		add(multiplayerButton);
		this.setVisible(true);
	}
	
	public JButton makeButtons(int x, int y, int sizeX, int sizeY){
		JButton button = new JButton();
		button.setBounds(x, y, sizeX, sizeY);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		//button.setBorderPainted(false);
		return button;
	}
	
	public void hideMenu(){
		setVisible(false);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == campaignButton){
				hideMenu();
				Game.GAME.showCampaign();
				Game.GAME.campaign.testShoot(); // just for testing, if this also makes it into submission.... suck it
			}
			else if (e.getSource() == challengeButton){
				hideMenu();
			}
			else if(e.getSource() == multiplayerButton){
				hideMenu();
			}
		}
	}
	

}
