package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.lang.*;

import mysql.CP;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class StudentAcademicEligibility {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4;
	JButton b1,b2,b3;
	JScrollPane sp,sp1,sp2,sp3;
	Border border1;
	JTable table,table1,table2,table3;
	JPanel panel1,panel2,panel3,panel4;
	DefaultTableModel tableMode1,tableMode2,tableMode3,tableMode4;
	JComboBox<String> cb1;
	
	//OTHER VARIABLES
	Connection con;
	String si_id;
	String FacultyName,Gender,dept;
	int FID,sem,scheme,did;
	int cb1index;
	int ay;
	int cb1val;
	
	//TABLE variables
	String BATCH,DEPT,SEC;
	int SEM,join_year;
	int p2btncount=0,p3btncount=0,p4btncount=0;
	
	
	public StudentAcademicEligibility() {
		initialize();	
	}
	
	public StudentAcademicEligibility(int fid) {
		this.FID = fid;
		initialize();	
	}
	
	public void initialize()  {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,875);
		
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
		
		l2 = new JLabel("STUDENT  ACADEMIC  ELIGIBIITY  STATUS");
		l2.setBounds(440,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
	    
		
	  //PANEL 1 CREATION - HOME BUTTON CONTENTS
	    panel1 = new JPanel();
	    panel1.setBounds(0,220,1510,500);
	    panel1.setLayout(null);
//	    panel1.setSize(1510,500);
//		panel1.setPreferredSize(new Dimension(900,900));
	    
	    //PANEL 2 Creation
	    panel2 = new JPanel();
	    panel2.setBounds(0,220,1510,500);
	    panel2.setLayout(null);
	    panel2.setVisible(false);
	    
	    tableMode2 = new DefaultTableModel() {
				 public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				 } 
			};
			
			table1 = new JTable(tableMode2);
			
			border1 = BorderFactory.createLineBorder(Color.cyan,2);
			table1.setBorder(border1);
			table1.setBounds(10,10,1500,470);
			table1.setBackground(Color.black);
			table1.setForeground(Color.white);
			table1.setSelectionBackground(Color.red);
			table1.setGridColor(Color.red);
			table1.setSelectionForeground(Color.black);
			table1.setFont(new Font("Aerial",Font.PLAIN,15));
			table1.setRowHeight(50);
			table1.setAutoCreateRowSorter(true);
			table1.getTableHeader().setResizingAllowed(true);
//			table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table1.setPreferredSize(new Dimension(0,5000));
			
		 table1.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		 table1.getTableHeader().setBackground(Color.BLUE);
		 table1.getTableHeader().setForeground(Color.WHITE);
		 
		tableMode2.addColumn("BATCH");
		tableMode2.addColumn("DEPARTMENT");
		tableMode2.addColumn("ACDMIC YR");
		tableMode2.addColumn("SEMESTER");
		tableMode2.addColumn("SECTION");
		tableMode2.addColumn("STRENGTH");
		tableMode2.addColumn("SUBCODE");
		tableMode2.addColumn("SUB NAME");
		tableMode2.addColumn("YEAR OF STUDY");
	    

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
		table1.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
		
		table1.setColumnSelectionAllowed(false);
		table1.setRowSelectionAllowed(true);
		
		sp1 = new JScrollPane(table1);
			sp1.setBounds(10,10,1500,470);
			sp1.setBackground(Color.cyan);
			sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp1.getVerticalScrollBar().setUnitIncrement(16);
//			sp1.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
		
	    
	    //PANEL 3 Creation
	    panel3 = new JPanel();
	    panel3.setBounds(0,220,1510,500);
	    panel3.setLayout(null);
	    panel3.setVisible(false);
	    
	    tableMode3 = new DefaultTableModel() {
				 public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				 } 
			};
			
			table2 = new JTable(tableMode3);
			
			border1 = BorderFactory.createLineBorder(Color.cyan,2);
			table2.setBorder(border1);
			table2.setBounds(10,10,1500,470);
			table2.setBackground(Color.black);
			table2.setForeground(Color.white);
			table2.setSelectionBackground(Color.red);
			table2.setGridColor(Color.red);
			table2.setSelectionForeground(Color.black);
			table2.setFont(new Font("Aerial",Font.PLAIN,15));
			table2.setRowHeight(50);
			table2.setAutoCreateRowSorter(true);
			table2.getTableHeader().setResizingAllowed(true);
