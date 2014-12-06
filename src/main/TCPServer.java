package main;

import java.io.IOException;
import java.net.*;

/**
 * TCP Server class
 * 
 * @author andersliltorp
 *
 */
class TCPServer {

	/**
	 * run method which sends and receives data to/from the client
	 * 
	 * @throws IOException
	 */
	public void run() throws IOException {

		// Creates a socket to send and recieve messages in port 8888
		@SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(8888);

		// Keep running until server is shut down.
		while (true) {
			// Creates a socket which listens for a connection, then accepts it
			Socket connectionSocket = welcomeSocket.accept();

			// Creates a clientworker with the connection
			ClientWorker client = new ClientWorker(connectionSocket);

			// Create a new thread for the clientworker
			Thread thread = new Thread(client, "client");

			// Starts the thread
			thread.start();
		}
	}
}