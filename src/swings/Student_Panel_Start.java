package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import mysql.CP;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
import java.util.Random;


public class Student_Panel_Start {
	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l15,l16,l17,l18,l9,l20,l31,l32,l33,l34,l35,l36,l37,l38,l39,l40,l41,l42;
	JPanel panel2,panel3,panel4,panel5,panel7;
	Border border1;
	JButton b1,b2,b7,b8,b9,b10,b11,b16,b17,b18,b19,b20,b21,b22,b23,b26,b27,b28,b29,b30,b31,b32;
	JTextArea ta1,ta2;
	JScrollPane sp2;
		
	// OTHER VARIABLES
	Random rand = new Random();
	String str1,str3;
	String StudentName,temp,PanelName="",MorF="",usn="";
	int id,backlog,project,internship;
	String dob;
	
	public Student_Panel_Start(String stnme) {
		StudentName = stnme;
		initialize();
	}
		
	public Student_Panel_Start(String stnme,String pname) {  //LOGIN
		StudentName= stnme;
		PanelName=pname;
		initialize();
	}
	public Student_Panel_Start(String roll,String stnme,String mf,String pname) {  //LOGIN
		usn = roll;
		StudentName= stnme;
		MorF=mf;
		PanelName = pname;
		initialize();
	}
	public Student_Panel_Start() {
		initialize();
//		frame.setVisible(true);
//		panel2.setVisible(true);
//		panel3.setVisible(true);
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
		
		l2 = new JLabel("STUDENT    PANEL");
		l2.setBounds(673,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel();
		l3.setBounds(600,110,1000,100);
	    l3.setFont(new Font("Times New Roman",Font.ITALIC,26));
	    l3.setVisible(true);
	    
	    if(MorF.equals("Male")) {
	    	l3.setText("           Welcome  !!!  Mr .  " + StudentName);
	    }
	    else {
	    	l3.setText("           Welcome  !!!  Ms .  " + StudentName);
	    }
	    
	    b1 = new JButton();
		b1.setBounds(1400,75,50,50);
		b1.setBorder(new RoundedBorder(50));
		b1.setForeground(Color.BLUE);
		ImageIcon imgic2 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\profilelogo.png");
		Image img2 = imgic2.getImage();
		Image modifiedimage2 = img2.getScaledInstance(52,55,java.awt.Image.SCALE_SMOOTH);
		imgic2 = new ImageIcon(modifiedimage2);
		b1.setIcon(imgic2);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if(panel4.isShowing()==true || panel5.isShowing()==true || panel3.isShowing()==true) {
					panel4.setVisible(false);
					panel5.setVisible(false);
					panel3.setVisible(false);
				}
				if(panel7.isShowing()!=true)
					panel7.setVisible(true);
				else
					panel7.setVisible(false);
				
			}
		});
		
		l4 = new JLabel("Profile",SwingConstants.CENTER);
	    l4.setBounds(1350,102,150,100);
	    l4.setFont(new Font("Comic Sans MS",Font.ITALIC,21));
	    
	    l9 = new JLabel();
	    l9.setBounds(300,230,1240,610);
	    border1 = BorderFactory.createLineBorder(Color.black,4);
		l9.setBorder(border1);
	    
		
		//PANEL - 4 CREATION -> STUDENT RECORD UPDATION
	    panel4 = new JPanel();
		panel4.setBounds(300,230,1240,580);
		panel4.setLayout(null);
		
		l15 = new JLabel("Your  Academic  Performance");
	    l15.setBounds(400,5,600,100);
	    l15.setFont(new Font("Comic Sans MS",Font.BOLD,28));
		
	    l16 = new JLabel("Continuous  Internal  Evaluation { I/A }");
	    l16.setBounds(300,130,450,100);
	    l16.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    b16 = new JButton("Click Here");
		b16.setBounds(800,155,150,45);
		b16.setFont(new Font("Arial",Font.PLAIN,20));
		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					StudentIAPerformance siap = new StudentIAPerformance(usn);
				}
			}
		});
	    
	    l17 = new JLabel("Current  Attendance  Status ");
	    l17.setBounds(300,225,450,100);
	    l17.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    b17 = new JButton("Click Here");
		b17.setBounds(800,250,150,45);
		b17.setFont(new Font("Arial",Font.PLAIN,20));
		b17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					StudentAttendanceStatus sas = new StudentAttendanceStatus(usn);
				}
			}
		});
	    
	    l18 = new JLabel("Semester  End  Examination  { SEE } ");
	    l18.setBounds(300,315,450,100);
	    l18.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    b18 = new JButton("Click Here");
		b18.setBounds(800,340,150,45);
		b18.setFont(new Font("Arial",Font.PLAIN,20));
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					StudentSEEPerformance ssp = new StudentSEEPerformance(usn);
				}
			}
		});
		
		l20 = new JLabel("Grade  Point  Average.  { GPA } ");
	    l20.setBounds(300,410,450,100);
	    l20.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    b20 = new JButton("Click Here");
		b20.setBounds(800,435,150,45);
		b20.setFont(new Font("Arial",Font.PLAIN,20));
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					if(panel4.isShowing()==true || panel7.isShowing()==true) {
						panel4.setVisible(false);
						panel7.setVisible(false);
					}
					if(panel5.isShowing()!=true)
						panel5.setVisible(true);
					else
						panel5.setVisible(false);
				}
			}
		});
		
		b19 = new JButton("<=]");
		b19.setBounds(1080,500,58,45);
		b19.setFont(new Font("Arial",Font.PLAIN,16));
		b19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
					panel4.setVisible(false);
				}
			}
		});
	    
	    panel4.add(l15);
	    panel4.add(l16);
	    panel4.add(b16);
	    panel4.add(l17);
	    panel4.add(b17);
	    panel4.add(l18);
	    panel4.add(b18);
	    panel4.add(b19);
	    panel4.add(l20);
	    panel4.add(b20);
	    if(PanelName.equals("panel4")) {
	    	panel4.setVisible(true);
	    }
	    else {
	    panel4.setVisible(false);
	    }
		
		
	  //PANEL - 5 CREATION -> SUBJECTS RECORD UPDATION
	    panel5 = new JPanel();
		panel5.setBounds(300,230,1240,580);
		panel5.setLayout(null);
		
		l5 = new JLabel("Student  Grade  Point  Average  Portal ");
	    l5.setBounds(375,5,600,100);
	    l5.setFont(new Font("Comic Sans MS",Font.BOLD,28));
		
	    l6 = new JLabel("Calculate Semester Grade Point Average ");
	    l6.setBounds(300,135,450,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b20 = new JButton("SGPA");
		b20.setBounds(800,160,120,50);
		b20.setFont(new Font("Arial",Font.PLAIN,18));
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("SGPA") == true) {
					StudentSGPACalculation ssgpac = new StudentSGPACalculation(usn);
				}
			}
		});
	    
	    l7 = new JLabel("Calculate Cumulative Grade Point Average");
	    l7.setBounds(300,250,450,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b21 = new JButton("CGPA");
		b21.setBounds(800,275,120,50);
		b21.setFont(new Font("Arial",Font.PLAIN,18));
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("CGPA") == true) {
					StudentCGPACalculation scgpac = new StudentCGPACalculation(usn);
				}
			}
		});
	    
	    l8 = new JLabel("View Your Other Academic Achievement's");
	    l8.setBounds(300,370,450,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,24));
	   
	    b22 = new JButton("SHOW");
		b22.setBounds(800,390,120,50);
		b22.setFont(new Font("Arial",Font.PLAIN,18));
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("SHOW") == true) {
					StudentAcademicAchievements saa = new StudentAcademicAchievements(usn);
				}
			}
		});
		
		b23 = new JButton("<=]");
		b23.setBounds(1080,500,58,45);
		b23.setFont(new Font("Arial",Font.PLAIN,16));
		b23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
