package swings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;

import mysql.CP;
import mysql.TeachesTable;
import mysql.TeachesTableOperationsDB;



public class AssignFacultyToClass {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	JPanel panel1;
	JScrollPane sp;
	JTextField tf1;
	JButton b0,b1,b2,b3;	
	JComboBox cb1,cb2,cb3,cb4;
	JComboBox<String> cb5;
	
	//OTHER VARIABLES
	Connection con;
	String AdminName;
	String FName="",FGender="",FPhno="",FEmail="";
	String Batch,Dept,Section,SubCode,si_id;
	int FID,Sem,AcademicYear;
	
	public AssignFacultyToClass() {
		initialize();
	}
	
	public AssignFacultyToClass(String adname) {
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
		
		//PANEL 1 CREATION - HOME BUTTON CONTENTS
	    panel1 = new JPanel();
	    panel1.setBounds(0,0,1525,875);
	    panel1.setLayout(null);
	    panel1.setPreferredSize(new Dimension(1510,1150));
		
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
		
		l2 = new JLabel("ASSIGN   FACULTY   TO   A   CLASS");
		l2.setBounds(460,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		JOptionPane.showMessageDialog(frame,"ALERT !! Please Note that this Panel can be used to Assign Faculties of 'CSE' Department Only & that all the Subjects are of 2018 Scheme. ","Warning Message",JOptionPane.WARNING_MESSAGE);
		
		l3 = new JLabel("Enter  Faculty  ID  :  ");
	    l3.setBounds(475,140,300,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
		
	    tf1 = new JTextField("enter fid");
		tf1.setBounds(725,160,200,60);
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.ITALIC,26));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf1.getText().trim().equals("enter fid"))
		        	tf1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf1.getText().trim().equals(""))
		            tf1.setText("enter fid");		    	
		    }
		});
		
		b0 = new JButton();
		b0.setBounds(955,163,50,50);
		b0.setBorder(new RoundedBorder(20));
		b0.setForeground(Color.BLUE);
		ImageIcon imgic0 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\search-icon.png");
		Image img0 = imgic0.getImage();
		Image modifiedimage0 = img0.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		imgic0 = new ImageIcon(modifiedimage0);
		b0.setIcon(imgic0);
		b0.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				try {
		    		  con = CP.createCon();
		    		  
		    		 FID =   Integer.parseInt(tf1.getText().trim());
		  			String query = "select FFNAME,FLNAME,FGENDER,FPHNO,FEMAIL from faculty where fid=?;";

		  			PreparedStatement pstmt = con.prepareStatement(query);
		  			pstmt.setInt(1,FID);
		  			
		  			ResultSet set = pstmt.executeQuery();
			  		
		  			while(set.next()) {
		  				String fname = set.getString(1);
		  				String lname = set.getString(2);
		  				FGender = set.getString(3);
		  				FPhno = set.getString(4);
		  				FEmail = set.getString(5);
		  				
		  				FName = fname + " " + lname;
		  			}			
		  			
		  			l4.setText("Faculty  Name :  " + FName);
		  			l5.setText("Faculty  Gender :  "  + FGender);
		  			l6.setText("Faculty  Phone :  "  + FPhno);
		  			l7.setText("Faculty  Email :  "  + FEmail);
	    	  	}
	  	    catch(Exception a2) {
	  	    	a2.printStackTrace();
	  	    }
				}
		});
		
		l4 = new JLabel("Faculty  Name :  " + FName);
	    l4.setBounds(100,240,600,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l5 = new JLabel("Faculty  Gender :  "  + FGender);
	    l5.setBounds(950,240,600,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l6 = new JLabel("Faculty  Phone :  "  + FPhno);
	    l6.setBounds(100,340,600,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    	    
	    l7 = new JLabel("Faculty  Email :  "  + FEmail);
	    l7.setBounds(950,340,600,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
		
//	    ************************  SELECT  CLASS  *******************************************
	    
	    l8 = new JLabel("~ ~ ~  CHOOSE  A  CLASS  ~ ~ ~  ");
	    l8.setBounds(525,450,600,100);
	    l8.setFont(new Font("Comic Sans MS",Font.PLAIN,28));
	    
	    l9 = new JLabel("Acdmic Year");
	    l9.setBounds(40,575,150,100);
	    l9.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"        ---","   2018-22","   2019-23","   2020-24","   2021-25"};
		cb1 = new JComboBox(column1);
		cb1.setBounds(210,595,150,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  if(cb1value.equals("        ---")) {}
		    	  else {Batch = cb1value.trim();}
		      }
		    });
	    
	    l10 = new JLabel("Department");
	    l10.setBounds(450,575,200,100);
	    l10.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"     ---","    CSE","    ISE","    AIML","    DS","    MECH","    CIVIL","    ECE"};
		cb2 = new JComboBox(column2);
		cb2.setBounds(625,595,125,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb2value= cb2.getSelectedItem().toString();
		    	  if(cb2value.equals("     ---")) {}
		    	  else{Dept = cb2value.trim();}
		      }
		    });
	    
	    l11 = new JLabel("Semester");
	    l11.setBounds(850,575,200,100);
	    l11.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column3[] = {"    0","    1","    2","    3","    4","    5","    6","    7","    8"};
		cb3 = new JComboBox(column3);
		cb3.setBounds(985,595,125,50);	
	    cb3.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb3value= cb3.getSelectedItem().toString();
		    	  if(cb3value.equals("    0")) {}
		    	  else{Sem = Integer.parseInt(cb3value.trim());}
		      }
		    });
	    
	    l12 = new JLabel("Section");
	    l12.setBounds(1200,575,200,100);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column4[] = new String[]{"     ---","     A","     B","     C","     D","     E","     F","     G","     H","     I","     J","     K","     L"};
		cb4 = new JComboBox(column4);
		cb4.setBounds(1310,595,125,50);	
	    cb4.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb4value= cb4.getSelectedItem().toString();
		    	  if(cb4value.equals("     ---")) {}
		    	  else{Section = cb4value.trim();}
		      }
		    });
	    
