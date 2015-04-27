package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ControlGui extends JPanel {
	private JTextField angle, power;
	private JButton viewButton, shootButton;
	public ControlGui(){
		JPanel anglePanel = new JPanel();
		JLabel angleLabel = new JLabel("Angle");
		angle = new JTextField(10);
		anglePanel.add(angleLabel);
		anglePanel.add(angle);
		JPanel powerPanel = new JPanel();
		JLabel powerLabel = new JLabel("Power");
		power = new JTextField(10);
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
				System.out.println("Angle: " + angle.getText() + " Power: " + power.getText());
			}
			else if (e.getSource() == shootButton)
				System.out.println("Shoot");
		}
	}

}