//			table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table2.setPreferredSize(new Dimension(0,5000));
			
		 table2.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		 table2.getTableHeader().setBackground(Color.BLUE);
		 table2.getTableHeader().setForeground(Color.WHITE);
		
		tableMode3.addColumn("SID");
		tableMode3.addColumn("NAME");
		tableMode3.addColumn("USN");
		tableMode3.addColumn("I/A Average.");
		tableMode3.addColumn("Attendance Status");
	
//	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table2.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table2.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table2.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table2.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		sp2 = new JScrollPane(table2);
		sp2.setBounds(10,10,1500,470);
		sp2.setBackground(Color.cyan);
		sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp2.getVerticalScrollBar().setUnitIncrement(16);
//		sp2.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
		
	    
	  //PANEL 4 Creation
	    panel4 = new JPanel();
	    panel4.setBounds(0,220,1510,500);
	    panel4.setLayout(null);
	    panel4.setVisible(false);
	    
	    tableMode4 = new DefaultTableModel() {
				 public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				 } 
			};
			
			table3 = new JTable(tableMode4);
			
			border1 = BorderFactory.createLineBorder(Color.cyan,2);
			table3.setBorder(border1);
			table3.setBounds(10,10,1500,470);
			table3.setBackground(Color.black);
			table3.setForeground(Color.white);
			table3.setSelectionBackground(Color.red);
			table3.setGridColor(Color.red);
			table3.setSelectionForeground(Color.black);
			table3.setFont(new Font("Aerial",Font.PLAIN,15));
			table3.setRowHeight(50);
			table3.setAutoCreateRowSorter(true);
			table3.getTableHeader().setResizingAllowed(true);
//			table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table3.setPreferredSize(new Dimension(0,5000));
			
		 table3.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		 table3.getTableHeader().setBackground(Color.BLUE);
		 table3.getTableHeader().setForeground(Color.WHITE);
		
		tableMode4.addColumn("SID");
		tableMode4.addColumn("NAME");
		tableMode4.addColumn("USN");
		tableMode4.addColumn("I/A Average.");
		tableMode4.addColumn("Attendance Status");
	

//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table3.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table3.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table3.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table3.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table3.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		sp3 = new JScrollPane(table3);
		sp3.setBounds(10,10,1500,470);
		sp3.setBackground(Color.cyan);
		sp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp3.getVerticalScrollBar().setUnitIncrement(16);
