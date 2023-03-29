package swings;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import mysql.CP;
import mysql.GPATable;
import mysql.GPATableOperationsDB;

public class StudentCGPACalculation {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JPanel panel1;
	JScrollPane sp;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l13,l20,l21,l22,l23,l24,l25,l26,l27;
	JComboBox cb1,cb2;
	JButton b1,b2;
		
	//OTHER VARIABLES
	String USN;
	CP cpcon;
	Connection con;
	String StudentName,Gender,si_id,Dept;
	int sem,scheme;
	double cgpa;
	double arr[] = new double[10];
		
	
	public StudentCGPACalculation() {
		initialize();	
	}
	
	public StudentCGPACalculation(String usn) {
		this.USN = usn;
		initialize();	
	}
	
	public void initialize() {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,875);
		
		//PANEL 1 CREATION - HOME BUTTON CONTENTS
	    panel1 = new JPanel();
	    panel1.setBounds(0,0,1525,875);
	    panel1.setLayout(null);
	    panel1.setPreferredSize(new Dimension(1510,1300));
	    
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
		
		l2 = new JLabel("CGPA  CALCULATION  PORTAL");
		l2.setBounds(500,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
	    
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
			Dept = si_id.substring(2,4);
			
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
	    
		if(Dept.equals("CS")) {}
		else {
			Object[] options = { "OK"};
			int result = JOptionPane.showOptionDialog(null, "ALERT !! Sorry to inform you that this feature is open only to CSE Department as of now. We are Extremely Sorry for the Inconvinience Caused.","Information",
			 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			 null, options, options[0]);
			if(result == JOptionPane.YES_OPTION) {
				Student_Panel_Start sps = new Student_Panel_Start(USN,StudentName,Gender,"panel5");
			}
		}
		
		l3 = new JLabel("              My  Current  SEM  :-     " + sem +"                                                       Current  Scheme  of  Study  :-     " + scheme);
	    l3.setBounds(40,130,1500,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,30));
	  
		 
		l4 = new JLabel("1st  Semester  SGPA");
	    l4.setBounds(400,240,400,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l20 = new JLabel();
	    l20.setBounds(900,260,125,60);
	    l20.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
		
		l5 = new JLabel("2nd  Semester  SGPA");
	    l5.setBounds(400,350,750,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	   
	    l21 = new JLabel();
	    l21.setBounds(900,370,125,60);
	    l21.setFont(new Font("Times New Roman",Font.PLAIN,28));
		 
	    
		l6 = new JLabel("3rd  Semester  SGPA");
	    l6.setBounds(400,460,750,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	   
	    l22 = new JLabel();
	    l22.setBounds(900,480,125,60);
	    l22.setFont(new Font("Times New Roman",Font.PLAIN,28));
	
	    
		l7 = new JLabel("4th  Semester  SGPA");
	    l7.setBounds(400,570,750,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l23 = new JLabel();
	    l23.setBounds(900,590,125,60);
	    l23.setFont(new Font("Times New Roman",Font.PLAIN,28));
	
	    
		l8 = new JLabel("5th  Semester  SGPA");
	    l8.setBounds(400,680,750,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,28));
	   
	    l24 = new JLabel();
	    l24.setBounds(900,700,125,60);
	    l24.setFont(new Font("Times New Roman",Font.PLAIN,28));
		
	    
		l9 = new JLabel("6th  Semester  SGPA");
	    l9.setBounds(400,790,750,100);
	    l9.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l25 = new JLabel();
	    l25.setBounds(900,810,125,60);
	    l25.setFont(new Font("Times New Roman",Font.PLAIN,28));
	  
	    
		l10 = new JLabel("7th  Semester  SGPA");
	    l10.setBounds(400,900,750,100);
	    l10.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l26 = new JLabel();
	    l26.setBounds(900,920,125,60);
	    l26.setFont(new Font("Times New Roman",Font.PLAIN,28));
	
	    
		l11 = new JLabel("8th  Semester  SGPA");
	    l11.setBounds(400,1010,750,100);
	    l11.setFont(new Font("Times New Roman",Font.PLAIN,28));
	   
	    l27 = new JLabel();
	    l27.setBounds(900,1030,125,60);
	    l27.setFont(new Font("Times New Roman",Font.PLAIN,28));
		
	    
	    try {
			
			con = CP.createCon();
			
			for(int i=1; i<=8; i++) {
			
				String query = "Select SGPA from GPA where usn=? and sem=?;";
			
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, USN);
				pstmt.setInt(2, i);
				ResultSet set = pstmt.executeQuery();
				
			while(set.next()) {
				double semsgpa = set.getDouble(1);
					arr[i] = semsgpa;
				}
			}
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	    if(sem==1) {
	    	l20.setText(arr[1]+"");
		    l21.setText("Null");
		    l22.setText("Null");
		    l23.setText("Null");
		    l24.setText("Null");
		    l25.setText("Null");
		    l26.setText("Null");
		    l27.setText("Null");
	    }
	    else if(sem==2) {
	    	l20.setText(arr[1]+"");
		    l21.setText(arr[2]+"");
		    l22.setText("Null");
		    l23.setText("Null");
		    l24.setText("Null");
		    l25.setText("Null");
		    l26.setText("Null");
		    l27.setText("Null");
	    }
	    else if(sem==3) {
	    	l20.setText(arr[1]+"");
		    l21.setText(arr[2]+"");
		    l22.setText(arr[3]+"");
		    l23.setText("Null");
		    l24.setText("Null");
		    l25.setText("Null");
		    l26.setText("Null");
		    l27.setText("Null");
	    }
	    else if(sem==4) {
	    	l20.setText(arr[1]+"");
		    l21.setText(arr[2]+"");
		    l22.setText(arr[3]+"");
		    l23.setText(arr[4]+"");
		    l24.setText("Null");
		    l25.setText("Null");
		    l26.setText("Null");
		    l27.setText("Null");
	    }
	    else if(sem==5) {
	    	l20.setText(arr[1]+"");
		    l21.setText(arr[2]+"");
		    l22.setText(arr[3]+"");
		    l23.setText(arr[4]+"");
		    l24.setText(arr[5]+"");
		    l25.setText("Null");
		    l26.setText("Null");
		    l27.setText("Null");
	    }
	    else if(sem==6) {
	    	l20.setText(arr[1]+"");
		    l21.setText(arr[2]+"");
		    l22.setText(arr[3]+"");
		    l23.setText(arr[4]+"");
		    l24.setText(arr[5]+"");
		    l25.setText(arr[6]+"");
		    l26.setText("Null");
		    l27.setText("Null");
	    }
	    else if(sem==7) {
	    	l20.setText(arr[1]+"");
		    l21.setText(arr[2]+"");
		    l22.setText(arr[3]+"");
		    l23.setText(arr[4]+"");
		    l24.setText(arr[5]+"");
		    l25.setText(arr[6]+"");
		    l26.setText(arr[7]+"");
		    l27.setText("Null");
	    }
	    else if(sem==8) {
	    	l20.setText(arr[1]+"");
		    l21.setText(arr[2]+"");
		    l22.setText(arr[3]+"");
		    l23.setText(arr[4]+"");
		    l24.setText(arr[5]+"");
		    l25.setText(arr[6]+"");
		    l26.setText(arr[7]+"");
		    l27.setText(arr[8]+"");
	    }
	    
	    
	    l13 = new JLabel();
	    l13.setBounds(580,400,500,100);
	    l13.setFont(new Font("Comic Sans MS",Font.BOLD,19));
	    
	    
		b1 = new JButton("CALCULATE");
		b1.setBounds(620,1150,150,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("CALCULATE") == true) {
					
					if(sem!=8) {
						JOptionPane.showMessageDialog(frame,"Sorry!! CGPA can be calculated only after the Successful Completion of 8th Semester.","Error Message",JOptionPane.ERROR_MESSAGE);
					}
					else {
						double totalcredscored = arr[1]*21 + arr[2]*21 + arr[3]*24 + arr[4]*24 + arr[5]*25 + arr[6]*24 + arr[7]*20 + arr[8]*18;
						cgpa = (totalcredscored/1770.00 )* 10.00;
						l13.setText(String.format("Congratulations!! You Have achieved an Overall CGPA of  %.2f ", cgpa));
						JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
						l13.setVisible(true);
						
					}
				}
			}
		});
		
		
		b2 = new JButton("BACK");
		b2.setBounds(925,1150,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Student_Panel_Start sps = new Student_Panel_Start(USN,StudentName,Gender,"panel5");
				}
			}
		});
	    
		panel1.add(l1);
		panel1.add(l0);
		panel1.add(l2);
		panel1.add(l3);
		panel1.add(l4);
		panel1.add(l5);
		panel1.add(l6);
		panel1.add(l7);
		panel1.add(l8);
		panel1.add(l9);
		panel1.add(l10);
		panel1.add(l11);
		panel1.add(l20);
		panel1.add(l21);
		panel1.add(l22);
		panel1.add(l23);
		panel1.add(l24);
		panel1.add(l25);
		panel1.add(l26);
		panel1.add(l27);
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(l13);
	    panel1.setVisible(true);
	    
	    sp = new JScrollPane(panel1);
		sp.setBounds(0,0,1525,875);
		sp.setBackground(Color.cyan);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.getVerticalScrollBar().setUnitIncrement(35);
	    
		//FRAME Add ON's
	    frame.add(sp);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		StudentCGPACalculation ssc = new StudentCGPACalculation("4SF20CS030");
	}
	
}
