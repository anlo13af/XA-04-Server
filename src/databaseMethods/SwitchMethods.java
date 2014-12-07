package databaseMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.user.encryptionAES;
/**
 * Class that determines which action should be performed.
 */
public class SwitchMethods extends Model {
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();

	/**
	 * Allows the client to create a new calendar
	 * 
	 * @param userName
	 * @param calendarName
	 * @param privatePublic
	 * @return String with a message about the outcome of the request
	 * @throws SQLException
	 */
	public String createNewCalendar(String userName, String calendarName,
			int privatePublic) throws SQLException {
		String stringToBeReturned = "";
		testConnection();
		if (authenticateNewCalendar(calendarName) == false) {
			addNewCalendar(calendarName, userName, privatePublic);
			stringToBeReturned = "The new calendar has been created!";
		} else {
			stringToBeReturned = "The new calendar has not been created!";
		}

		return stringToBeReturned;
	}
	/**
	 * Determines whether a newly created calendar can be authenticated
	 * @param newCalendarName
	 * @return
	 * @throws SQLException
	 */
	public boolean authenticateNewCalendar(String newCalendarName)
			throws SQLException {
		testConnection();
		boolean authenticate = false;

		resultSet = qb.selectFrom("calendar")
				.where("name", "=", newCalendarName).ExecuteQuery();

		while (resultSet.next()) {
			authenticate = true;
		}
		return authenticate;
	}
	/**
	 * Adds a new calendar to the database
	 * @param newCalendarName
	 * @param userName
	 * @param publicOrPrivate
	 * @throws SQLException
	 */
	public void addNewCalendar(String newCalendarName, String userName,
			int publicOrPrivate) throws SQLException {
		String[] keys = { "Name", "Active", "CreatedBy", "PrivatePublic" };
		String[] values = { newCalendarName, "1", userName,
				Integer.toString(publicOrPrivate) };
		qb.insertInto("calendar", keys).values(values).execute();
	}
	
	/**
	 * Adds a new event to the database.
	 * @param location
	 * @param createdBy
	 * @param start
	 * @param end
	 * @param name
	 * @param text
	 * @return 0 or 1 depending on whether the calendar was added to the DB or not.
	 */
	public String addNewEvent(String location, String createdBy,
			ArrayList<String> start, ArrayList<String> end, String name,
			String text) {
		String stringStart = start.get(0) + "-" + start.get(1) + "-" + start.get(2) + " " + start.get(3) + ":" + start.get(4) + ":00";
		String stringEnd = end.get(0) + "-" + end.get(1) + "-" + end.get(2) + " " + end.get(3) + ":" + end.get(4) + ":00";
		String[] keys = { "location", "createdby", "start", "end", "name",
				"text" };
		String[] values = { location, createdBy, stringStart, stringEnd,
				name, text };

		try {
			qb.insertInto("events", keys).values(values).execute();
			return "0";
		} catch (SQLException e) {
			e.printStackTrace();
			return "1";
		}
	}
	
	/**
	 * Finds the userid for the user with the given username
	 * @param username
	 * @return The users userid
	 * @throws SQLException
	 */
	public String findUserID(String username) throws SQLException {
		int id = 0;
		ResultSet rs = qb.selectFrom("users").where("email", "=", username).ExecuteQuery();
		while (rs.next()) {
			id = rs.getInt("userid");
		}
		String sID = String.valueOf(id);
		return sID;
	}
	
