package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.lang.*;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class DisplayFacultyRecord {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3;
	JScrollPane sp,sp1,sp2,sp3;
	JComboBox cb1,cb2;
	Border border1,border2;
	JTable table,table1,table2,table3;
	JPanel panel1,panel2,panel3,panel4;
	DefaultTableModel tableMode2,tableMode3,tableMode4;
	
	//OTHER VARIABLES
	Connection con;
	String dept;
	String AdminName;
	String desgn;
	int did;
	
	public DisplayFacultyRecord() {
		initialize();	
	}
	
	public DisplayFacultyRecord(String adname) {
		this.AdminName = adname;
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
		
		l2 = new JLabel("FACULTY  RECORD  DATABASE  PORTAL");
		l2.setBounds(440,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel("Designation");
	    l3.setBounds(40,130,155,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"            ---"," Assistant Professor"," Associate Professor"," Professor"," HOD"};
		cb1 = new JComboBox(column1);
		cb1.setBounds(210,155,250,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  desgn = cb1value.trim();
		      }
		    });
	  
	    l4 = new JLabel("Department");
	    l4.setBounds(1125,130,200,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"        ---","    CSE","    ISE","    AIML","    DS","    MECH","    CIVIL","    ECE"};
		cb2 = new JComboBox(column2);
		cb2.setBounds(1310,155,150,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb2value= cb2.getSelectedItem().toString();
		    	  dept = cb2value.trim();
		    	  if(dept.equals("CSE")) {did=1;}
			    	 else if(dept.equals("ISE")) {did=2;}
			    	 else if(dept.equals("AIML")) {did=3;}
			    	 else if(dept.equals("DS")) {did=4;}
			    	 else if(dept.equals("MECH")) {did=5;}
			    	 else if(dept.equals("CIVIL")) {did=6;}
			    	 else if(dept.equals("ECE")) {did=7; }
		      }
		    });
		
	  //PANEL 1 CREATION - HOME BUTTON CONTENTS
	    panel1 = new JPanel();
	    panel1.setBounds(0,220,1510,500);
	    panel1.setLayout(null);
