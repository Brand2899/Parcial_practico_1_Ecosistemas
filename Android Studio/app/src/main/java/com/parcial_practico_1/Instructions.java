package com.parcial_practico_1;

public class Instructions {

    private String groupName;
    private int R, G, B, posX, posY, particleNumber;

    public Instructions(String groupName, int R, int G, int B, int posX, int posY, int particleNumber){
        this.groupName = groupName;
        this.R = R;
        this.G = G;
        this.B = B;
        this.posX = posX;
        this.posY = posY;
        this.particleNumber = particleNumber;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getR() {
        return R;
    }

    public int getG() {
        return G;
    }

    public int getB() {
        return B;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getParticleNumber() {
        return particleNumber;
    }
}
