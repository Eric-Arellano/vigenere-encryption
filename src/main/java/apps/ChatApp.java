package apps;

import apps.networkingutilities.ConnectionInterfacer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ChatApp implements Launchable {

	private final ConnectionInterfacer connectionInterfacer;
	private volatile boolean keepRunning;
	private volatile boolean messageReceived;

	ChatApp(String[] args) {
		this.connectionInterfacer = new ConnectionInterfacer(args);
		this.keepRunning = true;
		this.messageReceived = false;
	}

	public void launchApp() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Runnable networkListener = createNetworkListener();
		Runnable commandLineInterface = createCommandLineInterface(executor);

		connectionInterfacer.launchConnection();
		executor.submit(networkListener);
		executor.submit(commandLineInterface);
	}

	private synchronized void closeApp() {
		keepRunning = false;
		notifyAll();
		connectionInterfacer.closeConnection();
	}

	private Runnable createNetworkListener() {
		return () -> {
			while (keepRunning) {
				connectionInterfacer.listenForMessage();
				messageReceived = true;
				notifyAll();
			}
		};
	}

	private Runnable createCommandLineInterface(ExecutorService executor) {
		return () -> {
			closeApp();
			// TODO: ask to:
			// 1) send message that will be encrypted upon arrival
			// 2) wait until receiving encrypted message that can then be decrypted locally with key
			// (never send key)
		};
	}

	private synchronized void receiveMessage() {
		if (messageReceived) {
			askToDecryptReceivedMessage();
			String encryptedMessage = askForMessage();
			String key = askForKey();
			decryptMessage(encryptedMessage, key);
			messageReceived = false;
		}
	}

	private void askToDecryptReceivedMessage() {

	}

	private String askForMessage() {
		return null;
	}

	private String askForKey() {
		return null;
	}

	private void decryptMessage(String encryptedMessage, String key) {

	}

	private synchronized void sendMessage(String message) {
		connectionInterfacer.sendMessage();
	}



}
