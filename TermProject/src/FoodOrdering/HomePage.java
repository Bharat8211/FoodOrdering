  package FoodOrdering;


import FoodOrdering.CategoriesOfFood.Chinese;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomePage {
     public static void main(String[] args) {
    	 HashMap<String,Integer> cartItems = new HashMap<>();
    	 Home show = new Home(cartItems);
     }
}

class Division extends JPanel{
	
	JLabel text,description;
	JButton signup,login;
	Image image;
	
	Division(HashMap<String,Integer> cartItems){
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,1200,500);
		
		//LABELS
		
		text = new JLabel("zomato");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Impact", Font.ITALIC, 100));
		text.setBounds(455,70,500,200);
		layeredPane.add(text,Integer.valueOf(1));
		description = new JLabel("Discover the best foods & drinks");
        description.setForeground(Color.WHITE);
        description.setFont(new Font("Okra", Font.PLAIN, 40));
        description.setBounds(310,250,900,50);
		layeredPane.add(description);
		
		//BUTTON
		 
		signup = new JButton("Signup");
		login = new JButton("Login");
		
	    login.setBounds(1000,10,80,50);
		signup.setBounds(1100,10, 80, 50);
		add(login);
		add(signup);
		
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login(cartItems); 
			}
		});
		
		signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SignUp(cartItems);
				
				
			}
		});
		
		
		
		
        
		//IMAGE
		JLabel img = new JLabel();
		ImageIcon img1 = new ImageIcon("src/logo.png");
		img.setHorizontalTextPosition(JLabel.CENTER);
		img.setVerticalTextPosition(JLabel.CENTER);
		img.setIcon(img1);
		img.setBounds(0,0, 1200, 500);
		layeredPane.add(img,Integer.valueOf(0));
		
		//JPanel
		setSize(1200,500);
		setLayout(null);
		add(layeredPane);
	}
	
	
}


class Home extends JFrame{ 
	
	
	JFrame frame;
	
	JButton order;
	
	Home(HashMap<String,Integer> cartItems){
		
		frame  = new JFrame(); 


	    
		JPanel upperhalf = new Division(cartItems) ;
		upperhalf.setBounds(0,0,1200,500);
		add(upperhalf);
		

		order = new JButton("Order Now");
		order.setBounds(400,600, 400, 40);
		order.setForeground(Color.RED);
		order.setBackground(Color.green);
	    add(order);
		
	    order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame,"Please Login,to continue to Zomato" , "Please Login",JOptionPane.INFORMATION_MESSAGE);	
			
				
			}
		});
		
		setTitle("Home");
		setLayout(null);
		
		setVisible(true);
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}