//					panel5.setVisible(false);
					if(panel5.isShowing()==true || panel7.isShowing()==true) {
						panel5.setVisible(false);
						panel7.setVisible(false);
					}
					if(panel4.isShowing()!=true)
						panel4.setVisible(true);
				}
			}
		});
	    
	    panel5.add(l5);
	    panel5.add(l6);
	    panel5.add(b20);
	    panel5.add(l7);
	    panel5.add(b21);
	    panel5.add(l8);
	    panel5.add(b22);
	    panel5.add(b23);
	    if(PanelName.equals("panel5")) {
	    	panel5.setVisible(true);
	    }
	    else {
	    panel5.setVisible(false);
	    }
	    
	    // PANEL -3 RANK LIST CREATION
	    
	    panel3 = new JPanel();
		panel3.setBounds(300,230,1240,580);
		panel3.setLayout(null);
		
		l40 = new JLabel("Sahyadri  Student  Rank  List");
	    l40.setBounds(375,5,600,100);
	    l40.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
	    l41 = new JLabel("All  Time  VTU  Sahyadri  Toppers  List");
	    l41.setBounds(285,175,480,100);
	    l41.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    b30 = new JButton("VIEW");
		b30.setBounds(820,200,120,50);
		b30.setFont(new Font("Arial",Font.PLAIN,20));
		b30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("VIEW") == true) {
					StudentTopperzList stl = new StudentTopperzList(usn);
				}
			}
		});
	    
	    l42 = new JLabel("List  of  Students  with  BackLog's");
	    l42.setBounds(300,320,450,100);
	    l42.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    b31 = new JButton("VIEW");
		b31.setBounds(820,345,120,50);
		b31.setFont(new Font("Arial",Font.PLAIN,20));
		b31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("VIEW") == true) {
					BacklogStudentzList bsl = new BacklogStudentzList(usn);
				}
			}
		});
	    
		b32 = new JButton("<=]");
		b32.setBounds(1080,500,58,45);
		b32.setFont(new Font("Arial",Font.PLAIN,16));
		b32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
					panel3.setVisible(false);
				}
			}
		});
	    
	    panel3.add(l40);
	    panel3.add(l41);
	    panel3.add(b30);
	    panel3.add(l42);
	    panel3.add(b31);
	    panel3.add(b32);
	    if(PanelName.equals("panel3")) {
	    	panel3.setVisible(true);
	    }
	    else {
	    panel3.setVisible(false);
	    }
	    
	    
		//PANEL 7 CREATION - ADMIN PROFILE
	    panel7 = new JPanel();
		panel7.setBounds(300,230,1240,580);
		panel7.setLayout(null);
		
		l31 = new JLabel("My   User   Profile");
	    l31.setBounds(475,0,600,100);
	    l31.setFont(new Font("Comic Sans MS",Font.BOLD,28));
	    
	    l32 = new JLabel();
	    l32.setBounds(50,100,175,170);
	    ImageIcon imgic5;
	    if(MorF.equals("Male")) {
	    	imgic5 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\boy2.png");
	    }
	    else if(MorF.equals("Female")) {
	    	imgic5 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\926460.png");
	    }
	    else {
	    	imgic5 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\person.png");
	    }
	    Image img5 = imgic5.getImage();
		Image modifiedimage5 = img5.getScaledInstance(175,150,java.awt.Image.SCALE_SMOOTH);
		imgic5 = new ImageIcon(modifiedimage5);
		l32.setIcon(imgic5);
		
		l33 = new JLabel("NAME  :-   "+StudentName+"   { STUDENT }");
	    l33.setBounds(290,40,520,200);
	    l33.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    l34 = new JLabel("ID          :-   @" + StudentName + rand.nextInt(1000,10000));
	    l34.setBounds(290,90,500,200);
	    l34.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    l35 = new JLabel("EMAIL   :-   " + StudentName + rand.nextInt(1000,10000) + "@gmail.com");
	    l35.setBounds(290,140,500,200);
	    l35.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b26 = new JButton("EDIT");
		b26.setBounds(1000,150,125,50);
		b26.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
		b26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("EDIT") == true) {
					
				}
			}
		});
		
		try {
		    Connection con = CP.createCon();
			String query = "select SID,SDOB from student where USN=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, usn);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				id = set.getInt(1);
				dob = set.getString(2);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		try {
		    Connection con = CP.createCon();
			String query = "select SNoProj,SInternShip,SBACKLOGS from academicachievements where USN=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, usn);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				project = set.getInt(1);
				internship = set.getInt(2);
				backlog = set.getInt(3);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	     
	    l36 = new JLabel("ROLL_NO   :-   "+ id +"                                   USN   :-   " + usn + "                               DOB    :-   " + dob);
	    l36.setBounds(50,290,1200,100); 
	    l36.setFont(new Font("Times New Roman",Font.PLAIN,24));
		
	    l37 = new JLabel("ORIGIN   :-   India                                  STATE   :-   Karnataka                                CITY   :-   Mangalore ");
	    l37.setBounds(50,350,1200,100);
	    l37.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    l38 = new JLabel("BACKLOGS   :-   "+ backlog +"                                PROJECTS   :-   " + project+ "                                       INTERNSHIP   :-    " + internship);
	    l38.setBounds(50,410,1200,100);
	    l38.setFont(new Font("Times New Roman",Font.PLAIN,24));
		
	    l39 = new JLabel("MY   BIO   :");
	    l39.setBounds(110,480,150,100);
	    l39.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    str3 = "I am a Student...";
	    ta2 = new JTextArea(str3);
		ta2.setBounds(300,500,600,60);
		ta2.setEditable(true);
		sp2 = new JScrollPane(ta2);
		sp2.setBounds(300,500,600,60);
//		sp2.setBorder(BorderFactory.createTitledBorder("Server Output"));
		ta2.setFont(new Font("Gothic",Font.PLAIN,24));
		ta2.setRows(3);
		ta2.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	ta2.setText(str3);
		    }
		    public void focusLost(FocusEvent e) {
		    	ta2.setText(str3);	    	
		    }
		});
		ta2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
	    			String str4 = ta2.getText();
	    			str3 = str4;
		        }
	    	}
	    });
		
		b27 = new JButton("<=]");
		b27.setBounds(1080,500,58,45);
		b27.setFont(new Font("Arial",Font.PLAIN,16));
		b27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
					panel7.setVisible(false);
				}
			}
		});
	    
	    panel7.add(l31);
		panel7.add(l32);
	    panel7.add(l33);
	    panel7.add(l34);
	    panel7.add(l35);
	    panel7.add(b26);
	    panel7.add(l36);
	    panel7.add(l37);
	    panel7.add(l38);
	    panel7.add(l39);
	    panel7.add(sp2);
	    panel7.add(b27);
	    if(PanelName.equals("panel7")) {
	    	panel7.setVisible(true);
	    }
	    else {
	    	panel7.setVisible(false);
	    }
		
		//PANEL 2 CREATION - MENU CREATION
		panel2 = new JPanel();
		panel2.setBounds(0,145,303,745);
		panel2.setLayout(null);
		panel2.setBorder(border1);
		
		b2 = new JButton();
		b2.setBounds(10,10,50,50);
