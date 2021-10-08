package model;

import processing.core.PApplet;

public class Particle implements Runnable {
	
	private String group;
	private int R, G, B;
	private int posX, posY;
	private int dirX, dirY;
	private PApplet app;
	
	public Particle(String group, int R, int G, int B, int posX, int posY, PApplet app) {
		this.app = app;
		this.group = group;
		this.R = R;
		this.G = G;
		this.B = B;
		this.posX = posX;
		this.posY = posY;
		dirX = 1;
		dirY = 1;
	}
	
	public void run() {
		
		move();
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void draw() {
		app.fill(R, G, B);
		app.noStroke();
		app.circle(posX, posY, 30);
	}
	
	public void move() {
		//int vel = (int) app.random(2, 10);
		
		int vel = 1;
		
		int random1 = (int) app.random(1,28000);
		int random2 = (int) app.random(1,30000);
		int random3 = (int) app.random(1,2500);
		
		posX += 1*dirX*vel;
		posY += 1*dirY*vel;
		
		if(posX < 30 || posX > (app.width - 30)) {
			dirX *= -1;
		}
		if(posY < 30 || posY > (app.height - 30)) {
			dirY *= -1;
		}
		
		if(random1 % random3 == 0) {
			dirX *= -1;
		}
		if(random2 % random3 == 0) {
			dirY *= -1;
		}
	}
	
	public String getGroup() {
		return group;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
