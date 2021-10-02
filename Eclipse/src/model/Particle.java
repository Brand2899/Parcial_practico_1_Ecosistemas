package model;

import processing.core.PApplet;

public class Particle {
	
	private String group;
	private int R, G, B;
	private int posX, posY;
	private PApplet app;
	
	public Particle(String group, int R, int G, int B, int posX, int posY, PApplet app) {
		this.app = app;
		this.group = group;
		this.R = R;
		this.G = G;
		this.B = B;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void draw() {
		app.fill(R, G, B);
		app.noStroke();
		app.circle(posX, posY, 30);
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
