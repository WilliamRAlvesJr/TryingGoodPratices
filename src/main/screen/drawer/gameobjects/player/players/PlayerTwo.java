package main.screen.drawer.gameobjects.player.players;

import main.screen.drawer.DrawBuilder;
import main.screen.drawer.gameobjects.player.Player;
import main.screen.drawer.imageloader.PlayerImageLoader;
import main.screen.gameloop.GameScreen;

public class PlayerTwo extends Player {

	public PlayerTwo(DrawBuilder drawBuilder) {
		super(drawBuilder, new PlayerImageLoader().getImage());
	}

	@Override
	protected void safePlaceToPlayer(GameScreen target) {
		this.xAxis = target.getWidth()/20; 
		this.yAxis = target.getHeight()/2+target.getHeight()/5;
	}

	@Override
	public void Build(int xAxis, int punch) {
//		if(punch == 1){
//			doPunch();
//		} else {
			this.xAxis += xAxis*(this.xAxis/4);
			this.drawBuilder
			.setXAxis(this.xAxis)
			.Build();
//		}
	}

	@Override
	public Player drawMeTo(GameScreen target) {
		Player player = new PlayerTwo(drawBuilder);
		player.drawTo(target);
		return player;
	}

	@Override
	public void doPunch() {
//		System.out.println("FALCOUN PUNCH");
//		setImage("soco1");
//		this.xAxis += xAxis*(this.xAxis/4);
//		this.drawBuilder
//		.setXAxis(this.xAxis)
//		.Build();
	}
}
