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

public class StudentSGPACalculation {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JPanel panel1;
	JScrollPane sp;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JComboBox cb1,cb2;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	JButton b1,b2,b3;
		
	//OTHER VARIABLES
	String USN;
	CP cpcon;
	Connection con;
	String StudentName,Gender,si_id,Dept;
	int sem,scheme;
	int sub1cred,sub2cred,sub3cred,sub4cred,sub5cred,sub6cred,sub7cred,sub8cred,sub9cred;
		
	
	public StudentSGPACalculation() {
		initialize();	
	}
	
	public StudentSGPACalculation(String usn) {
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
	    panel1.setPreferredSize(new Dimension(1510,1475));
	    
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
		
		l2 = new JLabel("SGPA  CALCULATION  PORTAL");
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
		
		l3 = new JLabel("              My  Current  SEM  :-                                                            Current  Scheme  of  Study  :-  ");
	    l3.setBounds(40,130,1500,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,30));
	    
	    String column1[] = {"    0","    1","    2","    3","    4","    5","    6","    7","    8"};
		cb1 = new JComboBox(column1);
		cb1.setBounds(450,155,125,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  sem = Integer.parseInt(cb1value.trim());
//		    	  cb1index = cb1.getSelectedIndex();
		      }
		    });
	    cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
			}
	    });
	    
	    if(sem==1) {
	    	cb1.setSelectedIndex(1);
	    }
	    else if(sem==2) {
	    	cb1.setSelectedIndex(2);
	    }
	    else if(sem==3) {
	    	cb1.setSelectedIndex(3);
	    }
	    else if(sem==4) {
	    	cb1.setSelectedIndex(4);
	    }
	    else if(sem==5) {
	    	cb1.setSelectedIndex(5);
	    }
	    else if(sem==6) {
	    	cb1.setSelectedIndex(6);
	    }
	    else if(sem==7) {
	    	cb1.setSelectedIndex(7);
	    }
	    else if(sem==8) {
	    	cb1.setSelectedIndex(8);
	    }
	    
	    String column2[] = {"      0000","      2015","      2018","      2020"};
		 cb2 = new JComboBox(column2);
		 cb2.setBounds(1300,155,150,50);	
		 cb2.setFont(new Font("Gothic",Font.ITALIC,24));
		 cb2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String cb3value= cb2.getSelectedItem().toString();
//				 scheme = Integer.parseInt(cb3value.trim());
			   }
		  });
		 cb2.setSelectedIndex(2);
	    
		 
		l4 = new JLabel("");
	    l4.setBounds(250,240,850,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf1 = new JTextField("xxx");
		tf1.setBounds(1150,260,125,60);
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.ITALIC,24));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf1.getText().trim().equals("xxx"))
		        	tf1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf1.getText().trim().equals(""))
		            tf1.setText("xxx");		    	
		    }
		});
		tf1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf1.getText()) == 100) {
		    		  sub1cred=10;
		    	  }
		    	  else {
		    	  sub1cred = Integer.parseInt(tf1.getText())/10 +1;
		    	  }
