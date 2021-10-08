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

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	private Controller c;
	
	private int particleNumber;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1500, 800);
	}
	
	public void setup() {
		c = new Controller(this);
		particleNumber = 5;
		createParticle();
	}
	
	public void draw() {
		background(255);
		c.draw();
	}
	
	public void startServer() {
		new Thread(
				() -> {
					
					try {
						ServerSocket server = new ServerSocket(5000);
						socket = server.accept();
						
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
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}).start();
	}
	
	public void createParticle() {
		c.createParticle("g1", 255, 0, 0, 500, 500, this);
		c.createParticle("g1", 255, 0, 0, 500, 500, this);
		c.createParticle("g1", 255, 0, 0, 500, 500, this);
	}
}
