package lib;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class Login extends HttpServlet {
	boolean check = false;
	final User curUsr = new User();
	LoginAuthAdapter loginProcess = new LoginAuthAdapter(){
		// new implementation for this method.
		@Override
		public boolean connectAndCheck(String name, String pin) {
			final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
			final String DB_URL = "jdbc:oracle:thin:@localhost:1521/XE";
			
			final String USER = "Saher";
			final String PASS = "1234";
			
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			boolean ret = false;
			
			try {
				Class.forName(JDBC_DRIVER);
				
				// connect to database
				System.out.println("*****Connecting to Database*****");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				System.out.println("Connected...");
				
				// form SQL query
				System.out.println("Creating statement...");
			    stat = conn.createStatement();
			    String sql;
			    sql = "SELECT UsrName, Pin FROM login_auth";
			    rs = stat.executeQuery(sql);
			    
			    // get result set and compare user data
			    if (rs.next()){
			         //Retrieve by column name
			         String UsrName  = rs.getString("UsrName");
			         String Pin = rs.getString("Pin");

			         if (UsrName.equals(name) && Pin.equals(pin)) {
			        	 ret = true;
			         }
			         else {
			        	 ret = false;
			         }
			    }
			    else if (!rs.next()) {
			    	ret = false;
			    }
			} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
					try {
						rs.close();
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
			throws ServletException, IOException { }

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("*****Receiving Login Client Request*****");
		
		//Read form fields
		curUsr.setName(request.getParameter("name").toString());
		curUsr.setPin(request.getParameter("password").toString());
		
		//Print to console
		System.out.println(curUsr.getName());
		System.out.println(curUsr.getPin());
		
		//check back with DB
		check = loginProcess.connectAndCheck(curUsr.getName(), curUsr.getPin());
		
		System.out.println("*****Login Result*****");
		
		//Invalid info
		if (!check) {
			request.setAttribute("error", "Unrecognized User!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println("FAILED login!");
		}
		//Valid info
		else {
			System.out.println("SUCCESSFUL login!");
			request.setAttribute("name", curUsr.getName());
			request.setAttribute("password", curUsr.getPin());
			request.getRequestDispatcher("in.jsp").forward(request, response);
		}
		System.out.println("*****END*****\n");
	}
}
