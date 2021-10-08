package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private ArrayList<Particle> particleGroup;
	
	public Logic(PApplet app) {
		this.app = app;
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
		float calcDis = 0;
		int arrayPos = 0;
		
		for(int i = 0; i < particleGroup.size(); i++) {
			calcDis = app.dist(mouseX, mouseY, particleGroup.get(i).getPosX(), particleGroup.get(i).getPosY());
			
			if(calcDis < 30) {
				System.out.println("Cerca \n");
			}
		}
		
		for(int i = 0; i < particleGroup.size(); i++) {
			System.out.println(particleGroup.get(i).getPosX() + "  //  posX");
			System.out.println(particleGroup.get(i).getPosY() + "  //  posY");
			System.out.println(mouseX + "  //  MouseX");
			System.out.println(mouseY + "  //  MouseY");
			System.out.println(calcDis + "  //  CalcDis");
		}
	}
}
