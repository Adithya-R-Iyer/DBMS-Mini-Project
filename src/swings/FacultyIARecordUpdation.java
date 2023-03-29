package swings;

import javax.swing.*;

import mysql.CP;
import mysql.GPATable;
import mysql.GPATableOperationsDB;
import mysql.IAMarksTable;
import mysql.IAMarksTableOperationsDB;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FacultyIARecordUpdation {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JComboBox<String> cb1,cb2,cb3;
	JButton b1,b2;
	JPanel panel1;
	JScrollPane sp,sp1;
	JTextField tf1,tf2,tf3,tf4;
	JTextArea ta1;
	
	//OTHER VARIBLES
	int FID;
	Connection con;
	String FacultyName,Gender,StudentName,StudentUSN,Section,si_id,SubName="",SubCode="",Scheme="";
	int Sem,join_year,ay=2022;
	int ia1mrks,ia2mrks,ia3mrks,assgnmrks;
	String str1,finalia="",Status="",Remarks="";
//	String arr[] = new String[50];
	 ArrayList<String> arr = new ArrayList<>(50);
	
	public FacultyIARecordUpdation() {
		initialize();
	}
	
	public FacultyIARecordUpdation(int fid) {
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
	    panel1.setPreferredSize(new Dimension(1510,1450));
		
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
		
		l2 = new JLabel("STUDENT    CIE    RECORD    UPDATION    PORTAL");
		l2.setBounds(425,45,800,100);
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
		
	    l6 = new JLabel("Subject  Code  :   " + SubCode);
	    l6.setBounds(75,250,400,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l7 = new JLabel("Subject  Name  :   " + SubName);
	    l7.setBounds(550,250,500,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
	   
	    l8 = new JLabel("Scheme  :   " + Scheme);
	    l8.setBounds(1100,250,300,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    
	    l9 = new JLabel("CIE   I   Marks            :" + Scheme);
	    l9.setBounds(475,380,300,100);
	    l9.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf1 = new JTextField("xx");
		tf1.setBounds(800,395,250,70);
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.ITALIC,24));
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
		    	  ia1mrks = Integer.parseInt(tf1.getText());
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
	    
	    l10 = new JLabel("CIE   II   Marks           :" + Scheme);
	    l10.setBounds(475,515,300,100);
	    l10.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf2 = new JTextField("xx");
		tf2.setBounds(800,535,250,70);
		tf2.requestFocusInWindow();
		tf2.setFont(new Font("Gothic",Font.ITALIC,24));
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
		    	  ia2mrks = Integer.parseInt(tf2.getText());
		    	  tf3.grabFocus();
		      }
		    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf3.grabFocus();
		        }
	    	}
	    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					tf3.grabFocus();
		        }
	    	}
	    });
	 
	    l11 = new JLabel("CIE   III   Marks          :" + Scheme);
	    l11.setBounds(475,655,300,100);
	    l11.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf3 = new JTextField("xx");
		tf3.setBounds(800,675,250,70);
		tf3.requestFocusInWindow();
		tf3.setFont(new Font("Gothic",Font.ITALIC,24));
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
		    	  ia3mrks = Integer.parseInt(tf3.getText());
		    	  tf4.grabFocus();
		      }
		    });
		tf3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf2.grabFocus();
		        }
	    	}
	    });
		tf3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					tf4.grabFocus();
		        }
	    	}
	    });
		
		l12 = new JLabel("Assignment   Marks       :" + Scheme);
	    l12.setBounds(450,795,300,100);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf4 = new JTextField("xx");
		tf4.setBounds(800,815,250,70);
		tf4.requestFocusInWindow();
		tf4.setFont(new Font("Gothic",Font.ITALIC,24));
		tf4.setHorizontalAlignment(JTextField.CENTER);
		tf4.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf4.getText().trim().equals("xx"))
		        	tf4.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf4.getText().trim().equals(""))
		            tf4.setText("xx");		    	
		    }
		});
		tf4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  assgnmrks = Integer.parseInt(tf4.getText());
		    	  b1.grabFocus();
		      }
		    });
		tf4.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf3.grabFocus();
		        }
	    	}
	    });
		tf4.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					b1.grabFocus();
		        }
	    	}
	    });
	    
		l13 = new JLabel("Final   IA   Marks    :" + finalia);
	    l13.setBounds(325,950,600,100);
	    l13.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l14 = new JLabel("Eligibility   Status    :" + Status);
	    l14.setBounds(950,950,600,100);
	    l14.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    l15 = new JLabel("My   Remarks    :");
		l15.setBounds(250,1040,250,150);
	    l15.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    str1 = "write something...";
	    ta1 = new JTextArea(str1);
		ta1.setBounds(500,1090,700,125);
		ta1.setEditable(true);
		sp1 = new JScrollPane(ta1);
		sp1.setBounds(500,1090,700,125);
		sp1.setBorder(BorderFactory.createTitledBorder("Server Output"));
		ta1.setFont(new Font("Gothic",Font.PLAIN,22));
		ta1.setRows(10);
		ta1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(ta1.getText().trim().equals(str1))
		        	ta1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(ta1.getText().trim().equals(""))
		            ta1.setText(str1);		    	
		    }
		});
		
		
		
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
			  			String query = "select ia1,ia2,ia3,assgnmrks,finalia,remarks from iamarks where usn=? and subcode=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setString(1, StudentUSN);
			  			pstmt.setString(2, SubCode);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				ia1mrks = set.getInt(1);
			  				ia2mrks = set.getInt(2);
			  				ia3mrks = set.getInt(3);
			  				assgnmrks = set.getInt(4);
			  				finalia = Integer.toString(set.getInt(5));
			  				Remarks = set.getString(6);
