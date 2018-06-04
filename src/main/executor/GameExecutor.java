package main.executor;

import main.servers.server.GameServer;

public class GameExecutor {

	static public void main(String[] args) {

		GameServer gameServer = new GameServer();
		gameServer.start();
		
		MakePlayers playerOne = new MakePlayers();
		MakePlayers playerTwo = new MakePlayers();
		
		playerOne.start();
		playerTwo.start();

	}
}
