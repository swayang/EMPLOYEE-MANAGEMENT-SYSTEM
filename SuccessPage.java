package org.oecm19.task;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SuccessPage extends JFrame
{
	JFrame f;
	static JLabel jl;
	JButton jb1,jb2,jb3,jb4;
	static JTextField jt;

	public SuccessPage()
	{
		f = new JFrame("GET EMPLOYEE ID");
		jl=new JLabel("EMPLOYEE_ID");
		jl.setBounds(50, 80, 120, 30);
		jt=new JTextField();
		jt.setBounds(140,80,120,30);
		
		jb1=new JButton("RESULT");
		jb1.setBackground(Color.MAGENTA);
		jb1.setBounds(90,150,90,30);
		
		jb1.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ShowEmployeeDetails sd=new ShowEmployeeDetails();
				sd.setVisible(true);
				sd.dispose();
			}
		});
		

		jb2=new JButton("BACK");
		jb2.setBackground(Color.GREEN);
		jb2.setBounds(220, 150, 90, 30);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				back(e);
				
			}
		});
		
		
		jb3=new JButton("DELETE");
		jb3.setBackground(Color.blue);
		jb3.setBounds(330, 150, 90, 30);
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteprogram(e);
			}
		});
		
		
		jb4=new JButton("EDIT");
		jb4.setBackground(Color.red);
		jb4.setBounds(440, 150, 90, 30);
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				editbutton(e);
			}
		});
		f.add(jl);
		f.add(jb1);
		f.add(jb2);
		f.add(jb3);
		f.add(jb4);
	
		f.add(jt);
		f.setSize(600, 400);
		f.setLayout(null);
		f.setVisible(true);
		

	}

	protected void editbutton(ActionEvent e) 
	{
		
		ShowEmployeeDetails sd=new ShowEmployeeDetails();
		sd.setVisible(true);
		this.dispose();
	}

	protected void deleteprogram(ActionEvent e)
	{
		DltEmployeedtls dt=new DltEmployeedtls();
		dt.setVisible(true);
		this.dispose();
	}

	protected void back(ActionEvent e)
	{
		AdminLogin ad=new AdminLogin();
		ad.setVisible(true);
		this.dispose();
	}

	public static void main(String[] args) {

		new SuccessPage();
	}

}
