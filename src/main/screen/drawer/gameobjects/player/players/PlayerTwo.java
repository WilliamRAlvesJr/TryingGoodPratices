package main.screen.drawer.gameobjects.player.players;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.drawer.imageloader.PlayerImageLoader;
import main.screen.gameloop.GameScreen;

public class PlayerTwo extends Player {

	public PlayerTwo(DrawBuilder drawBuilder) {
		super(drawBuilder, new PlayerImageLoader().getImage());
	}

	@Override
	protected void safePlaceToPlayer(GameScreen target) {
		setxAxis(target.getWidth()/20); 
		setyAxis(target.getHeight()/2+target.getHeight()/5);
	}

	@Override
	protected int reason() {
		return (getxAxis()/4);
	}

	@Override
	protected int side() {
		return 1;
	}

	@Override
	protected int sizeAdjust() {
		return 0;
	}
}