package JsonClasses;

/**
 * Class with getters and setters for DeleteCalendar, making it possible to
 * convert between gson and json
 * 
 * @author andersliltorp
 *
 */
public class DeleteCalendar implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "deleteCalendar";
	private String calendarName;
	private String userName;

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
	 * Gets the name of the calendar being deleted
	 * 
	 * @return the calendar name
	 */
	public String getCalendarName() {
		return calendarName;
	}

	/**
	 * Sets the name of the calendar being deleted
	 * 
	 * @param calendarName
	 */
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	/**
	 * Gets the username of the user deleting the calendar
	 * 
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the username of the user deleting the calendar
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
