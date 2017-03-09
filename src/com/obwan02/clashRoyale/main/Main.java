package com.obwan02.clashRoyale.main;

import javax.swing.JFrame;

import com.obwan02.clashRoyale.world.Game;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Clash Royale");
		
		Game game = new Game();
		
		frame.add(game);
		frame.setSize(Specifications.windowWidth, Specifications.windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

}
