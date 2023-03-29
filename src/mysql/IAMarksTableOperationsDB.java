package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class IAMarksTableOperationsDB {


	public static void insertintoIAMarksTable(String temp,String dept,int did){
		 
		Connection con = CP.createCon();
		System.out.println(temp.length());
	try {
		
		if(temp.length() == 10) {
			
			String USN = temp;
			int count;
			
			 if(dept.equals("CS")) {did=1;}
	    	 else if(dept.equals("IS")) {did=2;}
	    	 else if(dept.equals("AI")) {did=3;}
	    	 else if(dept.equals("DS")) {did=4;}
	    	 else if(dept.equals("ME")) {did=5;}
	    	 else if(dept.equals("CI")) {did=6;}
	    	 else if(dept.equals("EC")) {did=7;}
			
			String query1 = "select subcode from subjects where did=?;";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			
				pstmt1.setInt(1,did);
				ResultSet set1 = pstmt1.executeQuery();
				
				while(set1.next()) {
					String query2 = "insert into iamarks(USN,SUBCODE) values(?,?);";
					PreparedStatement pstmt2 = con.prepareStatement(query2);
					
					pstmt2.setString(1, USN);
					pstmt2.setString(2, set1.getString(1));
					pstmt2.executeUpdate();
				}
		}
		else if(temp.length() == 6 || temp.length()==7 || temp.length()==8) {
			
			String SUBCODE = temp;
			
			String query1 = "select s.usn from student s,stud_info si where s.si_id=si.si_id and si.did=?;";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			
				pstmt1.setInt(1,did);
				
				ResultSet set1 = pstmt1.executeQuery();
				
				while(set1.next()) {
					String query2 = "insert into iamarks(USN,SUBCODE) values(?,?);";
					PreparedStatement pstmt2 = con.prepareStatement(query2);
					
					pstmt2.setString(1, set1.getString(1));
					pstmt2.setString(2, SUBCODE);
					pstmt2.executeUpdate();
				}
			
		}
	}
	catch(Exception e) {}
	}
	
	public static void updateIAMarksTable(IAMarksTable iamt){
		 
		Random rand = new Random();
		Connection con = CP.createCon();
		String status ="";
		
		try {
			String query = "update iamarks set ia1=?,ia2=?,ia3=?,assgnmrks=?,finalia=?,SEE=?,TotalMrks=?,remarks=? where usn=? and subcode=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			int SEE = rand.nextInt(15,61);
			pstmt.setInt(1,iamt.getIA1());
			pstmt.setInt(2,iamt.getIA2());
			pstmt.setInt(3, iamt.getIA3());
			pstmt.setInt(4,iamt.getAssgnMrks());
			pstmt.setInt(5,iamt.getFinalIA());
			pstmt.setInt(6, SEE);
			pstmt.setInt(7, iamt.getFinalIA() + SEE);
			pstmt.setString(8, iamt.getReview());
			pstmt.setString(9,iamt.getUSN());
			pstmt.setString(10,iamt.getSUBCODE());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
