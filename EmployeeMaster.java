package org.oecm19.task;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.*;
import java.sql.*;
import java.util.Enumeration;

import javax.swing.*;

public class EmployeeMaster extends JFrame 
	{
	
	JFrame f;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JButton b1, b2, b3;
	ButtonGroup bg;
	JRadioButton jb1, jb2;
	JTextField id, nm, em, ph, ag, dp, st, ct;

	 

	private int eid = 400;

	public EmployeeMaster()
	{
		f = new JFrame("EMPLOYEE REGISTRATION DETAILS");

		l1 = new JLabel("EMP_ID :");
		l1.setBounds(50, 80, 90, 30);
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(200, 80, 120, 30);

		l2 = new JLabel("EMP_NAME :");
		l2.setBounds(50, 120, 90, 30);
		nm = new JTextField();
		nm.setBounds(200, 120, 120, 30);

		l3 = new JLabel("EMP_EMAIL :");
		l3.setBounds(50, 160, 90, 30);
		em = new JTextField();
		em.setBounds(200, 160, 120, 30);

		l4 = new JLabel("EMP_PHONE :");
		l4.setBounds(50, 200, 90, 30);
		ph = new JTextField();
		ph.setBounds(200, 200, 120, 30);

		l5 = new JLabel("EMP_AGE :");
		l5.setBounds(50, 240, 90, 30);
		ag = new JTextField();
		ag.setBounds(200, 240, 120, 30);

		l6 = new JLabel("EMP_DEPT :");
		l6.setBounds(50, 280, 90, 30);
		dp = new JTextField();
		dp.setBounds(200, 280, 120, 30);

		l7 = new JLabel("EMP_STATE :");
		l7.setBounds(50, 320, 90, 30);
		st = new JTextField();
		st.setBounds(200, 320, 120, 30);

		l8 = new JLabel("EMP_COUNTRY :");
		l8.setBounds(50, 360, 90, 30);
		ct = new JTextField();
		ct.setBounds(200, 360, 120, 30);

		l9 = new JLabel("GENDER :");
		l9.setBounds(50, 400, 90, 30);

		bg = new ButtonGroup();
		jb1 = new JRadioButton("MALE");
		jb1.setBounds(200, 400, 70, 20);
		jb1.setSelected(true);
		bg.add(jb1);
		jb2 = new JRadioButton("FEMALE");
		jb2.setBounds(270, 400, 70, 20);
		bg.add(jb2);

		b1 = new JButton("SUBMIT");
		b1.setBounds(100, 500, 90, 30);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e1) {
				submittion(e1);
			}
		});

		b2 = new JButton("RESET");
		b2.setBounds(400, 500, 90, 30);
		b2.setBackground(Color.MAGENTA);
		
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e2) 
			{
				resetbutton(e2);
			}
		});

		b3 = new JButton("BACK");
		b3.setBounds(700, 500, 90, 30);
		b3.setBackground(Color.YELLOW);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				backbutton(e);
			}
		});

		f.add(l1);
		f.add(id);
		f.add(l2);
		f.add(nm);
		f.add(l3);
		f.add(em);
		f.add(l4);
		f.add(ph);
		f.add(l5);
		f.add(ag);
		f.add(l6);
		f.add(dp);
		f.add(l7);
		f.add(st);
		f.add(l8);
		f.add(ct);
		f.add(l9);
		f.add(jb1);
		f.add(jb2);
		f.add(b1);
		f.add(b2);
		f.add(b3);

		f.setSize(600, 400);
		f.setLayout(null);
		f.setVisible(true);

	}
	
	

	private void resetbutton(ActionEvent e2)
	{
		EmployeeMaster emp = new EmployeeMaster();
		emp.setVisible(true);
		this.dispose();
//		System.exit(0);

	}



	private void backbutton(ActionEvent e)
	{
		
		AdminLogin ad = new AdminLogin();
		ad.setVisible(true);
		this.dispose();
		
		
		
	}



	private void submittion(ActionEvent e1)
	{
		String id = Integer.toString(eid++);
		int eId = eid;
		
		
		String name = nm.getText();
//		nm.setEditable(false);
		if (name.length() == 0) {
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER EMPLOYEE NAME");
			return;
		}
		String email = em.getText();
		if(!email.contains("@") && email.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER VALID PHONE NUMBER");
			return;
		}
		
		String phone = ph.getText();
		if (phone.length() > 10 || phone.length() < 10) {
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER VALID PHONE NUMBER");
			return;
		}

		String dept = dp.getText();
		if (dept.length() == 0) {
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER DEPARTMENT");
			return;
		}
		String state = st.getText();
		if (state.length() == 0) {
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER STATE");
			return;
		}
		String country = ct.getText();
		if (country.length() == 0) {
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER COUNTRY");
			return;
		}
		String gender = null;
		Enumeration enm = bg.getElements();
		while (enm.hasMoreElements()) {
			AbstractButton ab = (AbstractButton) enm.nextElement();
			if (bg.isSelected(ab.getModel())) {
				gender = ab.getText();
			}
		}

		Connection con = null;
		PreparedStatement pstmt = null;

		String insertqry = "insert into project1.employee values(?,?,?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt = con.prepareStatement(insertqry);

			pstmt.setInt(1, eId);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			pstmt.setInt(5, (Integer.parseInt(ag.getText())));
			pstmt.setString(6, dept);
			pstmt.setString(7, state);
			pstmt.setString(8, country);
			pstmt.setString(9, gender);

			pstmt.executeUpdate();

			JOptionPane.showMessageDialog(rootPane, "Employee is registered");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new EmployeeMaster();
	}

}
