package de.htwg.TextAdventure.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{

	private static final int BORDER_SIZE = 10;
	private static final int TEXT_WIDTH = 700;
	private static final int TEXT_HEIGTH = 410;
	private static final int STATS_WIDTH = 130;
	private static final int BUTTONS_HEIGTH = 120;
	private static final int PANEL_WIDTH = 880;
	private static final int PANEL_HEIGTH = 580;
	
	JPanel mainPanel;
	static JPanel statsPanel;
	static JPanel buttonsPanel;
	static JTextArea text;
	
	/**
	 * MainPanel for the GUI
	 * @return mainPanel
	 * returns the mainPanel wich will be shown on the GUI
	 */
	public static JPanel maPanel(){
	
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
	
		text = new JTextArea();
		text.setPreferredSize(new Dimension(TEXT_WIDTH, TEXT_HEIGTH));
		text.setEditable(false);
		
		statsPanel = new JPanel();
		statsPanel.setPreferredSize(new Dimension(STATS_WIDTH, TEXT_HEIGTH));
		statsPanel.setBackground(Color.DARK_GRAY);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(TEXT_WIDTH, BUTTONS_HEIGTH));
		buttonsPanel.setBackground(Color.GRAY);
		
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
		return mainPanel;
	}

}
