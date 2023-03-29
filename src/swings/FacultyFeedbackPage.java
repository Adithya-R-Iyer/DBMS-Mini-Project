package swings;

import javax.swing.*;

import mysql.CP;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FacultyFeedbackPage {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l10,l11,l12,l13,l14,l15;
	JRadioButton rb,rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12,rb13,rb14,rb15,rb16,rb17,rb18,rb19,rb20;
	ButtonGroup bg1,bg2,bg3,bg4;
	JSlider slider;
	JComboBox<String> cb1,cb2,cb3;
	JButton b2;
	JPanel panel1;
	JTextArea ta1;
	JScrollPane sp,sp1;
	
	//OTHER VARIBLES
	int FID;
	Connection con;
	String FacultyName,Gender,StudentName,StudentUSN,Section,si_id,SubName="",SubCode="",Scheme="";
	int Sem,join_year,ay=2022;
//	String arr[] = new String[50];
	 ArrayList<String> arr = new ArrayList<>(50);
	
	public FacultyFeedbackPage() {
		initialize();
	}
	
	public FacultyFeedbackPage(int fid) {
		this.FID = fid;
		initialize();
	}
	
	public void  initialize() {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,1000);
		
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
		
		l2 = new JLabel("MY    STUDENTs    FEEDBACK    PAGE");
		l2.setBounds(480,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		
		try {
		    con = CP.createCon();
			String query = "select ffname,fgender,join_year from faculty where fid=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, FID);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				 FacultyName = set.getString(1);
				 Gender = set.getString(2);
				 join_year = set.getInt(3);
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		l5 = new JLabel("USN  :  ");
	    l5.setBounds(1100,150,300,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
		
	    String column3[] = {"                ---"};
		cb3 = new JComboBox<>(column3);
		cb3.setBounds(1200,175,250,50);	
	    cb3.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  if(cb3.getItemCount()>=2 && cb3.getSelectedIndex()!=0) {

		    	  StudentUSN= cb3.getSelectedItem().toString().trim();
		    	  
		    	  try {
			  		    con = CP.createCon();
			  			String query = "select Punctuality,Regularity,Communication,Confidence,Rating,Review from feedback where fid=? and si_id=? and subcode=? and usn=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setString(2, si_id);
			  			pstmt.setString(3, SubCode);
			  			pstmt.setString(4, StudentUSN);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				String	Punctuality = set.getString(1);
			  				String	Regularity = set.getString(2);
			  				String	Communication = set.getString(3);
			  				String	Confidence = set.getString(4);
			  				int	Rating = set.getInt(5);
			  				String	Review = set.getString(6);
			  			
			  				if(Punctuality.equals("Below Avg.")) 
			  					rb1.doClick();
			  				else if(Punctuality.equals("Avg."))
			  					rb2.doClick();
			  				else if(Punctuality.equals("Good"))
			  					rb3.doClick();
			  				else if(Punctuality.equals("Very Good"))
			  					rb4.doClick();
			  				else if(Punctuality.equals("Excellent"))
			  					rb5.doClick();
			  				
			  				if(Regularity.equals("Below Avg.")) 
			  					rb6.doClick();
			  				else if(Regularity.equals("Avg."))
			  					rb7.doClick();
			  				else if(Regularity.equals("Good"))
			  					rb8.doClick();
			  				else if(Regularity.equals("Very Good"))
			  					rb9.doClick();
			  				else if(Regularity.equals("Excellent"))
			  					rb10.doClick();
			  				
			  				if(Communication.equals("Below Avg.")) 
			  					rb11.doClick();
			  				else if(Communication.equals("Avg."))
			  					rb12.doClick();
			  				else if(Communication.equals("Good"))
			  					rb13.doClick();
			  				else if(Communication.equals("Very Good"))
			  					rb14.doClick();
			  				else if(Communication.equals("Excellent"))
			  					rb15.doClick();
			  				
			  				if(Confidence.equals("Below Avg.")) 
			  					rb16.doClick();
			  				else if(Confidence.equals("Avg."))
			  					rb17.doClick();
			  				else if(Confidence.equals("Good"))
			  					rb18.doClick();
			  				else if(Confidence.equals("Very Good"))
			  					rb19.doClick();
			  				else if(Confidence.equals("Excellent"))
			  					rb20.doClick();
			  				
			  				slider.setValue(Rating);
			  				ta1.setText(Review);
			  				}
			  				
			  				rb1.setEnabled(false);
			  				rb2.setEnabled(false);
			  				rb3.setEnabled(false);
			  				rb4.setEnabled(false);
			  				rb5.setEnabled(false);
			  				rb6.setEnabled(false);
			  				rb7.setEnabled(false);
			  				rb8.setEnabled(false);
			  				rb9.setEnabled(false);
			  				rb10.setEnabled(false);
			  				rb11.setEnabled(false);
			  				rb12.setEnabled(false);
			  				rb13.setEnabled(false);
			  				rb14.setEnabled(false);
			  				rb15.setEnabled(false);
			  				rb16.setEnabled(false);
			  				rb17.setEnabled(false);
			  				rb18.setEnabled(false);
			  				rb19.setEnabled(false);
			  				rb20.setEnabled(false);
			  				slider.setEnabled(false);
			  				ta1.setEditable(false);
			  			
			  			}
			  		catch(Exception ee) {
			  			ee.printStackTrace();
			  		}
		    	  }
		      }
		    });
		
		l4 = new JLabel("Semester / Section  :  ");
	    l4.setBounds(550,150,300,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"      ---"};
		cb2 = new JComboBox<>(column2);
		cb2.setBounds(810,175,150,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {

		    	  if(cb2.getItemCount()>=2 && cb2.getSelectedIndex()!=0) {
		    		  
		    		  si_id = arr.get(cb2.getSelectedIndex()-1);
		    	  
		    	  String cb2value= cb2.getSelectedItem().toString().trim();
		    	  Sem = Integer.parseInt(cb2value.substring(0,1));
		    	  Section = cb2value.substring(1);
		    	  
		    	  cb3.setSelectedIndex(0);
		    	  for(int i=cb3.getItemCount()-1; i>=1; i--) {
		  				cb3.removeItemAt(i);
		  			}
		    	  
		    	  try {
			  		    con = CP.createCon();
			  			String query = "select usn from feedback where fid=? and si_id=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setString(2, si_id);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				String	USN = set.getString(1);
			  				 
			  				 cb3.addItem("        " + USN);
			  				}
			  			}
			  		catch(Exception ee) {
			  			ee.printStackTrace();
			  		}
		    	  
		    	  try {
			  		    con = CP.createCon();
			  			String query = "select t.subcode,s.sname,s.scheme from teaches t,subjects s where t.subcode=s.subcode and t.fid=? and t.si_id=? and t.facademicyear=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setString(2, si_id);
			  			pstmt.setInt(3, ay);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				SubCode = set.getString(1);
			  				SubName = set.getString(2);
			  				Scheme = Integer.toString(set.getInt(3));			  				
			  				}
			  			l6.setText("Subject  Code  :   " + SubCode);
			  			l7.setText("Subject  Name  :   " + SubName);
			  			l8.setText("Scheme  :   " + Scheme);
			  			}
			  		catch(Exception ee) {
			  			ee.printStackTrace();
			  		}
		    	  }
		      }
		    });
		
		l3 = new JLabel("Academic  Year  :   ");
	    l3.setBounds(75,150,300,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"      ---"};
		cb1 = new JComboBox<>(column1);
		cb1.setBounds(300,175,150,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  ay = Integer.parseInt(cb1value.trim());
		    	  
		    	  cb2.setSelectedIndex(0);
		    	  for(int i=cb2.getItemCount()-1; i>=1; i--) {
		  				cb2.removeItemAt(i);
		  			}
		    	  arr.removeAll(arr);
		    
		    	  try {
			  		    con = CP.createCon();
			  			String query = "select si_id from teaches where fid=? and FAcademicYear=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setInt(2, ay);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				String	si_id = set.getString(1);
			  				 arr.add(si_id);
			  				 
			  				 cb2.addItem("       " + si_id.substring(4));
			  				}
			  			}
			  		catch(Exception ee) {
			  			ee.printStackTrace();
			  		}
		      }
		    });
	    for(int i=join_year; i<=2022; i++) {
	    	cb1.addItem("     "+Integer.toString(i));
	    }
	    cb1.setSelectedItem("     " + Integer.toString(2022));
		
	    
	    l6 = new JLabel("Subject  Code  :   " + SubCode);
	    l6.setBounds(75,250,300,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l7 = new JLabel("Subject  Name  :   " + SubName);
	    l7.setBounds(550,250,300,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
	   
	    l8 = new JLabel("Scheme  :   " + Scheme);
	    l8.setBounds(1100,250,300,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    
	    // FEEDBACK FORM
	    
	    l10 = new JLabel("Punctuality in Class ?");
		l10.setBounds(30,339,250,150);
	    l10.setFont(new Font("Times New Roman",Font.BOLD,26));
	   
	    rb = new JRadioButton("xxx");
		Font newRadioButtonFont = new Font(rb.getFont().getName(),rb.getFont().getStyle(),18);
		
		rb1 = new JRadioButton("Below Avg.");
		rb1.setBounds(400,390,150,50);
	//	rb1.setBackground(Color.LIGHT_GRAY);
		rb1.setFont(newRadioButtonFont);

		rb2 = new JRadioButton("Avg.");
		rb2.setBounds(640,390,150,50);
	//	rb2.setBackground(Color.LIGHT_GRAY);
		rb2.setFont(newRadioButtonFont);

		rb3 = new JRadioButton("Good");
		rb3.setBounds(830,390,150,50);
	//	rb3.setBackground(Color.LIGHT_GRAY);
		rb3.setFont(newRadioButtonFont);

		rb4 = new JRadioButton("Very Good");
		rb4.setBounds(1050,390,150,50);
	//	rb4.setBackground(Color.LIGHT_GRAY);
		rb4.setFont(newRadioButtonFont);

		rb5 = new JRadioButton("Excellent");
		rb5.setBounds(1300,390,200,50);
	//	rb5.setBackground(Color.LIGHT_GRAY);
		rb5.setFont(newRadioButtonFont);

		bg1 = new ButtonGroup();
		bg1.add(rb1);
		bg1.add(rb2);
		bg1.add(rb3);
	    bg1.add(rb4);
	    bg1.add(rb5);
	    
	    
	    l11 = new JLabel("Regularity in Class ?");
		l11.setBounds(30,434,250,150);
	    l11.setFont(new Font("Times New Roman",Font.BOLD,27));
	    
	    rb6 = new JRadioButton("Below Avg.");
		rb6.setBounds(400,485,150,50);
	//	rb6.setBackground(Color.LIGHT_GRAY);
		rb6.setFont(newRadioButtonFont);

		rb7 = new JRadioButton("Avg.");
		rb7.setBounds(640,485,150,50);
	//	rb7.setBackground(Color.LIGHT_GRAY);
		rb7.setFont(newRadioButtonFont);

		rb8 = new JRadioButton("Good");
		rb8.setBounds(830,485,150,50);
	//	rb8.setBackground(Color.LIGHT_GRAY);
		rb8.setFont(newRadioButtonFont);

		rb9 = new JRadioButton("Very Good");
		rb9.setBounds(1050,485,150,50);
	//	rb9.setBackground(Color.LIGHT_GRAY);
		rb9.setFont(newRadioButtonFont);

		rb10 = new JRadioButton("Excellent");
		rb10.setBounds(1300,485,200,50);
	//	rb10.setBackground(Color.LIGHT_GRAY);
		rb10.setFont(newRadioButtonFont);

		bg2 = new ButtonGroup();
		bg2.add(rb6);
		bg2.add(rb7);
		bg2.add(rb8);
	    bg2.add(rb9);
	    bg2.add(rb10);

	    
	    l14 = new JLabel("Communication Skills ?");
		l14.setBounds(30,529,300,150);
	    l14.setFont(new Font("Times New Roman",Font.BOLD,27));
	    
	    rb11 = new JRadioButton("Below Avg.");
		rb11.setBounds(400,580,150,50);
	//	rb11.setBackground(Color.LIGHT_GRAY);
		rb11.setFont(newRadioButtonFont);

		rb12 = new JRadioButton("Avg.");
		rb12.setBounds(640,580,150,50);
	//	rb12.setBackground(Color.LIGHT_GRAY);
		rb12.setFont(newRadioButtonFont);

		rb13 = new JRadioButton("Good");
		rb13.setBounds(830,580,150,50);
	//	rb13.setBackground(Color.LIGHT_GRAY);
		rb13.setFont(newRadioButtonFont);

		rb14 = new JRadioButton("Very Good");
		rb14.setBounds(1050,580,150,50);
	//	rb14.setBackground(Color.LIGHT_GRAY);
		rb14.setFont(newRadioButtonFont);

		rb15 = new JRadioButton("Excellent");
		rb15.setBounds(1300,580,200,50);
	//	rb15.setBackground(Color.LIGHT_GRAY);
		rb15.setFont(newRadioButtonFont);

		bg3 = new ButtonGroup();
		bg3.add(rb11);
		bg3.add(rb12);
		bg3.add(rb13);
	    bg3.add(rb14);
	    bg3.add(rb15);
	   
	    
	    l15 = new JLabel("Self  Confidence ?");
		l15.setBounds(30,624,275,150);
	    l15.setFont(new Font("Times New Roman",Font.BOLD,27));
	    
	    rb16 = new JRadioButton("Below Avg.");
		rb16.setBounds(400,675,150,50);
	//	rb16.setBackground(Color.LIGHT_GRAY);
		rb16.setFont(newRadioButtonFont);

		rb17 = new JRadioButton("Avg.");
		rb17.setBounds(640,675,150,50);
	//	rb17.setBackground(Color.LIGHT_GRAY);
		rb17.setFont(newRadioButtonFont);

		rb18 = new JRadioButton("Good");
		rb18.setBounds(830,675,150,50);
	//	rb18.setBackground(Color.LIGHT_GRAY);
		rb18.setFont(newRadioButtonFont);

		rb19 = new JRadioButton("Very Good");
		rb19.setBounds(1050,675,150,50);
	//	rb19.setBackground(Color.LIGHT_GRAY);
		rb19.setFont(newRadioButtonFont);

		rb20 = new JRadioButton("Excellent");
		rb20.setBounds(1300,675,200,50);
	//	rb20.setBackground(Color.LIGHT_GRAY);
		rb20.setFont(newRadioButtonFont);

		bg4 = new ButtonGroup();
		bg4.add(rb16);
		bg4.add(rb17);
		bg4.add(rb18);
	    bg4.add(rb19);
	    bg4.add(rb20);
	    
	    
	    l13 = new JLabel("Overall  Rating  (0 - 10)  : ");
		l13.setBounds(200,810,400,50);
		l13.setFont(new Font("Times New Roman",Font.PLAIN,26));
		slider = new JSlider(0,10,5);
		slider.setBounds(600,830,550,50);
	//	slider.setBackground(Color.LIGHT_GRAY);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setFont(new Font("MV Boli",Font.PLAIN,14));

	    l12 = new JLabel("My  Review  :");
		l12.setBounds(250,900,200,150);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
//	    str1 = "write something...";
	    ta1 = new JTextArea();
		ta1.setBounds(500,950,800,125);
		ta1.setEditable(true);
		sp1 = new JScrollPane(ta1);
		sp1.setBounds(500,950,800,125);
		sp1.setBorder(BorderFactory.createTitledBorder("Server Output"));
		ta1.setFont(new Font("Gothic",Font.PLAIN,22));
		ta1.setRows(10);
		
		b2 = new JButton("BACK");
		b2.setBounds(1200,1150,150,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Faculty_Panel_Start sps = new Faculty_Panel_Start(FID,FacultyName,Gender,"panel7");
				}
			}
		});
		
		
		//PANEL 1 Add ON's
		panel1.add(l0);
		panel1.add(l1);
		panel1.add(l2);
		panel1.add(l5);
		panel1.add(cb3);
		panel1.add(l4);
		panel1.add(cb2);
		panel1.add(l3);
		panel1.add(cb1);
		panel1.add(l6);
		panel1.add(l7);
		panel1.add(l8);
		panel1.add(l10);
		panel1.add(rb1);
		panel1.add(rb2);
		panel1.add(rb3);
		panel1.add(rb4);
		panel1.add(rb5);
		panel1.add(l11);
		panel1.add(rb6);
		panel1.add(rb7);
		panel1.add(rb8);
		panel1.add(rb9);
		panel1.add(rb10);
		panel1.add(l13);
		panel1.add(slider);
		panel1.add(sp1);
		panel1.add(l12);
		panel1.add(l14);
		panel1.add(rb11);
		panel1.add(rb12);
		panel1.add(rb13);
		panel1.add(rb14);
		panel1.add(rb15);
		panel1.add(l15);
		panel1.add(rb16);
		panel1.add(rb17);
		panel1.add(rb18);
		panel1.add(rb19);
		panel1.add(rb20);
		panel1.add(b2);
//		panel1.add(l6);
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
		FacultyFeedbackPage ffp  = new FacultyFeedbackPage(2);
	}

}
