package org.oecm19.task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;
import org.oecm19.task.*;
import org.oecm19.task.SuccessPage;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;

@SuppressWarnings("unchecked")
public class AdminLogin extends JFrame {

	JTextField t1;
	JFrame jf, f;
	JPasswordField pp1;
	JButton b1, b2, b3, b4;
	JLabel l1, l2, l3, l4, l5;

	public AdminLogin() {
		jf = new JFrame("ADMIN LOGIN FORM");
		// f = new JFrame("FAILURE PAGE");

		Container ct = jf.getContentPane();
		GroupLayout gp = new GroupLayout(ct);
		ct.setLayout(gp);
		gp.setAutoCreateContainerGaps(true);

		l1 = new JLabel("UserName :   ");
		l1.setBounds(50, 80, 120, 30);
		t1 = new JTextField();
		t1.setBounds(140, 80, 120, 30);

		l2 = new JLabel("Password :   ");
		l2.setBounds(50, 120, 120, 30);
		pp1 = new JPasswordField();
		pp1.setBounds(140, 120, 120, 30);

		b1 = new JButton("LOGIN");
		b1.setBounds(370, 100, 90, 30);
		b1.setBackground(Color.MAGENTA);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				loginbutton(evt);

			}
		});

		l3 = new JLabel(" DO NOT HAVE AN ACCOUNT--------    ");
		l3.setBounds(140, 160, 250, 30);
		l3.setBackground(Color.LIGHT_GRAY);

		b2 = new JButton("SIGNUP");
		b2.setBounds(370, 160, 90, 30);
		b2.setBackground(Color.green);

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				signupbutton(e);

			}
		});

		l4 = new JLabel("ALREADY A REGISTERED EMPLOYEE ?  ");
		l4.setBounds(140, 200, 250, 30);

		b3 = new JButton("SHOW");
		b3.setBackground(Color.PINK);
		b3.setBounds(370, 200, 90, 30);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				showbutton(e);
				

			}
		});

		l5 = new JLabel("DELETE EMPLOYEE RECORD   ");
		l5.setBounds(140, 250, 250, 30);

		b4 = new JButton("DELETE");
		b4.setBounds(370, 250, 90, 30);
		b4.setBackground(Color.YELLOW);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deletebutton(e);
			}
		});

		jf.add(l1);
		jf.add(t1);
		jf.add(l2);
		jf.add(pp1);
		jf.add(b1);
		jf.add(b2);
		jf.add(l3);
		jf.add(l4);
		jf.add(b3);
		jf.add(l5);
		jf.add(b4);

		jf.setSize(600, 400);
		jf.setLayout(null);
		jf.setVisible(true);

		// create a sequential group for horizontal axis//
		SequentialGroup sq = gp.createSequentialGroup();
		sq.addGroup(gp.createParallelGroup().addComponent(l1).addComponent(l2));
		sq.addGroup(
				gp.createParallelGroup().addComponent(t1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(pp1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE));
		gp.setHorizontalGroup(sq);

		// create a sequential group for vertical axis//
		GroupLayout.SequentialGroup vg = gp.createSequentialGroup();
		vg.addGroup(gp.createParallelGroup(Alignment.BASELINE).addComponent(l1).addComponent(t1));
		vg.addGroup(gp.createParallelGroup(Alignment.BASELINE).addComponent(l2).addComponent(pp1));
		gp.setVerticalGroup(vg);
	}

	protected void loginbutton(ActionEvent evt) 
	{
		validation(evt);
		EmployeeMaster emp = new EmployeeMaster();
		emp.setVisible(true);
		this.dispose();
	}

	protected void showbutton(ActionEvent e)
	{
		SuccessPage sp = new SuccessPage();
		sp.setVisible(true);
		this.dispose();
	}

	protected void signupbutton(ActionEvent e) 
	{
		SignupPage sg = new SignupPage();
		sg.setVisible(true);
		this.dispose();
	}

	protected void deletebutton(ActionEvent e) {
		SuccessPage sp = new SuccessPage();
		sp.setVisible(true);
		this.dispose();
	}

	public void validation(ActionEvent evt) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String nm = t1.getText();
		String pwd = pp1.getText();

		String qry = "select * from project1.registration where user_name=" + "'" + nm + "'" + " and " + "password = "
				+ "'" + pwd + "'";

		System.out.println("query  " + qry);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();

			if (rs.next())
			{
				
				
				if (nm.equalsIgnoreCase(rs.getString("user_name")) && pwd.equalsIgnoreCase(rs.getString("password")))
				{

					JOptionPane.showMessageDialog(rootPane, "Successfully Updated.", "ALERT",
							JOptionPane.WARNING_MESSAGE);

				}
				

			} 
			
			
			else if (nm.length() == 0 && pwd.length() == 0)
			{
				JFrame f = new JFrame("FAILURE PAGE");
				JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER USERNAME AND PASSWORD", "ALERT",
						JOptionPane.WARNING_MESSAGE);

				this.dispose();
			} 
			
			
			else if (nm.length() == 0 && pwd.length() != 0) 
			{

				JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER USERNAME ", "ALERT", JOptionPane.WARNING_MESSAGE);

				this.dispose();
			} 
			else if (nm.length() != 0 && pwd.length() == 0)
			{
				JFrame f = new JFrame("FAILURE PAGE");
				JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER PASSWORD ", "ALERT", JOptionPane.WARNING_MESSAGE);

				// this.dispose();
				return;
			}

			else
			{

				JFrame f = new JFrame("FAILURE PAGE");
				JOptionPane.showMessageDialog(rootPane, "ERROR INPUT", "ALERT", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {

		new AdminLogin();

	}

}
