package gui;

import java.awt.Dimension;

//import javax.swing.BorderFactory;
//import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameOverScreen extends gui.mainPanel {
	
	JTextArea text;
	//JPanel panel;
	
	public GameOverScreen(){
		
		//panel = new JPanel();
		//panel.setBorder(BorderFactory.createRaisedBevelBorder());
		text = new JTextArea();
		text.setPreferredSize(new Dimension(700, 410));
		text.setEditable(false);
		text.setText("You got beaten up badly! You lose :(");
		//System.out.println("ll");
		//panel.add(text);
		
	}

}
