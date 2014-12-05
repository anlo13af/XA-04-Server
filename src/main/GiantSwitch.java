package main;
import java.util.ArrayList;

import model.Forecast.Forecast;
import model.Forecast.ForecastModel;
import model.QOTD.QOTDModel;
import model.calendar.GetCalendarData;
import JsonClasses.AddUser;
import JsonClasses.AuthUser;
import JsonClasses.ChangePW;
import JsonClasses.CreateCalendar;
import JsonClasses.DeleteCalendar;
import JsonClasses.GetCalendar;
import JsonClasses.WeatherInfo;

import com.google.gson.*;

import databaseMethods.SwitchMethods;
import model.user.*;

public class GiantSwitch {
	
	
	
	public String GiantSwitchMethod(String jsonString) throws Exception {
		QOTDModel QOTDKlasse = new QOTDModel();
		ForecastModel fm = new ForecastModel();
		SwitchMethods SW = new SwitchMethods();
		AuthenticateUser Auth = new AuthenticateUser();
		
		Gson gson = new GsonBuilder().create();
		String answer = "";	
		
		//Creates a switch which determines which method should be used. Methods will be applied later on
		switch (Determine(jsonString)) {
		//If the Json String contains one of the keywords below, run the relevant method.

		/************
		 ** COURSES **
		 ************/

		case "importCalendar":
			System.out.println("Recieved importCourse");
			break;

		/**********
		 ** LOGIN **
		 **********/
		case "logIn":
			AuthUser AU = (AuthUser)gson.fromJson(jsonString, AuthUser.class);
			try {
				answer = Auth.authenticate(AU.getAuthUserEmail(), AU.getAuthUserPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "logOut":
			System.out.println("Recieved logOut");
			break;
		
		case "changePassword":
			ChangePW Change = (ChangePW)gson.fromJson(jsonString, ChangePW.class);
			answer = SW.changePassword(Change.getEmail(), Change.getPassword());
			break;
		
		case "addUser":
			AddUser AddU = (AddUser)gson.fromJson(jsonString, AddUser.class);
			answer = SW.addUser(AddU.getEmail(), AddU.getPassword());
			break;
		
		/*************
		 ** CALENDAR **
		 *************/
		case "createCalendar":
			
			CreateCalendar CC = (CreateCalendar)gson.fromJson(jsonString, CreateCalendar.class);
			answer = SW.createNewCalendar(CC.getUserName(), CC.getCalendarName(), CC.getPublicOrPrivate());
			break;
			
		case "deleteCalendar":
			DeleteCalendar DC = (DeleteCalendar)gson.fromJson(jsonString, DeleteCalendar.class);
			answer = SW.deleteCalendar(DC.getUserName(), DC.getCalendarName());
			break;
		
		case "saveImportedCalendar":
			break;
			
		case "getCalendar":
			GetCalendar GC = (GetCalendar)gson.fromJson(jsonString, GetCalendar.class);
			answer = GetCalendarData.getDataFromCalendar(GC.getcbsID());
			break;

		case "getEvents":
			System.out.println("Recieved getEvents");
			break;

		case "createEvent":
			System.out.println("Recieved saveEvent");
			break;

		case "getEventInfo":
			System.out.println("Recieved getEventInfo");
			break;
			
		case "deleteEvent":
			System.out.println("Recieved deleteEvent");
		
		case "saveNote":
			System.out.println("Recieved saveNote");
			break;

		case "getNote":
			System.out.println("Recieved getNote");
			break;
			
		case "deleteNote":
			System.out.println("Recieved deleteNote");
			break;

		/**********
		 ** QUOTE **
		 **********/
		case "getQuote":
			answer = QOTDKlasse.getQuote();
			break;

		/************
		 ** WEATHER **
		 ************/

		case "getWeather":
			Gson tojson = new GsonBuilder().create();
			 ArrayList<Forecast> forecastList = fm.requestForecast();
		        
			answer = "{\"weatherlist\":" + tojson.toJson(forecastList) + "}";
			break;
		
		default:
			System.out.println("Error" + jsonString );
			break;
		}
		
		return answer;
		
	}

	//Creates a loooong else if statement, which checks the JSon string which keyword it contains, and returns the following 
	//keyword if
	public String Determine(String ID) {

		if (ID.contains("getEvents")) {
			return "getEvents";
		} else if (ID.contains("getEventInfo")) {
			return "getEventInfo";
		} else if (ID.contains("saveNote")) {
			return "saveNote";
		} else if (ID.contains("getNote")) {
			return "getNote";
		} else if (ID.contains("deleteNote")){
			return "deleteNote";
		}else if  (ID.contains("deleteCalendar")){
			return "deleteCalendar";
		} else if (ID.contains("getWeather")) {
			return "getWeather";
		} else if (ID.contains("saveImportedCalendar")) {
			return "saveImportedCalendar";
		}else if (ID.contains("importCourse")) {
			return "importCourse";
		} else if (ID.contains("exportCourse")) {
			return "exportCourse";
		} else if (ID.contains("getQuote")) {
			return "getQuote";
		} else if (ID.contains("logIn")) {
			return "logIn";
		} else if (ID.contains("logOut")) {
			return "logOut";
		} else if (ID.contains("getCalendar")) {
			return "getCalendar";
		} else if (ID.contains("createEvent")) {
			return "createEvent";
		} else if (ID.contains("deleteEvent")) {
			return "deleteEvent"; 
		} else if (ID.contains("createCalendar")) {
			return "createCalendar";
		} else if (ID.contains("addUser")) {
			return "addUser";
		} else if (ID.contains("changePassword")) {
			return "changePassword";
		}
		else
			return "error";
	}
	

}
