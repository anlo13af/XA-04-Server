package JsonClasses;

/**
 * Class with getters and setters for CreateCalendar, making it possible to
 * convert between gson and json
 * 
 * @author andersliltorp
 *
 */
public class CreateCalendar implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "createCalendar";
	private String calendarName;
	private String userName;
	private int publicOrPrivate;

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
	 * Gets the name of the calendar being created
	 * 
	 * @return the calendar name
	 */
	public String getCalendarName() {
		return calendarName;
	}

	/**
	 * Sets the name of the calendar being created
	 * 
	 * @param calendarName
	 */
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	/**
	 * Gets the username of the user creating the calendar
	 * 
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the username of the user creating the calendar
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the value of public or private
	 * 
	 * @return whether the new calendar is public or private
	 */
	public int getPublicOrPrivate() {
		return publicOrPrivate;
	}

	/**
	 * Sets the value of public or private
	 * 
	 * @param publicPrivate
	 */
	public void setPublicOrPrivate(int publicPrivate) {
		this.publicOrPrivate = publicPrivate;
	}

}
