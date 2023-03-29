package mysql;
import java.sql.*;

public class SubjectsTableOperationsDB {

	public static void insertintosubjectstable(SubjectsTable st) throws SQLException {
		
			Connection con = CP.createCon();
			String query = "insert into subjects(subcode,sname,did,scheme,scredits,sem) values(?,?,?,?,?,?)";
			
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, st.getSUBCODE());
			pstmt.setString(2, st.getSNAME());
			pstmt.setInt(3, st.getDID());
			pstmt.setInt(4, st.getSCHEME());
			pstmt.setInt(5, st.getSCREDITS());
			pstmt.setInt(6, st.getSEM());
			
			//exec..
			pstmt.executeUpdate();
		
	}
	
	public static void deletefromsubjectstable(String subcode) throws SQLException{
			
			
				Connection con = CP.createCon();
				String query,query1;
				
				query1 = "select sname from subjects where subcode=?;";
				PreparedStatement pstmt1 = con.prepareStatement(query1);
				pstmt1.setString(1, subcode);
				ResultSet set = pstmt1.executeQuery();
				
				if(set.next() == false) {
					throw new SQLException();
				}
				else {
				
					query = "delete from subjects where subcode=?;";
			
					//prepared stmt
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1,subcode);
					
					//exec..
					pstmt.executeUpdate();
				}
			
	}
	
	public static void updatesubjectstable(SubjectsTable st) throws SQLException {
		
		Connection con = CP.createCon();
		String query = "update subjects set SNAME=?,DID=?,SCHEME=?,SCREDITS=?,SEM=? where subcode=?;";
		
		//prepared stmt
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, st.getSNAME());
		pstmt.setInt(2, st.getDID());
		pstmt.setInt(3, st.getSCHEME());
		pstmt.setInt(4, st.getSCREDITS());
		pstmt.setInt(5, st.getSEM());
		pstmt.setString(6, st.getSUBCODE());
		
		//exec..
		pstmt.executeUpdate();
	
}
}
