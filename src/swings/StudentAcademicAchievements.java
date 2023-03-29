package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import mysql.AcademicAchievementsTable;
import mysql.AcademicAchievementsTableOperationsDB;
import mysql.CP;
import mysql.GPATableOperationsDB;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class StudentAcademicAchievements {

	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf4;
	JButton b1,b2;
			
	//OTHER VARIABLES
	String USN,StudentName,Gender,si_id;
	int SNoProj,SInternShip,SBACKLOGS;
	int sem,scheme;
	Connection con;
	
	public StudentAcademicAchievements() {
		initialize();
	}
	public StudentAcademicAchievements(String usn) {
		this.USN = usn;
		initialize();
	}
	
	public void initialize() {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1000,600);
		
		l0 = new JLabel("STUDENT  ACADEMIC  ASSESSMENT  SYSTEM  -  Sahyadri  College  of  Engineering  and  Management",SwingConstants.CENTER);
		l0.setBounds(75,0,900,50);
		l0.setFont(new Font("Times New Roman",Font.PLAIN,17));
		
		l1 = new JLabel();
		l1.setBounds(10,10,100,75);
		ImageIcon imgic1 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\logo.png");
		Image img1 = imgic1.getImage();
		Image modifiedimage1 = img1.getScaledInstance(100,75,java.awt.Image.SCALE_SMOOTH);
		imgic1 = new ImageIcon(modifiedimage1);
		l1.setIcon(imgic1);
		
		l2 = new JLabel("STUDENT  ACADEMIC  ACHIEVEMENTS  PORTAL");
		l2.setBounds(230,30,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,28));
		
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
	    
		
		l3 = new JLabel("      	      My  Current  SEM  :-     " + sem +"                                  Current  Scheme  of  Study  :-     " + scheme);
	    l3.setBounds(0,100,1000,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,25));
	  
	    
	    l4 = new JLabel("Number  of  Projects  { Mini & Major }");
	    l4.setBounds(175,180,500,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    tf1 = new JTextField("xx");
		tf1.setBounds(625,205,125,50);
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.ITALIC,21));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf1.getText().trim().equals("xx"))
		        	tf1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf1.getText().trim().equals(""))
		            tf1.setText("xx");		    	
		    }
		});
		tf1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  SNoProj = Integer.parseInt(tf1.getText());
		    	  tf2.grabFocus();
		      }
		    });
		tf1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					tf2.grabFocus();
		        }
	    	}
	    });
		
		
		l5 = new JLabel("Number  of  Internships  { MIN 1 }");
	    l5.setBounds(175,270,500,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    tf2 = new JTextField("xx");
		tf2.setBounds(625,295,125,50);
		tf2.requestFocusInWindow();
		tf2.setFont(new Font("Gothic",Font.ITALIC,21));
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf2.getText().trim().equals("xx"))
		        	tf2.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf2.getText().trim().equals(""))
		            tf2.setText("xx");		    	
		    }
		});
		tf2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  SInternShip = Integer.parseInt(tf2.getText());
		    	  tf3.grabFocus();
		      }
		    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					tf3.grabFocus();
		        }
	    	}
	    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf1.grabFocus();
		        }
	    	}
	    });
		
		
		l6 = new JLabel("No  of  BackLog's  { if any }");
	    l6.setBounds(175,360,500,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    tf3 = new JTextField("xx");
		tf3.setBounds(625,385,125,50);
		tf3.requestFocusInWindow();
		tf3.setFont(new Font("Gothic",Font.ITALIC,21));
		tf3.setHorizontalAlignment(JTextField.CENTER);
		tf3.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf3.getText().trim().equals("xx"))
		        	tf3.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf3.getText().trim().equals(""))
		            tf3.setText("xx");		    	
		    }
		});
		tf3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
//		    	  SBACKLOGS = Integer.parseInt(tf3.getText());
		    	  b1.grabFocus();
		      }
		    });
		tf3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					b1.grabFocus();
		        }
	    	}
	    });
		tf3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf2.grabFocus();
		        }
	    	}
	    });
		
		
		try {
			
			con = CP.createCon();
			
			String query = "Select SNoProj,SInternShip,SBACKLOGS from academicachievements where usn=?;";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, USN);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				SNoProj = set.getInt(1);
				SInternShip = set.getInt(2);
				SBACKLOGS = set.getInt(3);
				}
			
			tf1.setText(Integer.toString(SNoProj));
			tf2.setText(Integer.toString(SInternShip));
			tf3.setText(Integer.toString(SBACKLOGS));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		b1 = new JButton("SAVE");
		b1.setBounds(300,500,125,40);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("SAVE") == true) {
					
					try {
						AcademicAchievementsTable aat = new AcademicAchievementsTable(USN,SNoProj,SInternShip);
						AcademicAchievementsTableOperationsDB.insertintoacademicachievementstable(aat);
						JOptionPane.showMessageDialog(frame,"Successful !! Your Achievements Updated successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(frame,e,"Error Message",JOptionPane.ERROR_MESSAGE);
					}
					tf3.setText(Integer.toString(SBACKLOGS));
				}
			}
		});
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){	
	    			
	    			try {
					AcademicAchievementsTable aat = new AcademicAchievementsTable(USN,SNoProj,SInternShip);
					AcademicAchievementsTableOperationsDB.insertintoacademicachievementstable(aat);
					JOptionPane.showMessageDialog(frame,"Successful !! Your Achievements Updated successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame,e,"Error Message",JOptionPane.ERROR_MESSAGE);
				}
				tf3.setText(Integer.toString(SBACKLOGS));
		        }
	    	}
	    });
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){		
	    			tf3.grabFocus();	
		        }
	    	}
	    });
		
		b2 = new JButton("BACK");
		b2.setBounds(550,500,125,40);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Student_Panel_Start sps = new Student_Panel_Start(USN,StudentName,Gender,"panel5");
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
	    frame.add(tf3);
	    frame.add(b1);
	    frame.add(b2);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		StudentAcademicAchievements rsd = new StudentAcademicAchievements("4SF20CS030");
	}
	
}
