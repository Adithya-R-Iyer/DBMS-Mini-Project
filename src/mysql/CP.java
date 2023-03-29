package mysql;
import java.sql.*;

public class CP {

static Connection con;
	
	public static Connection createCon() {
		
		try {
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create Connection
			
		String user = "root";
		String password = "SK@@))@";
		String url = "jdbc:mysql://localhost:3306/dbms_mini_project";
		
		con = DriverManager.getConnection(url,user,password);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
