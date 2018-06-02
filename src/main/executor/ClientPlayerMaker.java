package main.executor;

import main.screen.gameloop.GameLoop;

public class ClientPlayerMaker extends Thread {
	ClientPlayerMaker(){
		new GameLoop();
	}
}
