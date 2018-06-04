package main.servers.server.uiserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import main.servers.client.Client;

public class ServerWriterThread extends Thread {
	
	private Client client;
	
	public ServerWriterThread(Client client){
		this.client = client;
	}
	
	@Override
	public void run() {	
		while(true) {
			try {
				OutputStream is = client.socket.getOutputStream();
				OutputStreamWriter isr = new OutputStreamWriter(is);
				BufferedWriter bw = new BufferedWriter(isr);
				String msg = "Mensagem escrita pelo servidor";
				bw.write(msg);
				bw.flush();
				sleep(67);
			} catch (InterruptedException | IOException e) {
				System.err.println("Impossivel escrever mensagem no cliente\n"+e);
			}			
		}
	}
}
