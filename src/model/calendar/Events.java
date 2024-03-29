package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.QueryBuild.QueryBuilder;

/**
 * Created by jesperbruun on 10/10/14. Den laver selve arrayet af alle generede
 * Event
 */
public class Events {
	//Create arraylist to contain events
	ArrayList<Event> events = new ArrayList<Event>();

	/**
	 * getEvents method which gets events for a given userid
	 * @param id
	 * @return ArrayList with all the user's events.
	 */
	public ArrayList<Event> getEvents(String id) {
		QueryBuilder qb = new QueryBuilder();
		try {
			System.out.println("Getting events from database.");
			//Gets events for the user with given ID from the database.
			ResultSet rs = qb.selectFrom("events").where("createdby", "=", id).ExecuteQuery();
			
			//Cycle through events
			while (rs.next()) {
				// String values from SQL database (must be created)
				int eventID = rs.getInt("eventid");
				int type = rs.getInt("type");
				String location = rs.getString("location");
				int createdby = rs.getInt("createdby");
				Date startDate = rs.getDate("start");
				Date startTime = rs.getTime("start");
				Date endDate = rs.getDate("end");
				Date endTime = rs.getTime("end");
				String nameEvent = rs.getString("name");
				String text = rs.getString("text");

				String stringEventID = String.valueOf(eventID);
				String stringType = String.valueOf(type);
				String stringCreatedby = String.valueOf(createdby);
				String stringStartDate = String.valueOf(startDate);
				String stringEndDate = String.valueOf(endDate);
				String stringStartTime = String.valueOf(startTime);
				String stringEndTime = String.valueOf(endTime);
				stringStartTime = stringStartTime.substring(0, stringStartTime.length() - 3);
				stringEndTime = stringEndTime.substring(0, stringEndTime.length() - 3);
				
				ArrayList<String> startArray = new ArrayList<String>(Arrays.asList(stringStartDate.split("-")));
				String[] start = stringStartTime.split(":");
				String starthour = start[0];
				String startmin = start[1];
				startArray.add(starthour);
				startArray.add(startmin);
				
				ArrayList<String> endArray = new ArrayList<String>(Arrays.asList(stringEndDate.split("-")));
				String[] end = stringEndTime.split(":");
				String endhour = end[0];
				String endmin = end[1];
				endArray.add(endhour);
				endArray.add(endmin);

				ArrayList<String> alStart = new ArrayList<String>();
				alStart.add(stringStartDate + " " + stringStartTime);

				ArrayList<String> alEnd = new ArrayList<String>();
				alEnd.add(stringEndDate + " " + stringEndTime);
				
				//Add events to arraylist
				events.add(new Event(stringEventID, stringEventID, stringType,
						nameEvent, text, location, stringCreatedby, startArray, endArray));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	/**
	 * Get events from CBS database
	 * @return arraylist of events
	 */
	public ArrayList<Event> getCBSEvents() {
		return events;
	}
	
	/**
	 * Sets events
	 * @param event
	 */
	public void setEvents(ArrayList<Event> event) {
		this.events = event;
	}

	// Konverterer array events til en tekst streng
	@Override
	public String toString() {
		return Arrays.toString(events.toArray());
	}
}