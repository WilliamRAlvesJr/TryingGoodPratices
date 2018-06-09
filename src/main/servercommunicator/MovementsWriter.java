package main.servercommunicator;

import static main.servercommunicator.ServerSocket.getSocket;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import main.executor.ClientPlayerMaker;
import main.screen.gameloop.GameWindow;

public class MovementsWriter extends Thread {

	private boolean playing = true;
	private ClientPlayerMaker player;
	private Socket socket;
	private UIEvents uiEvents;
	private PrintStream pstream;

	public MovementsWriter(GameWindow gameWindow) {
		try {
			socket = getSocket();
			this.player = (ClientPlayerMaker) gameWindow;
			this.uiEvents = player.uiEvents;

			pstream = new PrintStream(socket.getOutputStream());
			pstream.println(socket.getLocalPort());
			
			new MovementsReader(socket).start();

		} catch (IOException e) {
			JOptionPane.showMessageDialog
			(null, "O servidor não foi iniciado\n\n"+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println("Erro ao receber dados do servidor: "+e);
			System.exit(0);
		}
	}

	@Override
	public void run() {
		try {
			while(playing) {

				if(uiEvents.getxAxisPlayer() > 1){

					pstream.println(socket.getLocalPort()+"RIGHT");
					uiEvents.setxAxisPlayer(uiEvents.getxAxisPlayer()/10);
				} else if (uiEvents.getxAxisPlayer() < -1){

					pstream.println(socket.getLocalPort()+"LEFT");
					uiEvents.setxAxisPlayer(uiEvents.getxAxisPlayer()/10);
				} else if (uiEvents.getPunchable() > 1) {

					pstream.println(socket.getLocalPort()+"PUNCH");
					uiEvents.setPunchable(uiEvents.getPunchable()/10); 
				}
				player.repaint();
				sleep(67);
			}
		}catch(InterruptedException e){
			System.err.println("Impossivel enviar dados para o servidor: "+e);
		}
	}
}