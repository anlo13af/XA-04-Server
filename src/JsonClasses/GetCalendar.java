package JsonClasses;

/**
 * Class with getters and setters for GetCalendar, making it possible to
 * convert between gson and json
 * 
 * @author andersliltorp
 *
 */
public class GetCalendar implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "getCalendar";
	private String cbsID, id;

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
	 * Gets the cbs ID (username) of the user getting calendar data
	 * 
	 * @return the cbs ID
	 */
	public String getcbsID() {
		return cbsID;
	}

	/**
	 * Sets the cbs ID (username) of the user getting calendar data
	 * 
	 * @param cbsID
	 */
	public void setcbsID(String cbsID) {
		this.cbsID = cbsID;
	}

	/**
	 * Gets the id (userid) of the user getting calendar data
	 * 
	 * @return the id
	 */
	public String getID() {
		return id;
	}

	/**
	 * Sets the id (userid) of the user getting calendar data
	 * 
	 * @param id
	 */
	public void setID(String id) {
		this.id = id;
	}

}