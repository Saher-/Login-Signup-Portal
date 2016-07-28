package lib;

public class User {
	private String name;
	private String pin;
	private String email;
	private long phone;
	private String dob;
	private String preferences;
	private String languages;
	
	/**
	 * Constructor
	 */
	public User(){}
	
	/**
	 * Get user name
	 * @param name
	 */
	public void setName(String _name) {
		name = _name;
	}
	
	/**
	 * Return user name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get user pin code
	 * @param _pin
	 */
	public void setPin(String _pin) {
		pin = _pin;
	}
	
	/**
	 * Return user pin code
	 * @return pin
	 */
	public String getPin() {
		return pin;
	}
	
	/**
	 * Get user email address
	 * @param _email
	 */
	public void setEmail(String _email) {
		email = _email;
	}
	
	/**
	 * Return user email address
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Get user phone number
	 * @param _phone
	 */
	public void setPhone(String _phone) {
		phone = Long.parseLong(_phone);
	}
	
	/**
	 * Return user phone number
	 * @return phone
	 */
	public long getPhone() {
		return phone;
	}
	
	/**
	 * Get user date of birth
	 * @param _dob
	 */
	public void setDob(String _dob) {
		dob = _dob;
	}
	
	/**
	 * Return user date of birth
	 * @return dob
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * Get user book preferences
	 * @param _pref
	 */
	public void setPreferences(String _pref) {
		preferences = _pref;
	}
	
	/**
	 * Return user book preferences
	 * @return preferences
	 */
	public String getPreferences() {
		return preferences;
	}
	
	/**
	 * Get user book languages
	 * @param _lang
	 */
	public void setLanguages(String _lang) {
		languages = _lang;
	}
	
	/**
	 * Return user book languages
	 * @return languages
	 */
	public String getLanguages() {
		return languages;
	}
}
