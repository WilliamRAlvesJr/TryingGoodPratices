package main.screen.drawer.gameobjects;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.DrawMe;
import main.screen.gameloop.GameScreen;

public abstract class GameObject implements DrawMe {
	
	protected Image image;
	protected DrawBuilder drawBuilder;

	public GameObject(DrawBuilder drawBuilder, Image image) {
		this.image = image;
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
}
