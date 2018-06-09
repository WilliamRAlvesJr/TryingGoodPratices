package main.servercommunicator;

import static main.screen.drawer.GameDrawer.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MovementsReader extends Thread {

	private Socket socket;
	private Scanner reader;
	private String msg;
	private String clientName;

	public MovementsReader(Socket socket) {
		System.out.println("Iniciando leitor de servidor...");
		try {
			this.socket = socket;
			reader = new Scanner(socket.getInputStream());

		} catch (IOException e) {
			System.err.println("Erro ao receber dados do servidor: "+e);
		}
		System.out.println("Leitor de servidor iniciado com sucesso");
	}

	@Override
	public void run() {
		clientName = reader.nextLine();

		try {
			while(true) {

				msg = reader.nextLine();
				sendValues(msg);

				sleep(67);
			}

		} catch(InterruptedException e) {
			System.err.println("Impossivel receber dados do servidor: "+e);
		}
	}

	private void sendValues(String msg) throws InterruptedException{

		if(msg.startsWith(clientName)) {
			if(msg.endsWith("LEFT")) {
				setxAxisPlayerOne(getxAxisPlayerOne() - 1);
				setPlayerOneState(6);
			}
			else if(msg.endsWith("RIGHT")){
				setxAxisPlayerOne(getxAxisPlayerOne() + 1);
				setPlayerOneState(6);
			}

			else if(msg.endsWith("PUNCH"))
				setPlayerOneState(3);
		}

		else if(!msg.startsWith(clientName)) {
			if(msg.endsWith("LEFT")){
				setxAxisPlayerTwo(getxAxisPlayerTwo() - 1);
				setPlayerTwoState(6);
			}

			else if(msg.endsWith("RIGHT")) {
				setxAxisPlayerTwo(getxAxisPlayerTwo() + 1);
				setPlayerTwoState(6);
			}

			else if(msg.endsWith("PUNCH"))
				setPlayerTwoState(3);
		}
	}

}