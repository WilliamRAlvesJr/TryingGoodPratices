package main.screen.drawer.imageloader;

import java.awt.Image;

public class Imager {
	
	private Image image;
	private String ImagePath;
	private String ImageName;
	
	public Image getImage() {
		return image;
	}
	public Imager setImage(Image image) {
		this.image = image;
		return this;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public Imager setImagePath(String imagePath) {
		ImagePath = imagePath;
		return this;
	}
	public String getImageName() {
		return ImageName;
	}
	public Imager setImageName(String imageName) {
		ImageName = imageName;
		return this;
	}
}
