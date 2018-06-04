package main.screen.drawer.gameobjects.player.players;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.drawer.imageloader.PlayerImageLoader;
import main.screen.gameloop.GameScreen;

public class PlayerOne extends Player {

	public PlayerOne(DrawBuilder drawBuilder) {
		super(drawBuilder, new PlayerImageLoader().getImage());
	}

	@Override
	protected void safePlaceToPlayer(GameScreen target) {
		this.xAxis = target.getWidth()-target.getWidth()/8; 
		this.yAxis = target.getHeight()/2+target.getHeight()/5;
	}
	
	@Override
	protected int reason() {
		return (this.xAxis/80);
	}

	@Override
	public Player drawMeTo(GameScreen target) {
		Player player = new PlayerOne(drawBuilder);
		player.drawTo(target);
		return player;
	}

	@Override
	protected int side() {
		return (-1);
	}

	@Override
	protected int sizeAdjust() {
		return 1;
	}
}