package main.screen.drawer.gameobjects.player.players;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.gameloop.GameScreen;

public class PlayerTwo extends Player {

	public PlayerTwo(DrawBuilder drawBuilder) {
		super(drawBuilder);
	}

	@Override
	protected void safePlaceToPlayer(GameScreen target) {
		this.xAxis = target.getWidth()/20;//+target.getWidth();//target.getWidth()/25; 
		this.yAxis = target.getHeight()/2+target.getHeight()/5;
	}

	@Override
	public void movePlayer(int xAxis) {
		this.xAxis += xAxis*(this.xAxis/4);
		this.drawBuilder
		.setXAxis(this.xAxis)
		.Build();
	}
}
