package main.screen.drawer.gameobjects.background;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.GameObject;
import main.screen.drawer.imageloader.BackgroundImageLoader;

public class Background extends GameObject {

	public Background(DrawBuilder drawBuilder) {
		super(drawBuilder, new BackgroundImageLoader().getImage());
	}

	protected Image setImage(){
		return new BackgroundImageLoader().getImage();
	}
	
	@Override
	public int initDraw(int xAxis, int stage){
		/* TODO possível implementação: escolha de cenários */
		/* TODO possível implementação: parallax nos cenários */
		getDrawBuilder()
		.Build();
		
		return 0;
	}

}
