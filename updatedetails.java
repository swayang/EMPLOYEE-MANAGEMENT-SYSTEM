package org.oecm19.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updatedetails extends JFrame
{
	
	public updatedetails()
	{
		updatecomponents();
	}
	
	


	private void updatecomponents() 
	{
		

		String id = SuccessPage.jt.getText();
		int eId = Integer.parseInt(id);
		
		
		
		String emailId=ShowEmployeeDetails.em.getText();
		if(emailId.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER VALID EMAIL ID");
			return;
		}
		
		String phoneNumber=ShowEmployeeDetails.ph.getText();
		if (phoneNumber.length() > 10 || phoneNumber.length() < 10) {
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER VALID PHONE NUMBER");
			return;
		}
		
		
		String state=ShowEmployeeDetails.st.getText();
		if(state.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER YOUR STATE");
			return;
		}
		
		String country=ShowEmployeeDetails.ct.getText();
		if(country.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER YOUR COUNNTRY");
			return;
		}
		
		String gender=ShowEmployeeDetails.gd.getText();
		
		
		Connection con=null;
		Statement stmt=null;
		
		
		String qry="update project1.employee set E_phone="+"'"+phoneNumber+"'"+""
				+ ",E_state="+"'"+state+"'"+",E_email="+"'"+emailId+"'"+",E_country="+"'"+country+"'"
				+",E_gender="+"'"+gender+"'"+ "where E_id="+"'"+eId+"'";
		
		
		
		System.out.println(qry);
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			stmt=con.createStatement();
			stmt.executeUpdate(qry);
			JOptionPane.showMessageDialog(rootPane, "UPDATED SUCCESSFULLY");
			
			
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			System.out.println("closed all the costly resources");
		}
		
	}
	public static void main(String[] args)
	{
		new updatedetails();
	}

}
