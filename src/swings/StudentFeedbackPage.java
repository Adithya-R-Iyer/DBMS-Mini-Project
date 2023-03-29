package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import mysql.CP;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;
import mysql.FeedbackTable;
import mysql.FeedbackTableOperationsDB;

import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Random;

public class StudentFeedbackPage {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JComboBox<String> cb1;
	JButton b1,b2;
	JRadioButton rb,rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12,rb13,rb14,rb15,rb16,rb17,rb18,rb19,rb20;
	ButtonGroup bg1,bg2,bg3,bg4;
	JTextArea ta1;
	JScrollPane sp,sp1;
	JSlider slider;
	JPanel panel1;
	
	// OTHER VARIABLES
	String name;
	Connection con;
	String usn;
	String StudentName,Gender,si_id;
	int arr[] = new int[50];
	int FID;
	int cb1index;
	String SubCode,SubName;
	String str1;
	int SliderValue,count=0;
	String bg1value,bg2value,bg3value,bg4value,Text;
	
	// JComboBox<String> combo = new JComboBox<>(new String[] { "One","Two", "Three","Four","Five", "Six" });
		
	public StudentFeedbackPage() {
		initialize();
	}
	
	public StudentFeedbackPage(String usn) {
		this.usn = usn;
		initialize();
	}
	
