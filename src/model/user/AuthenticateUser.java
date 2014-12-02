package model.user;

import java.sql.ResultSet;

import model.QueryBuild.QueryBuilder;

public class AuthenticateUser {

	private ResultSet resultSet;
	private QueryBuilder qb;

	// Metoden faar email og password fra switchen (udtrukket fra en json) samt en boolean der skal saettes til true hvis det er serveren der logger paa, og false hvis det er en klient
	/**
	 * Allows the client to log in
	 * @param email
	 * @param password
	 * @param isAdmin
	 * @return
	 * @throws Exception
	 */
	public String authenticate(String email, String password) throws Exception {

		String[] keys = {"userid", "email", "active", "password"};

		qb = new QueryBuilder();

		// Henter info om bruger fra database via querybuilder
		resultSet = qb.selectFrom(keys, "users").where("email", "=", email).ExecuteQuery();

		// Hvis en bruger med forespurgt email findes
		if (resultSet.next()){
			System.out.println("Brugeren findes");
			System.out.println(resultSet.getString("password"));
			System.out.println(password);
			System.out.println(encryptionAES.encrypt(password));

			// Hvis brugeren er aktiv
			if(resultSet.getInt("active")==1)
			{					
				System.out.println("Brugeren er aktiv");
				// Hvis passwords matcher
				if(resultSet.getString("password").equals(encryptionAES.encrypt(password)))
				{
					return "0";
					
					/*int userID = resultSet.getInt("userid");

					String[] key = {"type"};

					resultSet = qb.selectFrom(key, "roles").where("userid", "=", new Integer(userID).toString()).ExecuteQuery();
					// Hvis brugeren baade logger ind og er registreret som admin, eller hvis brugeren baade logger ind og er registreret som bruger
					if(resultSet.next())
					{ 
						if(resultSet.getString("type").equals("admin") && isAdmin || (resultSet.getString("type").equals("user") && !isAdmin))
						{
							return "0"; // returnerer "0" hvis bruger/admin er godkendt
						}
					} else {
						return "4"; // returnerer fejlkoden "4" hvis brugertype ikke stemmer overens med loginplatform
					}*/
				} else {
					return "3"; // returnerer fejlkoden "3" hvis password ikke matcher
				}
			} else {
				return "2"; // returnerer fejlkoden "2" hvis bruger er sat som inaktiv
			}
		} return "1"; // returnerer fejlkoden "1" hvis email ikke findes
	} 
}