package main.screen.drawer;

import java.awt.Graphics;

import main.screen.drawer.gameobjects.GameObject;
import main.screen.drawer.gameobjects.background.Background;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.drawer.gameobjects.player.players.PlayerOne;
import main.screen.drawer.gameobjects.player.players.PlayerTwo;
import main.screen.gameloop.GameScreen;

public class Draw extends GameScreen {
	
	protected DrawBuilder drawBuilder;
	public static int xAxisPlayerOne;
	public static int xAxisPlayerTwo;
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		this.drawBuilder = new DrawBuilder(graphics, this); 

		drawBackgroud(drawBuilder);

		Player playerOne = drawPlayerOne(drawBuilder);
		Player playerTwo = drawPlayerTwo(drawBuilder);

		playerOne.movePlayer(xAxisPlayerOne);
		playerTwo.movePlayer(xAxisPlayerTwo);
	}
	
	private void drawBackgroud(DrawBuilder drawBuilder){
		GameObject background = new Background(drawBuilder);
		background.drawTo(this);
	}
	
	private Player drawPlayerOne(DrawBuilder drawBuilder){
		Player player = new PlayerOne(drawBuilder);
		player.drawTo(this);
		return player;
	}
	
	private Player drawPlayerTwo(DrawBuilder drawBuilder){
		Player player = new PlayerTwo(drawBuilder);
		player.drawTo(this);
		return player;
	}
	
}