//			  				Status = set.getString(7);
			  			}
			  			tf1.setText(Integer.toString(ia1mrks));
			  			tf2.setText(Integer.toString(ia2mrks));
			  			tf3.setText(Integer.toString(ia3mrks));
			  			tf4.setText(Integer.toString(assgnmrks));
			  			l13.setText("Final   IA   Marks    :    " + finalia);
			  			if(Integer.parseInt(finalia)>=16) {
			  				l14.setText("Eligibility   Status    :    " + "ELIGIBLE");
			  			}
			  			else {
			  				l14.setText("Eligibility   Status    :    " + "NOT  ELIGIBLE");
			  			}
			  			ta1.setText(Remarks);
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
		cb2.setBounds(800,175,175,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  if(cb2.getItemCount()>=2 && cb2.getSelectedIndex()!=0) {
		
		    		  si_id = arr.get(cb2.getSelectedIndex()-1);
		    
		    	  String cb2value= cb2.getSelectedItem().toString().trim();
		    	  Sem = Integer.parseInt(cb2value.substring(0,1));
		    	  Section = cb2value.substring(1);
		    	  SubCode = cb2value.substring(5);
		    
		    	  tf1.setText("xx");
		    	  tf2.setText("xx");
		    	  tf3.setText("xx");
		    	  tf4.setText("xx");
		    	  l13.setText("Final   IA   Marks    :" );
		    	  l14.setText("Eligibility   Status    :");
		    	  ta1.setText(str1);
		    	  cb3.setSelectedIndex(0);
		    	  for(int i=cb3.getItemCount()-1; i>=1; i--) {
		  				cb3.removeItemAt(i);
		  			}
		    	  
		    	  try {
			  		    con = CP.createCon();
			  			String query = "select s.usn from student s,teaches t where s.si_id=t.si_id and t.fid=? and s.si_id=? and t.subcode=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setString(2, si_id);
			  			pstmt.setString(3, SubCode);
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
			  			String query = "select s.sname,s.scheme from teaches t,subjects s where t.subcode=s.subcode and t.fid=? and t.si_id=? and t.facademicyear=? and t.subcode=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setString(2, si_id);
			  			pstmt.setInt(3, ay);
			  			pstmt.setString(4, SubCode);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				SubName = set.getString(1);
			  				Scheme = Integer.toString(set.getInt(2));			  				
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
		    	  
		    	  l6.setText("Subject  Code  :   ");
		    	  l7.setText("Subject  Name  :   ");
		    	  l8.setText("Scheme  :   ");
		    	  tf1.setText("xx");
		    	  tf2.setText("xx");
		    	  tf3.setText("xx");
		    	  tf4.setText("xx");
		    	  l13.setText("Final   IA   Marks    :" );
		    	  l14.setText("Eligibility   Status    :");
		    	  ta1.setText(str1);
		    	  cb2.setSelectedIndex(0);
		    	  cb3.setSelectedIndex(0);
		    	  for(int i=cb2.getItemCount()-1; i>=1; i--) {
		  				cb2.removeItemAt(i);
		  			}
		    	  for(int i=cb3.getItemCount()-1; i>=1; i--) {
		  				cb3.removeItemAt(i);
		  			}
		    	  arr.removeAll(arr);
		    	  
		    	  try {
			  		    con = CP.createCon();
			  			String query = "select si_id,subcode from teaches where fid=? and FAcademicYear=?;";

			  			PreparedStatement pstmt = con.prepareStatement(query);
			  			pstmt.setInt(1, FID);
			  			pstmt.setInt(2, ay);
			  			ResultSet set = pstmt.executeQuery();
			  			
			  			while(set.next()) {
			  				String	si_id = set.getString(1);
			  				String subcode = set.getString(2);
			  				 arr.add(si_id);
			  				 
			  				 cb2.addItem(" " + si_id.substring(4) + " - " + subcode);
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
		
		
		b1 = new JButton("UPDATE");
		b1.setBounds(550,1290,150,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
				//FINAL IA Calculation
				try {
					finalia = Integer.toString((int) (Math.ceil((ia1mrks + ia2mrks + ia3mrks)/3 + assgnmrks)));
					Remarks = ta1.getText();
					IAMarksTable iamt = new IAMarksTable(StudentUSN,SubCode,ia1mrks,ia2mrks,ia3mrks,assgnmrks,Integer.parseInt(finalia),Remarks);	
					IAMarksTableOperationsDB.updateIAMarksTable(iamt);
					if(Integer.parseInt(finalia)>=16) {
						Status = "ELIGIBLE";
					}
					else { 
						Status = "NOT  ELIGIBLE";
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(panel1,"Error!! Records not Updated. Please enter valid details.","Error Message",JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(panel1,"Successful!! Student CIE Records Updated Successfully.","Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setText("Final   IA   Marks    :    " + finalia);
				l14.setText("Eligibility   Status    :    " + Status);
			}
		});
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
	    			}
	    	}
	    });
		
		b2 = new JButton("BACK");
		b2.setBounds(900,1290,150,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Faculty_Panel_Start sps = new Faculty_Panel_Start(FID,FacultyName,Gender,"panel4");
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
		panel1.add(l9);
		panel1.add(tf1);
		panel1.add(l10);
		panel1.add(tf2);
		panel1.add(l11);
		panel1.add(tf3);
		panel1.add(l12);
		panel1.add(tf4);
		panel1.add(l13);
		panel1.add(l14);
		panel1.add(l15);
		panel1.add(sp1);
		panel1.add(b1);
		panel1.add(b2);
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
		FacultyIARecordUpdation fiaru  = new FacultyIARecordUpdation(10);
	}

}
