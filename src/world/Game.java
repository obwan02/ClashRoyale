package com.obwan02.clashRoyale.world;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Home home;
	
	public Game() {
		home = new Home();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		home.paint(g);
		
	}
	
}
