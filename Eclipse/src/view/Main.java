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

import processing.core.PApplet;

public class Main extends PApplet{
	
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1200, 800);
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		background(255);
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
}
