package main.screen.drawer.gameobjects.player;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.imageloader.PlayerImageLoader;
import main.screen.gameloop.GameScreen;

public abstract class Player extends PlayerObject {

	protected int xAxis;
	protected int yAxis;
	protected int multplier;
	protected int state;
	protected static boolean waitYourFriend;
	protected PlayerImageLoader playerImages;
	private GameScreen target;
	

	public Player(DrawBuilder drawBuilder, Image image) {
		super(drawBuilder, image);
		playerImages = new PlayerImageLoader();
	}

	protected abstract void safePlaceToPlayer(GameScreen target);

	@Override
	public void drawTo(GameScreen target) {
		this.target = target;
		safePlaceToPlayer(target);
		this.drawBuilder
		.setXAxis(xAxis)
		.setYaxis(yAxis)
		.setWidth(target.getWidth()/16)
		.setHeight(target.getHeight()/4);
	}

	public int initDraw(int xAxis, int state) {
		this.state = state;
		this.multplier = xAxis;
		
		if(this.state == 2)
			return doPunch();
		
		if(this.state == 1)
			return doPunchEnd();
		
		this.xAxis += xAxis*reason();
		this.drawBuilder
		.setXAxis(this.xAxis)
		.Build();
		

		
		return 0;
	}

	public int doPunch() {

		image = playerImages.getImage("soco1");

		drawBuilder
		.setWidth((side())*target.getWidth()/10)
		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
		.Build(image);

		if(waitYourFriend == false){
			waitYourFriend = true;
			return 2;
		}
		else {
			waitYourFriend = false;
			state = 1;
		}
		
		return state;
	}
	
	public int doPunchEnd() {

		image = playerImages.getImage("soco2");

		drawBuilder
		.setWidth((side())*target.getWidth()/10)
		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
		.Build(image);

		if(waitYourFriend == false){
			waitYourFriend = true;
			return 1;
		}
		else {
			waitYourFriend = false;
			state = 0;
		}
		
		return state;
	}

	protected int xAxisAdjust(){
		return (target.getWidth()/16)*sizeAdjust();
	}

	protected abstract int sizeAdjust();

	protected abstract int side();

	protected abstract int reason();

}
