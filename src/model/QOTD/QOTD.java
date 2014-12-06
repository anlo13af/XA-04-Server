package model.QOTD;

/**
 * QOTD class
 * 
 * @author andersliltorp
 *
 */
public class QOTD {

	private String quote;
	private String author;
	private String topic;

	/**
	 * QOTD constructor
	 * 
	 * @param quote
	 * @param author
	 * @param topic
	 */
	public QOTD(String quote, String author, String topic) {
		super();
		this.quote = quote;
		this.author = author;
		this.topic = topic;
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
	 * Gets the quote's author
	 * 
	 * @return author
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
	 * Gets the quote's topic
	 * 
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Sets the quote's topic
	 * 
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

}
