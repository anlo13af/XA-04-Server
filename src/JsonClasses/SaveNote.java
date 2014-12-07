package JsonClasses;

public class SaveNote implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "saveNote";
	private String note;
	private String createdby;
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
	 * Gets the note
	 * 
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets the note
	 * 
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getCreatedBy() {
		return createdby;
	}

	public void setCreatedBy(String createdby) {
		this.createdby = createdby;
	}
	public String getEventID() {
		return eventid;
	}

	/**
	 * Sets the event id
	 * 
	 * @param eventid
	 */
	public void setEventID(String eventid) {
		this.eventid = eventid;
	}


}