	public void initialize() {
		
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
		
		l2 = new JLabel("FACULTY    FEEDBACK    PAGE");
		l2.setBounds(525,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel("Faculty - Name ",SwingConstants.CENTER);
		l3.setBounds(450,125,200,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,29));
	    
	    // JComboBox<String> combo = new JComboBox<>(new String[] { "One","Two", "Three","Four","Five", "Six" });
	    String column1[] = {"         ---select faculty---"};
		cb1 = new JComboBox<>(column1);
		cb1.setBounds(680,150,325,55);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  cb1index = cb1.getSelectedIndex();
		    	  FID = arr[cb1index-1];
		    	  
		    	  try {
		      		
		      		con = CP.createCon();

		      		String query = "Select s.subcode,s.SNAME from teaches t,subjects s where t.subcode = s.subcode and si_id=? and fid=?;";
		      		
		      		PreparedStatement pstmt = con.prepareStatement(query);
		      		pstmt.setString(1, si_id);
		      		pstmt.setInt(2, FID);
		      		ResultSet set = pstmt.executeQuery();
		      		
		      		while(set.next()) {
		      			SubCode = set.getString(1);
		      			SubName = set.getString(2);  			
		      			}			
		          	}
		      		catch(Exception ea) {
		      			ea.printStackTrace();
		      		}
		    	  
		    	  l5.setText(Integer.toString(FID));
		    	  l7.setText(SubCode);
		    	  l9.setText(SubName);
		      }
		    });
	    
	    try {
			
			con = CP.createCon();
			
			String query = "Select SFNAME,SGENDER,si_id from student where usn=?;";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, usn);
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				StudentName = set.getString(1);
				Gender = set.getString(2);
				si_id= set.getString(3);
				}
	    }
	    catch(Exception e) {
			e.printStackTrace();
		}
	    
	    
    	try {
		
		con = CP.createCon();

		String query = "Select f.FID,f.FFNAME,f.FLNAME from teaches t,faculty f,subjects s where t.subcode=s.subcode and t.FID=f.FID and si_id=?;";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, si_id);
		ResultSet set = pstmt.executeQuery();
		
		int i=0;
		
		while(set.next()) {
			int fid = set.getInt(1);
			String fname = set.getString(2);
			String lname = set.getString(3);
			arr[i++] = fid;
	
			cb1.addItem("         Prof. " + fname + " " + lname);
			}			
    	}
		catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    	l4 = new JLabel("Faculty  ID  :-  ");
		l4.setBounds(75,250,300,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,29));

	    l5 = new JLabel("");
		l5.setBounds(250,250,300,100);
	    l5.setFont(new Font("Times New Roman",Font.ITALIC,28));
	    
	    l6 = new JLabel("Sub  Code  :-  ");
		l6.setBounds(550,250,300,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,29));
	    
	    l7 = new JLabel("");
		l7.setBounds(720,250,300,100);
	    l7.setFont(new Font("Times New Roman",Font.ITALIC,28));
	    
	    l8 = new JLabel("Sub  Name  :-  ");
		l8.setBounds(1100,250,300,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,29));
	    
	    l9 = new JLabel("");
		l9.setBounds(1280,250,300,100);
	    l9.setFont(new Font("Times New Roman",Font.ITALIC,28));
	    
	    
	    l10 = new JLabel("Punctuality in Class ?");
		l10.setBounds(30,339,250,150);
	    l10.setFont(new Font("Times New Roman",Font.BOLD,26));
	   
	    rb = new JRadioButton("xxx");
		Font newRadioButtonFont = new Font(rb.getFont().getName(),rb.getFont().getStyle(),18);
		
		rb1 = new JRadioButton("Below Avg.");
		rb1.setBounds(400,390,150,50);
	//	rb1.setBackground(Color.LIGHT_GRAY);
		rb1.setFont(newRadioButtonFont);
		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			if(rb1.isSelected() == true) {
				bg1value = rb1.getText();
				}
			}
		});
		rb2 = new JRadioButton("Avg.");
		rb2.setBounds(640,390,150,50);
	//	rb2.setBackground(Color.LIGHT_GRAY);
		rb2.setFont(newRadioButtonFont);
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb2.isSelected() == true) {
					bg1value = rb2.getText();
				}
			}
		});
		rb3 = new JRadioButton("Good");
		rb3.setBounds(830,390,150,50);
	//	rb3.setBackground(Color.LIGHT_GRAY);
		rb3.setFont(newRadioButtonFont);
		rb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb3.isSelected() == true) {
					bg1value = rb3.getText();
				}
			}
		});
		rb4 = new JRadioButton("Very Good");
		rb4.setBounds(1050,390,150,50);
	//	rb4.setBackground(Color.LIGHT_GRAY);
		rb4.setFont(newRadioButtonFont);
		rb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb4.isSelected() == true) {
					bg1value = rb4.getText();
				}
			}
		});
		rb5 = new JRadioButton("Excellent");
		rb5.setBounds(1300,390,200,50);
	//	rb5.setBackground(Color.LIGHT_GRAY);
		rb5.setFont(newRadioButtonFont);
		rb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb5.isSelected() == true) {
					bg1value = rb5.getText();
				}
			}
		});
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
		rb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			if(rb6.isSelected() == true) {
				bg2value = rb6.getText();
				}
			}
		});
		rb7 = new JRadioButton("Avg.");
		rb7.setBounds(640,485,150,50);
	//	rb7.setBackground(Color.LIGHT_GRAY);
		rb7.setFont(newRadioButtonFont);
		rb7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb7.isSelected() == true) {
					bg2value = rb7.getText();
				}
			}
		});
		rb8 = new JRadioButton("Good");
		rb8.setBounds(830,485,150,50);
	//	rb8.setBackground(Color.LIGHT_GRAY);
		rb8.setFont(newRadioButtonFont);
		rb8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb8.isSelected() == true) {
					bg2value = rb8.getText();
				}
			}
		});
		rb9 = new JRadioButton("Very Good");
		rb9.setBounds(1050,485,150,50);
	//	rb9.setBackground(Color.LIGHT_GRAY);
		rb9.setFont(newRadioButtonFont);
		rb9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb9.isSelected() == true) {
					bg2value = rb9.getText();
				}
			}
		});
		rb10 = new JRadioButton("Excellent");
		rb10.setBounds(1300,485,200,50);
	//	rb10.setBackground(Color.LIGHT_GRAY);
		rb10.setFont(newRadioButtonFont);
		rb10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb10.isSelected() == true) {
					bg2value = rb10.getText();
				}
			}
		});
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
		rb11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			if(rb11.isSelected() == true) {
				bg3value = rb11.getText();
				}
			}
		});
		rb12 = new JRadioButton("Avg.");
		rb12.setBounds(640,580,150,50);
	//	rb12.setBackground(Color.LIGHT_GRAY);
		rb12.setFont(newRadioButtonFont);
		rb12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb12.isSelected() == true) {
					bg3value = rb12.getText();
				}
			}
		});
		rb13 = new JRadioButton("Good");
		rb13.setBounds(830,580,150,50);
	//	rb13.setBackground(Color.LIGHT_GRAY);
		rb13.setFont(newRadioButtonFont);
		rb13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb13.isSelected() == true) {
					bg3value = rb13.getText();
				}
			}
		});
		rb14 = new JRadioButton("Very Good");
		rb14.setBounds(1050,580,150,50);
	//	rb14.setBackground(Color.LIGHT_GRAY);
		rb14.setFont(newRadioButtonFont);
		rb14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb14.isSelected() == true) {
					bg3value = rb14.getText();
				}
			}
		});
		rb15 = new JRadioButton("Excellent");
		rb15.setBounds(1300,580,200,50);
	//	rb15.setBackground(Color.LIGHT_GRAY);
		rb15.setFont(newRadioButtonFont);
		rb15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb15.isSelected() == true) {
					bg3value = rb15.getText();
				}
			}
		});
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
		rb16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			if(rb16.isSelected() == true) {
				bg4value = rb16.getText();
				}
			}
		});
		rb17 = new JRadioButton("Avg.");
		rb17.setBounds(640,675,150,50);
	//	rb17.setBackground(Color.LIGHT_GRAY);
		rb17.setFont(newRadioButtonFont);
		rb17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb17.isSelected() == true) {
					bg4value = rb17.getText();
				}
			}
		});
		rb18 = new JRadioButton("Good");
		rb18.setBounds(830,675,150,50);
	//	rb18.setBackground(Color.LIGHT_GRAY);
		rb18.setFont(newRadioButtonFont);
		rb18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb18.isSelected() == true) {
					bg4value = rb18.getText();
				}
			}
		});
		rb19 = new JRadioButton("Very Good");
		rb19.setBounds(1050,675,150,50);
	//	rb19.setBackground(Color.LIGHT_GRAY);
		rb19.setFont(newRadioButtonFont);
		rb19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb19.isSelected() == true) {
					bg4value = rb19.getText();
				}
			}
		});
		rb20 = new JRadioButton("Excellent");
		rb20.setBounds(1300,675,200,50);
	//	rb20.setBackground(Color.LIGHT_GRAY);
		rb20.setFont(newRadioButtonFont);
		rb20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(rb20.isSelected() == true) {
					bg4value = rb20.getText();
				}
			}
		});
		bg4 = new ButtonGroup();
		bg4.add(rb16);
		bg4.add(rb17);
		bg4.add(rb18);
	    bg4.add(rb19);
	    bg4.add(rb20);
	    
	    
	    l13 = new JLabel("Overall  Rating  (0 - 10)  : ");
		l13.setBounds(100,810,400,50);
		l13.setFont(new Font("Times New Roman",Font.PLAIN,26));
		slider = new JSlider(0,10,5);
		slider.setBounds(500,830,500,50);
	//	slider.setBackground(Color.LIGHT_GRAY);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setFont(new Font("MV Boli",Font.PLAIN,14));
