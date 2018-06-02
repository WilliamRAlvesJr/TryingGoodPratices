package main.screen.drawer.gameobjects.player;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.imageloader.PlayerImageLoader;
import main.screen.gameloop.GameScreen;

public abstract class Player extends PlayerObject {

	protected int xAxis;

	protected int yAxis;

	public Player(DrawBuilder drawBuilder) {
		super(drawBuilder);
	}

	protected abstract void safePlaceToPlayer(GameScreen target);
	
	@Override
	protected Image setImage() {
		return new PlayerImageLoader().getImage();
	}

	@Override
	public void drawTo(GameScreen target) {
		safePlaceToPlayer(target);
		this.drawBuilder
		.setXAxis(xAxis)
		.setYaxis(yAxis)
		.setWidth(target.getWidth()/16)
		.setHeight(target.getHeight()/4)
		.Build();
	}
	
	public abstract void movePlayer(int xAxis);
}
