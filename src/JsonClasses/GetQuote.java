package JsonClasses;

/**
 * Class with getters and setters for GetQuote, making it possible to convert
 * between gson and json
 * 
 * @author andersliltorp
 *
 */
public class GetQuote implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "getQuote";
	private String quote;
	private String author;
	private String topic;

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
	public String getQuote() {
		return quote;
	}

	/**
	 * Sets the quote
	 * 
	 * @param quote
	 */
	public void setQuote(String quote) {
		this.quote = quote;
	}

	/**
	 * Gets the author of the quote
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author of the quote
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the topic of the quote
	 * 
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Sets the topic of the quote
	 * 
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

}
