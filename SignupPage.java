package org.oecm19.task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignupPage extends JFrame {
	JFrame f1;
	JLabel l3, l4, l5, l6, l7;
	JButton b3;
	JTextField fn, ln, un;
	JPasswordField pp2, pp3;

	public SignupPage() {

		f1 = new JFrame("SIGNUP PAGE ");

		l3 = new JLabel("Firstname  : ");
		l3.setBounds(50, 80, 90, 30);
		fn = new JTextField();
		fn.setBounds(200, 80, 90, 30);

		l4 = new JLabel("Lastname  : ");
		l4.setBounds(50, 120, 90, 30);
		ln = new JTextField();
		ln.setBounds(200, 120, 90, 30);

		l5 = new JLabel("Username  : ");
		l5.setBounds(50, 160, 90, 30);
		un = new JTextField();
		un.setBounds(200, 160, 90, 30);

		l6 = new JLabel("Password  : ");
		l6.setBounds(50, 200, 90, 30);
		pp2 = new JPasswordField();
		pp2.setBounds(200, 200, 90, 30);

		l7 = new JLabel("Confirmpassword  : ");
		l7.setBounds(50, 240, 90, 30);
		pp3 = new JPasswordField();
		pp3.setBounds(200, 240, 90, 30);

		b3 = new JButton("GET STARTED ");
		b3.setBounds(200, 280, 200, 30);
		b3.setBackground(Color.green);
		f1.add(b3, BorderLayout.WEST);

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				validate(arg0);
				JOptionPane.showMessageDialog(rootPane, "SIGNUP SUCCESSFUL.", "ALERT", JOptionPane.WARNING_MESSAGE);
				AdminLogin ad=new AdminLogin();
				ad.setVisible(true);
				ad.dispose();
			}
		});

		Container ct1 = f1.getContentPane();
		GroupLayout gp = new GroupLayout(ct1);
		ct1.setLayout(gp);
		gp.setAutoCreateGaps(true);
		gp.setAutoCreateContainerGaps(true);

		SequentialGroup sq = gp.createSequentialGroup();
		sq.addGroup(gp.createParallelGroup().addComponent(l3).addComponent(l4).addComponent(l5).addComponent(l6)
				.addComponent(l7));

		sq.addGroup(gp.createParallelGroup().addComponent(fn).addComponent(ln).addComponent(un).addComponent(pp2)
				.addComponent(pp3));

		

		f1.add(l3);
		f1.add(l4);
		f1.add(l5);
		f1.add(l6);
		f1.add(l7);
		f1.add(b3);
		f1.add(fn);
		f1.add(ln);
		f1.add(pp2);
		f1.add(pp3);
		f1.add(un);

		f1.setSize(600, 400);
		f1.setLayout(null);
		f1.setVisible(true);

	}

	public void validate(ActionEvent arg0) {

		Connection con = null;
		PreparedStatement pstmt = null;
		// ResultSet rs=null;

		String inqry = "insert into project1.registration values(?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt = con.prepareStatement(inqry);

			pstmt.setString(1, fn.getText());
			pstmt.setString(2, ln.getText());
			pstmt.setString(3, un.getText());
			pstmt.setString(4, pp2.getText());
			pstmt.setString(5, pp3.getText());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new SignupPage();
	}

}
