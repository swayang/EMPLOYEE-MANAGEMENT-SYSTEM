package org.oecm19.task;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;
import org.oecm19.task.SuccessPage;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShowEmployeeDetails extends JFrame
		{	
			JLabel     l1,l2,l3,l4,l5,l6,l7,l8;
			static JTextField nm,em,ph,ag,dp,st,ct,gd;
			JFrame f;
			JButton b1,b2;
	
		public ShowEmployeeDetails()
		{
			initcomponents();
		}

	private void initcomponents()
	{
				String id=SuccessPage.jt.getText();
				int eId=Integer.parseInt(id);
		
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String retrieveqry="select * from project1.employee where E_id="+"'"+eId+"'";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
				pstmt=con.prepareStatement(retrieveqry);
				rs=pstmt.executeQuery();
				
			if(rs.next())
			{
				if(eId==rs.getInt(1))
				{
					System.out.println(retrieveqry);
					String name=rs.getString(2);
					String email=rs.getString(3);
					String phone=rs.getString(4);
					String age=Integer.toString(rs.getInt(5));
					String dept=rs.getString(6);
					String state=rs.getString(7);
					String country=rs.getString(8);
					String gender=rs.getString(9);
					
					
					f=new JFrame("EMPLOYEE DATA");
					
					l1 = new JLabel("EMP_NAME :");
					l1.setBounds(50, 80, 90, 30);
					nm = new JTextField(name);
					nm.setEditable(false);
					nm.setBounds(200, 80, 160, 30);

					l2 = new JLabel("EMP_EMAIL :");
					l2.setBounds(50, 120, 90, 30);
					em = new JTextField(email);
					em.setBounds(200, 120, 160, 30);

					l3 = new JLabel("EMP_PHONE :");
					l3.setBounds(50, 160, 90, 30);
					ph = new JTextField(phone);
//					ph.setEditable(true);
					ph.setBounds(200, 160, 160, 30);

					l4 = new JLabel("EMP_AGE :");
					l4.setBounds(50, 200, 90, 30);
					ag = new JTextField(age);
					ag.setEditable(false);
					ag.setBounds(200, 200, 160, 30);

					l5 = new JLabel("EMP_DEPT :");
					l5.setBounds(50, 240, 90, 30);
					dp = new JTextField(dept);
//					dp.setEditable(true);
					dp.setBounds(200, 240, 160, 30);

					l6 = new JLabel("EMP_STATE :");
					l6.setBounds(50, 280, 90, 30);
					st = new JTextField(state);
					st.setBounds(200, 280, 160, 30);

					l7 = new JLabel("EMP_COUNTRY :");
					l7.setBounds(50, 320, 90, 30);
					ct = new JTextField(country);
//					ct.setEditable(false);
					ct.setBounds(200, 320, 160, 30);

					l8 = new JLabel("EMP_GENDER :");
					l8.setBounds(50, 360, 90, 30);
					gd = new JTextField(gender);
					gd.setEditable(false);
					gd.setBounds(200, 360, 160, 30);
					
					b1=new JButton("BACK");
					b1.setBackground(Color.green);
					b1.setBounds(100, 400, 90, 30);
					b1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e)
						{
							back();
							SuccessPage sp=new SuccessPage();
							sp.setVisible(true);
						}
					});
					

					b2=new JButton("UPDATE");
					b2.setBackground(Color.ORANGE);
					b2.setBounds(300, 400, 90, 30);
					b2.addActionListener(new ActionListener() 
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
						{
							updateButton(e);
						}
					});
					
					f.add(l1);
					f.add(l2);
					f.add(l3);
					f.add(l4);
					f.add(l5);
					f.add(l6);
					f.add(l7);
					f.add(l8);
					f.add(nm);
					f.add(em);
					f.add(ph);
					f.add(ag);
					f.add(dp);
					f.add(st);
					f.add(ct);
					f.add(gd);
					f.add(b1);
					f.add(b2);
					
					f.setSize(600, 400);
					f.setLayout(null);
					f.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER VALID E_id", "ALERT",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
			
			
			
	}

	protected void updateButton(ActionEvent e)
	{
		updatedetails ud=new updatedetails();
		ud.setVisible(true);
		this.dispose();
	}

	protected void back() 
	{
		this.dispose();
	}

	public static void main(String[] args) 
	{
		new ShowEmployeeDetails();
	}

}
