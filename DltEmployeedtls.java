package org.oecm19.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DltEmployeedtls extends JFrame {
	public DltEmployeedtls() {
		deletecomponents();
	}

	private void deletecomponents() {

		String id = SuccessPage.jt.getText();
		int eId = Integer.parseInt(id);

		Connection con = null;
		Statement stmt = null;
		String deleteqry ="delete  from project1.employee where E_id="+"'"+eId+"'";
		System.out.println(deleteqry);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			stmt = con.createStatement();
			stmt.executeUpdate(deleteqry);
			JOptionPane.showMessageDialog(rootPane, " SUCCESSFULLY DELETED EMPLOYEE DETAILS");

		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new DltEmployeedtls();
	}

}
