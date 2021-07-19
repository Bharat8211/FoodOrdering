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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import FoodOrdering.CategoriesOfFood.Chinese;

public class paymentanddelivery {
	
	JFrame frame;
	public paymentanddelivery() {
		frame = new JFrame("Cart");
		frame.setSize(500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();		
		panel.setBounds(200,0,340,350);
		panel.setBackground(Color.WHITE);
		loginpanel1(panel);
		
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0,0,140,300);
		panel1.setBackground(Color.decode("#8ad7c1"));
		 
		
	    JLabel icon  = new JLabel();
	    ImageIcon img = new ImageIcon("src/FoodOrdering/delivery.png");
	    icon.setIcon(img);
	    icon.setBounds(45,40,120,120);
	    frame.add(icon);
	 
	    JLabel title  = new JLabel("Payments ");
	    title.setForeground(Color.WHITE);
	    title.setBounds(47,152,150,40);
	    title.setFont(new Font("ARIAL", Font.PLAIN, 30));
	    frame.add(title);
	 
		
		frame.add(panel);
		frame.add(panel1);
		  
		frame.setVisible(true);
		frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
	}

	
   	public void loginpanel1(JPanel panel) { 

		panel.setLayout(null);
//		setBounds(180,30,220,300);
	    panel.setVisible(true);
				

		JLabel userLabel = new JLabel("Enter Delivery Adress");
		userLabel.setBounds(20, 20, 200, 25);
		userLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
		panel.add(userLabel);

		JTextField userText = new JTextField();
		userText.setBounds(20, 70, 250, 50);
		userText.setVisible(true);
	    panel.add(userText);

		JLabel passwordLabel = new JLabel("Payment Option");
		passwordLabel.setBounds(20, 140, 200, 25);
		passwordLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
		panel.add(passwordLabel);

        JCheckBox confirm = new JCheckBox("Cash On delivery");
        panel.add(confirm);
        confirm.setBounds(20,180,30,30);
  
		JLabel Label = new JLabel();
		Label.setBounds(50, 180, 200, 30);
		Label.setFont(new Font("ARIAL", Font.PLAIN, 15));
		panel.add(Label);

      
		JButton PaymentButton = new JButton("Pay");
		PaymentButton.setBounds(70, 230, 150, 40);
		PaymentButton.setFont(new Font("ARIAL", Font.PLAIN, 20));
		panel.add(PaymentButton);
		
		PaymentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stu
				
				String username = new String(userText.getText());
              if(confirm.isSelected() && !username.isEmpty()) {
            	     JOptionPane.showMessageDialog(frame, "Your order have been successfully placed", "Successful", JOptionPane.INFORMATION_MESSAGE);
            	     frame.dispose();
              }
				
			}
		});
		

			
	}
	
	
	
	
	
	
	
    
}
