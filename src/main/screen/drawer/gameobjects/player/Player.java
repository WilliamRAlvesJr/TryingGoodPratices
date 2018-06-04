package main.screen.drawer.gameobjects.player;

import java.awt.Image;
import main.screen.drawer.DrawBuilder;
import main.screen.drawer.imageloader.PlayerImageLoader;
import main.screen.gameloop.GameScreen;

public abstract class Player extends PlayerObject {

	protected int xAxis;
	protected int yAxis;

	public Player(DrawBuilder drawBuilder, Image image) {
		super(drawBuilder, image);
	}

	public abstract void doPunch();
	
	protected abstract void safePlaceToPlayer(GameScreen target);

	@Override
	public void drawTo(GameScreen target) {
		safePlaceToPlayer(target);
		this.drawBuilder
		.setXAxis(xAxis)
		.setYaxis(yAxis)
		.setWidth(target.getWidth()/16)
		.setHeight(target.getHeight()/4);
	}
	
	public abstract void Build(int xAxis, int punch);
	
}
