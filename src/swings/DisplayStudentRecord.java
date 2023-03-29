package swings;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.lang.*;
import mysql.StudentTable;
import mysql.StudentTableOperationsDB;

import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class DisplayStudentRecord {

	//JCOMPONENTS VARIABLE DECLARATION 
	JFrame frame;
	JLabel l0,l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3;
	JScrollPane sp,sp1;
	JComboBox cb1,cb2,cb3,cb4;
	Border border1,border2;
	JTable table,table1;
	JPanel panel1,panel2;
	DefaultTableModel tableMode2;
	
	//OTHER VARIABLES
	Connection con;
	String ar="0000-00",dept="XYZ",section="Z";
	int sem=0;
	String si_id;
	String AdminName;
	
	public DisplayStudentRecord() {
		initialize();	
	}
	
	public DisplayStudentRecord(String adname) {
		this.AdminName = adname;
		initialize();	
	}
	
	public void initialize()  {
		
		// FRAME CREATION 
		frame = new JFrame();
		frame.setTitle("Student Management App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1920,875);
		
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
		
		l2 = new JLabel("STUDENT  RECORD  DATABASE  PORTAL");
		l2.setBounds(440,45,800,100);
		l2.setFont(new Font("Algerian",Font.BOLD,35));
		
		l3 = new JLabel("Acdmic Year");
	    l3.setBounds(40,130,155,100);
	    l3.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column1[] = {"        ---","   2018-22","   2019-23","   2020-24","   2021-25"};
		cb1 = new JComboBox(column1);
		cb1.setBounds(210,155,150,50);	
	    cb1.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb1value= cb1.getSelectedItem().toString();
		    	  ar = cb1value.trim();
		      }
		    });
	    cb1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_UP){
//					tf6.grabFocus();
		        }
	    	}
	    });
	    cb1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_LEFT){
//					tf7.grabFocus();
		        }
	    	}
	    });
	    
	    l4 = new JLabel("Department");
	    l4.setBounds(450,130,200,100);
	    l4.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column2[] = {"     ---","    CSE","    ISE","    AIML","    DS","    MECH","    CIVIL","    ECE"};
		cb2 = new JComboBox(column2);
		cb2.setBounds(625,155,125,50);	
	    cb2.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb2value= cb2.getSelectedItem().toString();
		    	  dept = cb2value.trim();
		      }
		    });
	    cb2.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent ie) {
	    	
	    	}
	    });
	    
	    l5 = new JLabel("Semester");
	    l5.setBounds(850,130,200,100);
	    l5.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column3[] = {"    0","    1","    2","    3","    4","    5","    6","    7","    8"};
		cb3 = new JComboBox(column3);
		cb3.setBounds(985,155,125,50);	
	    cb3.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb3value= cb3.getSelectedItem().toString();
		    	  sem = Integer.parseInt(cb3value.trim());
		      }
		    });
	    cb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
			}
	    });
	    
	    l6 = new JLabel("Section");
	    l6.setBounds(1200,130,200,100);
	    l6.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    
	    String column4[] = {"     ---","     A","     B","     C","     D","     E","     F","     G","     H","     I","     J","     K","     L"};
		cb4 = new JComboBox(column4);
		cb4.setBounds(1310,155,125,50);	
	    cb4.setFont(new Font("Gothic",Font.ITALIC,24));
	    cb4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String cb4value= cb4.getSelectedItem().toString();
		    	  section = cb4value.trim();
		      }
		    });
		
	  //PANEL 1 CREATION - HOME BUTTON CONTENTS
	    panel1 = new JPanel();
	    panel1.setBounds(0,220,1510,500);
	    panel1.setLayout(null);
		
	    try {
	
		String user = "root";
		String password = "SK@@))@";
		String url = "jdbc:mysql://localhost:3306/dbms_mini_project";
		
		con = DriverManager.getConnection(url,user,password);
		
		String query = "Select SID,SFNAME,SLNAME,USN,SPHNO,SCITY,SGENDER,SDOB,SEMAIL,si_id from student;";
		
		Statement st = con.createStatement();
		ResultSet set = st.executeQuery(query);
		
		DefaultTableModel tableModel = new DefaultTableModel() {
			 public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		table = new JTable(tableModel);
		
		
		border1 = BorderFactory.createLineBorder(Color.cyan,2);
		table.setBorder(border1);
		table.setBounds(10,10,1500,470);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setSelectionForeground(Color.black);
		table.setFont(new Font("Aerial",Font.PLAIN,14));
		table.setRowHeight(40);
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setResizingAllowed(true);
		table.setPreferredSize(new Dimension(0,5000));
		
	 table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
	 table.getTableHeader().setBackground(Color.BLUE);
	 table.getTableHeader().setForeground(Color.WHITE);
	 JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
		
//	 jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);	
	 
		tableModel.addColumn("ID");
		tableModel.addColumn("FNAME");
		tableModel.addColumn("LNAME");
		tableModel.addColumn("USN");
		tableModel.addColumn("PHNO");
		tableModel.addColumn("CITY");
		tableModel.addColumn("GENDER");
		tableModel.addColumn("DOB");
		tableModel.addColumn("SEMAIL");
		tableModel.addColumn("SI_ID");
		
		
		while(set.next()) {
			int id = set.getInt(1);
			String fname = set.getString(2);
			String lname = set.getString(3);
			String usn = set.getString(4);
			String phno = set.getString(5);
			String city = set.getString(6);
			String gender = set.getString(7);
			String dob = set.getString(8);
			String email = set.getString(9);
			String si_id = set.getString(10);
			
			Object data1[] = {id,fname,lname,usn,phno,city,gender,dob,email,si_id};
			tableModel.addRow(data1);
		}			
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
		
		sp = new JScrollPane(table);
		sp.setBounds(10,10,1500,470);
		sp.setBackground(Color.cyan);
		sp.setViewportBorder(BorderFactory.createLineBorder(Color.black,2));
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.getVerticalScrollBar().setUnitIncrement(16);
		
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
	    
	    panel1.add(sp);
	    panel1.setVisible(true);
	    
	    //PANEL2 CREATION
	    panel2 = new JPanel();
		panel2.setBounds(0,220,1510,500);
		panel2.setLayout(null);
		panel2.setVisible(false);
	    
		
		//FRAME CONTINUE
	    b1 = new JButton("UPDATE");
		b1.setBounds(400,730,125,50);
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String stg = ae.getActionCommand();
				if(stg.equals("UPDATE") == true) {
					si_id = ar.substring(2,4) + dept.substring(0,2) + sem + section;
					panel1.setVisible(false);
					
					
					try {
						
//						 si_id = ar.substring(2,4) + dept.substring(0,2) + sem + section;
							
						String user = "root";
						String password = "SK@@))@";
						String url = "jdbc:mysql://localhost:3306/dbms_mini_project";
						
						con = DriverManager.getConnection(url,user,password);
						
						String query = "Select SID,SFNAME,SLNAME,USN,SPHNO,SCITY,SGENDER,SDOB,SEMAIL from student where si_id=?;";
						
						PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						pstmt.setString(1, si_id);
						ResultSet set2 = pstmt.executeQuery();
						
						if(set2.next()==false) {
							JOptionPane.showMessageDialog(frame,"SORRY!! No Records Found ","Error Message",JOptionPane.ERROR_MESSAGE);
							cb1.setSelectedIndex(0);
							cb2.setSelectedIndex(0);
							cb3.setSelectedIndex(0);
							cb4.setSelectedIndex(0);
							panel1.setVisible(true);
							return;
						}
						set2.previous();
						
						 tableMode2 = new DefaultTableModel() {
							 public boolean isCellEditable(int row, int column) {
							       //all cells false
							       return false;
							    }
						};
						
						table1 = new JTable(tableMode2);
						
						table1.setBorder(border1);
						table1.setBounds(10,10,1500,470);
						table1.setBackground(Color.black);
						table1.setForeground(Color.white);
						table1.setSelectionBackground(Color.red);
						table1.setGridColor(Color.red);
						table1.setSelectionForeground(Color.black);
						table1.setFont(new Font("Aerial",Font.PLAIN,14));
						table1.setRowHeight(40);
						table1.setAutoCreateRowSorter(true);
						table1.getTableHeader().setResizingAllowed(true);
						table1.setPreferredSize(new Dimension(0,5000));
						
						table1.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
						 table1.getTableHeader().setBackground(Color.BLUE);
						 table1.getTableHeader().setForeground(Color.WHITE);
						 JTableUtilities.setCellsAlignment(table1, SwingConstants.CENTER);
									
						tableMode2.addColumn("ID");
						tableMode2.addColumn("FNAME");
						tableMode2.addColumn("LNAME");
						tableMode2.addColumn("USN");
						tableMode2.addColumn("PHNO");
						tableMode2.addColumn("CITY");
						tableMode2.addColumn("GENDER");
						tableMode2.addColumn("DOB");
						tableMode2.addColumn("SEMAIL");
						
						while(set2.next()) {
							int id = set2.getInt(1);
							String fname = set2.getString(2);
							String lname = set2.getString(3);
							String usn = set2.getString(4);
							String phno = set2.getString(5);
							String city = set2.getString(6);
							String gender = set2.getString(7);
							String dob = set2.getString(8);
							String email = set2.getString(9);
							
							Object data2[] = {id,fname,lname,usn,phno,city,gender,dob,email};
							tableMode2.addRow(data2);
						}
						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
						centerRenderer.setHorizontalAlignment( JLabel.CENTER );
						table1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
						table1.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
						
						sp1 = new JScrollPane(table1);
						sp1.setBounds(10,10,1500,470);
						sp1.setBackground(Color.cyan);
						sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						sp1.getVerticalScrollBar().setUnitIncrement(16);
						table1.setVisible(true);
						sp1.setVisible(true);
					   }
						catch(Exception e) {
							e.printStackTrace();
						}
					
					panel2.add(sp1);
					cb1.setSelectedIndex(0);
					cb2.setSelectedIndex(0);
					cb3.setSelectedIndex(0);
					cb4.setSelectedIndex(0);
					panel2.setVisible(true);
				 
				}
			}
		});
		b1.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent ke) {
	    		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
	    			
		        }
	    	}
	    });
		
		b3 = new JButton("PREVIOUS");
		b3.setBounds(650,730,150,50);
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("PREVIOUS") == true) {
					if(panel2.isShowing()==true) {
						panel2.setVisible(false);
						panel1.setVisible(true);
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
						cb3.setSelectedIndex(0);
						cb4.setSelectedIndex(0);
					}
				}
			}
		});
		
		b2 = new JButton("BACK");
		b2.setBounds(925,730,125,50);
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,19));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String stg = ae.getActionCommand();
				if(stg.equals("BACK") == true) {
					Admin_Panel_Start aps = new Admin_Panel_Start(AdminName,"panel1");
				}
			}
		});
		
		
		
		//Frame Add On's
		frame.add(l0);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(cb1);
		frame.add(l4);
		frame.add(cb2);
		frame.add(l5);
		frame.add(cb3);
		frame.add(l6);
		frame.add(cb4);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(b1);
		frame.add(b3);
		frame.add(b2);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		DisplayStudentRecord dsr = new DisplayStudentRecord();
	}

}

class JTableUtilities
{
    public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
}