//		    	  ((JComponent)sp.getParent()).scrollRectToVisible(sp.getBounds());
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
		
		l5 = new JLabel("");
	    l5.setBounds(250,350,750,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf2 = new JTextField("xxx");
		tf2.setBounds(1150,370,125,60);
		tf2.requestFocusInWindow();
		tf2.setFont(new Font("Gothic",Font.ITALIC,24));
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf2.getText().trim().equals("xxx"))
		        	tf2.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf2.getText().trim().equals(""))
		            tf2.setText("xxx");		    	
		    }
		});
		tf2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf2.getText()) == 100) {
		    		  sub2cred=10;
		    	  }
		    	  else {
		    	  sub2cred = Integer.parseInt(tf2.getText())/10 +1;
		    	  }
		    	  tf3.grabFocus();
		      }
		    });
		tf2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf1.grabFocus();
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
		 
		l6 = new JLabel("");
	    l6.setBounds(250,460,750,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf3 = new JTextField("xxx");
		tf3.setBounds(1150,480,125,60);
		tf3.requestFocusInWindow();
		tf3.setFont(new Font("Gothic",Font.ITALIC,24));
		tf3.setHorizontalAlignment(JTextField.CENTER);
		tf3.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf3.getText().trim().equals("xxx"))
		        	tf3.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf3.getText().trim().equals(""))
		            tf3.setText("xxx");		    	
		    }
		});
		tf3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf3.getText()) == 100) {
		    		  sub3cred=10;
		    	  }
		    	  else {
		    	  sub3cred = Integer.parseInt(tf3.getText())/10 +1;
		    	  }
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
		 
		l7 = new JLabel("");
	    l7.setBounds(250,570,750,100);
	    l7.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf4 = new JTextField("xxx");
		tf4.setBounds(1150,590,125,60);
		tf4.requestFocusInWindow();
		tf4.setFont(new Font("Gothic",Font.ITALIC,24));
		tf4.setHorizontalAlignment(JTextField.CENTER);
		tf4.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf4.getText().trim().equals("xxx"))
		        	tf4.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf4.getText().trim().equals(""))
		            tf4.setText("xxx");		    	
		    }
		});
		tf4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf4.getText()) == 100) {
		    		  sub4cred=10;
		    	  }
		    	  else {
		    	  sub4cred = Integer.parseInt(tf4.getText())/10 +1;
		    	  }
		    	  tf5.grabFocus();
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
					tf5.grabFocus();
		        }
	    	}
	    });
		 
		l8 = new JLabel("");
	    l8.setBounds(250,680,750,100);
	    l8.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf5 = new JTextField("xxx");
		tf5.setBounds(1150,700,125,60);
		tf5.requestFocusInWindow();
		tf5.setFont(new Font("Gothic",Font.ITALIC,24));
		tf5.setHorizontalAlignment(JTextField.CENTER);
		tf5.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf5.getText().trim().equals("xxx"))
		        	tf5.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf5.getText().trim().equals(""))
		            tf5.setText("xxx");		    	
		    }
		});
		tf5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf5.getText()) == 100) {
		    		  sub5cred=10;
		    	  }
		    	  else {
		    	  sub5cred = Integer.parseInt(tf5.getText())/10 +1;
		    	  }
