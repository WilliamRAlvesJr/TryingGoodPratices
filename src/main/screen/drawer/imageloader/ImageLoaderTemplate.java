package main.screen.drawer.imageloader;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class ImageLoaderTemplate {

	public List<Imager> imagers = new ArrayList<>();

	public Image getImage() {
		return imagers.get(0).getImage();
	}

	public Image getImage(String state) {
		try{
			for (Imager imager : imagers) {
				if(state.equals(imager.getImageName()))
					return imager.getImage(); 
			}
			throw new IOException();
		} catch(IOException e) {
			System.err.println("Não foi possível encontrar a imagem com o nome: "+state+"\n"+e);
			System.exit(0);
		}
		return null;
	}

	protected ImageLoaderTemplate(String... imagesPath) {
		for (String imagePath : imagesPath) {
			imagers.add(new Imager()
			.setImage(LoadImage(imagePath))
			.setImageName(makeImageName(imagePath))
			.setImagePath(imagePath));
		}
	}

	private String makeImageName(String imagePath) {
		String imageName = imagePath.split("\\.")[0];
		imageName = imageName.split("/")[1];
		return imageName;
	}

	private Image LoadImage(String imagePath){
		try {
			return ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.err.println("Erro ao carregar imagem: " + e);
			e.printStackTrace();
		}
		return null;
	}
}
