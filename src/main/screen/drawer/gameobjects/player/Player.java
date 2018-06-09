package main.screen.drawer.gameobjects.player;

import java.awt.Image;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.imageloader.PlayerImageLoader;
import main.screen.gameloop.GameScreen;

public abstract class Player extends PlayerObject {

	private int xAxis;
	private int yAxis;
	private int multplier;
	private int state;
	private static boolean waitYourFriend;
	private PlayerImageLoader playerImages;
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

		getDrawBuilder()
		.setXAxis(xAxis)
		.setYaxis(yAxis)
		.setWidth(target.getWidth()/16)
		.setHeight(target.getHeight()/4);
	}

	@Override
	public int initDraw(int xAxis, int state) {

		this.state = state;
		this.multplier = xAxis;

		if(this.state == 3)
			return doStartPunch();

		if(this.state == 2)
			return doPunch();

		if(this.state == 1)
			return doPunchEnd();


		if(this.state == 6)
			return startWalk();

		if(this.state == 5)
			return walkEnd();

		this.xAxis += xAxis*reason();

		getDrawBuilder()
		.setXAxis(this.xAxis)
		.Build();

		return 0;
	}

	public int startWalk() {

		setImage(playerImages.getImage("anda0"));

		getDrawBuilder()
		.setWidth((side())*target.getWidth()/18)
		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
		.Build(getImage());
		
		state = 5;
		return state;
	}

	public int walkEnd() {

		setImage(playerImages.getImage("anda1"));

		getDrawBuilder()
		.setWidth((side())*target.getWidth()/18)
		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
		.Build(getImage());
	
		state = 0;
		return state;
	}


	public int doStartPunch() {

		setImage(playerImages.getImage("soco0"));

		getDrawBuilder()
		.setWidth((side())*target.getWidth()/13)
		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
		.Build(getImage());

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

	public int doPunch() {

		setImage(playerImages.getImage("soco1"));

		getDrawBuilder()
		.setWidth((side())*target.getWidth()/10)
		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
		.Build(getImage());

		if(waitYourFriend == false){
			waitYourFriend = true;
			return 3;
		}
		else {
			waitYourFriend = false;
			state = 2;
		}

		return state;
	}

	public int doPunchEnd() {

		setImage(playerImages.getImage("soco2"));

		getDrawBuilder()
		.setWidth((side())*target.getWidth()/9)
		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
		.Build(getImage());

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

	protected int xAxisAdjust(){
		return (target.getWidth()/16)*sizeAdjust();
	}

	protected abstract int sizeAdjust();

	protected abstract int side();

	protected abstract int reason();

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public int getMultplier() {
		return multplier;
	}

	public void setMultplier(int multplier) {
		this.multplier = multplier;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public static boolean isWaitYourFriend() {
		return waitYourFriend;
	}

	public static void setWaitYourFriend(boolean waitYourFriend) {
		Player.waitYourFriend = waitYourFriend;
	}

	public PlayerImageLoader getPlayerImages() {
		return playerImages;
	}

	public void setPlayerImages(PlayerImageLoader playerImages) {
		this.playerImages = playerImages;
	}

	public GameScreen getTarget() {
		return target;
	}

	public void setTarget(GameScreen target) {
		this.target = target;
	}

}