//	    border1 = BorderFactory.createLineBorder(Color.cyan,2);
//	    panel1.setBorder(border1);
	 
	    try {
	
		String user = "root";
		String password = "SK@@))@";
		String url = "jdbc:mysql://localhost:3306/dbms_mini_project";
		
		con = DriverManager.getConnection(url,user,password);
		
		String query = "Select FID,FFNAME,FLNAME,FDESIGNATION,FSALARY,FPHNO,FCITY,FGENDER,FDOB,FEMAIL,DID from faculty;";
		
		Statement st = con.createStatement();
		ResultSet set = st.executeQuery(query);
		
		DefaultTableModel tableModel = new DefaultTableModel() {
			 public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		table = new JTable(tableModel);
		
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
		
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredSize(new Dimension(2000,5000));
		
	 table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
	 table.getTableHeader().setBackground(Color.BLUE);
	 table.getTableHeader().setForeground(Color.WHITE);
//	 JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
		
//	 jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);	
	 
		tableModel.addColumn("FID");
		tableModel.addColumn("FNAME");
		tableModel.addColumn("LNAME");
		tableModel.addColumn("DESIGNATION");
		tableModel.addColumn("SALARY");
		tableModel.addColumn("PHNO");
		tableModel.addColumn("CITY");
		tableModel.addColumn("GENDER");
		tableModel.addColumn("DOB");
		tableModel.addColumn("EMAIL");
		tableModel.addColumn("DEPTATMENT");
		
		
		while(set.next()) {
			int id = set.getInt(1);
			String fname = set.getString(2);
			String lname = set.getString(3);
			String desgn = set.getString(4);
			String sal = set.getString(5);
			String phno = set.getString(6);
			String city = set.getString(7);
			String gender = set.getString(8);
			String dob = set.getString(9);
			String email = set.getString(10);
			int did = set.getInt(11);
			
			
			if(did==1) {
				dept="CSE";
			}
			else if(did==2) {
				dept="ISE";
			}
			else if(did==3) {
				dept="AIML";
			}
			else if(did==4) {
				dept="DS";
			}
			else if(did==5) {
				dept="MECH";
			}
			else if(did==6) {
				dept="CIVIL";
			}
			else if(did==7) {
				dept="ECE";
			}
			
			Object data1[] = {id,fname,lname,desgn,sal,phno,city,gender,dob,email,dept};
			tableModel.addRow(data1);
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
		table.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(10).setCellRenderer( centerRenderer );
		
		
		sp = new JScrollPane(table);
		sp.setBounds(10,10,1500,470);
		sp.setBackground(Color.cyan);
		sp.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.getVerticalScrollBar().setUnitIncrement(16);
		
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
	    
	    panel1.add(sp);
	    panel1.setVisible(true);
	    
	    //PANEL2 CREATION
	    panel2 = new JPanel();
		panel2.setBounds(0,220,1510,500);
		panel2.setLayout(null);
		panel2.setVisible(false);
	    
		   
	  //PANEL 3 CREATION 
	    panel3 = new JPanel();
	    panel3.setBounds(0,220,1510,500);
	    panel3.setLayout(null);
	    panel3.setVisible(false);
	    
	  //PANEL 4 CREATION 
	    panel4 = new JPanel();
	    panel4.setBounds(0,220,1510,500);
	    panel4.setLayout(null);
	    panel4.setVisible(false);
		
	
		//FRAME CONTINUE
	    b1 = new JButton("UPDATE");
		b1.setBounds(400,730,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					
					panel1.setVisible(false);
					
					//PANEL - 2 CREATION
					if(cb2.getSelectedIndex()==0) {
					
					try {
						
						String user = "root";
						String password = "SK@@))@";
						String url = "jdbc:mysql://localhost:3306/dbms_mini_project";
						
						con = DriverManager.getConnection(url,user,password);
						
						String query = "Select FID,FFNAME,FLNAME,FDESIGNATION,FSALARY,FPHNO,FCITY,FGENDER,FDOB,FEMAIL,DID from faculty where FDESIGNATION=?;";
						
						PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						pstmt.setString(1, desgn);
						ResultSet set1 = pstmt.executeQuery();
						
						if(set1.next()==false) {
							JOptionPane.showMessageDialog(frame,"SORRY!! No Records Found ","Error Message",JOptionPane.ERROR_MESSAGE);
							cb1.setSelectedIndex(0);
							cb2.setSelectedIndex(0);
							panel2.setVisible(false);
							panel1.setVisible(true);
							return;
						}
						set1.previous();
						
						 tableMode2 = new DefaultTableModel() {
							 public boolean isCellEditable(int row, int column) {
							       //all cells false
							       return false;
							    }
						};
						
						table1 = new JTable(tableMode2);
						
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
						
						table1.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
						 table1.getTableHeader().setBackground(Color.BLUE);
						 table1.getTableHeader().setForeground(Color.WHITE);
//						 JTableUtilities.setCellsAlignment(table1, SwingConstants.CENTER);
						 table1.setPreferredSize(new Dimension(0,5000));
									
						 tableMode2.addColumn("FID");
						tableMode2.addColumn("FNAME");
						tableMode2.addColumn("LNAME");
						tableMode2.addColumn("DESIGNATION");
						tableMode2.addColumn("SALARY");
						tableMode2.addColumn("PHNO");
						tableMode2.addColumn("CITY");
						tableMode2.addColumn("GENDER");
						tableMode2.addColumn("DOB");
						tableMode2.addColumn("EMAIL");
						tableMode2.addColumn("DEPTATMENT");
						
						while(set1.next()) {
							int id = set1.getInt(1);
							String fname = set1.getString(2);
							String lname = set1.getString(3);
							String desgn = set1.getString(4);
							String sal = set1.getString(5);
							String phno = set1.getString(6);
							String city = set1.getString(7);
							String gender = set1.getString(8);
							String dob = set1.getString(9);
							String email = set1.getString(10);
							int did = set1.getInt(11);
							
							
							if(did==1) {
								dept="CSE";
							}
							else if(did==2) {
								dept="ISE";
							}
							else if(did==3) {
								dept="AIML";
							}
							else if(did==4) {
								dept="DS";
							}
							else if(did==5) {
								dept="MECH";
							}
							else if(did==6) {
								dept="CIVIL";
							}
							else if(did==7) {
								dept="ECE";
							}
							
							Object data2[] = {id,fname,lname,desgn,sal,phno,city,gender,dob,email,dept};
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
						table1.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(10).setCellRenderer( centerRenderer );
						
						sp1 = new JScrollPane(table1);
						sp1.setBounds(10,10,1500,470);
						sp1.setBackground(Color.cyan);
						sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						sp1.getVerticalScrollBar().setUnitIncrement(16);
						table1.setVisible(true);
						sp1.setVisible(true);
					   }
						catch(Exception e) {
							e.printStackTrace();
						}
					
					panel2.add(sp1);
					cb1.setSelectedIndex(0);
					cb2.setSelectedIndex(0);
					panel2.setVisible(true);
					}
					
					else if(cb1.getSelectedIndex()==0) {
						
						//PANEL 3 CREATION
						try {
							
							String user = "root";
							String password = "SK@@))@";
							String url = "jdbc:mysql://localhost:3306/dbms_mini_project";
							
							con = DriverManager.getConnection(url,user,password);
							
							String query = "Select FID,FFNAME,FLNAME,FDESIGNATION,FSALARY,FPHNO,FCITY,FGENDER,FDOB,FEMAIL,DID from faculty where DID=?;";
							
							PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							pstmt.setInt(1, did);
							ResultSet set2 = pstmt.executeQuery();
							
							if(set2.next()==false) {
								JOptionPane.showMessageDialog(frame,"SORRY!! No Records Found ","Error Message",JOptionPane.ERROR_MESSAGE);
								cb1.setSelectedIndex(0);
								cb2.setSelectedIndex(0);
								panel3.setVisible(false);
								panel1.setVisible(true);
								return;
							}
							set2.previous();
							
							 tableMode3 = new DefaultTableModel() {
								 public boolean isCellEditable(int row, int column) {
								       //all cells false
								       return false;
								    }
							};
							
							table2 = new JTable(tableMode3);
							
							table2.setBorder(border1);
							table2.setBounds(10,10,1500,470);
							table2.setBackground(Color.black);
							table2.setForeground(Color.white);
							table2.setSelectionBackground(Color.red);
							table2.setGridColor(Color.red);
							table2.setSelectionForeground(Color.black);
							table2.setFont(new Font("Aerial",Font.PLAIN,15));
							table2.setRowHeight(40);
							table2.setAutoCreateRowSorter(true);
							table2.getTableHeader().setResizingAllowed(true);
							
							table2.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
							 table2.getTableHeader().setBackground(Color.BLUE);
							 table2.getTableHeader().setForeground(Color.WHITE);
//							 JTableUtilities.setCellsAlignment(table1, SwingConstants.CENTER);
							 table2.setPreferredSize(new Dimension(0,5000));
										
							 tableMode3.addColumn("FID");
							tableMode3.addColumn("FNAME");
							tableMode3.addColumn("LNAME");
							tableMode3.addColumn("DESIGNATION");
							tableMode3.addColumn("SALARY");
							tableMode3.addColumn("PHNO");
							tableMode3.addColumn("CITY");
							tableMode3.addColumn("GENDER");
							tableMode3.addColumn("DOB");
							tableMode3.addColumn("EMAIL");
							tableMode3.addColumn("DEPTATMENT");
							
							while(set2.next()) {
								int id = set2.getInt(1);
								String fname = set2.getString(2);
								String lname = set2.getString(3);
								String desgn = set2.getString(4);
								String sal = set2.getString(5);
								String phno = set2.getString(6);
								String city = set2.getString(7);
								String gender = set2.getString(8);
								String dob = set2.getString(9);
								String email = set2.getString(10);
								int did = set2.getInt(11);
								
								
								if(did==1) {
									dept="CSE";
								}
								else if(did==2) {
									dept="ISE";
								}
								else if(did==3) {
									dept="AIML";
								}
								else if(did==4) {
									dept="DS";
								}
								else if(did==5) {
									dept="MECH";
								}
								else if(did==6) {
									dept="CIVIL";
								}
								else if(did==7) {
									dept="ECE";
								}
								
								Object data3[] = {id,fname,lname,desgn,sal,phno,city,gender,dob,email,dept};
								tableMode3.addRow(data3);
							}
							DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
							centerRenderer.setHorizontalAlignment( JLabel.CENTER );
							table2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
							table2.getColumnModel().getColumn(10).setCellRenderer( centerRenderer );
							
							sp2 = new JScrollPane(table2);
							sp2.setBounds(10,10,1500,470);
							sp2.setBackground(Color.cyan);
							sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
							sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
							sp2.getVerticalScrollBar().setUnitIncrement(16);
							table2.setVisible(true);
							sp2.setVisible(true);
						   }
							catch(Exception e) {
								e.printStackTrace();
							}
						
						panel3.add(sp2);
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
						panel3.setVisible(true);
					}
					
					
					else {
						
						//PANEL 4 CREATION
						try {
							
							String user = "root";
							String password = "SK@@))@";
							String url = "jdbc:mysql://localhost:3306/dbms_mini_project";
							
							con = DriverManager.getConnection(url,user,password);
							
							String query = "Select FID,FFNAME,FLNAME,FDESIGNATION,FSALARY,FPHNO,FCITY,FGENDER,FDOB,FEMAIL,DID from faculty where FDESIGNATION=? and DID=?;";
							
							PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							pstmt.setInt(2, did);
							pstmt.setString(1, desgn);
							ResultSet set3 = pstmt.executeQuery();
							
							if(set3.next()==false) {
								JOptionPane.showMessageDialog(frame,"SORRY!! No Records Found ","Error Message",JOptionPane.ERROR_MESSAGE);
								cb1.setSelectedIndex(0);
								cb2.setSelectedIndex(0);
								panel4.setVisible(false);
								panel1.setVisible(true);
								return;
							}
							set3.previous();
							
							 tableMode4 = new DefaultTableModel() {
								 public boolean isCellEditable(int row, int column) {
								       //all cells false
								       return false;
								    }
							};
							
							table3 = new JTable(tableMode4);
							
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
							
							table3.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
							 table3.getTableHeader().setBackground(Color.BLUE);
							 table3.getTableHeader().setForeground(Color.WHITE);
//							 JTableUtilities.setCellsAlignment(table1, SwingConstants.CENTER);
							 table3.setPreferredSize(new Dimension(0,5000));
										
							 tableMode4.addColumn("FID");
							tableMode4.addColumn("FNAME");
							tableMode4.addColumn("LNAME");
							tableMode4.addColumn("DESIGNATION");
							tableMode4.addColumn("SALARY");
							tableMode4.addColumn("PHNO");
							tableMode4.addColumn("CITY");
							tableMode4.addColumn("GENDER");
							tableMode4.addColumn("DOB");
							tableMode4.addColumn("EMAIL");
							tableMode4.addColumn("DEPTATMENT");
							
							while(set3.next()) {
								int id = set3.getInt(1);
								String fname = set3.getString(2);
								String lname = set3.getString(3);
								String desgn = set3.getString(4);
								String sal = set3.getString(5);
								String phno = set3.getString(6);
								String city = set3.getString(7);
								String gender = set3.getString(8);
								String dob = set3.getString(9);
								String email = set3.getString(10);
								int did = set3.getInt(11);
								
								
								if(did==1) {
									dept="CSE";
								}
								else if(did==2) {
									dept="ISE";
								}
								else if(did==3) {
									dept="AIML";
								}
								else if(did==4) {
									dept="DS";
								}
								else if(did==5) {
									dept="MECH";
								}
								else if(did==6) {
									dept="CIVIL";
								}
								else if(did==7) {
									dept="ECE";
								}
								
								Object data4[] = {id,fname,lname,desgn,sal,phno,city,gender,dob,email,dept};
								tableMode4.addRow(data4);
							}
							DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
							centerRenderer.setHorizontalAlignment( JLabel.CENTER );
							table3.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
							table3.getColumnModel().getColumn(10).setCellRenderer( centerRenderer );
							
							sp3 = new JScrollPane(table3);
							sp3.setBounds(10,10,1500,470);
							sp3.setBackground(Color.cyan);
							sp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
							sp3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
							sp3.getVerticalScrollBar().setUnitIncrement(16);
							table3.setVisible(true);
							sp3.setVisible(true);
						   }
							catch(Exception e) {
								e.printStackTrace();
							}
						
						panel4.add(sp3);
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
						panel4.setVisible(true);
					}
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
					if(panel2.isShowing()==true) {
						panel2.setVisible(false);
						panel1.setVisible(true);
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
					}
					else if(panel3.isShowing()==true) {
						panel3.setVisible(false);
						panel1.setVisible(true);
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
					}
					else if(panel4.isShowing()==true) {
						panel4.setVisible(false);
						panel1.setVisible(true);
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
					}
				}
			}
		});
		
		b2 = new JButton("BACK");
		b2.setBounds(925,730,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Admin_Panel_Start aps = new Admin_Panel_Start(AdminName,"panel1");
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
		frame.add(cb2);
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
		DisplayFacultyRecord dfr = new DisplayFacultyRecord();
	}

}

//class JTableUtilities
//{
//    public static void setCellsAlignment(JTable table, int alignment)
//    {
//        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//        rightRenderer.setHorizontalAlignment(alignment);
//
//        TableModel tableModel = table.getModel();
//
//        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
//        {
//            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
//        }
//    }
//}
