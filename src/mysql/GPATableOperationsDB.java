package mysql;

import java.sql.*;

public class GPATableOperationsDB {

	
	public static void insertintoGPAtable(GPATable gt) throws SQLException{
		 
		Connection con = CP.createCon();
		for(int i=1; i<=8; i++){
		String query = "insert into GPA(USN,SEM) values(?,?);";
		PreparedStatement pstmt = con.prepareStatement(query);
		
			pstmt.setString(1,gt.getUSN());
			pstmt.setInt(2,i);
			pstmt.executeUpdate();
		}
	}
	
	public static void deletefromgpatable(String USN) throws SQLException {
		
		
		Connection con = CP.createCon();
		String query;
	
			query = "delete from GPA where usn=?;";
	
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, USN);
			
			//exec..
			pstmt.executeUpdate();
		
}
	

	public static void updateGPAtable(GPATable gt) throws SQLException {
		
		Connection con = CP.createCon();
		String query = "update GPA set SGPA=? where USN=? and sem=?;";
		
		//prepared stmt
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setDouble(1, gt.getSGPA());
		pstmt.setString(2, gt.getUSN());
		pstmt.setInt(3, gt.getSem());
		
		//exec..
		pstmt.executeUpdate();
	
}
	
}
