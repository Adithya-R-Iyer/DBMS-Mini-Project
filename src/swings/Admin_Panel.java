package swings;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Admin_Panel {
	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5;
	JPasswordField pf;
	JTextField tf1;
	JButton b1,b2,b3;
	
	//OTHER VARIABLES
		private static final String OK ="Enter";
		char [] input;
		
	public Admin_Panel() {
		initialize();
	}

	public void initialize() {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,875);
		
		l0 = new JLabel("Hearty  Welcome  !!!  to  Student  Academic  Assessment  System  -  SUN  TECHNOLOGIES  PVT  LTD",SwingConstants.CENTER);
		l0.setBounds(0,0,1475,50);
		l0.setFont(new Font("Times New Roman",Font.PLAIN,22));
		
		l1 = new JLabel("ADMINISTRATOR    LOGIN");
		l1.setBounds(570,100,800,100);
		l1.setFont(new Font("Algerian",Font.BOLD,35));
		
		l5 = new JLabel();
		l5.setBounds(30,10,150,100);
		ImageIcon imgic1 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\logo.png");
		Image img1 = imgic1.getImage();
		Image modifiedimage1 = img1.getScaledInstance(150,100,java.awt.Image.SCALE_SMOOTH);
		imgic1 = new ImageIcon(modifiedimage1);
		l5.setIcon(imgic1);
		
		l2 = new JLabel("USERNAME");
	    l2.setBounds(400,260,300,100);
	    l2.setFont(new Font("Comic Sans MS",Font.PLAIN,24));
	    
	    tf1 = new JTextField("enter username");
		tf1.setBounds(700,275,350,70);
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.PLAIN,24));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf1.getText().trim().equals("enter username"))
		        	tf1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf1.getText().trim().equals(""))
		            tf1.setText("enter username");		    	
		    }
		});
		tf1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  pf.grabFocus();
		      }
		    });
		tf1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					pf.grabFocus();
		        }
	    	}
	    });
	    
		l3 = new JLabel("PASSWORD");
	    l3.setBounds(400,400,300,100);
	    l3.setFont(new Font("Comic Sans MS",Font.PLAIN,24));
	    
	    pf = new JPasswordField(10);
	    pf.setActionCommand(OK);
	    pf.setSize(350,70);
	    pf.setLocation(700,410);
	    pf.setFont(new java.awt.Font("sansserif", 0, 26));
	    pf.setHorizontalAlignment(JTextField.CENTER);
//	    pf.setPreferredSize(new java.awt.Dimension(4, 15));
//	    pf.setText("xxxxxxx");
	    pf.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		String cmd = ae.getActionCommand();
		        if (OK.equals(cmd)) { //Process the password.
		        	 input = pf.getPassword();
		            if (isPasswordCorrect(input)) {
		            	if(tf1.getText().equals("Adithya R Iyer") || tf1.getText().equals("Madan R Naik")) {
		            		if(tf1.getText().equals("Adithya R Iyer")) {
		            			Admin_Panel_Start aps = new Admin_Panel_Start("adithya");
		            		}
		            		else if(tf1.getText().equals("Madan R Naik")) {
		            			Admin_Panel_Start aps = new Admin_Panel_Start("madan");
		            		}
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(frame,"Invalid Username!! Please enter a valid Username","Error Message",JOptionPane.ERROR_MESSAGE);
		            	}
		            } else {
		            	if(tf1.getText().equals("Adithya R Iyer")) {
		            		JOptionPane.showMessageDialog(frame,"Invalid Password!! Try again","Error Message",JOptionPane.ERROR_MESSAGE);
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(frame,"Invalid Username or Password!! Please enter a valid Credentials","Error Message",JOptionPane.ERROR_MESSAGE);
		            	}
		            }
		        }
	    	}
	    });
	    pf.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
					tf1.grabFocus();
		        }
	    	}
	    });
	    
	    b1 = new JButton("LOGIN");
		b1.setBounds(695,565,140,50);
		b1.setFont(new Font("Arial",Font.PLAIN,24));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("LOGIN") == true) {
					input = pf.getPassword();
					if (isPasswordCorrect(input)) {
		            	if(tf1.getText().equals("Adithya R Iyer") || tf1.getText().equals("Madan R Naik")) {
		            		if(tf1.getText().equals("Adithya R Iyer")) {
		            			Admin_Panel_Start aps = new Admin_Panel_Start("adithya");
		            		}
		            		else if(tf1.getText().equals("Madan R Naik")) {
		            			Admin_Panel_Start aps = new Admin_Panel_Start("madan");
		            		}
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(frame,"Invalid Username!! Please enter a valid Username","Error Message",JOptionPane.ERROR_MESSAGE);
		            	}
					}
		            	else {
			            	if(tf1.getText().equals("Adithya R Iyer")) {
			            		JOptionPane.showMessageDialog(frame,"Invalid Password!! Try again","Error Message",JOptionPane.ERROR_MESSAGE);
			            	}
			            	else {
			            		JOptionPane.showMessageDialog(frame,"Invalid Username or Password!! Please enter valid Credentials","Error Message",JOptionPane.ERROR_MESSAGE);
			            	}
		            	
		            }
				}
			}
		});
		
		b2 = new JButton("BACK");
		b2.setBounds(915,565,140,50);
		b2.setFont(new Font("Arial",Font.PLAIN,24));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Start st = new Start();
				}
			}
		});
		
		l4 = new JLabel("Forgot   Password   !?   :    To   Change   Password   ... ");
	    l4.setBounds(425,675,450,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,20));
		
	    b3 = new JButton("Click Here");
		b3.setBounds(895,710,140,25);
		b3.setFont(new Font("Arial",Font.PLAIN,18));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("Click Here") == true) {
					
				}
			}
		});
	   
		frame.add(l0);
		frame.add(l5);
		frame.add(l1);
		frame.add(l2);
		frame.add(tf1);
		frame.add(l3);
		frame.add(pf);
		frame.add(b1);
		frame.add(b2);
		frame.add(l4);
		frame.add(b3);
		frame.setVisible(true);
		
	}
	
	private static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword0 = { 'a','d','i','@','1','2','3' };
	    char[] correctPassword1 = { 'm','a','d','@','1','2','3' };
	    
	    if (input.length != correctPassword0.length || input.length != correctPassword1.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword0) || Arrays.equals (input, correctPassword1);
	    }
	    Arrays.fill(correctPassword0,'0');
	    Arrays.fill(correctPassword1,'0');
	    return isCorrect;
	}
}
