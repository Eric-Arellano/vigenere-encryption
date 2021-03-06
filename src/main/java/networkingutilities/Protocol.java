package networkingutilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static networkingutilities.Connection.ConnectionType;
import static networkingutilities.LocalHostNameUtility.getLocalHostName;
import static networkingutilities.LocalHostNameUtility.getLocalIPAddress;

class Protocol {

	private final ConnectionType connectionType;

	Protocol(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	void notifyOpeningConnection() {
		String openingMessage = String.format("Opening %s connection on %s (%s)...",
				connectionType.toString(), getLocalHostName(), getLocalIPAddress());
		System.out.println(openingMessage);
	}

	void sendMessage(Socket socket, String messageToSend) throws IOException {
		try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
			if (messageToSend != null) {
				notifySending();
				writer.println(messageToSend);
				notifySent();
			}
		}
	}

	void readMessage(Socket socket) throws IOException {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()))) {
			String receivedMessage = reader.readLine();
			if (receivedMessage != null) {
				notifyReceived();
				System.out.println(receivedMessage);
			}
		}
	}

	void closeConnection() {
		String closingMessage = String.format("\nClosing %s's connection. Restart app if you'd like " +
				"to run it again.", connectionType.toString());
		System.out.println(closingMessage);
		System.exit(1);
	}

	private void notifySending() {
		String sendingNotification = String.format("\nSending to %s...", ConnectionType
				.getOtherConnectionType(connectionType));
		System.out.println(sendingNotification);
	}

	private void notifySent() {
		String sentNotification = String.format("\nMessage sent! Check the %s.", ConnectionType
				.getOtherConnectionType(connectionType));
		System.out.println(sentNotification);
	}

	private void notifyReceived() {
		System.out.println("\nMessage received!\n");
	}

}
