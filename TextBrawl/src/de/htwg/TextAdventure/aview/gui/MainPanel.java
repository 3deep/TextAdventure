package de.htwg.TextAdventure.aview.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{

	private static final int BORDER_SIZE = 10;
	private static final int TEXT_WIDTH = 700;
	private static final int TEXT_HEIGTH = 410;
	private static final int STATS_WIDTH = 180;
	private static final int BUTTONS_HEIGTH = 120;
	private static final int PANEL_WIDTH = 880;
	private static final int PANEL_HEIGTH = 580;
	
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JButton button5;
	public JButton button6;
	public JButton button7;
	public JButton button8;
	
	JPanel mainPanel;
	static JTextArea statsPanel;
	static JPanel buttonsPanel;
	static JTextArea text;
	
	/**
	 * MainPanel for the GUI
	 * @return mainPanel
	 * returns the mainPanel wich will be shown on the GUI
	 */
	public MainPanel(){
	
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
	
		text = new JTextArea();
		text.setPreferredSize(new Dimension(TEXT_WIDTH, TEXT_HEIGTH));
		text.setEditable(false);
		
		statsPanel = new JTextArea();
		statsPanel.setPreferredSize(new Dimension(STATS_WIDTH, TEXT_HEIGTH));
		statsPanel.setEditable(false);
		//statsPanel.setBackground(Color.DARK_GRAY);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(TEXT_WIDTH, BUTTONS_HEIGTH));
		//buttonsPanel.setBackground(Color.GRAY);

		Dimension buttenDimension = new Dimension(150, 40);
		button1 = new JButton();
		button1.setPreferredSize(buttenDimension);
		button2 = new JButton();
		button2.setPreferredSize(buttenDimension);
		button3 = new JButton();
		button3.setPreferredSize(buttenDimension);
		button4 = new JButton();
		button4.setPreferredSize(buttenDimension);
		button5 = new JButton();
		button5.setPreferredSize(buttenDimension);
		button6 = new JButton();
		button6.setPreferredSize(buttenDimension);

		buttonsPanel.add(button1);
		buttonsPanel.add(button2);
		buttonsPanel.add(button3);
		buttonsPanel.add(button4);
		buttonsPanel.add(button5);
		buttonsPanel.add(button6);
		
		GroupLayout layout = new GroupLayout(mainPanel);
		mainPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
	
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
								.addComponent(statsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
				);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(statsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addComponent(buttonsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				);
	
		mainPanel.setBounds(BORDER_SIZE, BORDER_SIZE, PANEL_WIDTH, PANEL_HEIGTH);
	}
	
	public void printString(String s){
		text.setText(s);
	}
	
	public void addString(String s){
		String tmp = text.getText();
		tmp +="\n" + s;
		text.setText(tmp);
	}
	
	public JPanel givePanel() {
		return mainPanel;
	}
	
	public void changeButtonText(int num, String text) {
		switch(num){
			case 1:
				button1.setText(text);
				break;
			case 2:
				button2.setText(text);
				break;
			case 3:
				button3.setText(text);
				break;
			case 4:
				button4.setText(text);
				break;
			case 5:
				button5.setText(text);
				break;
			case 6:
				button6.setText(text);
				break;
			default:
				break;
		}
	}
	
	public void printStats(String stats){
		statsPanel.setText(stats);
	}
	
	public void setButtonActive(int num, boolean bool){
		switch(num){
		case 1:
			if(bool){
				button1.setEnabled(true);}
			else{
				button1.setEnabled(false);}
			break;
		case 2:
			if(bool){
				button2.setEnabled(true);}
			else{
				button2.setEnabled(false);}
			break;
		case 3:
			if(bool){
				button3.setEnabled(true);}
			else{
				button3.setEnabled(false);}
			break;
		case 4:
			if(bool){
				button4.setEnabled(true);}
			else{
				button4.setEnabled(false);}
			break;
		case 5:
			if(bool){
				button5.setEnabled(true);}
			else{
				button5.setEnabled(false);}
			break;
		case 6:
			if(bool){
				button6.setEnabled(true);}
			else{
				button6.setEnabled(false);}
			break;
		default:
			break;
		}
	}
	

}
