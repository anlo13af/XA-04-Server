package main;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import JsonClasses.*;
import model.QOTD.*;

import java.util.Scanner;

public class TCPClient2 {
	
	public static void main (String [] args) throws Exception{
		
	switchy();
		
	}
	public static void switchy() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("1:CreateCalendar \n2:DeleteCalendar \n3:Login");
		int lol = scan.nextInt();
		//System.out.println("password?");
		//String password = scan.nextLine();
		shit(lol);
		
	}
	public static void shit(int lol) throws Exception {
		switch (lol){
		case 1 :
			System.out.println("Kalenders navn?");
			Scanner scan = new Scanner(System.in);
			String calendarName = scan.nextLine();
			System.out.println("User name?");
			String userName = scan.nextLine();
			CreateCalendar CC = new CreateCalendar();
			CC.setCalendarName(calendarName);
			CC.setPublicOrPrivate(1);
			CC.setUserName(userName);
			Gson gson = new GsonBuilder().create();
			String gsonString = gson.toJson(CC);
			gogogo(gsonString);
			
		break;
		case 2 : 
			System.out.println("Kalenders navn?");
			Scanner scan1 = new Scanner(System.in);
			String calendarName1 = scan1.nextLine();
			System.out.println("User name?");
			String userName1 = scan1.nextLine();
			DeleteCalendar DC = new DeleteCalendar();
			DC.setCalendarName(calendarName1);
			DC.setUserName(userName1);
			Gson gson1 = new GsonBuilder().create();
			String gsonString1 = gson1.toJson(DC);
			gogogo(gsonString1);
			break;
		case 3 :
			System.out.println("email?");
			Scanner scan2 = new Scanner(System.in);
			String email = scan2.nextLine();
			System.out.println("pass?");
			String pass = scan2.nextLine();
			AuthUser AU = new AuthUser();			
			AU.setAuthUserEmail(email);
			AU.setAuthUserPassword(pass);
			AU.setAuthUserIsAdmin(true);
			Gson gson2 = new GsonBuilder().create();
			String gsonString2 = gson2.toJson(AU);
			
			//String go = "AU";
			gogogo(gsonString2);
			break;
		}
			
		
		
		
		
		
		 
	}
		public static void gogogo(String go) throws Exception{
			String modifiedSentence;
			Gson gson = new GsonBuilder().create();

			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = go.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			outToServer.write(encrypted);
			outToServer.flush();
			switchy();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			modifiedSentence = inFromServer.readLine();
			System.out.println(modifiedSentence);
			System.out.println("FROM SERVER: " + modifiedSentence);
			clientSocket.close();
			
		}
}