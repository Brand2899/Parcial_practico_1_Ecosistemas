package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private ArrayList<Particle> particleGroup;
	private float dist;
	private int arrayPos;
	
	public Logic(PApplet app) {
		this.app = app;
		dist = 0;
		arrayPos = 0;
		particleGroup = new ArrayList<Particle>();
	}
	
	public void createParticle(String gName, int R, int G, int B, int posX, int posY, PApplet app) {
		particleGroup.add(new Particle(gName, R, G, B, posX, posY, app));
	}
	
	public void draw() {
		for(int i = 0; i < particleGroup.size(); i++) {
			particleGroup.get(i).draw();
			moveParticle();
		}
	}
	
	public void moveParticle() {
		for(int i = 0; i < particleGroup.size(); i++) {
			new Thread(particleGroup.get(i)).start();
		}
	}
	
	@SuppressWarnings("static-access")
	public void stopParticle(int mouseX, int mouseY) {
		
		for(int i = 0; i < particleGroup.size(); i++) {
			dist = app.dist(mouseX, mouseY, particleGroup.get(i).getPosX(), particleGroup.get(i).getPosY());
			
			if(dist < 20) {
				System.out.println("Cerca \n");
				arrayPos = i;
				
			}
		}
	}
}
