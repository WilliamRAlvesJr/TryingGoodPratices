package main.screen.drawer.gameobjects.player;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.GameObject;
import main.screen.gameloop.GameScreen;

public abstract class PlayerObject extends GameObject {
	
	public PlayerObject(DrawBuilder drawBuilder) {
		super(drawBuilder);
	}

	@Override
	public abstract void drawTo(GameScreen target);
	
}
