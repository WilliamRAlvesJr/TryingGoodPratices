package main.servers.server.uiserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerReaderThread extends Thread {
	
	private static Socket socket;
	
	public ServerReaderThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {	
		System.out.println("Inicio do writer");
		while(true) {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String msg = br.readLine();
				System.out.println("Mensagem enviada do cliente para o servidor: "+msg);
				
			} catch (Exception e) {}				
		}
	}
}
