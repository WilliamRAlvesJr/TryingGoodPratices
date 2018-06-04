package main.executor;

public class MakePlayers extends Thread {
	
	ClientPlayerMaker clientPlayerMaker;
	
	@Override
	public void run() {
		clientPlayerMaker = new ClientPlayerMaker();
	}
}
