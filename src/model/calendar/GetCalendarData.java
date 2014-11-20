package model.calendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jesperbruun on 13/10/14.
 */
public class GetCalendarData {
	
	static EncryptUserID e = new EncryptUserID();

	//henter data fra URL og l??er ind til en string
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    //Nu har vi alle data liggende i en string (JSON). 
    //Saa bruger vi Google's udviklede library Json string. den kan lave det om til java objekter
    //Events laver en arraylist af Event
    
    /**
     * Allows client to retrieve CBS's calendar and then access it.
     * @throws Exception
     */
    public static String getDataFromCalendar(String userID) throws Exception {

        /**
         * Get URL From calendar.cbs.dk -> Subscribe -> change URL to end with .json
         * Encrypt hash from
         */
    	//String userID = "alla13ad";
        String json = readUrl("http://calendar.cbs.dk/events.php/"+userID+"/"+e.getKey(userID)+".json");
        //String json = readUrl("http://calendar.cbs.dk/events.php/anli12ae/4ea5ca7d5f4a7475700a6508c5728cea.json");
     
        //JsonParser parser = new JsonParser();
        //JsonObject obj = parser.parse(json).getAsJsonObject();
        //Gson gson = new Gson();
        //Events events = gson.fromJson(obj, Events.class);
        return json;
        
        //tester events activityID's
        //for (int i = 0; i < events.getEvents().size(); i++){
        //    System.out.println(events.getEvents().get(i).getActivityid());
    }
}

