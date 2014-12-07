package main;
import java.io.IOException;
import java.sql.SQLException;

import GUI.Console;
import model.database.DatabaseInit;

/**
 * Main class
 * @author andersliltorp
 *
 */
public class Main {
	
	/**
	 * Main method which checks DB environment and starts the TCP server
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		/*Configurations cf = new Configurations();
		
		cf.ReadFile();
		
		System.out.println(cf.getPassword());*/
		GUI.Console console = new GUI.Console();
		console.show();
		System.setOut(console.getPs());
		
		DatabaseInit init = new DatabaseInit();
		
		try {
			init.go();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		new TCPServer().run();
	}

}
