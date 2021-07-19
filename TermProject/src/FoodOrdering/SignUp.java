 package FoodOrdering;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.List;



public class SignUp  {
	
 
	   public SignUp(HashMap<String,Integer> cartItems) {
			JFrame frame = new JFrame("Sign Up");
			frame.setSize(500, 350);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel1(panel,cartItems);
			panel.setBounds(200,0,340,350);
			panel.setBackground(Color.WHITE);
			
			
//			JLayeredPane container = new JLayeredPane();
//			container.setBounds(0,0,140,300);
			
			
			JPanel panel1 = new JPanel();
			panel1.setBounds(0,0,140,300);
			panel1.setBackground(Color.decode("#8ad7c1"));
			 
			
			JLabel icon  = new JLabel();
			ImageIcon img = new ImageIcon("src/FoodOrdering/user-2.png");
			icon.setIcon(img);
            icon.setBounds(45,40,120,120);
            frame.add(icon);
            
            JLabel title  = new JLabel("Sign Up");
            title.setForeground(Color.WHITE);
            title.setBounds(50,160,150,40);
            title.setFont(new Font("ARIAL", Font.PLAIN, 30));
            frame.add(title);
            
			
			frame.add(panel);
			frame.add(panel1);
			  
			frame.setVisible(true);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			
	   }
	   
		public void panel1(JPanel panel,HashMap<String,Integer> cartItems) {

			panel.setLayout(null);
//			setBounds(180,30,220,300);
		    panel.setVisible(true);
					 

			JLabel userLabel = new JLabel("User");
			userLabel.setBounds(20, 70, 80, 25);
			panel.add(userLabel);

			JTextField userText = new JTextField();
			userText.setBounds(110, 70, 160, 25);
		    panel.add(userText);

			JLabel passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(20, 110, 80, 25);
			panel.add(passwordLabel);

			JPasswordField passwordText = new JPasswordField();
			passwordText.setBounds(110, 110, 160, 25);
			panel.add(passwordText);
	  

			JLabel cnfrmpassword1 = new JLabel("Confirm");
			cnfrmpassword1.setBounds(20, 150, 120, 25);
			panel.add(cnfrmpassword1);

			JLabel cnfrmpassword2 = new JLabel("Password");
			cnfrmpassword2.setBounds(20, 165, 120, 25);
			panel.add(cnfrmpassword2);
			
			JPasswordField cnfrmpasswordText = new JPasswordField();
			cnfrmpasswordText.setBounds(110, 155, 160, 25);
			panel.add(cnfrmpasswordText);


			
			JButton registerButton = new JButton("Register");
			registerButton.setBounds(200, 210, 80, 25);
			panel.add(registerButton);
			
			
         	  
					String username = new String(userText.getText());
					String password = new String(passwordText.getPassword());
					String cnfrmpassword = new String(cnfrmpasswordText.getPassword());

			
			registerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String username = new String(userText.getText());
					String password = new String(passwordText.getPassword());
					String cnfrmpassword = new String(cnfrmpasswordText.getPassword());
					
					 if(username.isEmpty() || password.isEmpty() || cnfrmpassword.isEmpty()){
	               	  
	
	               	  JOptionPane.showMessageDialog(panel,"Please fill all the fields" , "Incomplete Form",JOptionPane.WARNING_MESSAGE);
	               	  
	                 }	
					 else {
						 User user = new User();
						 user.setUsername(username);
						 user.setPassword(password);
						 
						 List <User> l = new ArrayList<>();
						 
					     l.add(user);
					     
					     userlistascollege person = new userlistascollege();
					     
					     person.setList(l);
					    
					     
					    try {
					    	
							if(password.equals(cnfrmpassword)) {
								XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("dataofuser.xml")));
								
								x.writeObject(person);
								x.close();
								
								JOptionPane.showMessageDialog(panel,"You have successfully registerd to Zomato" , "Successfull Resgistration" , JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(panel,"Password didn't matched" , "Resgistration Failed" , JOptionPane.INFORMATION_MESSAGE);
							}
					    	
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
					          
							JOptionPane.showMessageDialog(panel," An error occured, try again " , " error " , JOptionPane.WARNING_MESSAGE);
							
							e1.printStackTrace();
						}
						 
					 }				
					
					
				}
			});
		
		}
	  


}
