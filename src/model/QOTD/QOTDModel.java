package model.QOTD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.QueryBuild.QueryBuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * QOTDModel class
 * @author andersliltorp
 *
 */
public class QOTDModel {

	@SuppressWarnings("unused")
	private ArrayList<QOTD> qotdlist = new ArrayList<>();

	QOTD qotdlist2 = new QOTD(null, null, null);
	QueryBuilder qb = new QueryBuilder();

	private ResultSet resultSet;

	/**
	 * readUrl method used to read weather data url
	 * @param urlString
	 * @return
	 * @throws Exception
	 */
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}

	}

	@SuppressWarnings("unused")
	/**
	 * saveQuote method used to parse the json string and get the quotes
	 * @return quote
	 */
	public static String saveQuote() {

		String json;
		String newquote = "";
		try {

			json = readUrl("http://dist-sso.it-kartellet.dk/quote/");

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

			String quote = (String) jsonObject.get("quote");
			newquote = quote.replaceAll("'", "\'");

			// String author = (String) jsonObject.get("author");
			// String topic = (String) jsonObject.get("topic");

			String[] keys = { "qotd" };
			String[] keys2 = { newquote };

			// System.out.println(quote + author + topic);

			// qb.update("dailyupdate", keys, keys2).where("windspeed", "=",
			// "100").Execute();
			// qb.update("dailyupdate", keys, keys2).where("msg_type", "=",
			// "1").Execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newquote;

	}

	/**
	 * getQuote method used to get quote from database
	 * @return
	 */
	public String getQuote() {
		String q = "";
		saveQuote();
		try {
			resultSet = qb.selectFrom("dailyupdate").all().ExecuteQuery();
			while (resultSet.next()) {
				q = resultSet.getString("qotd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return q;
	}

	/**
	 * NOT CURRENTLY USED
	 * updateQuote method used to update QOTD every one day
	 */
	public void updateQuote() {
		Date date = new Date(); // Current date & time
		long maxTimeNoUpdate = 86400; // Maximum one day with no update

		long date1 = date.getTime();
		long date2 = date.getTime() - maxTimeNoUpdate; // minus 1 hour -- should
														// be fetched from
														// database

		long timeSinceUpdate = date1 - date2;

		// if more than 1 hour ago, do update
		if (timeSinceUpdate > 864000) {
			// return fresh weather data
			saveQuote();
		}
	}

}
