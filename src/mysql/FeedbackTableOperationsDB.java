package mysql;
import java.sql.*;

public class FeedbackTableOperationsDB {

	public static void updatefeedbacktable(FeedbackTable ft) throws SQLException {
		
		Connection con = CP.createCon();
		String query = "insert into feedback(SI_ID,FID,SUBCODE,USN,Punctuality,Regularity,Communication,Confidence,Rating,Review) values(?,?,?,?,?,?,?,?,?,?);";
		//"update feedback set Punctuality=?,Regularity=?,Communication=?,Confidence=?,Rating=?,Review=? where si_id=? and fid=? and subcode=? and usn=?;"
		//prepared stmt
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, ft.getSI_ID());
		pstmt.setInt(2, ft.getFID());
		pstmt.setString(3, ft.getSUBCODE());
		pstmt.setString(4, ft.getUSN());
		pstmt.setString(5, ft.getPunctuality());
		pstmt.setString(6, ft.getRegularity());
		pstmt.setString(7, ft.getCommunication());
		pstmt.setString(8, ft.getConfidence());
		pstmt.setInt(9, ft.getRating());
		pstmt.setString(10, ft.getReview());
		
		//exec..
		pstmt.executeUpdate();
	
}

}
