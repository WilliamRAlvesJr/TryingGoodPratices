package main.screen.drawer.imageloader;


public class PlayerImageLoader extends ImageLoaderTemplate {

	private final static String STOPPED = "resources/parado.gif"; 
	private final static String START_PUNCH = "resources/soco1.gif";
	private final static String END_PUNCH = "resources/soco2.gif";
	
	public PlayerImageLoader() {
		super(STOPPED, START_PUNCH, END_PUNCH);
	}
}
