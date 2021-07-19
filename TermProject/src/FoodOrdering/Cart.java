package FoodOrdering;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Cart  {
	
	JFrame frame;
		
	public Cart(HashMap<String,Integer> cartItem ) {

		    frame = new JFrame("Cart");
			frame.setSize(500, 350);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();		
			panel.setBounds(200,0,340,350);
			panel.setBackground(Color.WHITE);
			try {
				cartpanel1(panel,cartItem);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("double catched");
				e.printStackTrace();
			}
			
			
//			JLayeredPane container = new JLayeredPane();
//			container.setBounds(0,0,140,300);
			
			
			JPanel panel1 = new JPanel();
			panel1.setBounds(0,0,140,300);
			panel1.setBackground(Color.decode("#8ad7c1"));
			 
			
		 JLabel icon  = new JLabel();
	     ImageIcon img = new ImageIcon("src/FoodOrdering/shopping-cart.png");
		 icon.setIcon(img);
	     icon.setBounds(45,40,120,120);
	     frame.add(icon);
	     
	     JLabel title  = new JLabel("Your Cart");
	     title.setForeground(Color.WHITE);
	     title.setBounds(47,152,150,40);
	     title.setFont(new Font("ARIAL", Font.PLAIN, 30));
	     frame.add(title);
	     
			
			frame.add(panel);
			frame.add(panel1);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);
			frame.setVisible(true);
			frame.setLayout(null);
	}
   	public void cartpanel1(JPanel panel,HashMap<String,Integer> cartItem ) { 

		panel.setLayout(null);
	    panel.setVisible(true);
	  
	    if(cartItem.isEmpty()) {
	        try {
				JLabel l = new JLabel("Your Cart is Empty");
				l.setBounds(80,155,200,20);
				panel.add(l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("triple catched");
				e.printStackTrace();
			}
	    }
	    else {
	    	try {
				JLabel l = new JLabel("Your Orders");
				l.setBounds(90,5,200,40);
				panel.add(l);
				l.setFont(new Font("Arial", Font.BOLD, 19));
				JLabel l1 = new JLabel("Items");
				JLabel l2 = new JLabel("Price");
				l1.setBounds(15,80,100,20);
				l2.setBounds(215,80,50,20);
				panel.add(l1);
				l1.setFont(new Font("Arial", Font.BOLD, 18));
				panel.add(l2);
				l2.setFont(new Font("Arial", Font.BOLD, 18));
				
				int j = 1;
				int k = 120;
				int sum = 0;
				for(String i : cartItem.keySet()) {
					JLabel itemoutput = new JLabel(i );
					panel.add(itemoutput);
					itemoutput.setBounds(15,k,190,20);
					itemoutput.setFont(new Font("Arial", Font.BOLD, 18));
					JLabel priceoutput = new JLabel("₹ "+cartItem.get(i));
					panel.add(priceoutput);
					priceoutput.setFont(new Font("Arial", Font.BOLD, 18));
					priceoutput.setBounds(215,k,50,20);
					k += 30;
					j++;
					sum += cartItem.get(i);
				}
				
				JLabel total = new JLabel("Total Price");
				panel.add(total);
				total.setBounds(15,k,190,20);
				total.setFont(new Font("Arial", Font.BOLD, 18));
				
				JLabel totalPrice = new JLabel("₹ " + sum);
				panel.add(totalPrice);
				totalPrice.setBounds(215,k,190,20);
				totalPrice.setFont(new Font("Arial", Font.BOLD, 18));
				
				k += 60;
				
				JButton payment = new JButton("Pay Now");
				panel.add(payment);
				payment.setBounds(50,k,200,40);
				payment.setFont(new Font("Arial", Font.BOLD, 18));
				
				payment.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new paymentanddelivery();
						frame.dispose();
					}
				});
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("triple catched");
				e.printStackTrace();
			}
	    }
	    
   
	}
   	
//   	public void setData(String item , Integer qty,Integer price) {
//   		 
//   		Integer totalPrice = qty * price;
//   		
//   		if(cartItems.containsKey(item)) {
//   			if(totalPrice == 0) {
//   				cartItems.remove(item);
//   			}else {
//   				cartItems.replace(item, totalPrice);	
//   			}
//   			
//   			
//   		}
//   		else {
//   			if(totalPrice != 0) {
//   				cartItems.put(item, totalPrice);
//   			}
//   		}
//   			
//   	}
//   	public boolean cartLimit() {
//   		if(cartItems.size() <= 5) {
//   			return true;
//   		}
//   		else {
//   			return false;
//   		}
//   	}
	
		
}
