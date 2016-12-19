package userInterface.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static userInterface.networking.LocalHostNameUtility.getLocalHostName;
import static userInterface.networking.LocalHostNameUtility.getLocalIPAddress;

class Protocol {

	private ConnectionType connectionType;

	Protocol(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	void notifyOpeningConnection() {
		String openingMessage = String.format("Opening %s connection on %s (%s)...",
				connectionType.toString(), getLocalHostName(), getLocalIPAddress());
		System.out.println(openingMessage);
	}

	void sendMessage(PrintWriter writer, String messageToSend) throws IOException {
		notifySending();
		writer.println(messageToSend);
		notifySent();
	}

	private void notifySending() {
		String sendingNotification = String.format("Sending to %s...", ConnectionType
				.getOtherConnectionType(connectionType));
		System.out.println(sendingNotification);
	}

	private void notifySent() {
		String sentNotification = String.format("\nMessage sent! Check the %s.", ConnectionType
				.getOtherConnectionType(connectionType));
		System.out.println(sentNotification);
	}

	void readMessage(BufferedReader reader) throws IOException {
		String receivedMessage = reader.readLine();
		notifyReceived();
		System.out.println(receivedMessage);
	}

	private void notifyReceived() {
		System.out.println("Message received!\n");
	}

	void closeConnection() {
		String closingMessage = String.format("\nClosing %s's connection. Restart app if you'd like " +
				"to run it again.", connectionType.toString());
		System.out.println(closingMessage);
		System.exit(1);
	}

	void handleIOException() {
		String exceptionMessage = String.format("IO Exception from %s.", connectionType.toString());
		System.out.println(exceptionMessage);
		System.exit(1);
	}

	enum ConnectionType {
		CLIENT, SERVER;

		@Override
		public String toString() {
			return name().toLowerCase();
		}

		static String getOtherConnectionType(ConnectionType currentType) {
			switch (currentType) {
				case CLIENT:
					return SERVER.toString();
				case SERVER:
					return CLIENT.toString();
				default:
					return null;
			}
		}

	}
}
