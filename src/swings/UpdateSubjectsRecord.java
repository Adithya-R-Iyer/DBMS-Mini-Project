package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import mysql.CP;
import mysql.FacultyTable;
import mysql.FacultyTableOperationsDB;
import mysql.IAMarksTableOperationsDB;
import mysql.StudentAttendanceTableOperationsDB;
import mysql.SubjectsTable;
import mysql.SubjectsTableOperationsDB;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class UpdateSubjectsRecord {
	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField tf2,tf1;
	JComboBox cb1,cb2,cb3,cb4;
	JButton b1,b2,b3;
	
	//OTHER VARIABLES
	String subcode,subname,dept;
	int did,sem,scheme,credits;
	String AdminName;
	
	public UpdateSubjectsRecord() {
		initialize();
	}
	public UpdateSubjectsRecord(String adname) {
		this.AdminName = adname;
		initialize();
	}
	
	public void initialize() {
		
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
		
		l2 = new JLabel("SUBJECT  RECORD   UPDATION  PORTAL");
		l2.setBounds(460,60,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel("Enter   Updated   Subject   Information   ...",SwingConstants.CENTER);
		l3.setBounds(280,150,1000,100);
	    l3.setFont(new Font("Times New Roman",Font.ITALIC,30));
		
	    l5 = new JLabel("Subject   Name");
	    l5.setBounds(75,260,175,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf2 = new JTextField("enter subject name");
		tf2.setBounds(275,280,275,60);	
		tf2.setFont(new Font("Gothic",Font.ITALIC,24));
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf2.getText().trim().equals("enter subject name"))
		        	tf2.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf2.getText().trim().equals(""))
		            tf2.setText("enter subject name");		    	
		    }
		});
		tf2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  subname = tf2.getText();
		    	  cb1.grabFocus();
		      }
		    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					cb4.grabFocus();
		        }
	    	}
	    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					cb1.grabFocus();
		        }
	    	}
	    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					cb1.grabFocus();
		        }
	    	}
	    });
		
		 l6 = new JLabel("Department");
		 l6.setBounds(75,410,200,100);
		 l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
		
	    
		 String column5[] = {"       ---","      CSE","      ISE","      AIML","      DS","      MECH","      CIVIL","      ECE"};
		 cb1 = new JComboBox(column5);
		 cb1.setBounds(275,430,150,50);	
		 cb1.setFont(new Font("Gothic",Font.ITALIC,23));
		 cb1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String cb1value= cb1.getSelectedItem().toString();
				 dept = cb1value.trim();
				 if(dept.equals("CSE")) {did=1;}
		    	 else if(dept.equals("ISE")) {did=2;}
		    	 else if(dept.equals("AIML")) {did=3;}
		    	 else if(dept.equals("DS")) {did=4;}
		    	 else if(dept.equals("MECH")) {did=5;}
		    	 else if(dept.equals("CIVIL")) {did=6;}
		    	 else if(dept.equals("ECE")) {did=7; }
				}
		 });
		 cb1.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent ie) {}
		 });
		 cb1.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
						tf2.grabFocus();
			        }
		    	}
		    });
			cb1.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
						cb2.grabFocus();
			        }
		    	}
		    });
			cb1.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
						cb3.grabFocus();
			        }
		    	}
		    });
			cb1.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_UP){
						tf2.grabFocus();
			        }
		    	}
		    });
		 
		 l7 = new JLabel("Semester");
		 l7.setBounds(875,410,200,100);
		 l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
		    
		 String column2[] = {"     0","     1","     2","     3","     4","     5","     6","     7","     8"};
		 cb2 = new JComboBox(column2);
		 cb2.setBounds(1085,430,125,50);	
		 cb2.setFont(new Font("Gothic",Font.ITALIC,24));
		 cb2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String cb2value= cb2.getSelectedItem().toString();
				 sem = Integer.parseInt(cb2value.trim());
			 }
		 });
		 cb2.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent ie) {
			 }
		 });
		 cb2.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
						cb1.grabFocus();
			        }
		    	}
		    });
			cb2.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
						cb3.grabFocus();
			        }
		    	}
		    });
			cb2.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
						cb4.grabFocus();
			        }
		    	}
		    });
			cb2.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_UP){
						tf2.grabFocus();
			        }
		    	}
		    });
		 
		 l8 = new JLabel("Scheme");
		 l8.setBounds(75,550,150,100);
		 l8.setFont(new Font("Times New Roman",Font.PLAIN,28));
		    
		 String column3[] = {"        0000","      2015","      2018","      2020"};
		 cb3 = new JComboBox(column3);
		 cb3.setBounds(275,570,150,50);	
		 cb3.setFont(new Font("Gothic",Font.ITALIC,24));
		 cb3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String cb3value= cb3.getSelectedItem().toString();
				 scheme = Integer.parseInt(cb3value.trim());
			   }
		  });
		 cb3.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
						cb2.grabFocus();
			        }
		    	}
		    });
			cb3.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
						cb4.grabFocus();
			        }
		    	}
		    });
			cb3.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
						tf2.grabFocus();
			        }
		    	}
		    });
			cb3.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_UP){
						cb1.grabFocus();
			        }
		    	}
		    });
		    
		 l9 = new JLabel("Credits");
		 l9.setBounds(875,550,200,100);
		 l9.setFont(new Font("Times New Roman",Font.PLAIN,28));
		 
		 String column4[] = {"    0","    1","    2","    3","    4"};
		 cb4 = new JComboBox(column4);
		 cb4.setBounds(1085,570,125,50);	
		 cb4.setFont(new Font("Gothic",Font.ITALIC,24));
		 cb4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String cb4value= cb4.getSelectedItem().toString();
				 credits = Integer.parseInt(cb4value.trim());
			 }
		 });
		 cb4.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent ie) {
			 }
		 });
		 cb4.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
						cb3.grabFocus();
			        }
		    	}
		    });
			cb4.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
						tf2.grabFocus();
			        }
		    	}
		    });
			cb4.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
						tf2.grabFocus();
			        }
		    	}
		    });
			cb4.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_UP){
						cb2.grabFocus();
			        }
		    	}
		    });
	    
	    tf1 = new JTextField("enter subject code");
		tf1.setBounds(875,280,295,62);
		tf1.grabFocus();
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.ITALIC,24));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf1.getText().trim().equals("enter subject code"))
		        	tf1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf1.getText().trim().equals(""))
		            tf1.setText("enter subject code");		    	
		    }
		});
		tf1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    
					try {
						subcode = tf1.getText();
						
						Connection con = CP.createCon();
						String query = "select SNAME,DID,SCHEME,SCREDITS,SEM from SUBJECTS where subcode=?;";
						
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, subcode);
						ResultSet set = pstmt.executeQuery();
					
						if(set.next()) {
							subname = set.getString(1);
							did = set.getInt(2);
							scheme = set.getInt(3);
							credits = set.getInt(4);
							sem = set.getInt(5);
						}
						else {
							JOptionPane.showMessageDialog(frame,"Error !! No Records Found...Please enter a valid Subject Code ","Error Message",JOptionPane.ERROR_MESSAGE);
							tf1.setText("");
							return;
						}
						
						tf2.setText(subname);
						
						//DEPARTMENT
						if(did==1) {
							cb1.setSelectedIndex(1);
						}
						else if(did==2) {
							cb1.setSelectedIndex(2);
						}
						else if(did==3) {
							cb1.setSelectedIndex(3);
						}
						else if(did==4) {
							cb1.setSelectedIndex(4);
						}
						else if(did==5) {
							cb1.setSelectedIndex(5);
						}
						else if(did==6) {
							cb1.setSelectedIndex(6);
						}
						else if(did==7) {
							cb1.setSelectedIndex(7);
						}
						
						//SCHEME      
						if(scheme==2015) {
							cb3.setSelectedIndex(1);
						}
						else if(scheme==2018) {
							cb3.setSelectedIndex(2);
						}
						else if(scheme==2020) {
							cb3.setSelectedIndex(3);
						}
						
						//CREDITS
						if(credits==1) {
							cb4.setSelectedIndex(1);
						}
						else if(credits==2) {
							cb4.setSelectedIndex(2);
						}
						else if(credits==3) {
							cb4.setSelectedIndex(3);
						}
						else if(credits==4) {
							cb4.setSelectedIndex(4);
						}
						
						//SEMESTER
						if(sem==1) {
							cb2.setSelectedIndex(1);
						}
						else if(sem==2) {
							cb2.setSelectedIndex(2);
						}
						else if(sem==3) {
							cb2.setSelectedIndex(3);
						}
						else if(sem==4) {
							cb2.setSelectedIndex(4);
						}
						else if(sem==5) {
							cb2.setSelectedIndex(5);
						}
						else if(sem==6) {
							cb2.setSelectedIndex(6);
						}
						else if(sem==7) {
							cb2.setSelectedIndex(7);
						}
						else if(sem==8) {
							cb2.setSelectedIndex(8);
						}
						
					}
					catch(Exception se){
//						se.printStackTrace();
						JOptionPane.showMessageDialog(frame,"Error !!  Please enter a valid Subject Code ","Error Message",JOptionPane.ERROR_MESSAGE);
						tf1.setText("");
					}
		      }
		    });
			
		b3 = new JButton("SEARCH");
		b3.setBounds(1200,285,140,45);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("SEARCH") == true) {
					
					try {
						subcode = tf1.getText();
						
						Connection con = CP.createCon();
						String query = "select SNAME,DID,SCHEME,SCREDITS,SEM from SUBJECTS where subcode=?;";
						
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, subcode);
						ResultSet set = pstmt.executeQuery();
						
						if(set.next()==true) {
							subname = set.getString(1);
							did = set.getInt(2);
							scheme = set.getInt(3);
							credits = set.getInt(4);
							sem = set.getInt(5);
						}
						else {
							JOptionPane.showMessageDialog(frame,"Error !! No Records Found...Please enter a valid Subject Code ","Error Message",JOptionPane.ERROR_MESSAGE);
							tf1.setText("");
							return;
						}
						
						tf2.setText(subname);
						
						//DEPARTMENT
						if(did==1) {
							cb1.setSelectedIndex(1);
						}
						else if(did==2) {
							cb1.setSelectedIndex(2);
						}
						else if(did==3) {
							cb1.setSelectedIndex(3);
						}
						else if(did==4) {
							cb1.setSelectedIndex(4);
						}
						else if(did==5) {
							cb1.setSelectedIndex(5);
						}
						else if(did==6) {
							cb1.setSelectedIndex(6);
						}
						else if(did==7) {
							cb1.setSelectedIndex(7);
						}
						
						//SCHEME      
						if(scheme==2015) {
							cb3.setSelectedIndex(1);
						}
						else if(scheme==2018) {
							cb3.setSelectedIndex(2);
						}
						else if(scheme==2020) {
							cb3.setSelectedIndex(3);
						}
						
						//CREDITS
						if(credits==1) {
							cb4.setSelectedIndex(1);
						}
						else if(credits==2) {
							cb4.setSelectedIndex(2);
						}
						else if(credits==3) {
							cb4.setSelectedIndex(3);
						}
						else if(credits==4) {
							cb4.setSelectedIndex(4);
						}
						
						//SEMESTER
						if(sem==1) {
							cb2.setSelectedIndex(1);
						}
						else if(sem==2) {
							cb2.setSelectedIndex(2);
						}
						else if(sem==3) {
							cb2.setSelectedIndex(3);
						}
						else if(sem==4) {
							cb2.setSelectedIndex(4);
						}
						else if(sem==5) {
							cb2.setSelectedIndex(5);
						}
						else if(sem==6) {
							cb2.setSelectedIndex(6);
						}
						else if(sem==7) {
							cb2.setSelectedIndex(7);
						}
						else if(sem==8) {
							cb2.setSelectedIndex(8);
						}
						
					}
					catch(Exception e){
//						e.printStackTrace();
						JOptionPane.showMessageDialog(frame,"Error !!  Please enter a valid Subject Code ","Error Message",JOptionPane.ERROR_MESSAGE);
						tf1.setText("");
					}
				}
			}
		});
		 
		 b1 = new JButton("SAVE");
		 b1.setBounds(520,720,125,50);
		 b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		 b1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				 if(stg.equals("SAVE") == true) {
					 SubjectsTable st = new SubjectsTable(subcode,subname,did,scheme,credits,sem);
					 try {
						SubjectsTableOperationsDB.updatesubjectstable(st);
						JOptionPane.showMessageDialog(frame,"Successful !! Subject record - " + subname + " updated successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(frame,"Unsuccessful !! constraints violated. Please enter valid information","Error Message",JOptionPane.ERROR_MESSAGE);
					}
					 tf1.setText("");
					 tf2.setText("");
					 cb1.setSelectedIndex(0);
					 cb2.setSelectedIndex(0);
					 cb3.setSelectedIndex(0);
					 cb4.setSelectedIndex(0);
					}
			}
		});
		 b1.addKeyListener(new KeyAdapter() {
		    	public void keyPressed(KeyEvent ke) {
		    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
		    			SubjectsTable st = new SubjectsTable(subcode,subname,did,scheme,credits,sem);
						 try {
							SubjectsTableOperationsDB.updatesubjectstable(st);
							JOptionPane.showMessageDialog(frame,"Successful !! Subject record - " + subname + " updated successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(frame,"Unsuccessful !! constraints violated. Please enter valid information","Error Message",JOptionPane.ERROR_MESSAGE);
						}
						 tf1.setText("");
						 tf2.setText("");
						 cb1.setSelectedIndex(0);
						 cb2.setSelectedIndex(0);
						 cb3.setSelectedIndex(0);
						 cb4.setSelectedIndex(0);
			        }
		    	}
		    });
			
		b2 = new JButton("BACK");
		b2.setBounds(830,720,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Admin_Panel_Start aps = new Admin_Panel_Start(AdminName,"panel5");
				}
			}
		});
		    
	    //Frame add-on's
	    frame.add(l0);
	    frame.add(l1);
	    frame.add(l2);
	    frame.add(l3);
	    frame.add(l5);
	    frame.add(tf2);
	    frame.add(l6);
	    frame.add(cb1);
	    frame.add(l7);
	    frame.add(cb2);
	    frame.add(l8);
	    frame.add(cb3);
	    frame.add(l9);
	    frame.add(cb4);
	    frame.add(tf1);
	    frame.add(b3);
	    frame.add(b1);
	    frame.add(b2);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		UpdateSubjectsRecord asr = new UpdateSubjectsRecord();
	}
}