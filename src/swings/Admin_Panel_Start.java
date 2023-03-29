package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.*;


public class Admin_Panel_Start {
	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30,l31,l32,l33,l34,l35,l36,l37,l38,l39;
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
	Border border1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28;
	JTextArea ta1,ta2;
	JScrollPane sp1,sp2;
		
	// OTHER VARIABLES
	String str1,str3;
	String AdminName,temp,PanelName="";
	
	public Admin_Panel_Start(String Adnme) {
		AdminName = Adnme;
		initialize();
	}
		
	public Admin_Panel_Start(String Adnme,String pname) {  //LOGIN
		AdminName= Adnme;
		PanelName=pname;
		initialize();
	}
	public Admin_Panel_Start() {
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
		
		l2 = new JLabel("ADMINISTRATOR   PANEL");
		l2.setBounds(580,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel(comp(AdminName),SwingConstants.CENTER);
		l3.setBounds(280,110,1000,100);
	    l3.setFont(new Font("Times New Roman",Font.ITALIC,26));
	    l3.setVisible(true);
	    
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
				if(AdminName == "madan") {
					if(panel1.isShowing()==true || panel3.isShowing()==true || panel4.isShowing()==true || panel5.isShowing()==true || panel7.isShowing()==true) {
						panel1.setVisible(false);
						panel3.setVisible(false);
						panel4.setVisible(false);
						panel5.setVisible(false);
						panel7.setVisible(false);
					}
					if(panel6.isShowing()!=true)
						panel6.setVisible(true);
					else
						panel6.setVisible(false);
				}
				else if(AdminName == "adithya") {
					if(panel1.isShowing()==true || panel3.isShowing()==true || panel4.isShowing()==true || panel5.isShowing()==true || panel6.isShowing()==true) {
						panel1.setVisible(false);
						panel3.setVisible(false);
						panel4.setVisible(false);
						panel5.setVisible(false);
						panel6.setVisible(false);
					}
					if(panel7.isShowing()!=true)
						panel7.setVisible(true);
					else
						panel7.setVisible(false);
				
				}
				
			}
		});
		
		l4 = new JLabel("Profile",SwingConstants.CENTER);
	    l4.setBounds(1350,102,150,100);
	    l4.setFont(new Font("Comic Sans MS",Font.ITALIC,21));
	    
	    l9 = new JLabel();
	    l9.setBounds(300,230,1240,610);
	    border1 = BorderFactory.createLineBorder(Color.black,4);
		l9.setBorder(border1);
	    
		//PANEL 1 CREATION - HOME BUTTON CONTENTS
		panel1 = new JPanel();
		panel1.setBounds(300,230,1240,580);
		panel1.setLayout(null);
		
		l5 = new JLabel("View  Database's");
	    l5.setBounds(550,5,400,100);
	    l5.setFont(new Font("Comic Sans MS",Font.BOLD,28));
	    
	    l6 = new JLabel("To   View   SCEM   Faculty   Database   {All  Dept's}");
	    l6.setBounds(200,140,600,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,26));
		
	    b3 = new JButton("Click Here");
		b3.setBounds(865,180,140,35);
		b3.setFont(new Font("Arial",Font.PLAIN,18));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					DisplayFacultyRecord dfr = new DisplayFacultyRecord(AdminName);
				}
			}
		});
	    
	    l7 = new JLabel("To   View   SCEM   Student   Database   {All  Dept's}");
	    l7.setBounds(200,275,600,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    b4 = new JButton("Click Here");
		b4.setBounds(865,310,140,35);
		b4.setFont(new Font("Arial",Font.PLAIN,18));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					DisplayStudentRecord dsr = new DisplayStudentRecord(AdminName);
				}
			}
		});
	    
	    l8 = new JLabel("To   View   SCEM   Subject's   List   for   all   Branches");
	    l8.setBounds(200,405,600,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    b5 = new JButton("Click Here");
		b5.setBounds(865,440,140,35);
		b5.setFont(new Font("Arial",Font.PLAIN,18));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					DisplaySubjectsRecord dsp = new DisplaySubjectsRecord(AdminName);
				}
			}
		});
		
		b6 = new JButton("<=]");
		b6.setBounds(1100,525,58,40);
		b6.setFont(new Font("Arial",Font.PLAIN,16));
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
					panel1.setVisible(false);
				}
			}
		});
	    
	    panel1.add(l5);
	    panel1.add(l6);
	    panel1.add(l7);
	    panel1.add(l8);
	    panel1.add(b3);
	    panel1.add(b4);
	    panel1.add(b5);
	    panel1.add(b6);
	    if(PanelName.equals("panel1")) {
	    	panel1.setVisible(true);
	    }
	    else {
	    panel1.setVisible(false);
	    }
	    
	  //PANEL - 3 CREATION -> FACULTY RECORD UPDATION
	    panel3 = new JPanel();
		panel3.setBounds(300,230,1240,580);
		panel3.setLayout(null);
		
		l11 = new JLabel("Update  Faculty  Record's  In  Database");
	    l11.setBounds(400,5,600,100);
	    l11.setFont(new Font("Comic Sans MS",Font.BOLD,28));
		
	    l12 = new JLabel("Add   A   New   Faculty   Record");
	    l12.setBounds(300,130,450,100);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b12 = new JButton("ADD");
		b12.setBounds(800,150,120,50);
		b12.setFont(new Font("Arial",Font.PLAIN,18));
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("ADD") == true) {
					AddFacultyRecord afr = new AddFacultyRecord(AdminName);
				}
			}
		});
	    
	    l13 = new JLabel("Remove  An  Existing  Faculty  Record");
	    l13.setBounds(300,240,450,100);
	    l13.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b13 = new JButton("REMOVE");
		b13.setBounds(800,265,120,50);
		b13.setFont(new Font("Arial",Font.PLAIN,18));
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("REMOVE") == true) {
					RemoveFacultyRecord rfr = new RemoveFacultyRecord(AdminName);
				}
			}
		});
	    
	    l14 = new JLabel("Update  Faculty  Information  in  DB");
	    l14.setBounds(300,355,450,100);
	    l14.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b14 = new JButton("UPDATE");
		b14.setBounds(800,375,120,50);
		b14.setFont(new Font("Arial",Font.PLAIN,18));
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					UpdateFacultyRecord ufr = new UpdateFacultyRecord(AdminName);
				}
			}
		});
		
		l39 = new JLabel("Assign  Faculties  to  Classes");
	    l39.setBounds(300,470,450,100);
	    l39.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b28 = new JButton("ASSIGN");
		b28.setBounds(800,490,120,50);
		b28.setFont(new Font("Arial",Font.PLAIN,18));
		b28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("ASSIGN") == true) {
					AssignFacultyToClass afc = new AssignFacultyToClass(AdminName);
				}
			}
		});
		
		b15 = new JButton("<=]");
		b15.setBounds(1080,500,58,45);
		b15.setFont(new Font("Arial",Font.PLAIN,16));
		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
					panel3.setVisible(false);
				}
			}
		});
	    
	    panel3.add(l11);
	    panel3.add(l12);
	    panel3.add(b12);
	    panel3.add(l13);
	    panel3.add(b13);
	    panel3.add(l14);
	    panel3.add(b14);
	    panel3.add(b15);
	    panel3.add(l39);
	    panel3.add(b28);
	    if(PanelName.equals("panel3")) {
	    	panel3.setVisible(true);
	    }
	    else {
	    panel3.setVisible(false);
	    }
	    
	  //PANEL - 4 CREATION -> STUDENT RECORD UPDATION
	    panel4 = new JPanel();
		panel4.setBounds(300,230,1240,580);
		panel4.setLayout(null);
		
		l15 = new JLabel("Update  Student  Record's  In  Database");
	    l15.setBounds(400,5,600,100);
	    l15.setFont(new Font("Comic Sans MS",Font.BOLD,28));
		
	    l16 = new JLabel("Add   A   New   Student   Record");
	    l16.setBounds(300,135,450,100);
	    l16.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b16 = new JButton("ADD");
		b16.setBounds(800,155,120,50);
		b16.setFont(new Font("Arial",Font.PLAIN,18));
		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("ADD") == true) {
					AddStudentRecord asr = new AddStudentRecord(AdminName);
				}
			}
		});
	    
	    l17 = new JLabel("Remove  An  Existing  Student  Record");
	    l17.setBounds(300,250,450,100);
	    l17.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b17 = new JButton("REMOVE");
		b17.setBounds(800,275,120,50);
		b17.setFont(new Font("Arial",Font.PLAIN,18));
		b17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("REMOVE") == true) {
					RemoveStudentRecord rsr = new RemoveStudentRecord(AdminName);
				}
			}
		});
	    
	    l18 = new JLabel("Update  Student  Information  in  DB ");
	    l18.setBounds(300,370,450,100);
	    l18.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b18 = new JButton("UPDATE");
		b18.setBounds(800,390,120,50);
		b18.setFont(new Font("Arial",Font.PLAIN,18));
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					UpdateStudentRecord usr = new UpdateStudentRecord(AdminName);
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
		
		l19 = new JLabel("Update  Subject  Record's  In  Database");
	    l19.setBounds(400,5,600,100);
	    l19.setFont(new Font("Comic Sans MS",Font.BOLD,28));
		
	    l20 = new JLabel("Add   A   New   Subject   Record");
	    l20.setBounds(300,135,450,100);
	    l20.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b20 = new JButton("ADD");
		b20.setBounds(800,155,120,50);
		b20.setFont(new Font("Arial",Font.PLAIN,18));
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("ADD") == true) {
					AddSubjectsRecord asr = new AddSubjectsRecord(AdminName);
				}
			}
		});
	    
	    l21 = new JLabel("Remove  An  Existing  Subject  Record");
	    l21.setBounds(300,250,450,100);
	    l21.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b21 = new JButton("REMOVE");
		b21.setBounds(800,275,120,50);
		b21.setFont(new Font("Arial",Font.PLAIN,18));
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("REMOVE") == true) {
					RemoveSubjectsRecord rsr = new RemoveSubjectsRecord(AdminName);
				}
			}
		});
	    
	    l22 = new JLabel("Update  Subject  Information  in  DB ");
	    l22.setBounds(300,370,450,100);
	    l22.setFont(new Font("Times New Roman",Font.PLAIN,24));
	   
	    b22 = new JButton("UPDATE");
		b22.setBounds(800,390,120,50);
		b22.setFont(new Font("Arial",Font.PLAIN,18));
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					UpdateSubjectsRecord usr = new UpdateSubjectsRecord(AdminName);
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
					panel5.setVisible(false);
				}
			}
		});
	    
	    panel5.add(l19);
	    panel5.add(l20);
	    panel5.add(b20);
	    panel5.add(l21);
	    panel5.add(b21);
	    panel5.add(l22);
	    panel5.add(b22);
	    panel5.add(b23);
	    if(PanelName.equals("panel5")) {
	    	panel5.setVisible(true);
	    }
	    else {
	    panel5.setVisible(false);
	    }
	    
	    //PANEL 6 CREATION - ADMIN PROFILE
	    panel6 = new JPanel();
		panel6.setBounds(300,230,1240,580);
		panel6.setLayout(null);
		
		l23 = new JLabel("My   User   Profile");
	    l23.setBounds(475,0,600,100);
	    l23.setFont(new Font("Comic Sans MS",Font.BOLD,28));
	    
	    l24 = new JLabel();
	    l24.setBounds(50,120,175,150);
	    ImageIcon imgic4 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\madan.png");
		Image img4 = imgic4.getImage();
		Image modifiedimage4 = img4.getScaledInstance(175,150,java.awt.Image.SCALE_SMOOTH);
		imgic4 = new ImageIcon(modifiedimage4);
		l24.setIcon(imgic4);
		
		l25 = new JLabel("NAME  :-   Madan   R   Naik   { ADMIN }");
	    l25.setBounds(290,40,500,200);
	    l25.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    l26 = new JLabel("ID          :-   @madanrnaik2106");
	    l26.setBounds(290,90,500,200);
	    l26.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    l27 = new JLabel("EMAIL   :-   madrnaik2002@gmail.com");
	    l27.setBounds(290,140,500,200);
	    l27.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    b24 = new JButton("EDIT");
		b24.setBounds(1000,150,125,50);
		b24.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
		b24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("EDIT") == true) {
					
				}
			}
		});
	     
	    l28 = new JLabel("STAFF_ID   :-   1001                              STAFF_ROLE   :-   Admin                                     DOB    :-   18-Aug-2002");
	    l28.setBounds(50,290,1200,100);
	    l28.setFont(new Font("Times New Roman",Font.PLAIN,24));
		
	    l29 = new JLabel("ORIGIN   :-   India                                  STATE   :-   Karnataka                                            CITY   :-   Mangalore ");
	    l29.setBounds(50,350,1200,100);
	    l29.setFont(new Font("Times New Roman",Font.PLAIN,24));
		
	    l30 = new JLabel("MY   BIO   :");
	    l30.setBounds(100,410,200,100);
	    l30.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    str1 = "No one is more cherished in this world,\nthan someone who lightens the burden of another.";
	    ta1 = new JTextArea(str1);
		ta1.setBounds(300,450,600,100);
		ta1.setEditable(true);
		sp1 = new JScrollPane(ta1);
		sp1.setBounds(300,450,600,100);
