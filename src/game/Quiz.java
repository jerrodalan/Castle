package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Quiz extends ImagePanel{

	ArrayList<QuestionPanel> questions;
	JLabel scoreLbl;
	
	public Quiz() {
		super("lib/hills.png");
		setLayout(new GridLayout(3,3));
		
		createQuestions();
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		add(panel);
		
		JButton gradeBtn = new JButton("Grade");
		gradeBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				score();
			}
		});
		panel.add(gradeBtn, BorderLayout.SOUTH);
		
		scoreLbl = new JLabel("SCORE:");
		scoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(scoreLbl, BorderLayout.CENTER);
		
	}
	
	private void createQuestions(){
		questions = new ArrayList<QuestionPanel>();
		
		QuestionPanel first = new QuestionPanel("Which is largest?", new String[] { "45\u00b0", "60\u00b0", "70\u00b0" }, 2);
		questions.add(first);
		add(first);
		
		QuestionPanel sec = new QuestionPanel("Which is Acute?", new String[] { "110\u00b0", "20\u00b0", "95\u00b0" }, 1);
		questions.add(sec);
		add(sec);
		
		QuestionPanel third = new QuestionPanel("Which is Right", new String[] { "90\u00b0", "100\u00b0", "45\u00b0" }, 0); 
		questions.add(third);
		add(third);
		
		QuestionPanel forth = new QuestionPanel("Which is Obtuse?", new String[] { "45\u00b0", "85\u00b0", "115\u00b0" }, 2);
		questions.add(forth);
		add(forth);
		
		QuestionPanel fifth = new QuestionPanel("What do all angles in a triangle add up to?", new String[] { "180\u00b0", "360\u00b0", "90\u00b0" }, 0);
		questions.add(fifth);
		add(fifth);
		
		QuestionPanel six = new QuestionPanel("What are the angles of a rectangle?", new String[] { "0\u00b0", "90\u00b0", "300\u00b0" }, 1);
		questions.add(six);
		add(six);
		
		QuestionPanel seven = new QuestionPanel("What is the best angle for distance?", new String[] { "60\u00b0", "20\u00b0", "45\u00b0" }, 2);
		questions.add(seven);
		add(seven);
		
		QuestionPanel eight = new QuestionPanel("Which angle is the same as 0\u00b0?", new String[] { "90\u00b0", "360\u00b0", "450\u00b0" }, 1);
		questions.add(eight);
		add(eight);
		
	}

	private void score(){
		int score = 0;
		for (QuestionPanel quest : questions){
			if (quest.isCorrect()){
				score++;
			}
		}
		scoreLbl.setText("Score: " + score + " / " + questions.size());
	}
	
}