//		sp3.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));

	    
	    
	    try {
		    con = CP.createCon();
			String query = "select ffname,fgender,did,join_year from faculty where fid=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, FID);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				 FacultyName = set.getString(1);
				 Gender = set.getString(2);
				 did = set.getInt(3);
				 join_year = set.getInt(4);
				 
				 if(did==1) {dept="CSE";}
		    	 else if(did==2) {dept="ISE";}
		    	 else if(did==3) {dept="AIML";}
		    	 else if(did==4) {dept="DS";}
		    	 else if(did==5) {dept="MECH";}
		    	 else if(did==6) {dept="CIVIL";}
		    	 else if(did==7) {dept="ECE"; }
				
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	    
	    
	    
	    try {
			
			con = CP.createCon();
			
			String query = "select si.yearid,si.did,c.yearofstudy,c.csem,c.section,c.CLASSSTDCOUNT,t.SUBCODE,s.sname,t.FAcademicYear from stud_info si,class c,teaches t,subjects s where si.cid=c.cid and si.si_id = t.si_id and t.subcode=s.subcode  and t.facademicyear=? and t.fid=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 2022);
			pstmt.setInt(2, FID);
			ResultSet set = pstmt.executeQuery();			
			
			 tableMode1 = new DefaultTableModel() {
				 public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				 } 
			};
			
			table = new JTable(tableMode1);
			
			border1 = BorderFactory.createLineBorder(Color.cyan,2);
			table.setBorder(border1);
			table.setBounds(10,10,1500,470);
			table.setBackground(Color.black);
			table.setForeground(Color.white);
			table.setSelectionBackground(Color.red);
			table.setGridColor(Color.red);
			table.setSelectionForeground(Color.black);
			table.setFont(new Font("Aerial",Font.PLAIN,15));
			table.setRowHeight(50);
			table.setAutoCreateRowSorter(true);
			table.getTableHeader().setResizingAllowed(true);
//			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setPreferredSize(new Dimension(0,5000));
			
		 table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		 table.getTableHeader().setBackground(Color.BLUE);
		 table.getTableHeader().setForeground(Color.WHITE);
		 
			tableMode1.addColumn("BATCH");
			tableMode1.addColumn("DEPARTMENT");
			tableMode1.addColumn("ACDMIC YR");
			tableMode1.addColumn("SEMESTER");
			tableMode1.addColumn("SECTION");
			tableMode1.addColumn("STRENGTH");
			tableMode1.addColumn("SUBCODE");
			tableMode1.addColumn("SUB NAME");
			tableMode1.addColumn("YEAR OF STUDY");
			
			while(set.next()) {
				String yearid = set.getString(1);
				int did = set.getInt(2);
				int acd_yr = set.getInt(3);
				int sem = set.getInt(4);
				String section = set.getString(5);
				int count = set.getInt(6);
				String subcode = set.getString(7);
				String subname = set.getString(8);
				int yr_of_study = set.getInt(9);
				String dept="";
				
				if(did==1) {dept="CSE";}
		    	 else if(did==2) {dept="ISE";}
		    	 else if(did==3) {dept="AIML";}
		    	 else if(did==4) {dept="DS";}
		    	 else if(did==5) {dept="MECH";}
		    	 else if(did==6) {dept="CIVIL";}
		    	 else if(did==7) {dept="ECE"; }
				

				Object data1[] = {yearid,dept,acd_yr,sem,section,count,subcode,subname,yr_of_study};
				tableMode1.addRow(data1);
			}			
			
//			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
			
			table.setColumnSelectionAllowed(false);
  			table.setRowSelectionAllowed(true);
			
//  	********************************************** MOUSE LISTENER ***********************************************		
			table.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
			    	if(e.getClickCount()==1) {
			    		table.clearSelection();
			    	}
			    	else if (e.getClickCount() == 2) {
			    	  
			    	  int row = table.getSelectedRow();
			    	  table.clearSelection();
			    	  
//			    	  System.out.println(row);
			    	  BATCH = (String) table.getModel().getValueAt(row,0);
			    	  DEPT = (String) table.getModel().getValueAt(row,1);
			    	  SEM = (int) table.getModel().getValueAt(row,3);
			    	  SEC = (String) table.getModel().getValueAt(row,4);
			    	   
			    	  panel2.setVisible(false);
			    	  panel1.setVisible(false);
			    	  panel4.setVisible(false);
			    	  
			    	  if(p3btncount>0) {
			    			 while (tableMode3.getRowCount()>0)
			    	          {
			    	             tableMode3.removeRow(0);   
			    	          }
				    		 }
			    	  
			    	  try {
				  			
				  			con = CP.createCon();
				  			String SI_ID = BATCH.substring(2,4) + DEPT.substring(0,2) + SEM + SEC;
				  			
				  			
				  			String query = "select s.sid,s.sfname,s.slname,s.usn,ae.status,ae.eligibility from student s,academiceligibility ae,teaches t where s.USN=ae.USN and s.si_id =t.si_id and ae.subcode = t.subcode and t.fid=? and t.si_id=?;";
				  			
				  			PreparedStatement pstmt = con.prepareStatement(query);
				  			pstmt.setInt(1, FID);
				  			pstmt.setString(2, SI_ID);
				  			ResultSet set3 = pstmt.executeQuery();
//				  			
						while(set3.next()) {
							int sid = set3.getInt(1);
							String fname = set3.getString(2);
							String lname = set3.getString(3);
							String usn = set3.getString(4);
							String status = set3.getString(5);
							String eligibility = set3.getString(6);
							
							if(status.equals("PASS")) {
								status = "Eligibile";
							}
							else if(status.equals("FAIL")){
								status = "Not Eligible";
							}
				
							Object data3[] = {sid,fname + " " + lname,usn,status,eligibility};
							tableMode3.addRow(data3);
						}			
				  			
						p3btncount +=1;
				  	    }
				  	    catch(Exception a) {
				  	    	a.printStackTrace();
				  	    }
//				    	  System.out.println("Entered");
				    	  panel3.add(sp2);
				  	    panel3.setVisible(true);
			      }
			    }
			});
			
			sp = new JScrollPane(table);
			sp.setBounds(10,10,1500,470);
			sp.setBackground(Color.cyan);
			sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp.getVerticalScrollBar().setUnitIncrement(16);
