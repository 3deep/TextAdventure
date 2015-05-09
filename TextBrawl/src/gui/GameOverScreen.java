package gui;

import java.awt.Dimension;
import javax.swing.JTextArea;

public class GameOverScreen extends gui.MainPanel {
	
	JTextArea text;
	
	public GameOverScreen(){
		
		text = new JTextArea();
		text.setPreferredSize(new Dimension(700, 410));
		text.setEditable(false);
		text.setText("You got beaten up badly! You lose :(");
		
	}

}
