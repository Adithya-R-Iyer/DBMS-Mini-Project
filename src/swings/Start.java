package swings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start {
	
	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3,b4;
	
	//OTHER VARIABLES
	
	public Start() {
		initialize();
	}
	
	public void initialize() {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,875);
		
		l0 = new JLabel("Hearty  Welcome  !!!  to  SAA  Management  System -  developed  by  -  SUN  TECHNOLOGIES  PVT  LTD",SwingConstants.CENTER);
		l0.setBounds(0,0,1475,50);
		l0.setFont(new Font("Times New Roman",Font.PLAIN,22));
		
		l6 = new JLabel();
		l6.setBounds(30,10,150,100);
		ImageIcon imgic = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\logo.png");
		Image img = imgic.getImage();
		Image modifiedimage = img.getScaledInstance(150,100,java.awt.Image.SCALE_SMOOTH);
		imgic = new ImageIcon(modifiedimage);
		l6.setIcon(imgic);
		
		l1 = new JLabel("STUDENT  ACADEMIC  ASSESSMENT  SYSTEM");
		l1.setBounds(400,90,800,100);
		l1.setFont(new Font("Algerian",Font.BOLD,35));
		
		l2 = new JLabel("I  AM   A");
	    l2.setBounds(670,190,150,100);
	    l2.setFont(new Font("Comic Sans MS",Font.PLAIN,26));
		
	    b1 = new JButton();
		b1.setBounds(150,340,275,300);
		ImageIcon imgic1 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\Admin1.png");
		Image img1 = imgic1.getImage();
		Image modifiedimage1 = img1.getScaledInstance(275,300,java.awt.Image.SCALE_SMOOTH);
		imgic1 = new ImageIcon(modifiedimage1);
		b1.setIcon(imgic1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					Admin_Panel ap = new Admin_Panel();
			}
		});
		
		l3 = new JLabel("ADMIN");
	    l3.setBounds(225,650,150,100);
	    l3.setFont(new Font("Times New Roman",Font.BOLD,24));
	 
		b2 = new JButton();
		b2.setBounds(625,340,275,300);
		ImageIcon imgic2 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\Faculty.png");
		Image img2 = imgic2.getImage();
		Image modifiedimage2 = img2.getScaledInstance(275,300,java.awt.Image.SCALE_SMOOTH);
		imgic2 = new ImageIcon(modifiedimage2);
		b2.setIcon(imgic2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					Faculty_Panel ap = new Faculty_Panel();
			}
		});
		
		l4 = new JLabel("FACULTY");
	    l4.setBounds(710,650,150,100);
	    l4.setFont(new Font("Times New Roman",Font.BOLD,24));
		
		b3 = new JButton();
		b3.setBounds(1100,340,275,300);
		ImageIcon imgic3 = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\student1.png");
		Image img3 = imgic3.getImage();
		Image modifiedimage3 = img3.getScaledInstance(275,300,java.awt.Image.SCALE_SMOOTH);
		imgic3 = new ImageIcon(modifiedimage3);
		b3.setIcon(imgic3);	
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					Student_Panel ap = new Student_Panel();
			}
		});	
		
		b4 = new JButton("<=]");
		b4.setBounds(50,165,60,50);
//		border1 = BorderFactory.createLineBorder(Color.DARK_GRAY,3);
//		b4.setBorder(border1);
		b4.setFont(new Font("Arial",Font.PLAIN,18));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("<=]") == true) {
					Start0 st0 = new Start0();
				}
			}
		});
		
		l5 = new JLabel("STUDENT");
	    l5.setBounds(1175,650,150,100);
	    l5.setFont(new Font("Times New Roman",Font.BOLD,24));
		
		frame.add(l0);
		frame.add(l6);
		frame.add(l1);
		frame.add(l2);
		frame.add(b4);
		frame.add(b1);
		frame.add(l3);
		frame.add(b2);
		frame.add(l4);
		frame.add(b3);
		frame.add(l5);
		frame.setVisible(true);
	}
}