//			sp.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
	
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    panel1.add(sp);
	    panel1.setVisible(true);
	    
	    
	    //FRAME Continue...
	    
	    l3 = new JLabel("Acdmic  Year  :-");
	    l3.setBounds(40,130,300,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"      ---"};
		cb1 = new JComboBox<>(column1);
		cb1.setBounds(275,155,150,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
//		    	  cb1val = cb1.getSelectedIndex();
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  ay = Integer.parseInt(cb1value.trim());
//		    	  System.out.println(ay);
		      }
		    });
	    for(int i=join_year; i<=2022; i++) {
	    	cb1.addItem("     "+Integer.toString(i));
	    }
	    
	    
	    cb1.setSelectedItem("     " + 2022);
	    
	    l4 = new JLabel("My  Department  :-   " + dept);
	    l4.setBounds(1050,130,500,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,30));
	    
	    b1 = new JButton("UPDATE");
		b1.setBounds(400,730,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					
					panel1.setVisible(false);
			    	panel3.setVisible(false); 
					panel4.setVisible(false);
					
					if(p2btncount>0) {
		    			 while (tableMode2.getRowCount()>0)
		    	          {
		    	             tableMode2.removeRow(0);   
		    	          }
			    		 }
			    	
			    	  try {
			  			
			  			con = CP.createCon();
			  			
			  			String query = "select si.yearid,si.did,c.yearofstudy,c.csem,c.section,c.CLASSSTDCOUNT,t.SUBCODE,s.sname,t.FAcademicYear from stud_info si,class c,teaches t,subjects s where si.cid=c.cid and si.si_id = t.si_id and t.subcode=s.subcode  and t.facademicyear=? and t.fid=?;";
			  			
			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(2, FID);
			  			pstmt.setInt(1, ay);
			  			ResultSet set2 = pstmt.executeQuery();
			  			
					while(set2.next()) {
						String yearid = set2.getString(1);
						int did = set2.getInt(2);
						int acd_yr = set2.getInt(3);
						int sem = set2.getInt(4);
						String section = set2.getString(5);
						int count = set2.getInt(6);
						String subcode = set2.getString(7);
						String subname = set2.getString(8);
						int yr_of_study = set2.getInt(9);
						String dept="";
						
						if(did==1) {dept="CSE";}
				    	 else if(did==2) {dept="ISE";}
				    	 else if(did==3) {dept="AIML";}
				    	 else if(did==4) {dept="DS";}
				    	 else if(did==5) {dept="MECH";}
				    	 else if(did==6) {dept="CIVIL";}
				    	 else if(did==7) {dept="ECE"; }
						

						Object data2[] = {yearid,dept,acd_yr,sem,section,count,subcode,subname,yr_of_study};
						tableMode2.addRow(data2);
					}			
//			  			
//			  			**************************************************** panel 4 creation mouse listener *****************************
			  			table1.addMouseListener(new MouseAdapter() {
						    public void mouseClicked(MouseEvent e) {
						    	if(e.getClickCount()==1) {
						    		table1.clearSelection();
						    	}
						    	else if (e.getClickCount() == 2) {
						    	  
						    	  int row = table1.getSelectedRow();
						    	  table1.clearSelection();
//						    	  System.out.println(row);
						    	  BATCH = (String) table1.getModel().getValueAt(row,0);
						    	  DEPT = (String) table1.getModel().getValueAt(row,1);
						    	  SEM = (int) table1.getModel().getValueAt(row,3);
						    	  SEC = (String) table1.getModel().getValueAt(row,4);
						    	   
						    	  panel3.setVisible(false);
						    	  panel2.setVisible(false);
						    	  panel1.setVisible(false);
						    	
						    	  if(p4btncount>0) {
						    			 while (tableMode4.getRowCount()>0)
						    	          {
						    	             tableMode4.removeRow(0);   
						    	          }
							    		 }
						    	  
						    	  try {
							  			
							  			con = CP.createCon();
							  			String SI_ID = BATCH.substring(2,4) + DEPT.substring(0,2) + SEM + SEC;
							  			
							  			
							  			String query = "select s.sid,s.sfname,s.slname,s.usn,ae.status,ae.eligibility from student s,academiceligibility ae,teaches t where s.USN=ae.USN and s.si_id =t.si_id and ae.subcode = t.subcode and t.fid=? and t.si_id=?;";
							  			
							  			PreparedStatement pstmt = con.prepareStatement(query);
							  			pstmt.setInt(1, FID);
							  			pstmt.setString(2, SI_ID);
							  			ResultSet set4 = pstmt.executeQuery();
							  			
									while(set4.next()) {
										int sid = set4.getInt(1);
										String fname = set4.getString(2);
										String lname = set4.getString(3);
										String usn = set4.getString(4);
										String status = set4.getString(5);
										String eligibility = set4.getString(6);
										
										if(status.equals("PASS")) {
											status = "Eligibile";
										}
										else if(status.equals("FAIL")){
											status = "Not Eligible";
										}
							
										Object data4[] = {sid,fname + " " + lname,usn,status,eligibility};
										tableMode4.addRow(data4);
									}			
//							  		
									p4btncount+=1;
							  	    }
							  	    catch(Exception a) {
							  	    	a.printStackTrace();
							  	    }
//							    	  System.out.println("Entered");
							    	  panel4.add(sp3);
							  	    panel4.setVisible(true);
						      }
						    }
						});
			  		
			  			p2btncount+=1;
			  	    }
			  	    catch(Exception a) {
			  	    	a.printStackTrace();
			  	    }
//			    	  System.out.println("Entered");
			    	  panel2.add(sp1);
			  	    panel2.setVisible(true);
				}
			}
		});
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
	    			
		        }
	    	}
	    });
	    
		b3 = new JButton("PREVIOUS");
		b3.setBounds(650,730,150,50);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("PREVIOUS") == true) {
					
						panel4.setVisible(false);
						panel3.setVisible(false);
						panel2.setVisible(false);
						panel1.setVisible(true);
						cb1.setSelectedItem("     " + 2022);
					
				}
			}
		});
		
		b2 = new JButton("BACK");
		b2.setBounds(925,730,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Faculty_Panel_Start sps = new Faculty_Panel_Start(FID,FacultyName,Gender,"panel4");
				}
			}
		});
		
		
		//Frame Add On's
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(cb1);	
		frame.add(l4);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(b1);
		frame.add(b3);
		frame.add(b2);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		StudentAcademicEligibility sae = new StudentAcademicEligibility(2);
	}
}