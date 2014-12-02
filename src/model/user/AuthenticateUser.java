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
			// Hvis brugeren er aktiv
			if(resultSet.getInt("active")==1)
			{					
				System.out.println("Brugeren er aktiv");
				// Hvis passwords matcher
				if(resultSet.getString("password").equals(encryptionAES.encrypt(password)))
				{
					return "0"; //returnerer "0" hvis brugeren er godkendt
				} else {
					return "3"; // returnerer fejlkoden "3" hvis password ikke matcher
				}
			} else {
				return "2"; // returnerer fejlkoden "2" hvis bruger er sat som inaktiv
			}
		} return "1"; // returnerer fejlkoden "1" hvis email ikke findes
	} 
}