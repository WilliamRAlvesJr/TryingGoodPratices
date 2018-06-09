//package main.screen.drawer.gameobjects.player;
//
//import static main.screen.drawer.gameobjects.player.Player.*;
//import java.awt.Image;
//import main.screen.drawer.DrawBuilder;
//import main.screen.drawer.imageloader.PlayerImageLoader;
//
//public class Puncher {
//
//	private Player player;
//	
//	public Puncher(Player player) {
//		this.player = player;
//	}
//
//	public int punch() {
//		if(player.getState() == 3)
//			return doStartPunch();
//		
//		if(player.getState() == 2)
//			return doPunch();
//		
//		if(player.getState() == 1)
//			return doPunchEnd();
//		
//		return 0;
//	}
//	
//	public int doStartPunch() {
//		
//		player.setImage(get("soco0"));
//
//		player.drawBuilder
//		.setWidth((player.side())*player.target.getWidth()/13)
//		.setXAxis(player.xAxis + player.multplier*player.reason() + player.xAxisAdjust())
//		.Build(player.image);
//
//		if(player.waitYourFriend == false){
//			player.waitYourFriend = true;
//			return 1;
//		}
//		else {
//			player.waitYourFriend = false;
//			player.state = 0;
//		}
//		
//		return state;
//	}
//
//	public int doPunch() {
//
//		image = playerImages.getImage("soco1");
//
//		drawBuilder
//		.setWidth((side())*target.getWidth()/10)
//		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
//		.Build(image);
//
//		if(waitYourFriend == false){
//			waitYourFriend = true;
//			return 3;
//		}
//		else {
//			waitYourFriend = false;
//			state = 2;
//		}
//		
//		return state;
//	}
//	
//	public int doPunchEnd() {
//
//		image = playerImages.getImage("soco2");
//
//		drawBuilder
//		.setWidth((side())*target.getWidth()/9)
//		.setXAxis(xAxis + multplier*reason() + xAxisAdjust())
//		.Build(image);
//
//		if(waitYourFriend == false){
//			waitYourFriend = true;
//			return 2;
//		}
//		else {
//			waitYourFriend = false;
//			state = 1;
//		}
//		
//		return state;
//	}
//}
