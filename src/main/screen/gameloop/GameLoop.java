package main.screen.gameloop;

import main.servercommunicator.MovementsThread;

public class GameLoop {

	private MovementsThread MovementsLoop;
	private GameWindow gameWindow;

	public GameLoop(GameWindow gameWindow){
		this.gameWindow = gameWindow;
	}
	
	public void startLoop() {
		this.MovementsLoop = new MovementsThread(gameWindow);
		MovementsLoop.start();
	}
}