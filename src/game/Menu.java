package game;

import java.awt.Dimension;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends ImagePanel {
	JButton campaignButton;
	JButton challengeButton;
	JButton multiplayerButton;
	
	
	
	public Menu(){
		super("/MainMenu2.png");
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
		button.setBorderPainted(false);
		return button;
	}
	
	public void hideMenu(){
		setVisible(false);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == campaignButton){
				Game.GAME.showCampaign();
			}
			else if (e.getSource() == challengeButton){
				Game.GAME.showQuiz();
			}
			else if(e.getSource() == multiplayerButton){
				JOptionPane.showConfirmDialog(Game.GAME, "This feature is not currently available.", "Cannot Process", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	

}
