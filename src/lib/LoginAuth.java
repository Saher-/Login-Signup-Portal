package lib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginAuth {
	/**
	 * Read values from HTML Servlet connection.
	 */
	public User readHtml();
	
	/**
	 * Connect to Database and check for existing user.
	 * return: a boolean flag for matching data
	 */
	public boolean connectAndCheck(String name, String pin);
	
	/**
	 * Connect to Database and Add (Signup) the user to the database.
	 * return: a boolean flag for successful user addition.
	 */
	public boolean connectAndAdd(String name, String pin,
								 String email, long phone,
								 String dob, String pref, String lang);

}
