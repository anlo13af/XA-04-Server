package databaseMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.user.encryptionAES;

public class SwitchMethods extends Model {
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();

	/**
	 * Allows the client to create a new calendar
	 * 
	 * @param userName
	 * @param calendarName
	 * @param privatePublic
	 * @return
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

	public void addNewCalendar(String newCalendarName, String userName,
			int publicOrPrivate) throws SQLException {
		String[] keys = { "Name", "Active", "CreatedBy", "PrivatePublic" };
		String[] values = { newCalendarName, "1", userName,
				Integer.toString(publicOrPrivate) };
		qb.insertInto("calendar", keys).values(values).execute();

		// doUpdate("insert into test.calendar (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalendarName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}

	public String addUser(String newUserEmail, String newUserPassword)
			throws Exception {
		System.out.println(newUserEmail);
		String[] keys = { "email", "active", "password" };
		String[] values = { newUserEmail, "1",
				encryptionAES.encrypt(newUserPassword) };
		ResultSet rs = qb.selectFrom("users").where("email", "=", newUserEmail)
				.ExecuteQuery();
		
		if (rs.next()) {
				System.out.println("hmm?");
				return "2"; // Returnerer 2: brugernavn findes allerede.
			} else {
				try {
					qb.insertInto("users", keys).values(values).execute();
					return "0"; // Returnerer 0: brugeren er oprettet
				} catch (SQLException e) {
					e.printStackTrace();
					return "1"; // Returnerer 1: Brugeren blev ikke oprettet
				}
			}
		}
		

	public String changePassword(String UserEmail, String newPassword)
			throws Exception {
		String[] keys = { "password" };
		String[] values = { encryptionAES.encrypt(newPassword) };
		try {
			qb.update("users", keys, values).where("email", "=", UserEmail)
					.execute();
			return "0"; // Returnerer 0: password er skiftet.
		} catch (SQLException e) {
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

	// Metoden faar email og password fra switchen (udtrukket fra en json) samt
	// en boolean der skal saettes til true hvis det er serveren der logger paa,
	// og false hvis det er en klient
	/**
	 * Allows the client to log in
	 * 
	 * @param email
	 * @param password
	 * @return
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
