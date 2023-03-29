package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import mysql.GPATableOperationsDB;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class RemoveStudentRecord {

	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4;
	JTextField tf1;
	JButton b1,b2;
			
	//OTHER VARIABLES
	String usn,name;
	String AdminName;
	
	public RemoveStudentRecord() {
		initialize();
	}
	public RemoveStudentRecord(String adname) {
		this.AdminName = adname;
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
		
		l2 = new JLabel("STUDENT  RECORD  DELETION  PORTAL");
		l2.setBounds(250,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,28));
		
		l3 = new JLabel("Enter   The   Old   Student   Details   ...",SwingConstants.CENTER);
		l3.setBounds(110,120,800,100);
	    l3.setFont(new Font("Times New Roman",Font.ITALIC,23));
	    
	    l4 = new JLabel("Enter   Student   USN");
	    l4.setBounds(200,250,300,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,24));
	    
	    tf1 = new JTextField("enter usn");
		tf1.setBounds(480,275,300,50);
		tf1.requestFocusInWindow();
		tf1.setFont(new Font("Gothic",Font.ITALIC,21));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent fe) {	
		    	if(tf1.getText().trim().equals("enter usn"))
		        	tf1.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		    	if(tf1.getText().trim().equals(""))
		            tf1.setText("enter usn");		    	
		    }
		});
		tf1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  usn = tf1.getText();
		    	  b1.grabFocus();
		      }
		    });
		tf1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_DOWN){
					b1.grabFocus();
		        }
	    	}
	    });
		
		b1 = new JButton("DELETE");
		b1.setBounds(300,430,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("DELETE") == true) {
					
					 Object[] options = { "YES", "NO","CANCEL" };
					int result = JOptionPane.showOptionDialog(null, "Do you want to delete Student Records for USN : " + usn, "Warning",
					 JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					 null, options, options[1]);
					 
					if(result == JOptionPane.YES_OPTION) {
						try {
							GPATableOperationsDB.deletefromgpatable(usn);
		    				StudentTableOperationsDB.deletefromstudenttable(usn);
		    				JOptionPane.showMessageDialog(frame,"Successful !! Student record deleted successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
		    			}
		    			catch(SQLException e) {
//		    				e.printStackTrace();
		    				JOptionPane.showMessageDialog(frame,"Unsuccessful !! Student record not found.","Error Message",JOptionPane.ERROR_MESSAGE);
		    			}
						tf1.setText("");	
					}
						else if(result == JOptionPane.CANCEL_OPTION){
							tf1.setText("");
						}
				}
			}
		});
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){	
	    			
	    			Object[] options = { "YES", "NO","CANCEL" };
					int result = JOptionPane.showOptionDialog(null, "Do you want to delete Student Records for USN : " + usn, "Warning",
					 JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					 null, options, options[1]);
					 
					if(result == JOptionPane.YES_OPTION) {
						try {
							GPATableOperationsDB.deletefromgpatable(usn);
		    				StudentTableOperationsDB.deletefromstudenttable(usn);
		    				JOptionPane.showMessageDialog(frame,"Successful !! Student record deleted successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
		    			}
		    			catch(SQLException e) {
//		    				e.printStackTrace();
		    				JOptionPane.showMessageDialog(frame,"Unsuccessful !! Student record not found.","Error Message",JOptionPane.ERROR_MESSAGE);
		    			}
						tf1.setText("");	
					}
						else if(result == JOptionPane.CANCEL_OPTION){
							tf1.setText("");
						}
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
		
		b2 = new JButton("BACK");
		b2.setBounds(550,430,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Admin_Panel_Start aps = new Admin_Panel_Start(AdminName,"panel4");
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
	    frame.add(b1);
	    frame.add(b2);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		RemoveStudentRecord rsd = new RemoveStudentRecord();
	}
	
}
