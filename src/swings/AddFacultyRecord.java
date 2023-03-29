package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import mysql.FacultyTable;
import mysql.FacultyTableOperationsDB;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;


public class AddFacultyRecord {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l15;
	JTextField tf1,tf2,tf4,tf5,tf6,tf7;
	JComboBox cb1,cb2,cb3,cb4,cb5;
	JButton b1,b2;
	
	//OTHER VARIABLES
	String cb1value;
	String msg;
	String column4[];
	String fname,lname,desg,phno,city,gender,dob,email,pay,dept;
	int did,join_year;
	String AdminName;
	
	public AddFacultyRecord() {
		initialize();
	}
	
	public AddFacultyRecord(String adname) {
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
		
		l2 = new JLabel("NEW  FACULTY  REGISTRATION  PORTAL");
		l2.setBounds(460,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel("Enter   The   New   Faculty   Details   ...",SwingConstants.CENTER);
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
					cb3.grabFocus();
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
		    	  cb3.grabFocus();
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
		

	    l6 = new JLabel("Designation");
	    l6.setBounds(40,330,150,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column3[] = {"            ---"," Assistant Professor"," Associate Professor"," Professor"," HOD"};
		cb3 = new JComboBox(column3);
		cb3.setBounds(200,355,230,50);	
	    cb3.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb3value= cb3.getSelectedItem().toString();
		    	  desg = cb3value.trim();
		      }
		    });
	    cb3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf1.grabFocus();
		        }
	    	}
	    });
	    cb3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
					tf2.grabFocus();
		        }
	    	}
	    });
	    cb3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					tf4.grabFocus();
		        }
	    	}
	    });
		
		l7 = new JLabel("PhNo.");
	    l7.setBounds(530,330,150,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf4 = new JTextField("enter faculty phno");
		tf4.setBounds(625,350,300,60);
		tf4.requestFocusInWindow();
		tf4.setFont(new Font("Gothic",Font.ITALIC,24));
		tf4.setHorizontalAlignment(JTextField.CENTER);
		tf4.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf4.getText().trim().equals("enter faculty phno"))
		        	tf4.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf4.getText().trim().equals(""))
		            tf4.setText("enter faculty phno");		    	
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
					cb3.grabFocus();
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
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					tf5.grabFocus();
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
	    
	    tf5 = new JTextField("enter faculty city");
		tf5.setBounds(1180,350,300,60);
		tf5.requestFocusInWindow();
		tf5.setFont(new Font("Gothic",Font.ITALIC,24));
		tf5.setHorizontalAlignment(JTextField.CENTER);
		tf5.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf5.getText().trim().equals("enter faculty city"))
		        	tf5.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf5.getText().trim().equals(""))
		            tf5.setText("enter faculty city");		    	
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
					cb3.grabFocus();
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
	    
	    tf7 = new JTextField("enter faculty email");
		tf7.setBounds(1180,475,300,60);
		tf7.requestFocusInWindow();
		tf7.setFont(new Font("Gothic",Font.ITALIC,24));
		tf7.setHorizontalAlignment(JTextField.CENTER);
		tf7.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf7.getText().trim().equals("enter faculty email"))
		        	tf7.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf7.getText().trim().equals(""))
		            tf7.setText("enter faculty email");		    	
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
	    
	    l12 = new JLabel("Salary \\ Pay");
	    l12.setBounds(40,575,150,100);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"        ---","   50k-100k","  100k-150k","  150k-200k","  200k-300k"};
		cb2 = new JComboBox(column2);
		cb2.setBounds(210,595,175,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb2value= cb2.getSelectedItem().toString();
		    	  pay = cb2value.trim();
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
	    l15.setBounds(530,575,200,100);
	    l15.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column5[] = {"        ---","       CSE","       ISE","       AIML","       DS","       MECH","       CIVIL","       ECE"};
		cb5 = new JComboBox(column5);
		cb5.setBounds(700,595,150,50);	
	    cb5.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb5value= cb5.getSelectedItem().toString();
		    	  dept = cb5value.trim();
		    	  if(dept.equals("CSE")) {did=1;}
			    	 else if(dept.equals("ISE")) {did=2;}
			    	 else if(dept.equals("AIML")) {did=3;}
			    	 else if(dept.equals("DS")) {did=4;}
			    	 else if(dept.equals("MECH")) {did=5;}
			    	 else if(dept.equals("CIVIL")) {did=6;}
			    	 else if(dept.equals("ECE")) {did=7; }
		      }
		    });
	    cb5.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent ie) {}
	    });
	    
	    l13 = new JLabel("Join  Year");
	    l13.setBounds(1060,575,150,100);
	    l13.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column4[] = {"     ---","     2007","     2008","     2009","     2010","     2011","     2012","     2013","     2014","     2015","     2016","     2017","     2018","     2019","     2020","     2021","     2022"};
		cb4 = new JComboBox(column4);
		cb4.setBounds(1250,595,150,50);	
	    cb4.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
//		    	  cb1val = cb1.getSelectedIndex();
		    	  String cb4value= cb4.getSelectedItem().toString();
		    	  join_year = Integer.parseInt(cb4value.trim());
//		    	  System.out.println(ay);
		      }
		    });
	    
	    cb4.setSelectedIndex(16);
	    
	    
	    b1 = new JButton("SAVE");
		b1.setBounds(520,720,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("SAVE") == true) {
					FacultyTable ft = new FacultyTable(fname,lname,desg,pay,phno,city,gender,dob,email,did,fname + " " + lname ,fname.substring(0,5)+"@123",join_year);
					try {
						FacultyTableOperationsDB.insertintofacultytable(ft);
						JOptionPane.showMessageDialog(frame,"Successful !! Faculty record - " + fname + " added successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(frame,"Unsuccessful !! constraints violated. Please enter valid information","Error Message",JOptionPane.ERROR_MESSAGE);
						tf1.grabFocus();
					}
					
					tf1.setText("");
					tf2.setText("");
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
		    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
		    			FacultyTable ft = new FacultyTable(fname,lname,desg,pay,phno,city,gender,dob,email,did,fname + " " + lname ,fname.substring(0,4)+"@123",join_year);
						try {
							FacultyTableOperationsDB.insertintofacultytable(ft);
							JOptionPane.showMessageDialog(frame,"Successful !! Faculty record - " + fname + " added successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(frame,"Unsuccessful !! constraints violated. Please enter valid information","Error Message",JOptionPane.ERROR_MESSAGE);
							tf1.grabFocus();
						}
						
						tf1.setText("");
						tf2.setText("");
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
		
		b2 = new JButton("BACK");
		b2.setBounds(830,720,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Admin_Panel_Start aps = new Admin_Panel_Start(AdminName,"panel3");
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
		frame.add(cb3);
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
		frame.add(cb4);
		frame.add(b1);
		frame.add(b2);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		AddFacultyRecord sr = new AddFacultyRecord(); 
	}

}
