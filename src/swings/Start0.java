package swings;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Start0 {

	//JCOMPONENTS VARIABLE DECLARATION 
		JFrame frame;
		JLabel l0,l1,l2;
		JButton b1;
		Border border1;
			
	public Start0() {
		initialize();
	}
	
	public void initialize() {
		
		//FRAME CREATION
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,875);
		
		l0 = new JLabel();
		l0.setBounds(0,0,1920,875);
		ImageIcon imgic = new ImageIcon("D:\\My DEGREE's\\BE {Computer Science}\\5th Sem\\18CSL58 {DBMS Laboratory}\\DBMS Project - WORKSPACE\\Student Academics Assessment System\\src\\Pictures\\sahyadri.png");
		Image img = imgic.getImage();
		Image modifiedimage = img.getScaledInstance(1920,875,java.awt.Image.SCALE_SMOOTH);
		imgic = new ImageIcon(modifiedimage);
		l0.setIcon(imgic);
		
		l1 = new JLabel("STUDENT  ACADEMIC  ASSESSMENT  SYSTEM");
		l1.setBounds(400,50,800,100);
		l1.setFont(new Font("Algerian",Font.BOLD,35));
//		l1.requestFocusInWindow();
//		l1.grabFocus();
		
		l2 = new JLabel("Sahyadri   College   of   Engineering   and    Management  ,  MANGALORE  575007");
		l2.setBounds(310,150,1000,100);
		l2.setFont(new Font("Times New Roman",Font.ITALIC,28));
		
		
		b1 = new JButton(">>");
		b1.setBounds(1475,325,70,175);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
//		b1.setBackground(Color.LIGHT_GRAY);
		border1 = BorderFactory.createLineBorder(Color.DARK_GRAY,3);
		b1.setBorder(border1);
		b1.setFont(new Font("Arial",Font.PLAIN,30));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals(">>") == true) {
					Start st = new Start();
				}
			}
		});
		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				b1.setOpaque(true);
				b1.setContentAreaFilled(true);
				b1.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent me) {
				b1.setOpaque(false);
				b1.setContentAreaFilled(false);
				b1.setBorderPainted(false);
			}
		});
		
		frame.add(l1);
		frame.add(l2);
		frame.add(b1);
		frame.add(l0);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Start0 st0 = new Start0();
	}

}
