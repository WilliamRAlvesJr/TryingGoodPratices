package main.servers.server;

import java.io.IOException;
import java.net.ServerSocket;

import main.screen.drawer.Draw;
import main.servers.client.Client;
import main.servers.client.ClientFactory;
import main.servers.server.uiserver.ServerReaderThread;
import main.servers.server.uiserver.ServerWriterThread;

public class GameServer extends Thread {

	private static Client clientOne;
	private static Client clientTwo;
	private static ServerSocket serverSocket;
	public static int xAxisPlayerOne;
	protected static int xAxisPlayerTwo;
	
	public GameServer() throws Exception {
		System.out.println("Iniciando servidor...");
		serverSocket = new ServerSocket(8080);
	}

	void waitClients(){
		try {
			clientOne = new ClientFactory().buildClient(serverSocket);
			clientTwo = new ClientFactory().buildClient(serverSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		System.out.println("Inicio da Thread");
		waitClients();
		ServerWriterThread w = new ServerWriterThread(clientOne.socket);
		ServerReaderThread r = new ServerReaderThread(clientOne.socket);
		w.start();
		r.start();
		while(true) {
			try {
				Draw.xAxisPlayerOne = this.xAxisPlayerOne;
				Draw.xAxisPlayerTwo = this.xAxisPlayerTwo;
			} catch (Exception e) {}				
		}
	}
}
