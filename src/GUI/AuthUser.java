package GUI;

/**
 * Not used
 * @author andersliltorp
 *
 */
public class AuthUser {
	public boolean login(String userName, String password)
	{

		boolean u = false;

		try
		{	
				if( userName == "1" && password == "2" ){
					u = true;
				}				

				else
					u = false;

			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return u;
	}

}
