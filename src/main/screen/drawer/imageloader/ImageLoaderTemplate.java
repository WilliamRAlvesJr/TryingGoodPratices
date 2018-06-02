package main.screen.drawer.imageloader;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoaderTemplate {

	protected Image image;
	protected String imagePath;

	public Image getImage() {
		return image;
	}

	protected ImageLoaderTemplate() {
		imagePath = setImagePath(); 
		image = LoadImage();
	}
	
	protected abstract String setImagePath();

	protected Image LoadImage(){
		try {
			return ImageIO.read(new File(this.imagePath));
		} catch (IOException e) {
			System.err.println("Erro ao carregar imagem: " + e);
			e.printStackTrace();
		}
		return null;
	}
}
