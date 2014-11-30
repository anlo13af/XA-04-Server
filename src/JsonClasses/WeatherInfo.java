package JsonClasses;
public class WeatherInfo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String overallID = "getWeather";
	private String weatherLocation;
	private String weather;
	private String temperature;
	
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public String getWeatherLocation() {
		return weatherLocation;
	}
	public void setWeatherLocation(String weatherLocation) {
		this.weatherLocation = weatherLocation;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	
}