//	    ************************  SELECT  CLASS  *******************************************
	    
	    l13 = new JLabel("~ ~ ~  CHOOSE  A  SUBJECT  ~ ~ ~  ");
	    l13.setBounds(525,700,600,100);
	    l13.setFont(new Font("Comic Sans MS",Font.PLAIN,28));
		
	    l14 = new JLabel("Select   A   SubCode   from   the   List  :");
	    l14.setBounds(380,810,600,100);
	    l14.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column5[] = {"           ---"};
		cb5 = new JComboBox<>(column5);
		cb5.setBounds(870,830,200,60);	
	    cb5.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  SubCode = cb5.getSelectedItem().toString().trim();
		      }
		});
	    
	    b3 = new JButton();
		b3.setBounds(1100,833,50,50);
		b3.setBorder(new RoundedBorder(20));
		b3.setForeground(Color.BLUE);
		ImageIcon imgic3 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\refresh-icon.png");
		Image img3 = imgic3.getImage();
		Image modifiedimage3 = img3.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		imgic3 = new ImageIcon(modifiedimage3);
		b3.setIcon(imgic3);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				cb5.setSelectedIndex(0);
		    	  for(int i=cb5.getItemCount()-1; i>=1; i--) {
		  				cb5.removeItemAt(i);
		  			}
		    	  
		    	  if(Sem==1) {
		    		  cb5.addItem("     18MAT11");
		    		  cb5.addItem("     18PHY12");
		    		  cb5.addItem("     18ELE13");
		    		  cb5.addItem("     18CIV14");
		    		  cb5.addItem("     18EGLD15");
		    		  cb5.addItem("     18PHYL16");
		    		  cb5.addItem("     18ELEL17");
		    		  cb5.addItem("     18EGH18");
		    	  }
		    	  else if(Sem==2) {
		    		  cb5.addItem("     18MAT21");
		    		  cb5.addItem("     18CHE22");
		    		  cb5.addItem("     18CPS23");
		    		  cb5.addItem("     18ELN24");
		    		  cb5.addItem("     18ME25");
		    		  cb5.addItem("     18CHEL26");
		    		  cb5.addItem("     18CPL27");
		    		  cb5.addItem("     18EGH28");
		    	  }
		    	  else if(Sem==3) {
		    		  cb5.addItem("     18MAT31");
		    		  cb5.addItem("     18CS32");
		    		  cb5.addItem("     18CS33");
		    		  cb5.addItem("     18CS34");
		    		  cb5.addItem("     18CS35");
		    		  cb5.addItem("     18CS36");
		    		  cb5.addItem("     18CSL37");
		    		  cb5.addItem("     18CSL38");
		    		  cb5.addItem("     18K(VK/AK)39");
		    	  }
		    	  else if(Sem==4) {
		    		  cb5.addItem("     18MAT41");
		    		  cb5.addItem("     18CS42");
		    		  cb5.addItem("     18CS43");
		    		  cb5.addItem("     18CS44");
		    		  cb5.addItem("     18CS45");
		    		  cb5.addItem("     18CS46");
		    		  cb5.addItem("     18CSL47");
		    		  cb5.addItem("     18CSL48");
		    		  cb5.addItem("     18CPC49");
		    	  }
		    	  else if(Sem==5) {
		    		  cb5.addItem("     18CS51");
		    		  cb5.addItem("     18CS52");
		    		  cb5.addItem("     18CS53");
		    		  cb5.addItem("     18CS54");
		    		  cb5.addItem("     18CS55");
		    		  cb5.addItem("     18CS56");
		    		  cb5.addItem("     18CSL57");
		    		  cb5.addItem("     18CSL58");
		    		  cb5.addItem("     18CIV59");
		    	  }
		    	  else if(Sem==6) {
		    		  cb5.addItem("     18CS61");
		    		  cb5.addItem("     18CS62");
		    		  cb5.addItem("     18CS63");
		    		  cb5.addItem("     18CS64X");
		    		  cb5.addItem("     18CS65X");
		    		  cb5.addItem("     18CSL66");
		    		  cb5.addItem("     18CSL67");
		    		  cb5.addItem("     18CSMP68");
		    	  }
		    	  else if(Sem==7) {
		    		  cb5.addItem("     18CS71");
		    		  cb5.addItem("     18CS72");
		    		  cb5.addItem("     18CS73X");
		    		  cb5.addItem("     18CS74X ");
		    		  cb5.addItem("     18CS75X");
		    		  cb5.addItem("     18CSL76");
		    		  cb5.addItem("     18CSP77");
		    	  }
		    	  else if(Sem==8) {
		    		  cb5.addItem("     18CS81");
		    		  cb5.addItem("     18CS82X");
		    		  cb5.addItem("     18CSP83");
		    		  cb5.addItem("     18CSS84 ");
		    		  cb5.addItem("     18CSI85");
		    	  }
				}
		});
	    
	    
