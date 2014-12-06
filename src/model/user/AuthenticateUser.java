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
			System.out.println("User found.");
			// Hvis brugeren er aktiv
			if(resultSet.getInt("active")==1)
			{					
				System.out.println("User is active.");
				// Hvis passwords matcher
				if(resultSet.getString("password").equals(encryptionAES.encrypt(password)))
				{
					System.out.println("Login succesful!");
					return "0"; //returnerer "0" hvis brugeren er godkendt
				} else {
					System.out.println("Login failed: wrong password.");
					return "3"; // returnerer fejlkoden "3" hvis password ikke matcher
				}
			} else {
				System.out.println("Login failed: user is inactive.");
				return "2"; // returnerer fejlkoden "2" hvis bruger er sat som inaktiv
			}
		} System.out.println("Login failed: user not found."); 
		return "1"; // returnerer fejlkoden "1" hvis email ikke findes
	} 
}