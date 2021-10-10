package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import controller.Command;
import controller.Controller;
import controller.Instructions;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	private Controller c;
	
	private String groupName;
	private int R, G, B, posX, posY, particleNumber;
	private boolean delete;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1500, 800);
	}
	
	public void setup() {
		startServer();
		c = new Controller(this);
		groupName = "";
		R = 0;
		G = 0;
		B = 0;
		posX = 0;
		posY = 0;
		particleNumber = 0;
		delete = false;
	}
	
	public void draw() {
		background(255);
		c.draw();
		stopParticle();
	}
	
	public void startServer() {
		new Thread(
				() -> {
					
					try {
						ServerSocket server = new ServerSocket(5357);
						System.out.println("Esperando cliente");
						socket = server.accept();
						System.out.println("Cliente conectado");
						
						InputStream is = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						br = new BufferedReader(isr);
						
						OutputStream os = socket.getOutputStream();
						OutputStreamWriter osw = new OutputStreamWriter(os);
						bw = new BufferedWriter(osw);
						
						while(true) {
							System.out.println("Esperando mensaje");
							String line = br.readLine();
							System.out.println("Recibido: " + line);
							Gson gson = new Gson();
							Instructions inst = gson.fromJson(line, Instructions.class);
							Command cmd = gson.fromJson(line, Command.class);
							groupName = inst.getGroupName();
							R = inst.getR();
							G = inst.getG();
							B = inst.getB();
							posX = inst.getPosX();
							posY = inst.getPosY();
							particleNumber = inst.getParticleNumber();
							delete = cmd.isDelete();
							createParticle();
							deleteParticles();
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}).start();
	}
	
	public void createParticle() {
		for(int i = 0; i < particleNumber; i++) {
			c.createParticle(groupName, R, G, B, posX, posY, this);
			System.out.println("Grupo particulas creada");
		}
	}
	
	public void stopParticle() {
		c.stopParticle(mouseX, mouseY);
	}
	
	public void deleteParticles() {
		if(delete) {
			c.deleteParticles();
		}
	}
}
