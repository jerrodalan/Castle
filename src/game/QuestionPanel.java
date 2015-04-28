package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class QuestionPanel extends JPanel{
	
	private JLabel quest;
	private ArrayList<JRadioButton> buttons;
	private int answer;
	
	public QuestionPanel(String question, String[] answers, int answer){
		this.answer = answer;
		buttons = new ArrayList<JRadioButton>();
		setLayout(new BorderLayout());
		setOpaque(false);
		setBorder(new LineBorder(Color.DARK_GRAY, 2));
		quest = new JLabel(question);
		add(quest, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(answers.length, 1));
		panel.setOpaque(false);
		
		ButtonGroup group = new ButtonGroup();
		for(String s: answers){
			JRadioButton temp = new JRadioButton();
			temp.setOpaque(false);
			temp.setText(s);
			buttons.add(temp);
			group.add(temp);
			panel.add(temp);
		}
		
		this.add(panel, BorderLayout.CENTER);
		
	}
	
	public boolean isCorrect(){
		return buttons.get(answer).isSelected();
	}
}
