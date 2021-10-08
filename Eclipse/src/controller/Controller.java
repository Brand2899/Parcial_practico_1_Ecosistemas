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
	
	public void stopParticle() {
		
	}
}
