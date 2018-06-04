package main.screen.drawer;

import java.awt.Graphics;

import main.screen.drawer.gameobjects.background.Background;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.drawer.gameobjects.player.players.PlayerOne;
import main.screen.drawer.gameobjects.player.players.PlayerTwo;
import main.screen.gameloop.GameScreen;

public class GameDrawer extends GameScreen {
	
	protected DrawBuilder drawBuilder;
	
	public static int xAxisPlayerOne;
	public static int xAxisPlayerTwo;
	
	public static int punchPlayerOne;
	public static int punchPlayerTwo;
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		this.drawBuilder = new DrawBuilder(graphics, this); 
		
		new Background(drawBuilder).drawMeTo(this);

		Player playerOne = new PlayerOne(drawBuilder).drawMeTo(this);
		Player playerTwo = new PlayerTwo(drawBuilder).drawMeTo(this);

		playerOne.Build(xAxisPlayerOne, punchPlayerOne);
		playerTwo.Build(xAxisPlayerTwo, punchPlayerTwo);
			
	}
}
