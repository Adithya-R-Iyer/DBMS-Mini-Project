package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcademicAchievementsTableOperationsDB {

	
	public static void insertintoacademicachievementstable(AcademicAchievementsTable aat) throws SQLException {
		
		Connection con = CP.createCon();
		String query = "update academicachievements set snoproj=?,sinternship=? where usn=?";
		
		//prepared stmt
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, aat.getSNoProj());
		pstmt.setInt(2, aat.getSInternShip());
		pstmt.setString(3, aat.getUSN());
		//exec..
		pstmt.executeUpdate();
	
	}
}
