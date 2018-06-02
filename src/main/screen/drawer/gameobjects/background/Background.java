package main.screen.drawer.gameobjects.background;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.GameObject;
import main.screen.drawer.imageloader.BackgroundImageLoader;

public class Background extends GameObject {
	
	public Background(DrawBuilder drawBuilder) {
		super(drawBuilder);
	}

	protected Image setImage(){
		return new BackgroundImageLoader().getImage();
	}
}
