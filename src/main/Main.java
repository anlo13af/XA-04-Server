package main;
import java.io.IOException;

import GUI.GUILogic;
import config.Configurations;

public class Main {
	//Starts public main method.
	
	public static void main(String[] args) throws IOException {
		Configurations cf = new Configurations();
		
		cf.ReadFile();
		
		//TCPServer server = new TCPServer();
		
		System.out.println(cf.getPassword());
		
		new GUILogic().run();
		new TCPServer().run();
	}

}
