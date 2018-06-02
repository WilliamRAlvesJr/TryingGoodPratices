package main.screen.gameloop;

import main.servercommunicator.MovementsThread;
import main.servercommunicator.UIEvents;

public class GameLoop extends GameWindow {

	public GameLoop() {

		MovementsThread MovementsLoop = new MovementsThread(this);

		MovementsLoop.start();
		addKeyListener(UIEvents.initKeyListener());
	}
}