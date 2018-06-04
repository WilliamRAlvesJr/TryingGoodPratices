package main.executor;

import main.screen.gameloop.GameLoop;
import main.screen.gameloop.GameWindow;
import main.servercommunicator.UIEvents;

public class ClientPlayerMaker extends GameWindow {

	private GameLoop gameLoop;
	public UIEvents uiEvents;
	
	public ClientPlayerMaker() {
		this.gameLoop = new GameLoop(this);
		this.uiEvents = new UIEvents();
		gameLoop.startLoop();

		addKeyListener(uiEvents.initKeyListener());
	}
}
