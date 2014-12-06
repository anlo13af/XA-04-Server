package JsonClasses;

/**
 * Class with getters and setters for AddUser, making it possible to convert
 * between gson and json
 * 
 * @author andersliltorp
 *
 */
public class AddUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	//Overall ID, used to determine which action should be performed.
	private String overallID = "addUser";
	private String email;
	private String password;

	/**
	 * Gets the overallID
	 * @return overall ID
	 */
	public String getOverallID() {
		return overallID;
	}
	
	/**
	 * Sets the overall ID
	 * @param overallID
	 */
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	/**
	 * Gets the new users email
	 * @return The email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the new users email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the new users password
	 * @return The password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the new users password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
