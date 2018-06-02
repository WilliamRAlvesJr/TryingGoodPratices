package main.screen.drawer.gameobjects;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.gameloop.GameScreen;

public abstract class GameObject {
	Image image;
	protected DrawBuilder drawBuilder;

	public GameObject(DrawBuilder drawBuilder) {
		this.image = setImage();
		this.drawBuilder = drawBuilder;
		drawBuilder.setImg(image)
		.setXAxis(0)
		.setYaxis(0);
	}

	public void drawTo(GameScreen target){
		this.drawBuilder
		.setWidth(target.getWidth())
		.setHeight(target.getHeight())
		.Build();
	}

	protected abstract Image setImage();
}
