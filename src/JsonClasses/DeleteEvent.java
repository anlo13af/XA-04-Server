package JsonClasses;

public class DeleteEvent implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "deleteEvent";
	private String eventid;

	/**
	 * Gets the overall ID
	 * 
	 * @return overall ID
	 */
	public String getOverallID() {
		return overallID;
	}

	/**
	 * Sets the overall ID
	 * 
	 * @param overallID
	 */
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

	/**
	 * Gets the event ID
	 * 
	 * @return event ID
	 */
	public String getEventID() {
		return eventid;
	}

	/**
	 * Sets the note
	 * 
	 * @param note
	 */
	public void setEventID(String eventid) {
		this.eventid = eventid;
	}
	


}