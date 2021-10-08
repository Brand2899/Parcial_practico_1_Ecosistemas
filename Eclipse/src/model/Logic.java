package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private ArrayList<Particle> particleGroup;
	private boolean isSelected;
	
	public Logic(PApplet app) {
		this.app = app;
		particleGroup = new ArrayList<Particle>();
		isSelected = false;
		
		prueba1();
		
	}
	
	public void createParticle(String gName, int R, int G, int B, int posX, int posY, PApplet app) {
		particleGroup.add(new Particle(gName, R, G, B, posX, posY, app));
	}
	
	public void prueba1() {
		particleGroup.add(new Particle("g1", 255, 0, 0, 400, 400, app));
	}
	
	public void draw() {
		for(int i = 0; i < particleGroup.size(); i++) {
			particleGroup.get(i).draw();
			moveParticle();
		}
	}
	
	public void moveParticle() {
		if(!isSelected) {
			for(int i = 0; i < particleGroup.size(); i++) {
				new Thread(particleGroup.get(i)).start();
			}
		}
	}
	
	public void stopParticle(int mouseX, int mouseY) {
		float calcDis = 0;
		int arrayPos = 0;
	}
}
