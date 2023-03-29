package swings;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import mysql.CP;
import mysql.GPATable;
import mysql.GPATableOperationsDB;
import mysql.IAMarksTable;
import mysql.IAMarksTableOperationsDB;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;
import mysql.SubjectsTableOperationsDB;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FacultyAttendanceStatusUpdation {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4;
	JComboBox<String> cb1,cb2;
	JButton b0,b1,b2,b3;
	DefaultTableModel tableMode1 = new DefaultTableModel() {
		 public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		 } 
	};
	JTable table = new JTable(tableMode1);
	JScrollPane sp,table_sp = new JScrollPane(table);;
	Border border1;
	
	//OTHER VARIBLES
	int FID;
	Connection con;
	String FacultyName,Gender,SubCode;
	int join_year,ay=2022;
	String si_id="";
	 ArrayList<String> arr = new ArrayList<>(50);
	 ResultSet set;
	 int column = 2,updatebtncount=0,cb2clickcount=0;
	
	public FacultyAttendanceStatusUpdation() {
		initialize();
	}
	
	public FacultyAttendanceStatusUpdation(int fid) {
		this.FID = fid;
		initialize();
	}
	
	public void  initialize() {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,1000);
		
		l0 = new JLabel("STUDENT  ACADEMIC  ASSESSMENT  SYSTEM  -  Sahyadri  College  of  Engineering  and  Management",SwingConstants.CENTER);
		l0.setBounds(50,0,1475,50);
		l0.setFont(new Font("Times New Roman",Font.PLAIN,22));
		
		l1 = new JLabel();
		l1.setBounds(30,10,150,100);
		ImageIcon imgic1 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\logo.png");
		Image img1 = imgic1.getImage();
		Image modifiedimage1 = img1.getScaledInstance(150,100,java.awt.Image.SCALE_SMOOTH);
		imgic1 = new ImageIcon(modifiedimage1);
		l1.setIcon(imgic1);
		
		l2 = new JLabel("STUDENT    ATTENDANCE    STATUS    UPDATION");
		l2.setBounds(400,45,850,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		
		try {
		    con = CP.createCon();
			String query = "select ffname,fgender,join_year from faculty where fid=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, FID);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				 FacultyName = set.getString(1);
				 Gender = set.getString(2);
				 join_year = set.getInt(3);
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
//		// ********************************** JTABLE  CONFIGURATIONS *****************************************************
		tableMode1.addColumn("Student ID");
		tableMode1.addColumn("USN");
		tableMode1.addColumn("NAME");
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );

		
		border1 = BorderFactory.createLineBorder(Color.cyan,2);
		table.setBorder(border1);
		table.setBounds(275,250,1050,450);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setSelectionForeground(Color.black);
		table.setFont(new Font("Aerial",Font.PLAIN,15));
		table.setRowHeight(50);
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setResizingAllowed(true);
//  	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredSize(new Dimension(0,3000));
		
  		table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
  		table.getTableHeader().setBackground(Color.BLUE);
  		table.getTableHeader().setForeground(Color.WHITE);

  		table_sp.setBounds(275,250,1050,450);
		table_sp.setBackground(Color.cyan);
		table_sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		table_sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		table_sp.getVerticalScrollBar().setUnitIncrement(16);
//		table_sp.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
	  		
//		************************************ REST  OF  CODE *********************************************************************
		
		
		b1 = new JButton("UPDATE");
		b1.setBounds(425,730,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
//				updatebtncount=1;			// Use FOR DEBUGGING PURPOSE ONLY
			
				if(updatebtncount==1) {
					
					 try { 
			  		    con = CP.createCon();
			  			String query = "select * from studentattendance where subcode in ( select subcode from teaches where FID=? and si_id=?) and usn in (select usn from student where si_id=?);";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setString(2, si_id);
			  			pstmt.setString(3, si_id);
			  			ResultSet set = pstmt.executeQuery();
			  			ResultSetMetaData setMD = set.getMetaData();

			  			while(set.next()) {
			  				
			  				 double AbsentCount=0,PresentCount=0,TotalCount=0,absentpercentage,presentpercentage;
			  				 
			  				 String usn = set.getString(1);
			  				 String subcode = set.getString(2);
			  				 
			  				for(int i=3; i<=setMD.getColumnCount(); i++) {
				  				String	attendance = set.getString(i);
				  				if(attendance == null) {continue;}
				  				else {
				  				if(attendance.equals("P")) {PresentCount+=1;TotalCount+=1;}
				  				else if(attendance.equals("AB")) {AbsentCount+=1;TotalCount+=1;}
			  					}
			  				}
			  				presentpercentage = (PresentCount/TotalCount)*100.00;
			  				absentpercentage = (AbsentCount/TotalCount)*100.00;		// in future if u want to display absent percent u can use this directly
			  				
			  				String qu = "update iamarks set attendance=? where usn=? and subcode=?;";
				  			PreparedStatement ps = con.prepareStatement(qu);
				  			ps.setInt(1, (int)presentpercentage);
				  			ps.setString(2, usn);
				  			ps.setString(3, subcode);
				  			ps.executeUpdate();
			  				}
			  			JOptionPane.showMessageDialog(frame,"Successful!! Attendence Status for class " + si_id.substring(4) + " updated successfully.","Information Message",JOptionPane.INFORMATION_MESSAGE);
				  		}
				  		catch(Exception ee) {
				  			ee.printStackTrace();
				  		}
				}
				else {
					JOptionPane.showMessageDialog(frame,"Unsuccessful!! Sorry, Cannot Send Duplicates.","Error Message",JOptionPane.ERROR_MESSAGE);
				}
				updatebtncount=0;
				
			}
		});
		b1.setVisible(false);
		
		b2 = new JButton("ADD");
		b2.setBounds(725,730,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("ADD") == true) {
					
					String m = null;
					m = JOptionPane.showInputDialog("Enter Date {dd/mm} ?");

					if ((m != null) && (m.length() > 0)) {
						
						column+=1;
						updatebtncount=1;
					    tableMode1.addColumn(m);
					    
					    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			  			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			  			for(int i=0; i<=column; i++) {table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );}
			  			
					     try {
				  		    con = CP.createCon();
				  			String query = "alter table studentattendance add column "+ m.substring(0,2) + "_" + m.substring(3,5) +" varchar(5);";
	
				  			PreparedStatement pstmt = con.prepareStatement(query);
				  			pstmt.executeUpdate();
				  			con.close();
					     }catch(Exception e1) {}
					     
//				  			*************************************************************************************************************
					     try {
//				    		si_id = arr.get(cb2.getSelectedIndex()-1);
				    	  
				    	    con = CP.createCon();
				  			String query2 = "select s.usn,s.sfname,s.slname from student s,teaches t where s.si_id=t.si_id and t.fid=? and t.si_id=?;";
		
				  			PreparedStatement pstmt2 = con.prepareStatement(query2);
				  			pstmt2.setInt(1, FID);
				  			pstmt2.setString(2, si_id);
				  			ResultSet set2 = pstmt2.executeQuery();
				  			int row=-1;
				  			
				  			while(set2.next()) {
				  				
				  				row+=1;
				  				String usn = set2.getString(1);
				  				String fname = set2.getString(2);
				  				String lname = set2.getString(3);
				  				
				  				Object[] options = { "PRESENT", "ABSENT"};
								int result = JOptionPane.showOptionDialog(null, "NAME : " + fname + " " + lname + "  USN : " + usn + " ?", "QUESTION",
								 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
								 null, options, options[0]);
								
								if(result==0) {
									
									tableMode1.setValueAt("P", row, column);
									
									String query3 = "update studentattendance set " + m.substring(0,2) + "_" + m.substring(3,5) + "=\"P\" where USN=? and SUBCODE=?;";
						  			PreparedStatement pstmt3 = con.prepareStatement(query3);
						  			pstmt3.setString(1, usn);
						  			pstmt3.setString(2, SubCode);
						  			pstmt3.executeUpdate();
								}
								else {
									
									tableMode1.setValueAt("AB", row, column);
									
									String query3 = "update studentattendance set " + m.substring(0,2) + "_" + m.substring(3,5) + "=\"AB\" where USN=? and SUBCODE=?;";
						  			PreparedStatement pstmt3 = con.prepareStatement(query3);
						  			pstmt3.setString(1, usn);
						  			pstmt3.setString(2, SubCode);
						  			pstmt3.executeUpdate();
								}
				  				
				  			}
			  		
					     }
						  	catch(Exception ee) {JOptionPane.showMessageDialog(frame,"Error!! Please Enter a Valid Date to Continue.","Error Message",JOptionPane.ERROR_MESSAGE);}
					} 				//ee.printStackTrace();
					else {}
					
				}
			}
		});
    	 b2.setVisible(false);
		
		l4 = new JLabel("Semester / Section  :  ");
	    l4.setBounds(980,150,300,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"      ---"};
		cb2 = new JComboBox<>(column2);
		cb2.setBounds(1230,175,140,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	   
	    b0 = new JButton();
		b0.setBounds(1400,175,50,50);
		b0.setBorder(new RoundedBorder(20));
		b0.setForeground(Color.BLUE);
		ImageIcon imgic0 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\update-icon.png");
		Image img0 = imgic0.getImage();
		Image modifiedimage0 = img0.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		imgic0 = new ImageIcon(modifiedimage0);
		b0.setIcon(imgic0);
		b0.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

					if(cb2clickcount>0) {
		    			 while (tableMode1.getRowCount()>0)
		    	          {
		    	             tableMode1.removeRow(0);   
		    	          }
		    		 }
					
					 try {
			    		 if(cb2.getItemCount()>=2 && cb2.getSelectedIndex()!=0) {
				    		  
				    		  si_id = arr.get(cb2.getSelectedIndex()-1);
//				    		  System.out.println(si_id);
				    		  
				    		  con = CP.createCon();
				    		  
				    		  String q = "select subcode from teaches where FID=? and SI_ID=?;";		// to get SUBCODE
				    		  PreparedStatement p = con.prepareStatement(q);
				    		  p.setInt(1, FID);
				    		  p.setString(2, si_id);
				    		  ResultSet s = p.executeQuery();
				    		  while(s.next()) {
				    			  SubCode = s.getString(1);
				    		  }
				  			String query = "select s.sid,s.usn,s.sfname,s.slname from student s,teaches t where s.si_id=t.si_id and t.fid=? and t.si_id=?;";
		
				  			PreparedStatement pstmt = con.prepareStatement(query);
				  			pstmt.setInt(1, FID);
				  			pstmt.setString(2, si_id);
				  			ResultSet set = pstmt.executeQuery();
				  		
					  		
				  			while(set.next()) {
				  				int sid = set.getInt(1);
				  				String usn = set.getString(2);
				  				String fname = set.getString(3);
				  				String lname = set.getString(4);
				  			
				  				Object data[] = {sid,usn,fname+" "+lname};
				  				tableMode1.addRow(data);
				  			}			
//				  			
				  			table_sp.setVisible(true);
				  			 b1.setVisible(true);
					    	 b2.setVisible(true);
				  			frame.add(table_sp);
				  			
				  			cb2clickcount+=1;
			    	  	}
			    	  }
			  	    catch(Exception a2) {
			  	    	a2.printStackTrace();
			  	    }
				}
