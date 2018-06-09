package main.screen.drawer.gameobjects;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.gameloop.GameScreen;

public abstract class GameObject {
	
	private Image image;
	private DrawBuilder drawBuilder;

	public GameObject(DrawBuilder drawBuilder, Image image) {
		this.image = image;
		
		this.drawBuilder = drawBuilder;
		drawBuilder.setImg(image)
		.setXAxis(0)
		.setYaxis(0);
		
		drawTo(getDrawBuilder().getGameScreen());
	}
	
	public void drawTo(GameScreen target){

		this.drawBuilder
		.setWidth(target.getWidth())
		.setHeight(target.getHeight());
		
	}
		
	public abstract int initDraw(int xAxis, int optional); 
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public DrawBuilder getDrawBuilder() {
		return drawBuilder;
	}

	public void setDrawBuilder(DrawBuilder drawBuilder) {
		this.drawBuilder = drawBuilder;
	}
	
}
