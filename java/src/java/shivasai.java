
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class shivasai {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;
	private JTextField tb3;
	private JTextField tb4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shivasai window = new shivasai();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public shivasai() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("student details");
		lblNewLabel.setBounds(154, 11, 124, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name ");
		lblNewLabel_1.setBounds(34, 65, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setBounds(34, 110, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("adderss");
		lblNewLabel_3.setBounds(34, 148, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("marks");
		lblNewLabel_4.setBounds(34, 190, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tb1 = new JTextField();
		tb1.setBounds(130, 62, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(130, 107, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		tb3 = new JTextField();
		tb3.setBounds(130, 145, 86, 20);
		frame.getContentPane().add(tb3);
		tb3.setColumns(10);
		
		tb4 = new JTextField();
		tb4.setBounds(130, 187, 86, 20);
		frame.getContentPane().add(tb4);
		tb4.setColumns(10);
		
		JButton btnNewButton = new JButton("enter ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tb1.getText();
				String id=tb2.getText();
				String address =tb3.getText();
				String marks=tb4.getText();
				int m=Integer.parseInt(marks);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mrec");
					String q="insert into student values('"+name+"','"+id+"','"+address+"','"+m+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton,"sucessful");
					
					}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
	
		});
		btnNewButton.setBounds(154, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
