package main;
import java.io.IOException;
import java.sql.SQLException;

import model.database.DatabaseInit;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		/*Configurations cf = new Configurations();
		
		cf.ReadFile();
		
		System.out.println(cf.getPassword());*/
		DatabaseInit init = new DatabaseInit();
		
		try {
			init.go();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		new TCPServer().run();
	}

}