//	    ************************************************************************************
		
		b1 = new JButton("ASSIGN");
		b1.setBounds(550,1000,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("ASSIGN") == true) {

					try {
					si_id = Batch.substring(2,4) + Dept.substring(0,2) + Sem + Section;
					String temp = JOptionPane.showInputDialog("Please Enter Academic Year to Continue ??",JOptionPane.QUESTION_MESSAGE);
					AcademicYear = Integer.parseInt(temp.trim());
					TeachesTable tt = new TeachesTable(si_id,FID,SubCode,AcademicYear);
//					System.out.println(si_id + " " + FID + " " + SubCode + " " + AcademicYear);
					TeachesTableOperationsDB.insertintoTeachesTable(tt);
					JOptionPane.showMessageDialog(frame,"Successful!! " + FName + " assigned to class " + si_id.substring(4) + " for Academic Year " + AcademicYear + " .","Information Message",JOptionPane.INFORMATION_MESSAGE);
					
					tf1.setText("enter fid");
					cb1.setSelectedIndex(0);
					cb2.setSelectedIndex(0);
					cb3.setSelectedIndex(0);
					cb4.setSelectedIndex(0);
					cb5.setSelectedIndex(0);
					for(int i=cb5.getItemCount()-1; i>=1; i--) {
		  				cb5.removeItemAt(i);
		  			}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(frame,"Invalid Credentials!! Please Enter valid details and Try Again Later","Error Message",JOptionPane.ERROR_MESSAGE);
						tf1.setText("enter fid");
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
						cb3.setSelectedIndex(0);
						cb4.setSelectedIndex(0);
						cb5.setSelectedIndex(0);
						for(int i=cb5.getItemCount()-1; i>=1; i--) {
			  				cb5.removeItemAt(i);
			  			}
					}
				}
			}
		});
		
		b2 = new JButton("BACK");
		b2.setBounds(850,1000,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Admin_Panel_Start aps = new Admin_Panel_Start(AdminName,"panel3");
					}
			}
		});
		
		//FRAME Add on's
		panel1.add(l0);
		panel1.add(l1);
		panel1.add(l2);
		panel1.add(l3);
		panel1.add(tf1);
		panel1.add(b0);
		panel1.add(l4);
		panel1.add(l5);
		panel1.add(l6);
		panel1.add(l7);
		panel1.add(l8);
		panel1.add(l9);
		panel1.add(cb1);
		panel1.add(l10);
		panel1.add(cb2);
		panel1.add(l11);
		panel1.add(cb3);
		panel1.add(l12);
		panel1.add(cb4);
		panel1.add(l13);
		panel1.add(l14);
		panel1.add(cb5);
		panel1.add(b3);
		panel1.add(b1);
		panel1.add(b2);
		
		//FRAME ADD ON's
		sp = new JScrollPane(panel1);
		sp.setBounds(0,0,1525,875);
		sp.setBackground(Color.cyan);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.getVerticalScrollBar().setUnitIncrement(35);
	    
		//FRAME Add ON's
	    frame.add(sp);
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
		AssignFacultyToClass aftc = new AssignFacultyToClass(); 
	}
}
