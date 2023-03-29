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

public class DisplayFacultySubjects {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4;
	JButton b1,b2;
	JScrollPane sp,sp1;
	Border border1;
	JTable table,table1;
	JPanel panel1,panel2;
	DefaultTableModel tableMode1,tableMode2;
	JComboBox cb1;
	
	//OTHER VARIABLES
	Connection con;
	String si_id;
	String FacultyName,Gender,dept;
	int FID,sem,scheme,did;
	int cb1index;
	int ay;
	
	public DisplayFacultySubjects() {
		initialize();	
	}
	
	public DisplayFacultySubjects(int fid) {
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
		
		l2 = new JLabel("MY  CURRENT  ACADEMIC  YEAR  SUBJECTS");
		l2.setBounds(440,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
	    
		
	  //PANEL 1 CREATION - HOME BUTTON CONTENTS
	    panel1 = new JPanel();
	    panel1.setBounds(0,220,1510,500);
	    panel1.setLayout(null);
//	    panel1.setSize(1510,500);
//		panel1.setPreferredSize(new Dimension(900,900));
	    
	    
	    try {
		    con = CP.createCon();
			String query = "select ffname,fgender,did from faculty where fid=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, FID);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				 FacultyName = set.getString(1);
				 Gender = set.getString(2);
				 did = set.getInt(3);
				 
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
			
			String query = " select s.subcode,s.sname,s.scheme,s.scredits,si.yearid,s.sem,t.si_id,t.FAcademicYear from teaches t,subjects s,stud_info si where t.subcode=s.subcode and t.si_id = si.si_id and t.fid=? and t.FAcademicYear=?;";
//			/select s.subcode,s.sname,s.scheme,s.credits,s.sem
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, FID);
			pstmt.setInt(2, 2022);
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
		 
			tableMode1.addColumn("SUB CODE");
			tableMode1.addColumn("SUB NAME");
			tableMode1.addColumn("SCHEME");
			tableMode1.addColumn("CREDITS");
			tableMode1.addColumn("BATCH");
			tableMode1.addColumn("SEM");
			tableMode1.addColumn("SECTION");
			tableMode1.addColumn("YEAR");
			
			while(set.next()) {
				String subcode = set.getString(1);
				String name = set.getString(2);
				int scheme = set.getInt(3);
				int credits = set.getInt(4);
				String batch = set.getString(5);
				int sem = set.getInt(6);
				String si_id = set.getString(7);
				int fay=set.getInt(8);
				

				Object data1[] = {subcode,name,scheme,credits,batch,sem,si_id.substring(5),fay};
				tableMode1.addRow(data1);
			}			
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
			
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
	    
	    //PANEL 2 Creation
	    panel2 = new JPanel();
	    panel2.setBounds(0,220,1510,500);
	    panel2.setLayout(null);
	    panel2.setVisible(false);
	    
	    //FRAME Continue...
	    
	    l3 = new JLabel("Acdmic  Year  :-");
	    l3.setBounds(40,130,300,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"     ---","     2015","     2016","     2017","     2018","     2019","     2020","     2021","     2022"};
		cb1 = new JComboBox(column1);
		cb1.setBounds(275,155,150,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  ay = Integer.parseInt(cb1value.trim());
//		    	  System.out.println(ay);
		      }
		    });
	    
	    cb1.setSelectedIndex(8);
	    
	    l4 = new JLabel("My  Department  :-   " + dept);
	    l4.setBounds(1050,130,500,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,30));
	    
	    b1 = new JButton("UPDATE");
		b1.setBounds(450,730,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					
					panel1.setVisible(false);
			    	  
			    	  try {
			  			
			  			con = CP.createCon();
			  			
			  			String query = "select s.subcode,s.sname,s.scheme,s.scredits,si.yearid,s.sem,t.si_id,t.FAcademicYear from teaches t,subjects s,stud_info si where t.subcode=s.subcode and t.si_id = si.si_id and t.fid=? and t.FAcademicYear=?;";
			  			
			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setInt(2, ay);
			  			ResultSet set2 = pstmt.executeQuery();
			  			
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
//			  			table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			  			table1.setPreferredSize(new Dimension(0,5000));
			  			
			  		 table1.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
			  		 table1.getTableHeader().setBackground(Color.BLUE);
			  		 table1.getTableHeader().setForeground(Color.WHITE);
			  		 
			  		tableMode2.addColumn("SUB CODE");
					tableMode2.addColumn("SUB NAME");
					tableMode2.addColumn("SCHEME");
					tableMode2.addColumn("CREDITS");
					tableMode2.addColumn("BATCH");
					tableMode2.addColumn("SEM");
					tableMode2.addColumn("SECTION");
					tableMode2.addColumn("YEAR");
					
					while(set2.next()) {
						String subcode = set2.getString(1);
						String name = set2.getString(2);
						int scheme = set2.getInt(3);
						int credits = set2.getInt(4);
						String batch = set2.getString(5);
						int sem = set2.getInt(6);
						String si_id = set2.getString(7);
						int fay=set2.getInt(8);
						

						Object data2[] = {subcode,name,scheme,credits,batch,sem,si_id.substring(5),fay};
						tableMode2.addRow(data2);
					}			
			  			
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
			  			
			  			sp1 = new JScrollPane(table1);
			  			sp1.setBounds(10,10,1500,470);
			  			sp1.setBackground(Color.cyan);
			  			sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			  			sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			  			sp1.getVerticalScrollBar().setUnitIncrement(16);
//			  			sp1.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
			  	
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
	    
		
		b2 = new JButton("BACK");
		b2.setBounds(925,730,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Faculty_Panel_Start sps = new Faculty_Panel_Start(FID,FacultyName,Gender,"panel7");
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
		frame.add(b1);
		frame.add(b2);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		DisplayFacultySubjects dfs = new DisplayFacultySubjects(2);
	}
}