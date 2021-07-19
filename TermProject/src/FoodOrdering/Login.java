 package FoodOrdering;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import FoodOrdering.CategoriesOfFood.Chinese;


public class Login {
        
	int k = 0;
	
	      public Login(int n) {
//	    	  isLoggedIn(k);
	      }
          	
	JFrame frame;
         public Login(HashMap<String,Integer> cartItems) {
        	 
 			frame = new JFrame("Log In");
 			frame.setSize(500, 350);
 			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 			JPanel panel = new JPanel();		
 			panel.setBounds(200,0,340,350);
 			panel.setBackground(Color.WHITE);
 			loginpanel1(panel,cartItems);
 			
 			
// 			JLayeredPane container = new JLayeredPane();
// 			container.setBounds(0,0,140,300);
 			
 			
 			JPanel panel1 = new JPanel();
 			panel1.setBounds(0,0,140,300);
 			panel1.setBackground(Color.decode("#8ad7c1"));
 			 
 			
 			JLabel icon  = new JLabel();
 			ImageIcon img = new ImageIcon("src/FoodOrdering/user-7.png");
 			icon.setIcon(img);
             icon.setBounds(45,40,120,120);
             frame.add(icon);
             
             JLabel title  = new JLabel("Log In");
             title.setForeground(Color.WHITE);
             title.setBounds(58,150,150,40);
             title.setFont(new Font("ARIAL", Font.PLAIN, 30));
             frame.add(title);
             
 			
 			frame.add(panel);
 			frame.add(panel1);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false); 
 			frame.setVisible(true);
 			frame.setLayout(null);
 			
         }
        
     	public void loginpanel1(JPanel panel,HashMap<String,Integer> cartItems) { 

    		panel.setLayout(null);
//    		setBounds(180,30,220,300);
    	    panel.setVisible(true);
    				

    		JLabel userLabel = new JLabel("Username");
    		userLabel.setBounds(20, 100, 80, 25);
    		panel.add(userLabel);

    		JTextField userText = new JTextField(20);
    		userText.setBounds(110, 100, 160, 25);
    	    panel.add(userText);

    		JLabel passwordLabel = new JLabel("Password");
    		passwordLabel.setBounds(20, 140, 80, 25);
    		panel.add(passwordLabel);

    		JPasswordField passwordText = new JPasswordField(20);
    		passwordText.setBounds(110, 140, 160, 25);
    		panel.add(passwordText);
      
          
    		JButton loginButton = new JButton("Login");
    		loginButton.setBounds(200, 210, 80, 25);
    		panel.add(loginButton);
    		
    
    		loginButton.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				
					String username = new String(userText.getText());
					String password = new String(passwordText.getPassword());
					
    				
                      if(username.isEmpty() || password.isEmpty()){
                    	  
                    	  JOptionPane.showMessageDialog(frame,"Please fill all the fields" , "Incomplete Form",JOptionPane.WARNING_MESSAGE);
                    	  
                      }
                      
                      else {
                    	  
                    	  try {
							XMLDecoder x = new XMLDecoder(new BufferedInputStream(new FileInputStream("dataofuser.xml")));
							
							userlistascollege l = (userlistascollege)x.readObject();
							
							List<User> u = l.getList();
							
//							int k = 0;
					
							for(User value : u) {
								if(value.getUsername().equals(username) && value.getPassword().equals(password)) {
									
									JOptionPane.showMessageDialog(frame,"Login Successful" , "LoggedIn",JOptionPane.WARNING_MESSAGE);
									k = 1;
									new Chinese(cartItems);
									frame.dispose();
								}
							}
							if(k == 0) {
								JOptionPane.showMessageDialog(frame,"User Not Found" , "Invalid User",JOptionPane.WARNING_MESSAGE);
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    	  
                    	  
                      }
    				
    				
    			}
    		
           });
    	
    	}
     	
     	boolean isLoggedIn() {
     		if(k == 0) {
     			return false;
     		}
     		return true;
     	}
	
}
