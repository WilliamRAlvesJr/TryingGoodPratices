package main.servercommunicator;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UIEvents {

	private int xAxisPlayer;
	private int punchable;

	public KeyListener initKeyListener() {
		return new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					punchable += 10;
					break;
				case KeyEvent.VK_RIGHT:
					xAxisPlayer += 10;
					break;
				case KeyEvent.VK_LEFT:
					xAxisPlayer -= 10;
					break;
				}

			}
		};
	}

	public int getxAxisPlayer() {
		return xAxisPlayer;
	}

	public void setxAxisPlayer(int xAxisPlayer) {
		this.xAxisPlayer = xAxisPlayer;
	}

	public int getPunchable() {
		return punchable;
	}

	public void setPunchable(int punchable) {
		this.punchable = punchable;
	}

}