//		slider.addChangeListener(new ChangeListener() {
//	         public void stateChanged(ChangeEvent ce) {
//	          SliderValue= slider.getValue();
//	        	 System.out.println(((JSlider) ce.getSource()).getValue());
//	         }
//	      });

		
	    l12 = new JLabel("Write  a  Review");
		l12.setBounds(150,900,200,150);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    str1 = "write something...";
	    ta1 = new JTextArea(str1);
		ta1.setBounds(400,950,800,125);
		ta1.setEditable(true);
		sp1 = new JScrollPane(ta1);
		sp1.setBounds(400,950,800,125);
		sp1.setBorder(BorderFactory.createTitledBorder("Server Output"));
		ta1.setFont(new Font("Gothic",Font.PLAIN,22));
		ta1.setRows(10);
		ta1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	ta1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	ta1.setText(str1);	    	
		    }
		});
		ta1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
	    			String str4 = ta1.getText();
	    			Text = ta1.getText();
		        }
	    	}
	    });
//		ta1.addCaretListener((CaretListener) new ActionListener() {
//		      public void actionPerformed(ActionEvent e) {
//
//		      }
//		    });
	    
		
		
	    
	    b1 = new JButton("SUBMIT");
		b1.setBounds(550,1150,150,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("SUBMIT") == true) {
					
					if(count==0) {
					SliderValue = slider.getValue();
					
					if(cb1.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(frame,"Error !!  Please select a Faculty from the list to continue. ","Error Message",JOptionPane.ERROR_MESSAGE);
						bg1.clearSelection();
						bg2.clearSelection();
						bg3.clearSelection();
						bg4.clearSelection();
						slider.setValue(5);
						ta1.setText("");
						return;
					}
					
					FeedbackTable ft = new FeedbackTable(si_id,FID,SubCode,usn,bg1value,bg2value,bg3value,bg4value,SliderValue,Text);
					try {
					FeedbackTableOperationsDB.updatefeedbacktable(ft);
					JOptionPane.showMessageDialog(frame,"Successful !! Review submitted successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(SQLException e) {
//						e.printStackTrace();
						JOptionPane.showMessageDialog(frame,"Error !!  Review already Submitted. Cannot send duplicates. ","Error Message",JOptionPane.ERROR_MESSAGE);
						bg1.clearSelection();
						bg2.clearSelection();
						bg3.clearSelection();
						bg4.clearSelection();
						slider.setValue(5);
						ta1.setText("");
					}
					
					bg1.clearSelection();
					bg2.clearSelection();
					bg3.clearSelection();
					bg4.clearSelection();
					slider.setValue(5);
					ta1.setText("");
					count=1;
					}
					else {
						JOptionPane.showMessageDialog(frame,"Error !!  Review already Submitted. Cannot send duplicates. ","Error Message",JOptionPane.ERROR_MESSAGE);
						bg1.clearSelection();
						bg2.clearSelection();
						bg3.clearSelection();
						bg4.clearSelection();
						slider.setValue(5);
						ta1.setText("");
					}
				}
			}
		});

		b2 = new JButton("BACK");
		b2.setBounds(875,1150,150,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Student_Panel_Start sps = new Student_Panel_Start(usn,StudentName,Gender,"panel7");
				}
			}
		});
		
		//SP  add on's
		panel1.add(l0);
		panel1.add(l1);
		panel1.add(l2);
		panel1.add(l3);
		panel1.add(cb1);
		panel1.add(l4);
		panel1.add(l6);
		panel1.add(l8);
		panel1.add(l5);
		panel1.add(l7);
		panel1.add(l9);
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
		panel1.add(b1);
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
		StudentFeedbackPage sfp = new StudentFeedbackPage("4SF20CS004");
	}

}
