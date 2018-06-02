package main.executor;

import main.servers.server.GameServer;

public class GameExecutor {

	static public void main(String[] args) {
		try {
			GameServer gameServer = new GameServer();
			gameServer.start();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new ClientPlayerMaker();
		new ClientPlayerMaker();

	}
}
