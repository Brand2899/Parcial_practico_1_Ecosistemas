package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private ArrayList<Particle> particleGroup;
	private float dist;
	private int arrayPos;
	private boolean moveAgain;
	
	public Logic(PApplet app) {
		this.app = app;
		dist = 0;
		arrayPos = 5000;
		moveAgain = false;
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
			if(!particleGroup.get(i).isSelected()) {
				new Thread(particleGroup.get(i)).start();
			} 
		}
	}
	
	@SuppressWarnings("static-access")
	public void calcDis(int mouseX, int mouseY) {
		for(int i = 0; i < particleGroup.size(); i++) {
			dist = app.dist(mouseX, mouseY, particleGroup.get(i).getPosX(), particleGroup.get(i).getPosY());
			
			if(dist < 50) {
				arrayPos = i;
				try {
					app.fill(0);
					app.textAlign(app.CENTER);
					app.text(particleGroup.get(arrayPos).getGroup(), particleGroup.get(arrayPos).getPosX(), particleGroup.get(arrayPos).getPosY());
					particleGroup.get(arrayPos).setSelected(true);
				}catch(IndexOutOfBoundsException e) {
					e.getLocalizedMessage();
				}
			}else {
				try {
					float distFar = app.dist(mouseX, mouseY, particleGroup.get(arrayPos).getPosX(), particleGroup.get(arrayPos).getPosY());
					
					if(distFar > 50) {
						particleGroup.get(arrayPos).setSelected(false);
					}
				}catch(IndexOutOfBoundsException e) {
					e.getLocalizedMessage();
				}
			}
		}
	}
	
	public void deleteParticles() {
		do {
			for(int i = 0; i < particleGroup.size(); i++) {
				particleGroup.remove(i);
			}
		}while(particleGroup.size() != 0);
	}
}
