package lib;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import java.util.regex.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class Signup extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean check = false;
	final User curUsr = new User();
	LoginAuthAdapter signupProcess = new LoginAuthAdapter(){
		//New implementation for this method
		@Override
		public boolean connectAndAdd(String name, String pin, String email,
									 long phone, String dob, String pref,
									 String lang) {
			final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
			final String DB_URL = "jdbc:oracle:thin:@localhost:1521/XE";
			
			final String USER = "Saher";
			final String PASS = "1234";
			
			Connection conn = null;
			Statement stat = null;
			boolean ret = false;
			int countP = 6;
			int countL = 18;
			
			try {
				Class.forName(JDBC_DRIVER);
				
				// connect to database
				System.out.println("*****Connecting to Database*****");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				System.out.println("Connected...");
				
				// form SQL query
				System.out.println("Creating statement...");
			    stat = conn.createStatement();
			    			    
			    String sql = "INSERT INTO login_auth ("
			    		+ "ID, UsrName, Pin, "
						+ "Email, Phone, Dob, "
						+ "Pref1, Pref2, Pref3, Pref4, Pref5, "
						+ "Pref6, Pref7, Pref8, Pref9, Pref10, "
						+ "Pref11, Pref12, lang1, lang2, lang3)"
						+ "VALUES (seq_id.NEXTVAL,?,?,?,?,TO_DATE(?,'MM-DD-YYYY'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    
			    PreparedStatement Q = conn.prepareStatement(sql);
			    
			    // Set the values for the INSERT
//			    Q.setString(1, "");
			    Q.setString(1, name);
			    Q.setString(2, pin);
			    Q.setString(3, email);
			    Q.setLong(4, phone);
			    Q.setString(5, dob);
			    
			    // Split on comma
				String[] Pr = pref.split(",");
				String[] La = lang.split(",");
				
				for (String i : Pr) {
					Q.setString(countP, i);
					countP++;
				}
				while (countP <= 17) {
					Q.setString(countP, "null");
					countP++;
				}
				
				for (String x : La) {
					Q.setString(countL, x);
					countL++;
				}
				while (countL <= 20) {
					Q.setString(countL, "null");
					countL++;
				}
			    
				System.out.println(Q);
				
				int Y = Q.executeUpdate();
				
			    // Determine if the operation was a fail or success
			    if (Y > 0) {
			    	ret = true;
			    }
			    else {
			    	ret = false;
			    }
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						stat.close();
						conn.close();
						System.out.println("Closing database connection!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
			return ret;
		}
	};
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("WE ARE IN, GET!");
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("*****Receiving Signup Client Request*****");
		
		//Read form fields
		curUsr.setName(request.getParameter("f_name")); 
		curUsr.setPin(request.getParameter("f_pin"));
		curUsr.setEmail(request.getParameter("f_email"));
		curUsr.setPhone(request.getParameter("f_phone"));
		curUsr.setDob(request.getParameter("f_dob"));
		curUsr.setPreferences(request.getParameter("f_pref"));
		curUsr.setLanguages(request.getParameter("f_lang"));
		
		String name = curUsr.getName();
		String pin = curUsr.getPin();
		String email = curUsr.getEmail();
		long phone = curUsr.getPhone();
		String dob = curUsr.getDob();
		String pref = curUsr.getPreferences();
		String lang = curUsr.getLanguages();
		
		//Print to console
		System.out.println(name);
		System.out.println(pin);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(dob);
		System.out.println(pref);
		System.out.println(lang);
		
		//Add user to DB
		check = signupProcess.connectAndAdd(name, pin, email, phone, dob, pref, lang);
		
		System.out.println("*****Login Result*****");
		
		//Invalid info
		if (!check) {
			System.out.println("FAILED signup!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else {
			System.out.println("SUCCESSFUL signup!");
			request.setAttribute("name", name);
			request.setAttribute("pin", pin);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			request.setAttribute("dob", dob);
			request.setAttribute("pref", pref);
			request.setAttribute("lang", lang);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		System.out.println("*****END*****\n");
	}
}
