package main;
import java.io.IOException;
import java.net.*;


class TCPServer{    
	
	/*public static void main(String argv[]) throws Exception*/
	public void run() throws IOException {

		//Creates a socket to send and recieve messages in port 8888
		@SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(8888);
		
		//While something is true
		while(true){
			//Creates a socket and a buffered reader which recieves some sort of input from somewhere around the internet!
			//GUILogic gui = new GUILogic();
			Socket connectionSocket = welcomeSocket.accept();
			ClientWorker client= new ClientWorker(connectionSocket);
			Thread thread = new Thread(client, "client");
			thread.start();
		}
	}
}