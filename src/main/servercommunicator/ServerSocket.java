package main.servercommunicator;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public abstract class ServerSocket {
	
	public static Socket getSocket() throws IOException{
		return new Socket("localhost", 8080);
	}
}
