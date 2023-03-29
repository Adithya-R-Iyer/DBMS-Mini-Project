package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import mysql.GPATable;
import mysql.GPATableOperationsDB;
import mysql.IAMarksTableOperationsDB;
import mysql.StudentAttendanceTableOperationsDB;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.event.*;
import java.util.*;
import java.sql.*;


public class AddStudentRecord {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JComboBox cb1,cb2,cb3,cb4,cb5;
	JButton b1,b2;
	
	//OTHER VARIABLES
	String cb1value;
	String msg;
	String column4[];
	String fname,lname,usn,phno,city,gender,dob,email,ar,dept,section;
	int sem;
	String AdminName;
	
	public AddStudentRecord() {
		initialize();
	}
	
	public AddStudentRecord(String adname) {
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
		
		l2 = new JLabel("NEW  STUDENT  REGISTRATION  PORTAL");
		l2.setBounds(460,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel("Enter   The   New   Student   Details   ...",SwingConstants.CENTER);
		l3.setBounds(280,110,1000,100);
	    l3.setFont(new Font("Times New Roman",Font.ITALIC,30));
	    
	    l4 = new JLabel("First   Name");
	    l4.setBounds(75,210,150,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf1 = new JTextField("enter first name");
		tf1.setBounds(250,230,300,60);
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.ITALIC,24));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf1.getText().trim().equals("enter first name"))
		        	tf1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf1.getText().trim().equals(""))
		            tf1.setText("enter first name");		    	
		    }
		});
		tf1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  fname = tf1.getText();
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
					tf3.grabFocus();
		        }
	    	}
	    });
		
		
	    l5 = new JLabel("Last   Name");
	    l5.setBounds(900,210,150,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf2 = new JTextField("enter last name");
		tf2.setBounds(1075,230,295,62);
		tf2.requestFocusInWindow();
		tf2.setFont(new Font("Gothic",Font.ITALIC,24));
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf2.getText().trim().equals("enter last name"))
		        	tf2.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf2.getText().trim().equals(""))
		            tf2.setText("enter last name");		    	
		    }
		});
		tf2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  lname = tf2.getText();
		    	  tf3.grabFocus();
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
					tf5.grabFocus();
		        }
	    	}
	    });
		

	    l6 = new JLabel("USN");
	    l6.setBounds(40,330,150,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf3 = new JTextField("enter student usn");
		tf3.setBounds(130,350,300,60);
		tf3.requestFocusInWindow();
		tf3.setFont(new Font("Gothic",Font.ITALIC,24));
		tf3.setHorizontalAlignment(JTextField.CENTER);
		tf3.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf3.getText().trim().equals("enter student usn"))
		        	tf3.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf3.getText().trim().equals(""))
		            tf3.setText("enter student usn");		    	
		    }
		});
		tf3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  usn= tf3.getText();
		    	  tf4.grabFocus();
		      }
		    });
		tf3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					tf2.grabFocus();
		        }
	    	}
	    });
		tf3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					tf4.grabFocus();
		        }
	    	}
	    });
		tf3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					cb1.grabFocus();
		        }
	    	}
	    });
		
		l7 = new JLabel("PhNo.");
	    l7.setBounds(530,330,150,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf4 = new JTextField("enter student phno");
		tf4.setBounds(625,350,300,60);
		tf4.requestFocusInWindow();
		tf4.setFont(new Font("Gothic",Font.ITALIC,24));
		tf4.setHorizontalAlignment(JTextField.CENTER);
		tf4.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf4.getText().trim().equals("enter student phno"))
		        	tf4.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf4.getText().trim().equals(""))
		            tf4.setText("enter student phno");		    	
		    }
		});
		tf4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  phno = tf4.getText();
		    	  tf5.grabFocus();
		      }
		    });
		tf4.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					tf3.grabFocus();
		        }
	    	}
	    });
		tf4.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					tf5.grabFocus();
		        }
	    	}
	    });
		tf4.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf1.grabFocus();
		        }
	    	}
	    });
		tf4.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					tf6.grabFocus();
		        }
	    	}
	    });
		
		l8 = new JLabel("City");
	    l8.setBounds(1060,330,150,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf5 = new JTextField("enter student city");
		tf5.setBounds(1180,350,300,60);
		tf5.requestFocusInWindow();
		tf5.setFont(new Font("Gothic",Font.ITALIC,24));
		tf5.setHorizontalAlignment(JTextField.CENTER);
		tf5.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf5.getText().trim().equals("enter student city"))
		        	tf5.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf5.getText().trim().equals(""))
		            tf5.setText("enter student city");		    	
		    }
		});
		tf5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  city = tf5.getText();
		    	  cb1.grabFocus();
		      }
		    });
		tf5.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					tf4.grabFocus();
		        }
	    	}
	    });
		tf5.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					cb1.grabFocus();
		        }
	    	}
	    });
		tf5.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					tf7.grabFocus();
		        }
	    	}
	    });
		
		l9 = new JLabel("Gender");
	    l9.setBounds(40,450,150,100);
	    l9.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"        ---","    Male","    Female","    Others"};
		cb1 = new JComboBox(column1);
		cb1.setBounds(175,475,150,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  cb1value= cb1.getSelectedItem().toString();
		    	  gender = cb1value.trim();
		      }
		    });
	    cb1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf3.grabFocus();
		        }
	    	}
	    });
		cb1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					tf6.grabFocus();
		        }
	    	}
	    });
	    
	    l10 = new JLabel("DOB");
	    l10.setBounds(530,450,150,100);
	    l10.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf6 = new JTextField("yyyy-mm-dd");
		tf6.setBounds(625,470,300,60);
		tf6.requestFocusInWindow();
		tf6.setFont(new Font("Gothic",Font.ITALIC,24));
		tf6.setHorizontalAlignment(JTextField.CENTER);
		tf6.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf6.getText().trim().equals("yyyy-mm-dd"))
		        	tf6.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf6.getText().trim().equals(""))
		            tf6.setText("yyyy-mm-dd");		    	
		    }
		});
		tf6.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  dob = tf6.getText();
		    	  tf7.grabFocus();
		      }
		    });
		tf6.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					cb1.grabFocus();
		        }
	    	}
	    });
		tf6.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					tf7.grabFocus();
		        }
	    	}
	    });
		tf6.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					cb2.grabFocus();
		        }
	    	}
	    });
		
		l11 = new JLabel("Email");
	    l11.setBounds(1060,450,150,100);
	    l11.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf7 = new JTextField("enter student email");
		tf7.setBounds(1180,475,300,60);
		tf7.requestFocusInWindow();
		tf7.setFont(new Font("Gothic",Font.ITALIC,24));
		tf7.setHorizontalAlignment(JTextField.CENTER);
		tf7.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf7.getText().trim().equals("enter student email"))
		        	tf7.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf7.getText().trim().equals(""))
		            tf7.setText("enter student email");		    	
		    }
		});
		tf7.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  email = tf7.getText();
		    	  cb2.grabFocus();
		      }
		    });
		tf7.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					tf6.grabFocus();
		        }
	    	}
	    });
		tf7.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					cb2.grabFocus();
		        }
	    	}
	    });
		tf7.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					cb2.grabFocus();
		        }
	    	}
	    });
	    
	    l12 = new JLabel("Acdmic Year");
	    l12.setBounds(40,575,150,100);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"        ---","   2018-22","   2019-23","   2020-24","   2021-25"};
		cb2 = new JComboBox(column2);
		cb2.setBounds(210,595,150,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb2value= cb2.getSelectedItem().toString();
		    	  ar = cb2value.trim();
		      }
		    });
	    cb2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf6.grabFocus();
		        }
	    	}
	    });
	    cb2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					tf7.grabFocus();
		        }
	    	}
	    });
	    
	    l15 = new JLabel("Department");
	    l15.setBounds(450,575,200,100);
	    l15.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column5[] = {"     ---","    CSE","    ISE","    AIML","    DS","    MECH","    CIVIL","    ECE"};
		cb5 = new JComboBox(column5);
		cb5.setBounds(625,595,125,50);	
	    cb5.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb5value= cb5.getSelectedItem().toString();
		    	  dept = cb5value.trim();
		      }
		    });
	    cb5.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent ie) {
	    	
	    	}
	    });
	    
	    l13 = new JLabel("Semester");
	    l13.setBounds(850,575,200,100);
	    l13.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column3[] = {"    0","    1","    2","    3","    4","    5","    6","    7","    8"};
		cb3 = new JComboBox(column3);
		cb3.setBounds(985,595,125,50);	
	    cb3.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb3value= cb3.getSelectedItem().toString();
		    	  sem = Integer.parseInt(cb3value.trim());
		      }
		    });
	    cb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
			}
	    });
	    
	    l14 = new JLabel("Section");
	    l14.setBounds(1200,575,200,100);
	    l14.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    column4 = new String[]{"     ---","     A","     B","     C","     D","     E","     F","     G","     H","     I","     J","     K","     L"};
		cb4 = new JComboBox(column4);
		cb4.setBounds(1310,595,125,50);	
	    cb4.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb4value= cb4.getSelectedItem().toString();
		    	  section = cb4value.trim();
		      }
		    });
	    
	    b1 = new JButton("SAVE");
		b1.setBounds(520,720,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("SAVE") == true) {
					String si_id = ar.substring(2,4) + dept.substring(0,2) + sem + section;
					StudentTable st = new StudentTable(fname,lname,usn,phno,city,gender,dob,email,si_id,usn,usn);
					GPATable gt = new GPATable(usn);
					try {
					StudentTableOperationsDB.insertintostudenttable(st);
					GPATableOperationsDB.insertintoGPAtable(gt);
					IAMarksTableOperationsDB.insertintoIAMarksTable(usn, dept.substring(0,2), 0);
					StudentAttendanceTableOperationsDB.insertintoStudentAttendanceTable(usn, dept.substring(0,2), 0);
					JOptionPane.showMessageDialog(frame,"Successful !! Student record " + fname + " added successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(SQLException e) {
//						e.printStackTrace();
						JOptionPane.showMessageDialog(frame,"Unsuccessful !!  Constraints violated. Please enter valid information ","Error Message",JOptionPane.ERROR_MESSAGE);
						tf1.grabFocus();
					}
					
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf5.setText("");
					tf6.setText("");
					tf7.setText("");
					cb1.setSelectedIndex(0);
					cb2.setSelectedIndex(0);
					cb3.setSelectedIndex(0);
					cb4.setSelectedIndex(0);
					cb5.setSelectedIndex(0);
					
				}
			}
		});
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
	    			String si_id = ar.substring(2,4) + dept.substring(0,2) + sem + section;
					StudentTable st = new StudentTable(fname,lname,usn,phno,city,gender,dob,email,si_id,usn,usn);
					GPATable gt = new GPATable(usn);
					try {
					StudentTableOperationsDB.insertintostudenttable(st);
					GPATableOperationsDB.insertintoGPAtable(gt);
					IAMarksTableOperationsDB.insertintoIAMarksTable(usn, dept.substring(0,2), 0);
					StudentAttendanceTableOperationsDB.insertintoStudentAttendanceTable(usn, dept.substring(0,2), 0);
					JOptionPane.showMessageDialog(frame,"Successful !! Student record " + fname + " added successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(SQLException e) {
						JOptionPane.showMessageDialog(frame,"Unsuccessful !!  Constraints violated. Please enter valid information ","Error Message",JOptionPane.ERROR_MESSAGE);
						tf1.grabFocus();
					}
					
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf5.setText("");
					tf6.setText("");
					tf7.setText("");
					cb1.setSelectedIndex(0);
					cb2.setSelectedIndex(0);
					cb3.setSelectedIndex(0);
					cb4.setSelectedIndex(0);
					cb5.setSelectedIndex(0);
					
//					try {
//						GPATable gt = new GPATable(usn);
//						GPATableOperationsDB.insertintoGPAtable(gt);
//					}
//					catch(SQLException e) {e.printStackTrace();}
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
					Admin_Panel_Start aps = new Admin_Panel_Start(AdminName,"panel4");
				}
			}
		});
		
		
		//Frame Add ON's
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(tf1);
		frame.add(l5);
		frame.add(tf2);
		frame.add(l6);
		frame.add(tf3);
		frame.add(l7);
		frame.add(tf4);
		frame.add(l8);
		frame.add(tf5);
		frame.add(l9);
		frame.add(cb1);
		frame.add(l10);
		frame.add(tf6);
		frame.add(l11);
		frame.add(tf7);
		frame.add(l12);
		frame.add(cb2);
		frame.add(l15);
		frame.add(cb5);
		frame.add(l13);
		frame.add(cb3);
		frame.add(l14);
		frame.add(cb4);
		frame.add(b1);
		frame.add(b2);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		AddStudentRecord sr = new AddStudentRecord(); 
	}

}
