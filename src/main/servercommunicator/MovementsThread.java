package main.servercommunicator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import main.executor.ClientPlayerMaker;
import main.screen.gameloop.GameWindow;

public class MovementsThread extends Thread {

	private boolean playing = true;
	private ClientPlayerMaker player;
	private Socket socket;
	private UIEvents uiEvents;
	private BufferedWriter bw;

	public MovementsThread(GameWindow gameWindow) {
		try {
			this.player = (ClientPlayerMaker) gameWindow;
			this.uiEvents = player.uiEvents;
			socket = new Socket("localhost", 8080);
			
			bw = makeWriter();
			bw.write(socket.getLocalPort()+"\n");
			bw.flush();
			
		} catch (IOException e) {
			System.err.println("Erro ao iniciar receber dados do cliente: "+e);
		}
	}

	@Override
	public void run() {
		while(playing) {
			try{
				if(uiEvents.getxAxisPlayer() > 1){
					
					bw.write(socket.getLocalPort()+"LEFT"+"\n");
					bw.flush();
					
					uiEvents.setxAxisPlayer(uiEvents.getxAxisPlayer()/10);
				} else if (uiEvents.getxAxisPlayer() < -1){
					
					bw.write(socket.getLocalPort()+"RIGHT"+"\n");
					bw.flush();
					
					uiEvents.setxAxisPlayer(uiEvents.getxAxisPlayer()/10);
				} else if (uiEvents.getPunchable()%2 == 1) {

					bw.write(socket.getLocalPort()+"PUNCH"+"\n");
					bw.flush();

					uiEvents.setPunchable(uiEvents.getPunchable() + 1); 
				}
					
				player.repaint();
				sleep(67);
			}catch(InterruptedException | IOException e){
				System.err.println("Impossivel receber dados do cliente: "+e);
			}
		}
	}
	
	private BufferedWriter makeWriter() {
		try {
			OutputStream is = socket.getOutputStream();
			OutputStreamWriter isr = new OutputStreamWriter(is);
			return new BufferedWriter(isr);
		} catch (IOException e) {
			System.err.println("Erro ao iniciar escritor do cliente\n"+e);
		}
		return null;
	}
}