package mysql;
import java.sql.*;

public class FacultyTableOperationsDB {

public static void insertintofacultytable(FacultyTable ft) throws SQLException{
		
		
			Connection con = CP.createCon();
			String query = "insert into faculty(ffname,flname,fdesignation,fsalary,fphno,fcity,fgender,fdob,femail,did,username,password,join_year) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, ft.getFFNAME());
			pstmt.setString(2, ft.getFLNAME());
			pstmt.setString(3, ft.getFDESIGNATION());
			pstmt.setString(4, ft.getFSALARY());
			pstmt.setString(5, ft.getFPHNO());
			pstmt.setString(6, ft.getFCITY());
			pstmt.setString(7, ft.getFGENDER());
			pstmt.setString(8, ft.getFDOB());
			pstmt.setString(9, ft.getFEMAIL());
			pstmt.setInt(10, ft.getDID());
			pstmt.setString(11, ft.getUSERNAME());
			pstmt.setString(12, ft.getPASSWORD());
			pstmt.setInt(13, ft.getJoin_Year());
			//exec..
			pstmt.executeUpdate();
		
	}
	
	public static void deletefromfacultytable(int fid) throws SQLException{
			
		
				Connection con = CP.createCon();
				String query,query1;
				
				query1 = "select ffname from faculty where fid=?;";
				PreparedStatement pstmt1 = con.prepareStatement(query1);
				pstmt1.setInt(1, fid);
				ResultSet set = pstmt1.executeQuery();
				
				if(set.next() == false) {
					throw new SQLException();
				}
				else {
				
				query = "delete from faculty where fid=?;";
		
				//prepared stmt
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, fid);
				
				//exec..
				pstmt.executeUpdate();
				}
	}
	
	public static void updatefacultytable(FacultyTable ft) throws SQLException{
		
		
		Connection con = CP.createCon();
		String query = "update faculty set FFNAME=?,FLNAME=?,FDESIGNATION=?,FSALARY=?,FPHNO=?,FCITY=?,FGENDER=?,FDOB=?,FEMAIL=?,DID=? where FID=?;";
		
		//prepared stmt
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, ft.getFFNAME());
		pstmt.setString(2, ft.getFLNAME());
		pstmt.setString(3, ft.getFDESIGNATION());
		pstmt.setString(4, ft.getFSALARY());
		pstmt.setString(5, ft.getFPHNO());
		pstmt.setString(6, ft.getFCITY());
		pstmt.setString(7, ft.getFGENDER());
		pstmt.setString(8, ft.getFDOB());
		pstmt.setString(9, ft.getFEMAIL());
		pstmt.setInt(10, ft.getDID());
		pstmt.setInt(11, ft.getFID());
		
		//exec..
		pstmt.executeUpdate();
	
}
}
