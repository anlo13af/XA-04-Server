package JsonClasses;

public class GetQuote implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "getQuote";
	//private String calendarName;
	//private String userName;
	private String quote;
	private String author;
	private String topic;
	//private int publicOrPrivate;
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

}
