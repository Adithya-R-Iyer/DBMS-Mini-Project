package mysql;
import java.sql.*;
import swings.RemoveStudentRecord;

public class StudentTableOperationsDB {

	public static void insertintostudenttable(StudentTable st) throws SQLException{
		 
		
			Connection con = CP.createCon();
			String query = "insert into Student(sfname,slname,usn,sphno,scity,sgender,sdob,semail,si_id,susername,spassword) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, st.getSFNAME());
			pstmt.setString(2, st.getSLNAME());
			pstmt.setString(3, st.getUSN());
			pstmt.setString(4, st.getSPHNO());
			pstmt.setString(5, st.getSCITY());
			pstmt.setString(6, st.getSGENDER());
			pstmt.setString(7, st.getSDOB());
			pstmt.setString(8, st.getSEMAIL());
			pstmt.setString(9, st.getSI_ID());
			pstmt.setString(10, st.getUSERNAME());
			pstmt.setString(11, st.getPASSWORD());
			
			//exec..
			pstmt.executeUpdate();
		
	}
	
	public static void deletefromstudenttable(String USN) throws SQLException {
		
				
				Connection con = CP.createCon();
				String query,query1;
				
				query1 = "select sfname from student where usn=?;";
				PreparedStatement pstmt1 = con.prepareStatement(query1);
				pstmt1.setString(1, USN);
				ResultSet set = pstmt1.executeQuery();
				
				if(set.next() == false) {
					System.out.println("error");
					throw new SQLException();
				}
				else {
					
					query = "delete from STUDENT where usn=?;";
			
					//prepared stmt
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, USN);
					
					//exec..
					pstmt.executeUpdate();
				}
	}
	
	public static void updatestudenttable(StudentTable st) throws SQLException{
		 
		
		Connection con = CP.createCon();
		String query = "update Student set SFNAME=?,SLNAME=?,SPHNO=?,SCITY=?,SGENDER=?,SDOB=?,SEMAIL=?,si_id=? where usn=?";
		
		//prepared stmt
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, st.getSFNAME());
		pstmt.setString(2, st.getSLNAME());
		pstmt.setString(3, st.getSPHNO());
		pstmt.setString(4, st.getSCITY());
		pstmt.setString(5, st.getSGENDER());
		pstmt.setString(6, st.getSDOB());
		pstmt.setString(7, st.getSEMAIL());
		pstmt.setString(8, st.getSI_ID());
		pstmt.setString(9, st.getUSN());
		
		//exec..
		pstmt.executeUpdate();
	
}
	
	
}

