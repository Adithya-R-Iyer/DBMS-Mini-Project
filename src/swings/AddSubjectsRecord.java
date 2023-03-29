package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import mysql.FacultyTable;
import mysql.FacultyTableOperationsDB;
import mysql.IAMarksTableOperationsDB;
import mysql.StudentAttendanceTableOperationsDB;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;
import mysql.SubjectsTable;
import mysql.SubjectsTableOperationsDB;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;


public class AddSubjectsRecord {
	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField tf1,tf2;
	JComboBox cb1,cb2,cb3,cb4;
	JButton b1,b2;
	
	//OTHER VARIABLES
	String subcode,subname,dept;
	int did,sem,scheme,credits;
	String AdminName;
	
	public AddSubjectsRecord() {
		initialize();
	}
	
	public AddSubjectsRecord(String adname) {
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
		
		l2 = new JLabel("NEW  SUBJECT  REGISTRATION  PORTAL");
		l2.setBounds(460,60,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel("Enter   The   New   Subject   Details   ...",SwingConstants.CENTER);
		l3.setBounds(280,150,1000,100);
	    l3.setFont(new Font("Times New Roman",Font.ITALIC,30));
		
	    l4 = new JLabel("Subject   Code");
	    l4.setBounds(75,260,175,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf1 = new JTextField("enter subject code");
		tf1.setBounds(275,280,275,60);
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
		    	  subcode = tf1.getText();
		    	  tf2.grabFocus();
		      }
		    });
		tf1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					tf2.grabFocus();
		        }
	    	}
	    });
		tf1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					cb1.grabFocus();
		        }
	    	}
	    });
		
		
	    l5 = new JLabel("Subject   Name");
	    l5.setBounds(875,260,175,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf2 = new JTextField("enter subject name");
		tf2.setBounds(1085,280,295,62);
		tf2.requestFocusInWindow();
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
					tf1.grabFocus();
		        }
	    	}
	    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					cb2.grabFocus();
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
		 
		 b1 = new JButton("SAVE");
		 b1.setBounds(520,720,125,50);
		 b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		 b1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				 if(stg.equals("SAVE") == true) {
					 SubjectsTable st = new SubjectsTable(subcode,subname,did,scheme,credits,sem);
					 try {
						SubjectsTableOperationsDB.insertintosubjectstable(st);
						IAMarksTableOperationsDB.insertintoIAMarksTable(subcode,"",did);
						StudentAttendanceTableOperationsDB.insertintoStudentAttendanceTable(subcode,"",did);
						JOptionPane.showMessageDialog(frame,"Successful !! Subject record - " + subname + " added successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(frame,"Unsuccessful !! constraints violated. Please enter valid information","Error Message",JOptionPane.ERROR_MESSAGE);
						tf1.grabFocus();
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
	    frame.add(l4);
	    frame.add(tf1);
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
	    frame.add(b1);
	    frame.add(b2);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		AddSubjectsRecord asr = new AddSubjectsRecord();
	}
}