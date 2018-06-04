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
	private Graphics graphics;
	private JPanel jpanel;
	
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	public DrawBuilder(Graphics graphics, JPanel jpanel) {
		this.graphics = graphics;
		this.jpanel = jpanel;
	}

	public Graphics Build() {
		graphics.drawImage(img, xAxis, yAxis, width, height, jpanel);
		return graphics;
	}
	
	public Graphics Build(Image img) {
		this.img = img;
		return Build();
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
