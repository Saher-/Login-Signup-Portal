/*
 * THIS IS AN ADAPTER CLASS...
 * holding empty implementation for the class methods, 
 * which will be Overridden in the appropriate class (Login - SignUp).
 * */

package lib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAuthAdapter implements LoginAuth{
	public User readHtml() {return null;}
	
	public boolean connectAndCheck(String name, String pin) {return false;}
	
	public boolean connectAndAdd(String name, String pin,
								 String email, long phone,
								 String dob, String pref,
								 String lang) {return false;}
}
