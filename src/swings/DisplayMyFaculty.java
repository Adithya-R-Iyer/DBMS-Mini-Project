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

public class DisplayMyFaculty {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3;
	JButton b1,b2;
	JScrollPane sp,sp1;
	Border border1;
	JTable table,table1;
	JPanel panel1,panel2;
	DefaultTableModel tableMode1,tableMode2;
	JComboBox cb1;
	
	//OTHER VARIABLES
	Connection con;
	String USN,si_id;
	String StudentName,Gender,dept;
	int sem,scheme,did;
	int btncount=0;
	
	public DisplayMyFaculty() {
		initialize();	
	}
	
	public DisplayMyFaculty(String usn) {
		this.USN = usn;
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
		
		l2 = new JLabel("MY  CURRENT  SEMESTER  FACULTIES");
		l2.setBounds(440,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
	    
		
	  //PANEL 1 CREATION - HOME BUTTON CONTENTS
	    panel1 = new JPanel();
	    panel1.setBounds(0,220,1510,500);
	    panel1.setLayout(null);
		
	    try {
		
		con = CP.createCon();
		
		String query = "Select SFNAME,SGENDER,si_id from student where usn=?;";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, USN);
		ResultSet set = pstmt.executeQuery();
		
		while(set.next()) {
			StudentName = set.getString(1);
			Gender = set.getString(2);
			si_id= set.getString(3);
			}
		
		sem = Integer.parseInt(si_id.substring(4,5));
		
		int sch = Integer.parseInt(si_id.substring(0,2));
		
		if(sch<15) {
			scheme=2013;
		}
		else if(sch==15 || sch==16 || sch==17) {
			scheme=2015;
		}
		else if(sch==18 || sch==19 || sch==20) {
			scheme=2018;
		}
		else if(sch>20) {
			scheme=2021;
		}
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
			
			con = CP.createCon();
			
			// TABLES - FACULTY  SUBJECTS  TEACHES
			String query = "Select f.FID,f.FFNAME,f.FLNAME,f.FDESIGNATION,f.FGENDER,f.FPHNO,f.FEMAIL,s.subcode,s.SNAME,f.did from teaches t,faculty f,subjects s where t.subcode=s.subcode and t.FID=f.FID and si_id=?;";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, si_id);
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
			table.setPreferredSize(new Dimension(0,5000));
			
		 table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		 table.getTableHeader().setBackground(Color.BLUE);
		 table.getTableHeader().setForeground(Color.WHITE);
		 
			tableMode1.addColumn("FID");
		 	tableMode1.addColumn("FIRST NAME");
			tableMode1.addColumn("LAST NAME");
			tableMode1.addColumn("DESIGNATION");
			tableMode1.addColumn("GENDER");
			tableMode1.addColumn("PHONE NO.");
			tableMode1.addColumn("EMAIL");
			tableMode1.addColumn("SUB CODE");
			tableMode1.addColumn("SUB NAME");
			
			while(set.next()) {
				int fid = set.getInt(1);
				String fname = set.getString(2);
				String lname = set.getString(3);
				String desgn = set.getString(4);
				String gender = set.getString(5);
				String phno = set.getString(6);
				String email = set.getString(7);
				String subcode = set.getString(8);
				String subname = set.getString(9);
				int did = set.getInt(10);
				String dept="";
				
				 if(did==1) {dept="CSE";}
		    	 else if(did==2) {dept="ISE";}
		    	 else if(did==3) {dept="AIML";}
		    	 else if(did==4) {dept="DS";}
		    	 else if(did==5) {dept="MECH";}
		    	 else if(did==6) {dept="CIVIL";}
		    	 else if(did==7) {dept="ECE"; }
				
				Object data1[] = {fid,fname,lname,desgn + " - " +dept,gender,phno,email,subcode,subname};
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
			table.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
			
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
		table1.setPreferredSize(new Dimension(0,5000));
		
	 table1.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
	 table1.getTableHeader().setBackground(Color.BLUE);
	 table1.getTableHeader().setForeground(Color.WHITE);
	 
		tableMode2.addColumn("FID");
	 	tableMode2.addColumn("FIRST NAME");
		tableMode2.addColumn("LAST NAME");
		tableMode2.addColumn("DESIGNATION");
		tableMode2.addColumn("GENDER");
		tableMode2.addColumn("PHONE NO.");
		tableMode2.addColumn("EMAIL");
		tableMode2.addColumn("SUB CODE");
		tableMode2.addColumn("SUB NAME");
		
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
		
		sp1 = new JScrollPane(table1);
		sp1.setBounds(10,10,1500,470);
		sp1.setBackground(Color.cyan);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.getVerticalScrollBar().setUnitIncrement(16);
//		sp1.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
	    
	    
	    //FRAME Continue...
	    
	    l3 = new JLabel("                My  Current  SEM  :-                                                             Current  Scheme  of  Study  :-  " + scheme);
	    l3.setBounds(40,130,1500,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
	    
	    String column1[] = {"    0","    1","    2","    3","    4","    5","    6","    7","    8"};
		cb1 = new JComboBox(column1);
		cb1.setBounds(450,155,125,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  sem = Integer.parseInt(cb1value.trim());
//		    	  cb1index = cb1.getSelectedIndex();
		      }
		    });
	    cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
			}
	    });
	    
	    if(sem==1) {
	    	cb1.setSelectedIndex(1);
	    }
	    else if(sem==2) {
	    	cb1.setSelectedIndex(2);
	    }
	    else if(sem==3) {
	    	cb1.setSelectedIndex(3);
	    }
	    else if(sem==4) {
	    	cb1.setSelectedIndex(4);
	    }
	    else if(sem==5) {
	    	cb1.setSelectedIndex(5);
	    }
	    else if(sem==6) {
	    	cb1.setSelectedIndex(6);
	    }
	    else if(sem==7) {
	    	cb1.setSelectedIndex(7);
	    }
	    else if(sem==8) {
	    	cb1.setSelectedIndex(8);
	    }
	    
	    b1 = new JButton("UPDATE");
		b1.setBounds(450,730,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					
					if(sem>Integer.parseInt(si_id.substring(4,5))) {
						JOptionPane.showMessageDialog(frame,"Error!! Please choose a valid semester to continue.","Error Message",JOptionPane.ERROR_MESSAGE);
						cb1.setSelectedIndex(5);
						panel2.setVisible(false);
						panel1.setVisible(true);
						panel1.setOpaque(true);
						return;
					}
					
					panel1.setVisible(false);
					if(btncount>0){
					 while (tableMode2.getRowCount()>0)
	    	          {
	    	             tableMode2.removeRow(0);   
	    	          }
					}
			    	String new_si_id = si_id.substring(0,4) + sem + si_id.substring(5);  
			    	
					try {
						
						con = CP.createCon();
						
						// TABLES - FACULTY  SUBJECTS  TEACHES
						String query = "Select f.FID,f.FFNAME,f.FLNAME,f.FDESIGNATION,f.FGENDER,f.FPHNO,f.FEMAIL,s.subcode,s.SNAME,f.did from teaches t,faculty f,subjects s where t.subcode=s.subcode and t.FID=f.FID and si_id=?;";
						
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, new_si_id);
						ResultSet set2 = pstmt.executeQuery();
						
						while(set2.next()) {
							int fid = set2.getInt(1);
							String fname = set2.getString(2);
							String lname = set2.getString(3);
							String desgn = set2.getString(4);
							String gender = set2.getString(5);
							String phno = set2.getString(6);
							String email = set2.getString(7);
							String subcode = set2.getString(8);
							String subname = set2.getString(9);
							int did = set2.getInt(10);
							String dept="";
							
							 if(did==1) {dept="CSE";}
					    	 else if(did==2) {dept="ISE";}
					    	 else if(did==3) {dept="AIML";}
					    	 else if(did==4) {dept="DS";}
					    	 else if(did==5) {dept="MECH";}
					    	 else if(did==6) {dept="CIVIL";}
					    	 else if(did==7) {dept="ECE"; }
							
							Object data2[] = {fid,fname,lname,desgn + " - " +dept,gender,phno,email,subcode,subname};
							tableMode2.addRow(data2);
						}			
						
						btncount+=1;
					    }
						catch(Exception e) {
							e.printStackTrace();
						}
			    	  panel2.add(sp1);
			  	    panel2.setVisible(true);
			  	    panel2.setOpaque(true);
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
					Student_Panel_Start sps = new Student_Panel_Start(USN,StudentName,Gender,"panel7");
				}
			}
		});
		
		
		//Frame Add On's
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(cb1);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(b1);
		frame.add(b2);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		DisplayMyFaculty dsr = new DisplayMyFaculty("4SF20CS004");
	}
}