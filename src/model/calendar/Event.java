package model.calendar;

import java.util.ArrayList;

/**
 * Created by jesperbruun on 10/10/14.
 * Til hver specifik event bliver de defineret saaledes.
 */
public class Event {
    private String activityid;
    private String eventid;
    private String type;
    private String title;
    private String description;
    private String location;
    private String createdby;
    private ArrayList<String> start;
    private ArrayList<String> end;

    /**
     * Sets the activity ID
     * @param activityid
     */
    public void setActivityid(String activityid){
        this.activityid = activityid;
    }
    
    /**
     * Gets the activity ID
     * @return activity ID
     */
    public String getActivityid(){
        return activityid;
    }

    /**
     * Sets the event ID
     * @param eventid
     */
    public void setEventid(String eventid){
        this.eventid = eventid;
    }
    
    /**
     * Gets the event ID
     * @return event ID
     */
    public String getEventid(){
        return eventid;
    }

    /**
     * Sets the event type
     * @param type
     */
    public void setType(String type){
        this.type = type;
    }
    
    /**
     * Gets the event's type
     * @return type
     */
    public String getType(){
        return type;
    }

    /**
     * Sets the event's title
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }
    
    /**
     * Gets the event's title
     * @return title
     */
    public String getTitle(){
        return title;
    }

    /**
     * Sets the event's description
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }
    
    /**
     * Gets the event's description
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Sets the event's location
     * @param location
     */
    public void setLocation(String location){
        this.location = location;
    }
    
    /**
     * Gets the event's location
     * @return location
     */
    public String getLocation(){
        return location;
    }

    /**
     * Sets the event's created by value
     * @param createdby
     */
    public void setCreatedby(String createdby){
        this.createdby = createdby;
    }
    
    /**
     * Gets the event's created by value
     * @return
     */
    public String getCreatedby(){
        return createdby;
    }
 
    /**
     * Sets the event's start date and time
     * @param start
     */
    public void setStart(ArrayList<String> start){
        this.start = start;
    }
    
    /**
     * Gets the event's start date and time
     * @return ArrayList with date and time
     */
    public ArrayList<String> getStart(){
        return start;
    }

    /**
     * Sets the event's end date and time
     * @param end
     */
    public void setEnd(ArrayList<String> end){
        this.end = end;
    }
    
    /**
     * Gets the event's end date and time
     * @return ArrayList with date and time
     */
    public ArrayList<String> getEnd(){
        return end;
    }
    
    /**
     * Event constructor
     * @param activityid
     * @param eventid
     * @param type
     * @param title
     * @param description
     * @param location
     * @param createdby
     * @param start
     * @param end
     */
	public Event(String activityid, String eventid, String type, String title,
			String description, String location, String createdby, ArrayList<String> start,
			ArrayList<String> end) {
		super();
		this.activityid = activityid;
		this.eventid = eventid;
		this.type = type;
		this.title = title;
		this.description = description;
		this.location = location;
		this.createdby = createdby;
		this.start = start;
		this.end = end;
	}
}