//		    	  ((JComponent)sp.getParent()).scrollRectToVisible(sp.getBounds());
		    	  if(sem==8) {
		    		  b2.grabFocus();
		    	  }
		    	  else {
		    		  tf6.grabFocus();
		    	  }
		      }
		    });
		tf5.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf4.grabFocus();
		        }
	    	}
	    });
		tf5.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
	    			if(sem==8) {
			    		  b2.grabFocus();
			    	  }
			    	  else {
			    		  tf6.grabFocus();
			    	  }
		        }
	    	}
	    });
		  
		l9 = new JLabel("");
	    l9.setBounds(250,790,750,100);
	    l9.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf6 = new JTextField("xxx");
		tf6.setBounds(1150,810,125,60);
		tf6.requestFocusInWindow();
		tf6.setFont(new Font("Gothic",Font.ITALIC,24));
		tf6.setHorizontalAlignment(JTextField.CENTER);
		tf6.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf6.getText().trim().equals("xxx"))
		        	tf6.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf6.getText().trim().equals(""))
		            tf6.setText("xxx");		    	
		    }
		});
		tf6.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf6.getText()) == 100) {
		    		  sub6cred=10;
		    	  }
		    	  else {
		    	  sub6cred = Integer.parseInt(tf6.getText())/10 +1;
		    	  }
		    	  tf7.grabFocus();
		      }
		    });
		tf6.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf5.grabFocus();
		        }
	    	}
	    });
		tf6.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					tf7.grabFocus();
		        }
	    	}
	    });
		
		l10 = new JLabel("");
	    l10.setBounds(250,900,750,100);
	    l10.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf7 = new JTextField("xxx");
		tf7.setBounds(1150,920,125,60);
		tf7.requestFocusInWindow();
		tf7.setFont(new Font("Gothic",Font.ITALIC,24));
		tf7.setHorizontalAlignment(JTextField.CENTER);
		tf7.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf7.getText().trim().equals("xxx"))
		        	tf7.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf7.getText().trim().equals(""))
		            tf7.setText("xxx");		    	
		    }
		});
		tf7.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf7.getText()) == 100) {
		    		  sub7cred=10;
		    	  }
		    	  else {
		    	  sub7cred = Integer.parseInt(tf7.getText())/10 +1;
		    	  }
		    	  if(sem==7) {
		    		  b2.grabFocus();
		    	  }
		    	  else {
		    		tf8.grabFocus();  
		    	  }
		      }
		    });
		tf7.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf6.grabFocus();
		        }
	    	}
	    });
		tf7.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
	    			if(sem==7) {
			    		  b2.grabFocus();
			    	  }
			    	  else {
			    		tf8.grabFocus();  
			    	  }
		        }
	    	}
	    });
		 
		l11 = new JLabel("");
	    l11.setBounds(250,1010,750,100);
	    l11.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf8 = new JTextField("xxx");
		tf8.setBounds(1150,1030,125,60);
		tf8.requestFocusInWindow();
		tf8.setFont(new Font("Gothic",Font.ITALIC,24));
		tf8.setHorizontalAlignment(JTextField.CENTER);
		tf8.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf8.getText().trim().equals("xxx"))
		        	tf8.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf8.getText().trim().equals(""))
		            tf8.setText("xxx");		    	
		    }
		});
		tf8.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf8.getText()) == 100) {
		    		  sub8cred=10;
		    	  }
		    	  else {
		    	  sub8cred = Integer.parseInt(tf8.getText())/10 +1;
		    	  }
		    	  if(sem==1 || sem==2) {
		    		  b2.grabFocus();
		    	  }
		    	  else {
		    		  tf9.grabFocus();
		    	  }
		      }
		    });
		tf8.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf7.grabFocus();
		        }
	    	}
	    });
		tf8.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
	    			 if(sem==1 || sem==2) {
			    		  b2.grabFocus();
			    	  }
			    	  else {
			    		  tf9.grabFocus();
			    	  }
		        }
	    	}
	    });
		 
		l12 = new JLabel("");
	    l12.setBounds(250,1120,750,100);
	    l12.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    tf9 = new JTextField("xxx");
		tf9.setBounds(1150,1140,125,60);
		tf9.requestFocusInWindow();
		tf9.setFont(new Font("Gothic",Font.ITALIC,24));
		tf9.setHorizontalAlignment(JTextField.CENTER);
		tf9.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf9.getText().trim().equals("xxx"))
		        	tf9.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf9.getText().trim().equals(""))
		            tf9.setText("xxx");		    	
		    }
		});
		tf9.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  if(Integer.parseInt(tf9.getText()) == 100) {
		    		  sub9cred=10;
		    	  }
		    	  else {
		    	  sub9cred = Integer.parseInt(tf9.getText())/10 +1;
		    	  }
		    	  b2.grabFocus();	
		      }
		    });
		tf9.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf8.grabFocus();
		        }
	    	}
	    });
		tf9.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					b2.grabFocus();
		        }
	    	}
	    });
		
		b1 = new JButton("UPDATE");
		b1.setBounds(350,1300,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					
					if(sem>Integer.parseInt(si_id.substring(4,5))) {
						JOptionPane.showMessageDialog(frame,"Error!! Please choose a valid semester to continue.","Error Message",JOptionPane.ERROR_MESSAGE);
						labelcontents(5);
						tf1.setText("xxx");
						tf2.setText("xxx");
						tf3.setText("xxx");
						tf4.setText("xxx");
						tf5.setText("xxx");
						tf6.setText("xxx");
						tf7.setText("xxx");
						tf8.setText("xxx");
						tf9.setText("xxx");
						cb1.setSelectedIndex(5);
						return;
					}
					else {
						labelcontents(sem);
						tf1.setText("xxx");
						tf2.setText("xxx");
						tf3.setText("xxx");
						tf4.setText("xxx");
						tf5.setText("xxx");
						tf6.setText("xxx");
						tf7.setText("xxx");
						tf8.setText("xxx");
						tf9.setText("xxx");
						cb1.setSelectedIndex(sem);
					}
				}
			}
		});
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
	    			b3.grabFocus();
		        }
	    	}
	    });
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					b2.grabFocus();
		        }
	    	}
	    });
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
	    			if(sem==8) {
	    				tf5.grabFocus();
	    			}
	    			else if(sem==1 || sem==2) {
	    				tf8.grabFocus();
	    			}
	    			else if(sem==7) {
	    				tf7.grabFocus();
	    			}
	    			else {
	    				tf9.grabFocus();
	    			}
		        }
	    	}
	    });
	    
		
		b2 = new JButton("CALCULATE");
		b2.setBounds(620,1300,150,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("CALCULATE") == true) {
					
					calcsgpa(sem);
				}
			}
		});
		b2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
					
	    			calcsgpa(sem);
	    			
		        }
	    	}
	    });
		b2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
	    			b1.grabFocus();
		        }
	    	}
	    });
		b2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					b3.grabFocus();
		        }
	    	}
	    });
		b2.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
	    			if(sem==8) {
	    				tf5.grabFocus();
	    			}
	    			else if(sem==1 || sem==2) {
	    				tf8.grabFocus();
	    			}
	    			else if(sem==7) {
	    				tf7.grabFocus();
	    			}
	    			else {
	    				tf9.grabFocus();
	    			}
		        }
	    	}
	    });
		
		
		b3 = new JButton("BACK");
		b3.setBounds(925,1300,125,50);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Student_Panel_Start sps = new Student_Panel_Start(USN,StudentName,Gender,"panel5");
				}
			}
		});
		b3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
	    			b2.grabFocus();
		        }
	    	}
	    });
		b3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
					b1.grabFocus();
		        }
	    	}
	    });
		b3.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
	    			if(sem==8) {
	    				tf5.grabFocus();
	    			}
	    			else if(sem==1 || sem==2) {
	    				tf8.grabFocus();
	    			}
	    			else if(sem==7) {
	    				tf7.grabFocus();
	    			}
	    			else {
	    				tf9.grabFocus();
	    			}
		        }
	    	}
	    });
		
		// DISPLAYING  CONTENTS  OF LABELS  - 1st iteration
				labelcontents(sem);
				
		l13 = new JLabel();
	    l13.setBounds(580,400,500,100);
	    l13.setFont(new Font("Comic Sans MS",Font.BOLD,19));
	    
		panel1.add(l1);
		panel1.add(l0);
		panel1.add(l2);
		panel1.add(l3);
		panel1.add(cb1);
		panel1.add(cb2);
		panel1.add(l4);
		panel1.add(tf1);
		panel1.add(l5);
		panel1.add(tf2);
		panel1.add(l6);
		panel1.add(tf3);
		panel1.add(l7);
		panel1.add(tf4);
		panel1.add(l8);
		panel1.add(tf5);
		panel1.add(l9);
		panel1.add(tf6);
		panel1.add(l10);
		panel1.add(tf7);
		panel1.add(l11);
		panel1.add(tf8);
		panel1.add(l12);
		panel1.add(tf9);
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
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
	
	public void labelcontents(int sem) {
	
		if(sem==1) {
	    	l4.setText("Calculus  and  Linear  Algebra  { 18MAT11 }");
	    	l5.setText("Physics  { 18PHY12 }");
	    	l6.setText("Basic  Electrical Engineering  { 18ELE13 }");
	    	l7.setText("Elements  of  Civil  Engineering  and  Mechanics  { 18CIV14 }");
	    	l8.setText("Engineering  Graphics  { 18EGDL15 }");
	    	l9.setText("Engineering  Physics  Laboratory  { 18PHYL16 }");
	    	l10.setText("Basic  Electrical  Engineering  Laboratory  { 18ELEL17 }");
	    	l11.setText("Technical  English-I  { 18EGH18 }"); 
	    	l12.setVisible(false);
	    	tf9.setVisible(false);
	    	b1.setBounds(350,1175,125,50);
	    	b2.setBounds(620,1175,150,50);
	    	b3.setBounds(925,1175,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1300));
	    }
	    else if(sem==2) {
	    	l4.setText("Calculus  and  Linear  Algebra  { 18MAT21 }");
	    	l5.setText("Engineering  Chemistry  { 18CHE22 }");
	    	l6.setText("C  Programming  for  Problem  Solving  { 18CPS23 }");
	    	l7.setText("Basic  Electronics  { 18ELN24 }");
	    	l8.setText("Elements  of  Mechanical  Engineering  { 18ME25 }");
	    	l9.setText("Engineering  Chemistry  Laboratory  { 18CHEL26 }");
	    	l10.setText("C  Programming  Laboratory  { 18CPL27 }");
	    	l11.setText("Technical  English-II  { 18EGH28 }"); 
	    	l12.setVisible(false);
	    	tf9.setVisible(false);
	    	b1.setBounds(350,1175,125,50);
	    	b2.setBounds(620,1175,150,50);
	    	b3.setBounds(925,1175,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1300));
	    }
	    else if(sem==3) {
	    	l4.setText("Transform Calculus, Fourier Series & Numerical Techniques {18MAT31}");
	    	l5.setText("Data  Structures  and  Applications  { 18CS32 }");
	    	l6.setText("Analog  and  Digital  Electronics  { 18CS33 }");
	    	l7.setText("Computer  Organization  { 18CS34 }");
	    	l8.setText("Software  Engineering  { 18CS35 }");
	    	l9.setText("Discrete  Mathematical  Structures  { 18CS36 }");
	    	l10.setText("Analog  and  Digital  Electronics  Laboratory  { 18CSL37 }");
	    	l11.setText("Data  Structures  Laboratory  { 18CSL38 }"); 
	    	l12.setText("Vyavaharika / Aadalitha  Kannada  { 18K(VK/AK)39 }");
	    	l12.setVisible(true);
	    	tf9.setVisible(true);
	    	b1.setBounds(350,1300,125,50);
	    	b2.setBounds(620,1300,150,50);
	    	b3.setBounds(925,1300,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1475));
	    }
	    else if(sem==4) {
	    	l4.setText("Complex Analysis, Probability and Statistical Methods { 18MAT41 }");
	    	l5.setText("Design  and  Analysis  of  Algorithms  { 18CS42 }");
	    	l6.setText("Operating  Systems  { 18CS43 }");
	    	l7.setText("Microcontroller and  Embedded  Systems  { 18CS44 }");
	    	l8.setText("Object  Oriented  Concepts  { 18CS45 }");
	    	l9.setText("Data  Communication  { 18CS46 }");
	    	l10.setText("Design  and  Analysis  of  Algorithm  Laboratory  { 18CSL47 }");
	    	l11.setText("Microcontroller  and  Embedded  Systems  Laboratory  { 18CSL48 }"); 
	    	l12.setText("Constitution of India, Professional Ethics & Cyber Law  { 18CPC49 }");
	    	l12.setVisible(true);
	    	tf9.setVisible(true);
	    	b1.setBounds(350,1300,125,50);
	    	b2.setBounds(620,1300,150,50);
	    	b3.setBounds(925,1300,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1475));
	    }
	    else if(sem==5) {
	    	l4.setText("Management , Entrepreneurship  for  IT  idustry {18CS51}");
	    	l5.setText("Computer  Networks  and  Security  { 18CS52 }");
	    	l6.setText("Database  Management  System  { 18CS53 }");
	    	l7.setText("Automata  theory  and  Computability  { 18CS54 }");
	    	l8.setText("Application  Development  using  Python  { 18CS55 }");
	    	l9.setText("Unix  Programming  { 18CS56 }");
	    	l10.setText("Computer  Network  Laboratory  { 18CSL57 }");
	    	l11.setText("DBMS  Laboratory  with  mini  project  { 18CSL58 }"); 
	    	l12.setText("Environmental  Studies  { 18CIV59 }");
	    	l12.setVisible(true);
	    	tf9.setVisible(true);
	    	b1.setBounds(350,1300,125,50);
	    	b2.setBounds(620,1300,150,50);
	    	b3.setBounds(925,1300,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1475));
	    }
	    else if(sem==6) {
	    	l4.setText("System  Software  and  Compilers  {18CS61}");
	    	l5.setText("Computer  Graphics  and  Visualization  { 18CS62 }");
	    	l6.setText("Web  Technology  and  its  applications  { 18CS63 }");
	    	l7.setText("Professional  Elective  - I  { 18CS64X }");
	    	l8.setText("Open  Elective  - A  { 18CS65X }");
	    	l9.setText("System  Software  Laboratory  { 18CSL66 }");
	    	l10.setText("Computer Graphics Laboratory with mini project  { 18CSL67 }");
	    	l11.setText("Mobile  Application  Development  { 18CSMP68 }"); 
	    	l12.setVisible(false);
	    	tf9.setVisible(false);
	    	b1.setBounds(350,1175,125,50);
	    	b2.setBounds(620,1175,150,50);
	    	b3.setBounds(925,1175,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1300));
	    }
	    else if(sem==7) {
	    	l4.setText("Artificial  Intelligence  and  Machine  Learning  {18CS71}");
	    	l5.setText("Big  Data  Analytics  { 18CS72 }");
	    	l6.setText("Professional  Elective  - II  { 18CS73X }");
	    	l7.setText("Professional  Elective  - III  { 18CS74X }");
	    	l8.setText("Open  Elective  - B  { 18CS75X }");
	    	l9.setText("Artificial Intelligence and Machine Learning Laboratory  { 18CSL76 }");
	    	l10.setText("Project  Work Phase  - I  { 18CSP77 }");
	    	l11.setVisible(false);
	    	tf8.setVisible(false);
	    	l12.setVisible(false);
	    	tf9.setVisible(false);
	    	b1.setBounds(350,1075,125,50);
	    	b2.setBounds(620,1075,150,50);
	    	b3.setBounds(925,1075,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1200));
	    }
	    else if(sem==8) {
	    	l4.setText("Internet  of  Things  {18CS81}");
	    	l5.setText("Professional  Elective  - IV  { 18CS82X }");
	    	l6.setText("Project  Work  Phase  - II  { 18CSP83 }");
	    	l7.setText("Technical  Seminar  { 18CSS84 }");
	    	l8.setText("Internship  { 18CSI85 }");
	    	l9.setVisible(false);
	    	tf6.setVisible(false);
	    	l10.setVisible(false);
	    	tf7.setVisible(false);
	    	l11.setVisible(false);
	    	tf8.setVisible(false);
	    	l12.setVisible(false);
	    	tf9.setVisible(false);
	    	b1.setBounds(350,850,125,50);
	    	b2.setBounds(620,850,150,50);
	    	b3.setBounds(925,850,125,50);
	    	panel1.setPreferredSize(new Dimension(1510,1000));
	    }
	}
	
	public void calcsgpa(int sem) {
		
		try {
//			if(sem==4 || sem==5) {
			if(sub1cred>10 || sub2cred>10 ||sub3cred>10 || sub4cred>10 || sub5cred>10 ||sub6cred>10 || sub7cred>10 || sub8cred>10 ||sub9cred>10 && (sem==3 || sem==4 || sem==5))
			{
				JOptionPane.showMessageDialog(frame,"Error!! Please enter valid information.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(sub1cred<5 || sub2cred<5 ||sub3cred<5 || sub4cred<5 || sub5cred<5 ||sub6cred<5 || sub7cred<5 || sub8cred<5 ||sub9cred<5 && (sem==3 || sem==4 || sem==5))
			{
				System.out.println(sub1cred + " " + sub2cred + " " + sub3cred + " " + sub4cred + " " + sub5cred + " " + sub6cred + " " + sub7cred + " " + sub8cred + " " + sub9cred);
				JOptionPane.showMessageDialog(frame,"Sorry!! Your SGPA can't be calculated. You have BACKLOGs in one or more Subject.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(sub1cred>10 || sub2cred>10 ||sub3cred>10 || sub4cred>10 || sub5cred>10 ||sub6cred>10 || sub7cred>10 || sub8cred>10 && (sem==1 || sem==2 || sem==6))
			{
				JOptionPane.showMessageDialog(frame,"Error!! Please enter valid information.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(sub1cred<5 || sub2cred<5 ||sub3cred<5 || sub4cred<5 || sub5cred<5 ||sub6cred<5 || sub7cred<5 || sub8cred<5 && (sem==1 || sem==2 || sem==6))
			{
				System.out.println(sub1cred + " " + sub2cred + " " + sub3cred + " " + sub4cred + " " + sub5cred + " " + sub6cred + " " + sub7cred + " " + sub8cred + " " + sub9cred);
				JOptionPane.showMessageDialog(frame,"Sorry!! Your SGPA can't be calculated. You have BACKLOGs in one or more Subject.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(sub1cred>10 || sub2cred>10 ||sub3cred>10 || sub4cred>10 || sub5cred>10 ||sub6cred>10 || sub7cred>10 && sem==7)
			{
				JOptionPane.showMessageDialog(frame,"Error!! Please enter valid information.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(sub1cred<5 || sub2cred<5 ||sub3cred<5 || sub4cred<5 || sub5cred<5 ||sub6cred<5 || sub7cred<5 && sem==7)
			{
				System.out.println(sub1cred + " " + sub2cred + " " + sub3cred + " " + sub4cred + " " + sub5cred + " " + sub6cred + " " + sub7cred + " " + sub8cred + " " + sub9cred);
				JOptionPane.showMessageDialog(frame,"Sorry!! Your SGPA can't be calculated. You have BACKLOGs in one or more Subject.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(sub1cred>10 || sub2cred>10 ||sub3cred>10 || sub4cred>10 || sub5cred>10  && sem==8)
			{
				JOptionPane.showMessageDialog(frame,"Error!! Please enter valid information.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(sub1cred<5 || sub2cred<5 ||sub3cred<5 || sub4cred<5 || sub5cred<5 && sem==8)
			{
				System.out.println(sub1cred + " " + sub2cred + " " + sub3cred + " " + sub4cred + " " + sub5cred + " " + sub6cred + " " + sub7cred + " " + sub8cred + " " + sub9cred);
				JOptionPane.showMessageDialog(frame,"Sorry!! Your SGPA can't be calculated. You have BACKLOGs in one or more Subject.","Error Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
			if(sem==1) {
				int subwithcred3 = sub1cred + sub3cred + sub4cred + sub5cred;
				int subwithcred2 = sub6cred + sub7cred;
				double sem1totalcred = subwithcred3*3 + sub2cred*4 + subwithcred2*2 + sub8cred;
				double sgpa = (sem1totalcred/210.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
 			}
			else if(sem==2) {
				int subwithcred3 = sub1cred + sub3cred + sub4cred + sub5cred;
				int subwithcred2 = sub6cred + sub7cred;
				double sem1totalcred = subwithcred3*3 + sub2cred*4 + subwithcred2*2 + sub8cred;
				double sgpa = (sem1totalcred/210.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
			}
			else if(sem==3) {
				int subwithcred3 = sub1cred + sub3cred + sub4cred + sub5cred + sub6cred;
				int subwithcred2 = sub7cred + sub8cred;
				double sem1totalcred = subwithcred3*3 + sub2cred*4 + subwithcred2*2 + sub9cred;
				double sgpa = (sem1totalcred/240.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
			}
			else if(sem==4) {
				int subwithcred3 = sub1cred + sub3cred + sub4cred + sub5cred + sub6cred;
				int subwithcred2 = sub7cred + sub8cred;
				double sem1totalcred = subwithcred3*3 + sub2cred*4 + subwithcred2*2 + sub9cred;
				double sgpa = (sem1totalcred/240.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
			}
			else if(sem==5) {
				int subwithcred4 = sub2cred + sub3cred;
				int subwithcred3 = sub1cred + sub4cred + sub5cred + sub6cred;
				int subwithcred2 = sub7cred + sub8cred;
				double sem1totalcred = subwithcred3*3 + subwithcred4*4 + subwithcred2*2 + sub9cred;
				double sgpa = (sem1totalcred/250.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
			}
			else if(sem==6) {
				int subwithcred4 = sub1cred + sub2cred + sub3cred;
				int subwithcred3 = sub4cred + sub5cred;
				int subwithcred2 = sub6cred + sub7cred + sub8cred;
				double sem1totalcred = subwithcred3*3 + subwithcred4*4 + subwithcred2*2;
				double sgpa = (sem1totalcred/240.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
			}
			else if(sem==7) {
				int subwithcred4 = sub1cred + sub2cred;
				int subwithcred3 = sub3cred + sub4cred + sub5cred;
				double sem1totalcred = subwithcred3*3 + subwithcred4*4  + sub6cred*2 + sub7cred;
				double sgpa = (sem1totalcred/200.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
			}
			else if(sem==8) {
				int subwithcred3 = sub1cred + sub2cred + sub5cred;
				double sem1totalcred = subwithcred3*3 + sub3cred*8  + sub4cred;
				double sgpa = (sem1totalcred/180.0)*10.0;
				GPATable gt = new GPATable(USN,sem,sgpa);
				GPATableOperationsDB.updateGPAtable(gt);
				l13.setText(String.format("Congratulations!! Your SGPA for Sem " + sem + " is  %.2f", sgpa));
				JOptionPane.showMessageDialog(frame,l13,"Success Message",JOptionPane.INFORMATION_MESSAGE);
				l13.setVisible(true);
			}
			}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(frame,"Error!! Please enter valid information.","Error Message",JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public static void main(String[] args) {
		StudentSGPACalculation ssc = new StudentSGPACalculation("4SF20CS030");
	}
	
}
