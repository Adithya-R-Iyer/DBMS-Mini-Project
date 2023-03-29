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

public class StudentTopperzList {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5;
	JComboBox<String> cb2,cb3;
	JButton b0,b3;
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
	int FID=0;
	Connection con;
	String FacultyName,FacultyGender,StudentName,StudentGender,si_id="4SFXXXXXXX";
	int join_year,ay=2022,sem,did;
	String batch,dept;
	 ResultSet set;
	 int btncount=0;
	 String usn = "";
	
	public StudentTopperzList() {
		initialize();
	}
	
	public StudentTopperzList(int fid) {
		this.FID = fid;
		initialize();
	}
	
	public StudentTopperzList(String usn) {
		this.usn = usn;
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
		
		l2 = new JLabel("SAHYADRI    STUDENT    TOPPERz    LIST");
		l2.setBounds(400,45,850,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		
		try {
		    con = CP.createCon();
			String query = "select ffname,fgender,join_year,did from faculty where fid=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, FID);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				 FacultyName = set.getString(1);
				 FacultyGender = set.getString(2);
				 join_year = set.getInt(3);
				 did = set.getInt(4);
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			con = CP.createCon();
			
			String query = "Select SFNAME,SGENDER,si_id from student where usn=?;";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, usn);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				StudentName = set.getString(1);
				StudentGender = set.getString(2);
				si_id= set.getString(3);
				}
			
			if(si_id.substring(2,4).equals("CS")) {did=1;}
			else if(si_id.substring(2,4).equals("IS")) {did=2;}	
			else if(si_id.substring(2,4).equals("AI")) {did=3;}
			else if(si_id.substring(2,4).equals("DS")) {did=4;}
			else if(si_id.substring(2,4).equals("ME")) {did=5;}
			else if(si_id.substring(2,4).equals("CI")) {did=6;}
			else if(si_id.substring(2,4).equals("EC")) {did=7;}
			
		}
		catch(Exception ae) {
			ae.printStackTrace();
		}
		
//		// ********************************** JTABLE  CONFIGURATIONS *****************************************************
		tableMode1.addColumn("Student ID");
		tableMode1.addColumn("USN");
		tableMode1.addColumn("NAME");
		tableMode1.addColumn("TOTAL MARKS");
		tableMode1.addColumn("RANK");
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );

		border1 = BorderFactory.createLineBorder(Color.cyan,2);
		table.setBorder(border1);
		table.setBounds(200,240,1200,480);
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

  		table_sp.setBounds(200,240,1200,490);
		table_sp.setBackground(Color.cyan);
		table_sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		table_sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		table_sp.getVerticalScrollBar().setUnitIncrement(16);
//		table_sp.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
	  		
//		************************************ REST  OF  CODE *********************************************************************
		
		l5 = new JLabel("Batch  :");
	    l5.setBounds(40,135,150,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column3[] = {"        ---","   2018-22","   2019-23","   2020-24","   2021-25"};
		cb3 = new JComboBox(column3);
		cb3.setBounds(150,160,150,50);	
	    cb3.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb3value= cb3.getSelectedItem().toString();
		    	  batch = cb3value.trim();
		      }
		    });
	    
		
		
		l4 = new JLabel("Semester  :  ");
	    l4.setBounds(1070,135,300,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"       0","       1","       2","       3","       4","       5","       6","       7","       8"};
		cb2 = new JComboBox(column2);
		cb2.setBounds(1225,160,140,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb2value= cb2.getSelectedItem().toString();
		    	  sem = Integer.parseInt(cb2value.trim());
		      }
		    });
	   
	    b0 = new JButton();
		b0.setBounds(1400,160,50,50);
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

					if(btncount>0) {
		    			 while (tableMode1.getRowCount()>0)
		    	          {
		    	             tableMode1.removeRow(0);   
		    	          }
		    		 }
					 try {
				    		  con = CP.createCon();
				    		  
				  			String query = "select sid,sfname,slname,usn,sum(TotalMrks) as Total_Marks "
				  					+ "from iamarks NATURAL JOIN student "
				  					+ "where usn in "
				  					+ "(select usn from student where si_id in "
				  					+ "(select si_id from stud_info where did=? and (yearid,cid) in "
				  					+ "(select yearid,cid from class where yearid=? and csem=?))) and subcode in "
				  					+ "(select subcode from subjects where did=? and sem=?) "
				  					+ "group by usn having count(usn)>=1 order by Total_Marks DESC;";
		
				  			PreparedStatement pstmt = con.prepareStatement(query);
				  			pstmt.setInt(1, did);
				  			pstmt.setString(2, batch);
				  			pstmt.setInt(3, sem);
				  			pstmt.setInt(4, did);
				  			pstmt.setInt(5, sem);
				  			
				  			ResultSet set = pstmt.executeQuery();
				  			int rank=0;
					  		
				  			while(set.next()) {
				  				int sid = set.getInt(1);
				  				String fname = set.getString(2);
				  				String lname = set.getString(3);
				  				String usn = set.getString(4);
				  				int totalmrks = set.getInt(5);
				  				rank+=1;
				  				
				  				Object data[] = {sid,usn,fname+" "+lname,totalmrks,rank};
				  				tableMode1.addRow(data);
				  			}			
//				  			
				  			table_sp.setVisible(true);
				  			frame.add(table_sp);
				  			
				  			btncount+=1;
			    	  	}
			    	  
			  	    catch(Exception a2) {
			  	    	a2.printStackTrace();
			  	    }
				}
//			}
		});
		
			if(did==1) {dept="CSE";}
	   	 else if(did==2) {dept="ISE";}
	   	 else if(did==3) {dept="AIML";}
	   	 else if(did==4) {dept="DS";}
	   	 else if(did==5) {dept="MECH";}
	   	 else if(did==6) {dept="CIVIL";}
	   	 else if(did==7) {dept="ECE"; }
		
		
		l3 = new JLabel("My  Department  :-   " + dept);
	    l3.setBounds(500,135,300,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
		
		
		b3 = new JButton("BACK");
		b3.setBounds(700,740,125,50);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					if(usn.equals("")) {
					Faculty_Panel_Start sps = new Faculty_Panel_Start(FID,FacultyName,FacultyGender,"panel5");	
					}
					else if(FID==0) {
						Student_Panel_Start sps = new Student_Panel_Start(usn,StudentName,StudentGender,"panel3");
					}
				}
			}
		});
	    
	    
		//PANEL 1 Add ON's
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l4);
		frame.add(l5);
		frame.add(cb3);
		frame.add(cb2);
		frame.add(l3);
		frame.add(b0);
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
		StudentTopperzList stl  = new StudentTopperzList("4SF20CS004");
	}

}
