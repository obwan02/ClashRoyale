package com.obwan02.clashRoyale.world;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static final int NANO_SECOND = 1000000000;

	private static final int targetFPS = 60;
	
	private Home home;
	private Thread gameThread;
	private boolean running;
	
	public Game() {
		home = new Home();
		gameThread = new Thread(this);
		
		running = false;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		home.paint(g);
		g.drawString("Test", 100, 100);
	} 
	
	public void initComponents() {
		/* TODO: Init sprite sheets and other stuff
		 *  
		 */
	}
	
	public void start() {
		running = true;
		gameThread.start();
	}
	
	public boolean getStatus() {
		return running;
	}
	
	@Override
	public void run() {
		
		long before = System.nanoTime();
		long beforeC = System.nanoTime();
		long interval = NANO_SECOND / targetFPS;
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			
			if(now - before >= interval) {
				before = now;
				frames++;
			}
			
			if(now - beforeC >= NANO_SECOND) {
				beforeC = now;
				System.out.println(frames);
				frames = 0;
			}
		}
		
		running = false;
	}
	
}
