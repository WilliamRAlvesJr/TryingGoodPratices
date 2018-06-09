package main.screen.gameloop;

import main.servercommunicator.MovementsReader;
import main.servercommunicator.MovementsWriter;

public class GameLoop {

	private MovementsWriter movementsWriter;
	private MovementsReader movementsReader;
	private GameWindow gameWindow;

	public GameLoop(GameWindow gameWindow){
		this.gameWindow = gameWindow;
	}

	public void startLoop() {
		try {
			this.movementsWriter = new MovementsWriter(gameWindow);
			movementsWriter.start();
			Thread.sleep(1000);
		} catch (Exception e) {
//			this.movementsReader = new MovementsReader();
//			movementsReader.start();
		}
	}
}