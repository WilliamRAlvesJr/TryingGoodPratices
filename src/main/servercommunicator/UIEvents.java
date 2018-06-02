package main.servercommunicator;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UIEvents {
	private static int xAxisPlayerOne;
	private static int xAxisPlayerTwo;
	private static KeyListener keyListener;
	
	public static KeyListener initKeyListener() {
		return keyListener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					xAxisPlayerOne += 10;
					break;
				case KeyEvent.VK_LEFT:
					xAxisPlayerOne -= 10;
					break;
				}
			}
		};
	}

	public static int getxAxisPlayerOne() {
		return xAxisPlayerOne;
	}
	
	public static int getxAxisPlayerTwo() {
		return xAxisPlayerTwo;
	}

	public static void setxAxisPlayerOne(int xAxisPlayerOne) {
		UIEvents.xAxisPlayerOne = xAxisPlayerOne;
	}
	
	public static void setxAxisPlayerTwo(int xAxisPlayerTwo) {
		UIEvents.xAxisPlayerTwo = xAxisPlayerTwo;
	}
}
