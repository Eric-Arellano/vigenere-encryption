package apps;

import networkingutilities.ConnectionInterfacer;

class NetworkingApp implements Launchable {

	private final ConnectionInterfacer connectionInterfacer;

	NetworkingApp(String[] args) {
		this.connectionInterfacer = new ConnectionInterfacer(args);
	}

	public void launchApp() {
		connectionInterfacer.launchConnection();
		sendMessageIfPresent();
		connectionInterfacer.listenForMessage();
		connectionInterfacer.closeConnection();
	}

	private void sendMessageIfPresent() {
		if (connectionInterfacer.hasMessageToSend()) {
			connectionInterfacer.sendMessage(connectionInterfacer.getMessageToSend());
		}
	}

}
