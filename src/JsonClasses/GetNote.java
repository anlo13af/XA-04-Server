package JsonClasses;

/**
 * Class with getters and setters for GetQuote, making it possible to convert
 * between gson and json
 * 
 * @author andersliltorp
 *
 */
public class GetNote implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "getNote";
	private String note;
	private String eventid;
	//private String topic;

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
	 * Gets the quote
	 * 
	 * @return quote
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets the quote
	 * 
	 * @param quote
	 */
	public void setNote(String note) {
		this.note = note;
	}
	public String getEventID() {
		return eventid;
	}

	/**
	 * Sets the quote
	 * 
	 * @param quote
	 */
	public void setEventID(String eventid) {
		this.eventid = eventid;
	}


}
