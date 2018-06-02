package main.screen.drawer.gameobjects.player.players;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.gameloop.GameScreen;

public class PlayerOne extends Player {

	public PlayerOne(DrawBuilder drawBuilder) {
		super(drawBuilder);
	}

	@Override
	protected void safePlaceToPlayer(GameScreen target) {
		this.xAxis = target.getWidth()-target.getWidth()/8; 
		this.yAxis = target.getHeight()/2+target.getHeight()/5;
	}
	
	@Override
	public void movePlayer(int xAxis) {
		this.xAxis += xAxis*(this.xAxis/80);
		this.drawBuilder
		.setXAxis(this.xAxis)
		.Build();
	}
}