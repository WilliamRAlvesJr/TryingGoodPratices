package main.servercommunicator;

import static main.servercommunicator.UIEvents.getxAxisPlayerOne;
import static main.servercommunicator.UIEvents.setxAxisPlayerOne;

import java.io.IOException;
import java.net.Socket;

import main.screen.gameloop.GameLoop;
import main.servers.server.GameServer;

public class MovementsThread extends Thread {

	private Socket socket; 
	private boolean playing = true;
	private GameLoop gameLoop;

	public MovementsThread(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
		try {
			socket = new Socket("localhost", 8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(playing) {
			if(getxAxisPlayerOne() > 1){
				setxAxisPlayerOne(getxAxisPlayerOne()/10);
				GameServer.xAxisPlayerOne += 1;
			} else if (getxAxisPlayerOne() < -1){
				setxAxisPlayerOne(getxAxisPlayerOne()/10);
				GameServer.xAxisPlayerOne -= 1;
			}
			gameLoop.repaint();
		}
	}
}