//			}
		});
		
		l3 = new JLabel("Academic  Year  :   ");
	    l3.setBounds(200,150,300,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"      ---"};
		cb1 = new JComboBox<>(column1);
		cb1.setBounds(430,175,150,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  ay = Integer.parseInt(cb1value.trim());
		    	  
		    	 b1.setVisible(false);
		    	 b2.setVisible(false);
		    	  cb2.setSelectedIndex(0);
		    	  for(int i=cb2.getItemCount()-1; i>=1; i--) {
		  				cb2.removeItemAt(i);
		  			}
		    	  arr.removeAll(arr);
		    	  
		    	  try {
			  		    con = CP.createCon();
			  			String query = "select si_id from teaches where fid=? and FAcademicYear=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setInt(2, ay);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				String	si_id = set.getString(1);
			  				 arr.add(si_id);
			  				 
			  				 cb2.addItem("       " + si_id.substring(4));
			  				}
			  			}
			  		catch(Exception ee) {
			  			ee.printStackTrace();
			  		}
		      }
		    });
	    for(int i=join_year; i<=2022; i++) {
	    	cb1.addItem("     "+Integer.toString(i));
	    }
	    cb1.setSelectedItem("     " + Integer.toString(2022));
		
		
		b3 = new JButton("BACK");
		b3.setBounds(1050,730,125,50);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Faculty_Panel_Start sps = new Faculty_Panel_Start(FID,FacultyName,Gender,"panel4");
				}
			}
		});
	    
	    
		//PANEL 1 Add ON's
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l4);
		frame.add(cb2);
		frame.add(l3);
		frame.add(cb1);
		frame.add(b0);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.setVisible(true);
	}

	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
	
	public static void main(String[] args) {
		FacultyAttendanceStatusUpdation fasu  = new FacultyAttendanceStatusUpdation(2);
	}

}