	public String getNote(String id) {
		String note = "no note";
		ResultSet rs;
		System.out.println("before select");
		try {
			rs = qb.selectFrom("notes").where("eventid", "=", id).ExecuteQuery();
			System.out.println("after select");
			if (rs.next()) {
				System.out.println("inside if");
				note = rs.getString("text");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return note;
	}
	
	public String saveNote(String eventid, String text) throws SQLException {
		ResultSet rs = qb.selectFrom("notes").where("eventid", "=", eventid).ExecuteQuery();
		String[] keys = { "eventid", "text" };
		String[] values = { eventid, text };
		if (rs.next()) {
			qb.update("notes", keys, values).where("eventid", "=", eventid).execute();
			return "0"; //0 for updated note
		} else {
			qb.insertInto("notes", keys).values(values).execute();
			return "1"; //1 for added note
		}
	}

	/**
	 * Adds a new user to the DB
	 * @param newUserEmail
	 * @param newUserPassword
	 * @return 0, 1 or 2 depending on whether the user was added, the username already exists or an sql error
	 * @throws Exception
	 */
	public String addUser(String newUserEmail, String newUserPassword)
			throws Exception {
		System.out.println("Adding new user: " + newUserEmail);
		String[] keys = { "email", "active", "password" };
		String[] values = { newUserEmail, "1",
				encryptionAES.encrypt(newUserPassword) };
		ResultSet rs = qb.selectFrom("users").where("email", "=", newUserEmail)
				.ExecuteQuery();

		if (rs.next()) {
			System.out.println("User not added, username " + newUserEmail + " already exists.");
			return "2"; // Returnerer 2: brugernavn findes allerede.
		} else {
			try {
				qb.insertInto("users", keys).values(values).execute();
				System.out.println("User " + newUserEmail + " was added!");
				return "0"; // Returnerer 0: brugeren er oprettet
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL Error, user not added.");
				return "1"; // Returnerer 1: Brugeren blev ikke oprettet
			}
		}
	}

	/**
	 * Changes the users password
	 * @param UserEmail
	 * @param newPassword
	 * @return 0 or 1 depending on whether the users password changed or not
	 * @throws Exception
	 */
	public String changePassword(String UserEmail, String newPassword)
			throws Exception {
		String[] keys = { "password" };
		String[] values = { encryptionAES.encrypt(newPassword) };
		try {
			qb.update("users", keys, values).where("email", "=", UserEmail)
					.execute();
			System.out.println("Changed password for: " + UserEmail);
			return "0"; // Returnerer 0: password er skiftet.
		} catch (SQLException e) {
			System.out.println("SQL Error, couldn't change password");
			e.printStackTrace();
			return "1"; // Returnerer 1: password blev ikke skiftet.
		}
	}

	/**
	 * Allows the client to delete a calendar
	 * 
	 * @param userName
	 * @param calendarName
	 * @return
	 */
	public String deleteCalendar(String userName, String calendarName)
			throws SQLException {
		String stringToBeReturned = "";
		testConnection();
		stringToBeReturned = removeCalendar(userName, calendarName);

		return stringToBeReturned;
	}
	
	/**
	 * Sets a users chosen calendar to inactive
	 * @param userName
	 * @param calendarName
	 * @return String with a message of the outcome of the request.
	 * @throws SQLException
	 */
	public String removeCalendar(String userName, String calendarName)
			throws SQLException {
		String stringToBeReturned = "";
		String usernameOfCreator = "";
		String calendarExists = "";
		resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName)
				.ExecuteQuery();

		// ("select * from calendar where Name = '"+calendarName+"';");
		while (resultSet.next()) {
			calendarExists = resultSet.toString();
		}
		if (!calendarExists.equals("")) {
			String[] value = { "CreatedBy" };
			resultSet = qb.selectFrom(value, "Calendar")
					.where("Name", "=", calendarName).ExecuteQuery();
			while (resultSet.next()) {
				usernameOfCreator = resultSet.getString("CreatedBy");
			}
			if (!usernameOfCreator.equals(userName)) {
				stringToBeReturned = "Only the creator of the calendar is able to delete it.";
			} else {
				String[] keys = { "Active" };
				String[] values = { "2" };
				qb.update("Calendar", keys, values)
						.where("Name", "=", calendarName).execute();
				stringToBeReturned = "Calendar has been set inactive";
			}
		} else {
			stringToBeReturned = "The calendar you are trying to delete, does not exists.";
		}

		return stringToBeReturned;
	}

	/**
	 * Allows the client to log in
	 * 
	 * @param email
	 * @param password
	 * @return 0, 1, 2, 3 that represents different outcomes of the request.
	 * @throws Exception
	 */
	public String authenticate(String email, String password) throws Exception {

		String[] keys = { "userid", "email", "active", "password" };

		qb = new QueryBuilder();

		// Henter info om bruger fra database via querybuilder
		resultSet = qb.selectFrom(keys, "users").where("email", "=", email)
				.ExecuteQuery();

		// Hvis en bruger med forespurgt email findes
		if (resultSet.next()) {
			// Hvis brugeren er aktiv
			if (resultSet.getInt("active") == 1) {
				System.out.println("Brugeren er aktiv");
				// Hvis passwords matcher
				if (resultSet.getString("password").equals(password)) {
					System.out.println("Brugerens password matcher");
					return "0";

				} else {
					return "3"; // returnerer fejlkoden "3" hvis password ikke
								// matcher
				}
			} else {
				return "2"; // returnerer fejlkoden "2" hvis bruger er sat som
							// inaktiv
			}
		} else {
			return "1"; // returnerer fejlkoden "1" hvis email ikke findes
		}
	}
}
