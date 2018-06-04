package main.screen.drawer;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DrawBuilder {

	private int yAxis;
	private int xAxis;
	private int width;
	private int height;
	private Image img;
	private static Graphics graphics;

	public void setGraphics(Graphics graphics) {
		DrawBuilder.graphics = graphics;
	}

	static private JPanel jpanel;

	public DrawBuilder(Graphics graphics, JPanel jpanel) {
		DrawBuilder.graphics = graphics;
		DrawBuilder.jpanel = jpanel;
	}

	public Graphics Build() {
		graphics.drawImage(img, xAxis, yAxis, width, height, jpanel);
		return graphics;
	}

	public DrawBuilder setImg(Image img) {
		this.img = img;
		return this;
	}

	public DrawBuilder setYaxis(int yAxis) {
		this.yAxis = yAxis;
		return this;
	}

	public DrawBuilder setXAxis(int xAxis) {
		this.xAxis = xAxis;
		return this;
	}

	public DrawBuilder setWidth(int width) {
		this.width = width;
		return this;
	}

	public DrawBuilder setHeight(int height) {
		this.height = height;
		return this;
	}
	
	public Graphics getGraphics() {
		return graphics;
	}
}
