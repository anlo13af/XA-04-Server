package JsonClasses;

/**
 * Class with getters and setters for AuthUser, making it possible to convert
 * between gson and json
 * 
 * @author andersliltorp
 *
 */
public class AuthUser implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	//Overall ID, used to determine which action should be performed.
	private String overallID = "logIn";
	private String email;
	private String password;
	
	/**
	 * Gets the overall ID
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
	 * Gets the user that's being authenticated's email
	 * @return the email
	 */
	public String getAuthUserEmail() {
		return email;
	}
	
	/**
	 * Sets the user that's being authenticated's email
	 * @param email
	 */
	public void setAuthUserEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the user that's being authenticated's password
	 * @return the password
	 */
	public String getAuthUserPassword() {
		return password;
	}
	
	/**
	 * Sets the user that's being authenticated's password
	 * @param password
	 */
	public void setAuthUserPassword(String password) {
		this.password = password;
	}

}