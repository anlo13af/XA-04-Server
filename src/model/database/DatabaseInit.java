package model.database;

import model.Model;
//import model.QueryBuild.QueryBuilder;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseInit extends Model {
	/**
	 * Creates the database environment if it doesn't already exist.
	 * @throws SQLException
	 * @throws IOException
	 */
    public void go() throws SQLException, IOException {

        if (doesDatabaseExist()) {
            System.out.print("Database environment does exist\n");
        } else {
            System.out.print("Database environment does NOT exist\n");
            readfromSqlFile("src/SQLFiles/cbscalendar.sql");
            System.out.println("\n\nDatabase environment created!");
        }

    }
}
