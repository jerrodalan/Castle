package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import game.Game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ControlGui extends JPanel {
	public JTextField angle, power;
	private JButton viewButton, shootButton;
	public ControlGui(){
		JPanel anglePanel = new JPanel();
		JLabel angleLabel = new JLabel("Angle");
		angle = new JTextField(10);
		angle.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				try {
					Game.GAME.campaign.getLauncher().setAngle(Integer.parseInt(angle.getText()));
				} catch (NumberFormatException ex) {}
				angle.setText(Game.GAME.campaign.getLauncher().getAngle() + "");
			}
			public void focusGained(FocusEvent e){
				angle.setSelectionStart(0);
				angle.setSelectionEnd(angle.getText().length());
			}
		});
		angle.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					requestFocus();
				}
			}
		});
		anglePanel.add(angleLabel);
		anglePanel.add(angle);
		JPanel powerPanel = new JPanel();
		JLabel powerLabel = new JLabel("Power");
		power = new JTextField(10);
		power.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				try {
					Game.GAME.campaign.getLauncher().setPower(Integer.parseInt(power.getText()));
				} catch (NumberFormatException ex){}
				power.setText(Game.GAME.campaign.getLauncher().getPower() + "");
			}
			public void focusGained(FocusEvent e){
				power.setSelectionStart(0);
				power.setSelectionEnd(power.getText().length());
			}
		});
		power.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					requestFocus();
				}
			}
		});
		powerPanel.add(powerLabel);
		powerPanel.add(power);
		viewButton = new JButton("View");
		shootButton = new JButton("Shoot");
		setSize(900, 200);
		add(anglePanel);
		add(powerPanel);
		add(viewButton);
		add(shootButton);
		ButtonListener buttons = new ButtonListener();
		shootButton.addActionListener(buttons);
		viewButton.addActionListener(buttons);
		
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == viewButton){
				System.out.println("Angle: " + angle.getText() + " Power: " + power.getText() + "---Still needs to draw shoot line");
			}
			else if (e.getSource() == shootButton)
				Game.GAME.campaign.getLauncher().shoot();
		}
	}

}