//		b2.setBorder(new RoundedBorder(30));
		b2.setForeground(Color.BLUE);
		ImageIcon imgic3 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\menue.png");
		Image img3 = imgic3.getImage();
		Image modifiedimage3 = img3.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		imgic3 = new ImageIcon(modifiedimage3);
		b2.setIcon(imgic3);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					if(b7.isShowing()==true) 
						b7.setVisible(false);
					else
						b7.setVisible(true);
					if(b8.isShowing()==true) 
						b8.setVisible(false);
					else
						b8.setVisible(true);
					if(b9.isShowing()==true) 
						b9.setVisible(false);
					else
						b9.setVisible(true);
					if(b10.isShowing()==true) 
						b10.setVisible(false);
					else
						b10.setVisible(true);
					if(b28.isShowing()==true) 
						b28.setVisible(false);
					else
						b28.setVisible(true);
					if(b29.isShowing()==true) 
						b29.setVisible(false);
					else
						b29.setVisible(true);
					if(b11.isShowing()==true) 
						b11.setVisible(false);
					else
						b11.setVisible(true);
					
			}
		});
	
		b7 = new JButton("HOME");
		b7.setBounds(75,70,150,50);
		b7.setForeground(Color.BLACK);
		b7.setBorder(new RoundedBorder(20));
		b7.setFont(new Font("Arial",Font.PLAIN,16));
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("HOME") == true) {
					if(panel4.isShowing()==true || panel5.isShowing()==true || panel3.isShowing()==true) {
						panel4.setVisible(false);
						panel3.setVisible(false);
						panel5.setVisible(false);
					}
					panel7.setVisible(true);
				}
			}
		});
		

		
	    b8 = new JButton("MY SUBJECTS");
		b8.setBounds(50,170,200,50);
		b8.setForeground(Color.BLACK);
		b8.setBorder(new RoundedBorder(30));
		b8.setFont(new Font("Arial",Font.PLAIN,16));
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("MY SUBJECTS") == true) {
					DisplayMySubjects dms = new DisplayMySubjects(usn);
				}
			}
		});
		
		b9 = new JButton("MY FACULTY");
		b9.setBounds(50,250,200,50);
		b9.setForeground(Color.BLACK);
		b9.setBorder(new RoundedBorder(30));
		b9.setFont(new Font("Arial",Font.PLAIN,16));
		b9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String stg = ae.getActionCommand();
			if(stg.equals("MY FACULTY") == true) {
				DisplayMyFaculty dms = new DisplayMyFaculty(usn);
				}	
			}
		});
		
		b10 = new JButton("MY PERFORMANCE");
		b10.setBounds(40,330,220,50);
		b10.setForeground(Color.BLACK);
		b10.setBorder(new RoundedBorder(30));
		b10.setFont(new Font("Arial",Font.PLAIN,16));
		b10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String stg = ae.getActionCommand();
			if(stg.equals("MY PERFORMANCE") == true) {
				if(panel7.isShowing()==true || panel5.isShowing()==true || panel3.isShowing()==true) {
					panel7.setVisible(false);
					panel5.setVisible(false);
					panel3.setVisible(false);
				}
				if(panel4.isShowing()!=true)
					panel4.setVisible(true);
				else
					panel4.setVisible(false);
				}
			}
		});
		
		b28 = new JButton("RANK LIST");
		b28.setBounds(50,410,200,50);
		b28.setForeground(Color.BLACK);
		b28.setBorder(new RoundedBorder(30));
		b28.setFont(new Font("Arial",Font.PLAIN,16));
		b28.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String stg = ae.getActionCommand();
			if(stg.equals("RANK LIST") == true) {
				if(panel4.isShowing()==true || panel5.isShowing()==true || panel7.isShowing()==true) {
					panel5.setVisible(false);
					panel4.setVisible(false);
					panel7.setVisible(false);
				}
				if(panel3.isShowing()!=true)
					panel3.setVisible(true);
				else
					panel3.setVisible(false);
				}
			}
		});
		
		b29 = new JButton("FEEDBACK");
		b29.setBounds(50,490,200,50);
		b29.setForeground(Color.BLACK);
		b29.setBorder(new RoundedBorder(30));
		b29.setFont(new Font("Arial",Font.PLAIN,16));
		b29.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String stg = ae.getActionCommand();
			if(stg.equals("FEEDBACK") == true) {
				StudentFeedbackPage sfp= new StudentFeedbackPage(usn);
				}
			}
		});
		
		b11 = new JButton("LOGOUT   <=]");
		b11.setBounds(75,590,150,50);
		b11.setForeground(Color.BLACK);
		b11.setBorder(new RoundedBorder(20));
		b11.setFont(new Font("Arial",Font.PLAIN,16));
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("LOGOUT   <=]") == true) {
					Student_Panel sp = new Student_Panel();
				}
			}
		});
		
		panel2.add(b2);
		panel2.add(b7);
		panel2.add(b8);
		panel2.add(b9);
		panel2.add(b10);
		panel2.add(b28);
		panel2.add(b29);
		panel2.add(b11);
	
		
		// frame add-ons
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(b1);
		frame.add(l4);
		frame.add(l9);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(panel5);
		frame.add(panel7);
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
		Student_Panel_Start aps = new Student_Panel_Start("4SF20CS004","Anil","Male","panel7");
	}
}
