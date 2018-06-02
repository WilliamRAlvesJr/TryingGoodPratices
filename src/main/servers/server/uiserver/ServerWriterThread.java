package main.servers.server.uiserver;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerWriterThread extends Thread {
	
	private static Socket socket;
	
	public ServerWriterThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {	
		System.out.println("Inicio da Reader");
		while(true) {
			try {
				OutputStream is = socket.getOutputStream();
				OutputStreamWriter isr = new OutputStreamWriter(is);
				BufferedWriter bw = new BufferedWriter(isr);
				bw.write(" String do server \n");
				bw.flush();
				
			} catch (Exception e) {}				
		}
	}
}
