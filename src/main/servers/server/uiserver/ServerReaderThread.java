package main.servers.server.uiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.screen.drawer.GameDrawer;
import main.servers.client.Client;

public class ServerReaderThread extends Thread {

	private Client client;
	private static String clientOneName;
	private static String clientTwoName;

	public ServerReaderThread(Client client){
		try {
			this.client = client;

			client.br = makeReader();
			String clientName = client.br.readLine();
			if(clientOneName == null)
				clientOneName = clientName;
			else
				clientTwoName = clientName;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {	
		while(true) {
			try {
				String msg = client.br.readLine();
				if(msg.startsWith(clientOneName)) {
					if(msg.endsWith("RIGHT"))
						GameDrawer.xAxisPlayerOne -= 1;

					else if(msg.endsWith("LEFT"))
						GameDrawer.xAxisPlayerOne += 1;
					
					else if(msg.endsWith("PUNCH")){
						GameDrawer.punchPlayerOne += 1;
						sleep(67);
						GameDrawer.punchPlayerOne -= 1;
					}
				}
				else if(msg.startsWith(clientTwoName)) {
					if(msg.endsWith("LEFT"))
						GameDrawer.xAxisPlayerTwo += 1;

					else if(msg.endsWith("RIGHT"))
						GameDrawer.xAxisPlayerTwo -= 1;
					
					else if(msg.endsWith("PUNCH")){
						GameDrawer.punchPlayerTwo += 1;
						GameDrawer.punchPlayerTwo -= 1;
					}
				}

				sleep(67);
			} catch (InterruptedException | IOException e) {
				System.err.println("Erro ao fazer comunicação com clientes\n"+e);
			}				
		}
	}

	private BufferedReader makeReader() {
		try {

			InputStream is = client.socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			return new BufferedReader(isr);
		} catch (IOException e) {
			System.err.println("Impossivel ler mensagem do cliente: "+e);
		}
		return null;
	}
}
