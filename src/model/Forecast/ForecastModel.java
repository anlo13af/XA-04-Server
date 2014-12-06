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
 * 
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
				// Adds each Forecast object to the array
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

}
