package main.screen.drawer.imageloader;


public class PlayerImageLoader extends ImageLoaderTemplate {

	private final static String STOPPED = "resources/parado.gif";
	private final static String START_PUNCH = "resources/soco0.gif";
	private final static String PUNCH = "resources/soco1.gif";
	private final static String END_PUNCH = "resources/soco2.gif";
	private final static String START_WALK = "resources/anda0.gif";
	private final static String END_WALK = "resources/anda1.gif";
	
	public PlayerImageLoader() {
		super(STOPPED, START_PUNCH, PUNCH, END_PUNCH, START_WALK, END_WALK);
	}
}
