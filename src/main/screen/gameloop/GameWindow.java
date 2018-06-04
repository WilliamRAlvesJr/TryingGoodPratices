package main.screen.gameloop;

import javax.swing.JFrame;

import main.screen.drawer.GameDrawer;

public class GameWindow extends JFrame {

	GameDrawer draw = new GameDrawer();

	public GameWindow() {
		super("Trabalho");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(draw);
		pack();
		setVisible(true);
	}
}
