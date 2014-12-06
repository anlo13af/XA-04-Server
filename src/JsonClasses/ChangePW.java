package JsonClasses;

/**
 * Class with getters and setters for ChangePW, making it possible to convert
 * between gson and json
 * 
 * @author andersliltorp
 *
 */
public class ChangePW implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "changePassword";
	private String email;
	private String password;

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
	 * Gets the email of the user that is changing password
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the user that is changing password
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password of the user that is changing password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user that is changing password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}