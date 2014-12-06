package main;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientWorker implements  Runnable{
	private Socket connectionSocketConected;
	private GiantSwitch GS = new GiantSwitch();
	private encryption cryp = new encryption();
	
	ClientWorker(Socket connectionSocket){
		this.connectionSocketConected = connectionSocket;
	}
	
	public void run(){
		try{
			byte[] b = new byte[500000];
			connectionSocketConected.getInputStream().read(b);
			
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());
			//Sets client sentence equals input from client		
			String ny = cryp.decrypt(b);
			String answer = GS.GiantSwitchMethod(ny);
			//Sends message back to client
			byte[] input = answer.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			outToClient.write(encrypted);
			outToClient.flush();
			
		}catch(Exception exception){
			System.err.println(exception);
		}
	}


}
