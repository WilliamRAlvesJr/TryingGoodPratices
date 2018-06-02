package main.screen.gameloop;

import javax.swing.JFrame;

import main.screen.drawer.Draw;

class GameWindow extends JFrame {

	boolean playing;
	Draw draw = new Draw();

	GameWindow() {
		super("Trabalho");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(draw);
		pack();
		setVisible(true);
	}
}
