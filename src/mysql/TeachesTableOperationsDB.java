package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class TeachesTableOperationsDB {

	public static void insertintoTeachesTable(TeachesTable t) throws SQLException{
		 
		Random rand = new Random();
		Connection con = CP.createCon();
		String status ="";
		
			String query = "insert into teaches values(?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			int SEE = rand.nextInt(0,61);
			pstmt.setString(1,t.getSI_ID());
			pstmt.setInt(2,t.getFID());
			pstmt.setString(3, t.getSUBCODE());
			pstmt.setInt(4,t.getFAcademicYear());
			pstmt.executeUpdate();

	}
}
