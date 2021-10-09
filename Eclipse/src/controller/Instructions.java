package controller;

public class Instructions {
	
	private String groupName;
	private int R, G, B, posX, posY, particleNumber;
	
	public Instructions() {
		
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
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

	public int getParticleNumber() {
		return particleNumber;
	}

	public void setParticleNumber(int particleNumber) {
		this.particleNumber = particleNumber;
	}
}
