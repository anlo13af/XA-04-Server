package JsonClasses;

/**
 * Class with getters and setters for WeatherInfo, making it possible to convert
 * between gson and json
 * 
 * @author andersliltorp
 *
 */
public class WeatherInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Overall ID, used to determine which action should be performed.
	private String overallID = "getWeather";
	private String weatherLocation;
	private String weather;
	private String temperature;

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
	 * Gets the location of the weather data
	 * 
	 * @return the location
	 */
	public String getWeatherLocation() {
		return weatherLocation;
	}

	/**
	 * Sets the location of the weather data
	 * 
	 * @param weatherLocation
	 */
	public void setWeatherLocation(String weatherLocation) {
		this.weatherLocation = weatherLocation;
	}

	/**
	 * Gets the weather string
	 * 
	 * @return weather
	 */
	public String getWeather() {
		return weather;
	}

	/**
	 * Sets the weather string
	 * 
	 * @param weather
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/**
	 * Gets the temperature
	 * 
	 * @return temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * Sets the temperature
	 * 
	 * @param temperature
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
}
