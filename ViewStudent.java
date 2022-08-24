package StudentManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewStudent extends JFrame implements ActionListener {
	JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	JButton btn, btn1;
	ViewStudent() {
		super("Student Information");
		lb5 = new JLabel("Enter Id:");
		lb5.setBounds(20, 20, 100, 20);
		tf5 = new JTextField(20);
		tf5.setBounds(130, 20, 150, 20);
		btn = new JButton("Search");
		btn.setBounds(300, 20, 80, 20);
		btn.addActionListener(this);
		lb = new JLabel("Fetching Student Information From Database");
		lb.setBounds(30, 80, 450, 30);
		lb.setForeground(Color.black);
		lb.setFont(new Font("Calibri", Font.BOLD, 20));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		lb1 = new JLabel("U_Name:");
		lb1.setBounds(20, 120, 100, 20);
		tf1 = new JTextField(50);
		tf1.setBounds(130, 120, 200, 20);
		lb2 = new JLabel("Entry_NO:");
		lb2.setBounds(20, 150, 100, 20);
		tf2 = new JTextField(100);
		tf2.setBounds(130, 150, 200, 20);
		lb3 = new JLabel("U_Email:");
		lb3.setBounds(20, 180, 100, 20);
		tf3 = new JTextField(50);
		tf3.setBounds(130, 180, 200, 20);
		lb4 = new JLabel("U_Contact:");
		lb4.setBounds(20, 210, 100, 20);
		tf4 = new JTextField(50);
		tf4.setBounds(130, 210, 200, 20);
		lb6 = new JLabel("U_HomeCity:");
		lb6.setBounds(20, 240, 200, 20);
		tf6 = new JTextField(50);
		tf6.setBounds(130, 240, 200, 20);
		setLayout(null);

		add(lb5);
		add(tf5);
		add(btn);
		add(lb);
		add(lb1);
		add(tf1);
		add(lb2);
		add(tf2);
		add(lb3);
		add(tf3);
		add(lb4);
		add(tf4);
		add(lb6);
		add(tf6);

		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf6.setEditable(false);
	}
	public void actionPerformed(ActionEvent e) {
		try {
			String str = tf5.getText();
			//class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/studentmanagementsystem", "root", "abc456");
			PreparedStatement st = con.prepareStatement("select * from student where entrynumber=?");
			st.setString(1, str);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String s = rs.getString(1);
				String s1 = rs.getString(2);
				String s2 = rs.getString(3);
				String s3 = rs.getString(4);
				String s4 = rs.getString(5);
				//Sets Records in TextFields.
				tf1.setText(s);
				tf2.setText(s1);
				tf3.setText(s2);
				tf4.setText(s3);
				tf6.setText(s4);
			} else {
				JOptionPane.showMessageDialog(null, "Name not Found");
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String args[]) {
		new ViewStudent();
	}
}