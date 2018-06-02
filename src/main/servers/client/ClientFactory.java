package main.servers.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ClientFactory {
	
	Client clientPlayer;
	
	public ClientFactory(){
		clientPlayer = new Client();
	}
	
	public Client buildClient(ServerSocket serverSocket) throws IOException {
		clientPlayer.socket = serverSocket.accept();		
		initiateReader();
		initiateWriter();
		System.out.println("New player connected to server");
		return clientPlayer;
	}
	
	private void initiateReader() throws IOException {
		InputStream is = clientPlayer.socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		clientPlayer.br = br;
	}

	private void initiateWriter() throws IOException {
		OutputStream is = clientPlayer.socket.getOutputStream();
		OutputStreamWriter isr = new OutputStreamWriter(is);
		BufferedWriter bw = new BufferedWriter(isr);
		clientPlayer.bw = bw;
	}
}