//		sp1.setBorder(BorderFactory.createTitledBorder("Server Output"));
		ta1.setFont(new Font("Gothic",Font.PLAIN,24));
		ta1.setRows(5);
		ta1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	ta1.setText(str1);
		    }
		    public void focusLost(FocusEvent e) {
		    	ta1.setText(str1);	    	
		    }
		});
		ta1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
	    			String str2 = ta1.getText();
	    			str1 = str2;
		        }
	    	}
	    });
		
		b25 = new JButton("<=]");
		b25.setBounds(1080,500,58,45);
		b25.setFont(new Font("Arial",Font.PLAIN,16));
		b25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
					panel6.setVisible(false);
				}
			}
		});
	    
	    panel6.add(l23);
		panel6.add(l24);
	    panel6.add(l25);
	    panel6.add(l26);
	    panel6.add(l27);
	    panel6.add(b24);
	    panel6.add(l28);
	    panel6.add(l29);
	    panel6.add(l30);
	    panel6.add(sp1);
	    panel6.add(b25);
		panel6.setVisible(false);
	    
		//PANEL 7 CREATION - ADMIN PROFILE
	    panel7 = new JPanel();
		panel7.setBounds(300,230,1240,580);
		panel7.setLayout(null);
		
		l31 = new JLabel("My   User   Profile");
	    l31.setBounds(475,0,600,100);
	    l31.setFont(new Font("Comic Sans MS",Font.BOLD,28));
	    
	    l32 = new JLabel();
	    l32.setBounds(50,100,175,170);
	    ImageIcon imgic5 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\adithya.png");
		Image img5 = imgic5.getImage();
		Image modifiedimage5 = img5.getScaledInstance(175,150,java.awt.Image.SCALE_SMOOTH);
		imgic5 = new ImageIcon(modifiedimage5);
		l32.setIcon(imgic5);
		
		l33 = new JLabel("NAME  :-   Adithya   R   Iyer   { ADMIN }");
	    l33.setBounds(290,40,520,200);
	    l33.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    
	    l34 = new JLabel("ID          :-   @adithyaiyer1972");
	    l34.setBounds(290,90,500,200);
	    l34.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    l35 = new JLabel("EMAIL   :-   adikrishna1972@gmail.com");
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
	     
	    l36 = new JLabel("STAFF_ID   :-   1002                              STAFF_ROLE   :-   Admin                                     DOB    :-   19-Jul-2002");
	    l36.setBounds(50,290,1200,100);
	    l36.setFont(new Font("Times New Roman",Font.PLAIN,24));
		
	    l37 = new JLabel("ORIGIN   :-   India                                  STATE   :-   Karnataka                                            CITY   :-   Mangalore ");
	    l37.setBounds(50,350,1200,100);
	    l37.setFont(new Font("Times New Roman",Font.PLAIN,24));
		
	    l38 = new JLabel("MY   BIO   :");
	    l38.setBounds(100,410,200,100);
	    l38.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    str3 = "Good management is the art of making problems\nso interesting and their solutions so constructive that\neveryone wants to get to work and\ndeal with them";
	    ta2 = new JTextArea(str3);
		ta2.setBounds(300,450,600,100);
		ta2.setEditable(true);
		sp2 = new JScrollPane(ta2);
		sp2.setBounds(300,450,600,100);
