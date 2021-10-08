package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
	
	private Logic l;
	private PApplet app;
	
	public Controller(PApplet app) {
		l = new Logic(app);
	}
	
	public void draw() {
		l.draw();
	}
	
	public void createParticle(String gName, int R, int G, int B, int posX, int posY, PApplet app) {
		l.createParticle(gName, R, G, B, posX, posY, app);
	}
	
	public void stopParticle(int mouseX, int mouseY) {
		l.stopParticle(mouseX, mouseY);
	}
}
