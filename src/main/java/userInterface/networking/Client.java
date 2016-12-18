package userInterface.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class Client {

	private String hostName;
	private int portNumber;
	private String messageToSend;

	public Client(String hostName, int portNumber, String messageToSend) {
		this.hostName = hostName;
		this.portNumber = portNumber;
		this.messageToSend = messageToSend;
	}

	public void launchConnection() {
		try (
				Socket encryptionSocket =
						new Socket(hostName, portNumber);
				PrintWriter out =
						new PrintWriter(encryptionSocket.getOutputStream(), true)
		) {
			System.out.println();
		} catch (UnknownHostException unknownHostException) {
			System.out.println();
		} catch (IOException ioException) {
			System.out.println();
		}
	}

}