//		sp2.setBorder(BorderFactory.createTitledBorder("Server Output"));
		ta2.setFont(new Font("Gothic",Font.PLAIN,24));
		ta2.setRows(5);
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
	    panel7.add(sp2);
	    panel7.add(b27);
		panel7.setVisible(false);
		
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
					if(l10.isShowing()==true) 
						l10.setVisible(false);
					else
						l10.setVisible(true);
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
					if(b11.isShowing()==true) 
						b11.setVisible(false);
					else
						b11.setVisible(true);
					
			}
		});
	
		b7 = new JButton("HOME");
		b7.setBounds(60,100,150,50);
		b7.setForeground(Color.BLACK);
		b7.setBorder(new RoundedBorder(20));
		b7.setFont(new Font("Arial",Font.PLAIN,16));
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("HOME") == true) {
					if(panel3.isShowing()==true || panel4.isShowing()==true || panel5.isShowing()==true || panel6.isShowing()==true || panel7.isShowing()==true) {
						panel3.setVisible(false);
						panel4.setVisible(false);
						panel5.setVisible(false);
						panel6.setVisible(false);
						panel7.setVisible(false);
					}
					if(panel1.isShowing()!=true)
						panel1.setVisible(true);
					else
						panel1.setVisible(false);
				}
			}
		});
		
		l10 = new JLabel("Update  Records  =>>");
	    l10.setBounds(15,170,275,100);
	    l10.setFont(new Font("Times New Roman",Font.BOLD,26));
		
	    b8 = new JButton("FACULTY");
		b8.setBounds(90,275,170,50);
		b8.setForeground(Color.BLACK);
		b8.setBorder(new RoundedBorder(30));
		b8.setFont(new Font("Arial",Font.PLAIN,16));
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("FACULTY") == true) {
					if(panel1.isShowing()==true || panel4.isShowing()==true || panel5.isShowing()==true || panel6.isShowing()==true || panel7.isShowing()==true) {
						panel1.setVisible(false);
						panel4.setVisible(false);
						panel5.setVisible(false);
						panel6.setVisible(false);
						panel7.setVisible(false);
					}
					if(panel3.isShowing()!=true)
						panel3.setVisible(true);
					else
						panel3.setVisible(false);
				}
			}
		});
		
		b9 = new JButton("STUDENT");
		b9.setBounds(90,370,170,50);
		b9.setForeground(Color.BLACK);
		b9.setBorder(new RoundedBorder(30));
		b9.setFont(new Font("Arial",Font.PLAIN,16));
		b9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String stg = ae.getActionCommand();
			if(stg.equals("STUDENT") == true) {
				if(panel1.isShowing()==true || panel3.isShowing()==true || panel5.isShowing()==true || panel6.isShowing()==true || panel7.isShowing()==true) {
					panel1.setVisible(false);
					panel3.setVisible(false);
					panel5.setVisible(false);
					panel6.setVisible(false);
					panel7.setVisible(false);
				}
				if(panel4.isShowing()!=true)
					panel4.setVisible(true);
				else
					panel4.setVisible(false);
				}	
			}
		});
		
		b10 = new JButton("SUBJECTS");
		b10.setBounds(90,470,170,50);
		b10.setForeground(Color.BLACK);
		b10.setBorder(new RoundedBorder(30));
		b10.setFont(new Font("Arial",Font.PLAIN,16));
		b10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String stg = ae.getActionCommand();
			if(stg.equals("SUBJECTS") == true) {
				if(panel1.isShowing()==true || panel3.isShowing()==true || panel4.isShowing()==true || panel6.isShowing()==true || panel7.isShowing()==true) {
					panel1.setVisible(false);
					panel3.setVisible(false);
					panel4.setVisible(false);
					panel6.setVisible(false);
					panel7.setVisible(false);
				}
				if(panel5.isShowing()!=true)
					panel5.setVisible(true);
				else
					panel5.setVisible(false);
				}
			}
		});
		
		b11 = new JButton("LOGOUT   <=]");
		b11.setBounds(50,590,175,50);
		b11.setForeground(Color.BLACK);
		b11.setBorder(new RoundedBorder(20));
		b11.setFont(new Font("Arial",Font.PLAIN,16));
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("LOGOUT   <=]") == true) {
					Admin_Panel ap = new Admin_Panel();
				}
			}
		});
		
		panel2.add(b2);
		panel2.add(b7);
		panel2.add(l10);
		panel2.add(b8);
		panel2.add(b9);
		panel2.add(b10);
		panel2.add(b11);
	
		
		// frame add-ons
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(b1);
		frame.add(l4);
		frame.add(l9);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(panel5);
		frame.add(panel6);
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
	
	private static String comp(String adnme) {
		if(adnme=="madan") {
//			this.temp= "Welcome  !!!  Mr .  Madan   R   Naik";
			return "Welcome  !!!  Mr .  Madan   R   Naik";
		}
		else if(adnme == "adithya") {
//			this.temp = "Welcome  !!!  Mr .  Adithya   R   Iyer";
			return "Welcome  !!!  Mr .  Adithya   R   Iyer";
		}
		return "no match";
	}
	
	public static void main(String[] args) {
		Admin_Panel_Start aps = new Admin_Panel_Start("");
	}
}
