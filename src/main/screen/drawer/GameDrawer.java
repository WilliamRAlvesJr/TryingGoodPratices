package main.screen.drawer;

import java.awt.Graphics;

import main.screen.drawer.gameobjects.GameObject;
import main.screen.drawer.gameobjects.background.Background;
import main.screen.drawer.gameobjects.player.players.PlayerOne;
import main.screen.drawer.gameobjects.player.players.PlayerTwo;
import main.screen.gameloop.GameScreen;

public class GameDrawer extends GameScreen {
	
	protected DrawBuilder drawBuilderBG;
	protected DrawBuilder drawBuilderOne;
	protected DrawBuilder drawBuilderTwo;
	
	GameObject background;
	GameObject playerOne;
	GameObject playerTwo;
	
	public static int scenarioXaxis;
	public static int xAxisPlayerOne;
	public static int xAxisPlayerTwo;
	
	public static int stageNumber;
	public static int playerOneState;
	public static int playerTwoState;
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		drawBuilderBG  = new DrawBuilder(graphics, this);
		drawBuilderOne = new DrawBuilder(graphics, this);
		drawBuilderTwo = new DrawBuilder(graphics, this);

		background = new Background(drawBuilderBG);
		playerOne  = new PlayerOne(drawBuilderOne);
		playerTwo  = new PlayerTwo(drawBuilderTwo);
		
						 background.initDraw(scenarioXaxis, stageNumber);
		playerOneState = playerOne.initDraw(xAxisPlayerOne, playerOneState);
		playerTwoState = playerTwo.initDraw(xAxisPlayerTwo, playerTwoState);
		
		if(xAxisPlayerTwo - xAxisPlayerOne > 67) {
			if(playerTwoState == 3)
				xAxisPlayerOne = 0;
			
			else if(playerOneState == 3)
				xAxisPlayerTwo = 0;
		}
		
	}


	
	
	public static int getxAxisPlayerOne() {
		return xAxisPlayerOne;
	}

	public static void setxAxisPlayerOne(int xAxisPlayerOne) {
		GameDrawer.xAxisPlayerOne = xAxisPlayerOne;
	}

	public static int getxAxisPlayerTwo() {
		return xAxisPlayerTwo;
	}

	public static void setxAxisPlayerTwo(int xAxisPlayerTwo) {
		GameDrawer.xAxisPlayerTwo = xAxisPlayerTwo;
	}

	public static int getPlayerOneState() {
		return playerOneState;
	}

	public static void setPlayerOneState(int playerOneState) {
		GameDrawer.playerOneState = playerOneState;
	}

	public static int getPlayerTwoState() {
		return playerTwoState;
	}

	public static void setPlayerTwoState(int playerTwoState) {
		GameDrawer.playerTwoState = playerTwoState;
	}

}
