package main.servers.server;

import java.io.IOException;
import java.net.ServerSocket;

import main.servers.client.Client;
import main.servers.client.ClientFactory;
import main.servers.server.uiserver.ServerReaderThread;
import main.servers.server.uiserver.ServerWriterThread;

public class GameServer extends Thread {

	private static int WAIT_SERVER_START = 1000;
	private static int PORT = 8080;

	private static Client clientOne;
	private static Client clientTwo;
	private static ServerSocket serverSocket;
	public static int xAxisPlayerOne;
	public static int xAxisPlayerTwo;
	private static ServerReaderThread readerTwo;
	private static ServerWriterThread writerTwo;
	private static ServerReaderThread readerOne;
	private static ServerWriterThread writerOne;

	public GameServer() {
		try {
			System.out.println("Iniciando servidor...");
			serverSocket = new ServerSocket(PORT);
			Thread.sleep(WAIT_SERVER_START);
			System.out.println("Servidor iniciado com sucesso!!!");

		} catch (InterruptedException | IOException e) {
			System.err.println("Erro ao iniciar o servidor: "+ e);
		}
	}

	@Override
	public void run(){
		waitClients();
		initReadersAndWriters();
		startClientsInteraction();
	}

	private void waitClients(){
		System.out.println("Esperando clientes...");
		clientOne = new ClientFactory().buildClient(serverSocket);
		clientTwo = new ClientFactory().buildClient(serverSocket);
		System.out.println("Clientes iniciados com sucesso!!!");
	}

	private void initReadersAndWriters(){ 
		System.out.println("preparando Comunicadores...");
		writerOne = new ServerWriterThread(clientOne);
		readerOne = new ServerReaderThread(clientOne);
		writerTwo = new ServerWriterThread(clientTwo);
		readerTwo = new ServerReaderThread(clientTwo);
		System.out.println("Comunicadores preparados");
	}

	private void startClientsInteraction(){
		System.out.println("Iniciando comunicadores...");
		writerOne.start();
		readerOne.start();
		writerTwo.start();
		readerTwo.start();
		System.out.println("Comunicadores iniciados");
	}
	
	public static int getxAxisPlayerOne() {
		return xAxisPlayerOne;
	}

	public static void setxAxisPlayerOne(int xAxisPlayerOne) {
		GameServer.xAxisPlayerOne = xAxisPlayerOne;
	}

	public static int getxAxisPlayerTwo() {
		return xAxisPlayerTwo;
	}

	public static void setxAxisPlayerTwo(int xAxisPlayerTwo) {
		GameServer.xAxisPlayerTwo = xAxisPlayerTwo;
	}
}
