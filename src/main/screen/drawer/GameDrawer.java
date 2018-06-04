package main.screen.drawer;

import java.awt.Graphics;
import main.screen.drawer.gameobjects.background.Background;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.drawer.gameobjects.player.players.PlayerOne;
import main.screen.drawer.gameobjects.player.players.PlayerTwo;
import main.screen.gameloop.GameScreen;

public class GameDrawer extends GameScreen {
	
	protected DrawBuilder drawBuilderBG;
	protected DrawBuilder drawBuilderOne;
	protected DrawBuilder drawBuilderTwo;
	
	public static int xAxisPlayerOne;
	public static int xAxisPlayerTwo;
	
	public static int playerOneState;
	public static int playerTwoState;
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		this.drawBuilderBG = new DrawBuilder(graphics, this);
		this.drawBuilderOne = new DrawBuilder(graphics, this);
		this.drawBuilderTwo = new DrawBuilder(graphics, this);

		new Background(drawBuilderBG).drawMeTo(this);

		Player playerOne = new PlayerOne(drawBuilderOne).drawMeTo(this);
		Player playerTwo = new PlayerTwo(drawBuilderTwo).drawMeTo(this);
		
		playerOneState = playerOne.initDraw(xAxisPlayerOne, playerOneState);
		playerTwoState = playerTwo.initDraw(xAxisPlayerTwo, playerTwoState);
		
	}
}
