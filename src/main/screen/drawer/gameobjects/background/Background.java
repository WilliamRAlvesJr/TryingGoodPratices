package main.screen.drawer.gameobjects.background;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.GameObject;
import main.screen.drawer.imageloader.BackgroundImageLoader;
import main.screen.gameloop.GameScreen;

public class Background extends GameObject {

	public Background(DrawBuilder drawBuilder) {
		super(drawBuilder, new BackgroundImageLoader().getImage());
	}

	protected Image setImage(){
		return new BackgroundImageLoader().getImage();
	}

	@Override
	public GameObject drawMeTo(GameScreen target) {
		GameObject background = new Background(drawBuilder);
		background.drawTo(target);
		return background;
	}
}
