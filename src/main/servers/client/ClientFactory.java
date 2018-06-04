package main.servers.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class ClientFactory {

	Client clientPlayer;

	public ClientFactory(){
		clientPlayer = new Client();
	}

	public Client buildClient(ServerSocket serverSocket) {
		try {
			clientPlayer.socket = serverSocket.accept();		
			initiateReader();
			initiateWriter();
			System.out.println("Um novo jogador entrou no servidor");
			return clientPlayer;
		} catch(IOException e) {
			System.err.println("Erro ao construir cliente: "+e);
			System.exit(0);
		}
		return null;
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
