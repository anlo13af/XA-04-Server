package main;
import java.io.DataOutputStream;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import JsonClasses.*;

import java.util.Scanner;

public class TCPClient2 {
	private static encryption cryp = new encryption();

	public static void main (String [] args) throws Exception{

		switchy();

	}
	public static void switchy() throws Exception {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("1:CreateCalendar \n2:DeleteCalendar \n3:Login \n4:QOTD \n5:Weather \n6:AddUser \n7:CBS Calendar");
		int lol = scan.nextInt();
		//System.out.println("password?");
		//String password = scan.nextLine();
		shit(lol);

	}
	public static void shit(int lol) throws Exception {
		String gsonString;
		Gson gson = new GsonBuilder().create();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		switch (lol){
		case 1 :
			System.out.println("Kalenders navn?");
			String calendarName = scan.nextLine();
			System.out.println("User name?");
			String userName = scan.nextLine();
			CreateCalendar CC = new CreateCalendar();
			CC.setCalendarName(calendarName);
			CC.setPublicOrPrivate(1);
			CC.setUserName(userName);
			gsonString = gson.toJson(CC);
			gogogo(gsonString);
			break;

		case 2 : 
			System.out.println("Kalenders navn?");
			String calendarName1 = scan.nextLine();
			System.out.println("User name?");
			String userName1 = scan.nextLine();
			DeleteCalendar DC = new DeleteCalendar();
			DC.setCalendarName(calendarName1);
			DC.setUserName(userName1);
			gsonString = gson.toJson(DC);
			gogogo(gsonString);
			break;

		case 3 :
			System.out.println("email?");
			String email = scan.nextLine();
			System.out.println("pass?");
			String pass = scan.nextLine();
			AuthUser AU = new AuthUser();			
			AU.setAuthUserEmail(email);
			AU.setAuthUserPassword(pass);
			gsonString = gson.toJson(AU);
			System.out.println(gsonString);
			gogogo(gsonString);
			break;

		case 4 :
			GetQuote GQ = new GetQuote();			
			gsonString = gson.toJson(GQ);
			System.out.println(gsonString);
			gogogo(gsonString);
			break;

		case 5 :
			WeatherInfo WI = new WeatherInfo();			
			gsonString = gson.toJson(WI);
			System.out.println(gsonString);
			gogogo(gsonString);
			break;
			
		case 6:
			System.out.println("Ny bruger email: ");
			String newUserEmail = scan.nextLine();
			System.out.println("Ny bruger password: ");
			String newUserPassword = scan.nextLine();
			AddUser AddU = new AddUser();
			AddU.setEmail(newUserEmail);
			AddU.setPassword(newUserPassword);
			gsonString = gson.toJson(AddU);
			gogogo(gsonString);
			break;
		
		case 7:
			System.out.println("Indtast CBS ID: ");
			String cbsID = scan.nextLine();
			String a = "{\"serialVersionUID\":1,\"overallID\":\"" + "getCalendar"
					+ "\",\"cbsID\":\"" + cbsID + "\"}";
			gogogo(a);

		}
	}


	public static void gogogo(String go) throws Exception{
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

		byte[] b = new byte[500000];
		clientSocket.getInputStream().read(b);
		String ny = cryp.decrypt(b);
		System.out.println(ny);


		clientSocket.close();
		switchy();


	}
}