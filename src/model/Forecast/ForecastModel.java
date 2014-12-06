package model.Forecast;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ForecastModel class
 * @author andersliltorp
 *
 */
public class ForecastModel extends Model {

	// Json parser to retrieve and map data from openweathermap.org
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<Forecast> forecastList = new ArrayList();
	private String weatherDescription = "";
	QueryBuilder qb = new QueryBuilder();

	@SuppressWarnings("rawtypes")
	/**
	 * requestForecast method which gets a json string with weather data and parses it
	 * @return ArrayList of Forecast objects
	 * @throws SQLException
	 */
	public ArrayList<Forecast> requestForecast() throws SQLException {

		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String[] value = { "*" };

		String result = "";
		// api.openweathermap.org/data/2.5/forecast?lat=35&lon=139
		try {
			qb.deleteFrom("dailyupdate").values(value).execute();
			System.out.println("Getting weather data...");
			url = new URL(
					"http://api.openweathermap.org/data/2.5/forecast?id=2618425&&mode=json&units=metric");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// henter indholder fra hjemmesiden efter vi har aabnet en
			// forbindelse
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				// vi skal ligge alle linjerne oven i hinanden
				result += line;
			}
			rd.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

			// get an array from the JSON object
			JSONArray list = (JSONArray) jsonObject.get("list");
			Iterator i = list.iterator();

			// take each value from the json array separately
			System.out.println("Inserting data into DB...");
			while (i.hasNext()) {
				String qotd = "";

				qotd = QOTDModel.saveQuote();

				JSONObject innerObj = (JSONObject) i.next();

				String string_date = (String) innerObj.get("dt_txt");
				String sh = string_date;

				JSONObject speedy = (JSONObject) innerObj.get("wind");
				Object ws = speedy.get("speed");
				String windspeed = String.valueOf(ws);

				JSONObject temp = (JSONObject) innerObj.get("main");
				Object celsius = temp.get("temp");
				String temperature = String.valueOf(celsius);

				// String temperatur = String.valueOf(celsius);
				JSONArray subList = (JSONArray) innerObj.get("weather");
				Iterator y = subList.iterator();

				while (y.hasNext()) {
					JSONObject childObj = (JSONObject) y.next();
					weatherDescription = (String) childObj.get("description");
				}

				@SuppressWarnings("unused")
				ResultSet forecast = null;
				try {
					String[] keys = { "date", "apparentTemperature", "summary",
							"windspeed", "qotd" };
					String[] values = { sh, temperature, weatherDescription,
							windspeed, qotd };
					qb.insertInto("dailyupdate", keys).values(values).execute();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				//Adds each Forecast object to the array
				forecastList.add(new Forecast(sh, temperature,
						weatherDescription, qotd));
			}
			System.out.println("Done.");
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		return forecastList;
	}

	// Henter vejrudsigten og gemmer de hentede data i en ArrayList
	/*
	 * public ArrayList<Forecast> getForecast() throws SQLException{
	 * 
	 * QueryBuilder qb = new QueryBuilder(); Date date = new Date(); // Current
	 * date & time long maxTimeNoUpdate = 3600; // Maximum one hour with no
	 * update
	 * 
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) ArrayList<Forecast>
	 * forecastFromDB = new ArrayList();
	 * 
	 * long date1 = date.getTime(); long date2 = date.getTime() -
	 * maxTimeNoUpdate; // minus 1 hour -- should be fetched from database
	 * 
	 * long timeSinceUpdate = 3599;
	 * 
	 * // if more than 1 hour ago, do update if(timeSinceUpdate > 3600){
	 * System.out.println("yaaaaaaay"); // return fresh weather data return
	 * this.requestForecast(); } else { // Query database and fetch existing
	 * weather data from db ResultSet forecast = null; try { forecast =
	 * qb.selectFrom("dailyupdate").where("msg_type", "=",
	 * "forecast").ExecuteQuery(); // Method to add these ResultSet values to
	 * ArrayList needs to be created return (ArrayList<Forecast>)
	 * forecastFromDB; } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * //Do something nice with ResultSet in order to make it into an ArrayList
	 * try { while(forecast.next()){ return forecastFromDB; } } catch
	 * (SQLException e) { e.printStackTrace(); } return null; } }
	 */

}
