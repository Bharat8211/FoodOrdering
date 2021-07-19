   package FoodOrdering.CategoriesOfFood;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import FoodOrdering.Cart;

public class Chinese extends JFrame{
  
	public HashMap<String,Integer> price ;
	public Vector<String> images = new Vector<>();
	 List<JCheckBox> box = new ArrayList<>();
	 List<JSpinner> spin = new ArrayList<>();
	 List<JRadioButton> radio = new ArrayList<>();
	 Vector<String> menulist = new Vector<>();
	 Vector<Integer> pricelist = new Vector<>();
	JFrame frame; 
	public Chinese(HashMap<String,Integer> cartItems){
		 frame = new JFrame() ;	  
	  	  
	       JPanel panel1 = new JPanel(); 
	  	   panel1.setBounds(0,0,300,800);
	  	   panel1.setBackground(Color.decode("#8ad7c1"));
	  	   
			JLabel menu = new JLabel("Menu");
			panel1.add(menu);
			menu.setFont(new Font("Arial", Font.BOLD, 40));
			menu.setBounds(15,10,200,60);
			menu.setForeground(Color.WHITE);
	  	   
	    	
			JLabel img = new JLabel();
			ImageIcon img1 = new ImageIcon("src/FoodOrdering/CategoriesOfFood/icon.png");
			img.setIcon(img1);
			img.setBounds(70,480,400,400);
			panel1.add(img);
			panel1.setLayout(null);
	      
			
			String arr[] = {"• Chinese", "• Italian" ,"• Indian","• Dessert","• Snacks","• Beverages" };
			
			int j = 80;
			
			for(int i = 0;i<6;i++) {
				JLabel food = new JLabel(arr[i]);
				panel1.add(food);
				food.setBounds(15,j,200,40);
				food.setFont(new Font("Arial", Font.BOLD, 20));
				j = j + 40 ;
			}
			
			int k = 80;
			ButtonGroup bg = new ButtonGroup();
			JRadioButton radiobtn1 = new JRadioButton();
			panel1.add(radiobtn1);
			radiobtn1.setBounds(150,k+5,25,25);
			bg.add(radiobtn1);
			radiobtn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Chinese(cartItems);
					frame.dispose();
				}
			});
			k += 40;
			JRadioButton radiobtn2 = new JRadioButton();
			panel1.add(radiobtn2);
			radiobtn2.setBounds(150,k+5,25,25);
			bg.add(radiobtn2);
			radiobtn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Italian(cartItems);
					frame.dispose();
				}
			});
			k += 40;
		
			JRadioButton radiobtn3 = new JRadioButton();
			panel1.add(radiobtn3);
			radiobtn3.setBounds(150,k+5,25,25);
			bg.add(radiobtn3);
			radiobtn3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Indian(cartItems);
					frame.dispose();
				}
			});
			k += 40;
			JRadioButton radiobtn4 = new JRadioButton();
			panel1.add(radiobtn4);
			radiobtn4.setBounds(150,k+5,25,25);
			bg.add(radiobtn4);
			radiobtn4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Desert(cartItems);
					frame.dispose();
				}
			});
			k += 40;
			JRadioButton radiobtn5 = new JRadioButton();
			panel1.add(radiobtn5);
			radiobtn5.setBounds(150,k+5,25,25);
			bg.add(radiobtn5);
			radiobtn5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Snacks(cartItems);
					frame.dispose();
				}
			});
			k += 40;
			JRadioButton radiobtn6 = new JRadioButton();
			panel1.add(radiobtn6);
			radiobtn6.setBounds(150,k+5,25,25);
			bg.add(radiobtn6);
			radiobtn6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Beverages(cartItems);
					frame.dispose();
				}
			});
			
			
			JLabel titleImage = new JLabel();
			ImageIcon img2 = new ImageIcon("src/FoodOrdering/CategoriesOfFood/insidemenu/menuchinese.png");
			titleImage.setIcon(img2);
			frame.add(titleImage);
			titleImage.setBounds(300,0,900,330);
			
			set();
			get(cartItems);
			
			JButton cart = new JButton("Cart");
			cart.setBounds(200,21,80,40);
			panel1.add(cart);
			
			cart.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Cart(cartItems);
				}
			});
			
			
			frame.setVisible(true);
			frame.setLayout(null);
			frame.setSize(1200,800);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(panel1);
	        frame.setLocationRelativeTo(null);
	}
	
	public void set() {
		price = new HashMap<>();
		price.put("Veg Chowmien", 50);
		price.put("Veg Manchurian", 100);
		price.put("Paneer Chilli", 70);
		price.put("Spring Rolls", 150);
		price.put("Hakka Noodles", 150);
		price.put("Schezwan Rice", 40);
		
		images.add("src/FoodOrdering/CategoriesOfFood/chinese/chillipaneer.jpg");
		images.add("src/FoodOrdering/CategoriesOfFood/chinese/chowmien.jpg");
		images.add("src/FoodOrdering/CategoriesOfFood/chinese/hakka.jpg");
		images.add("src/FoodOrdering/CategoriesOfFood/chinese/manchurian.jpg");
		images.add("src/FoodOrdering/CategoriesOfFood/chinese/rolls.jpg");
		images.add("src/FoodOrdering/CategoriesOfFood/chinese/rice.jpg");
		
		
	}
   public void get(HashMap<String,Integer> cartItems) {		
	   int j = 350;
	    int k = 0;
	    int l = 0;
//	
//	    JPanel pan = new JPanel();
//	    pan.setBounds(250,250,800,960);
//	    pan.setBackground(Color.BLACK);
//	    pan.setOpaque(true);
//	    pan.setLayout(null);
	    
//	    JLayeredPane container = new JLayeredPane();
//	    container.setBounds(300,0,1200,960);
//	    JScrollPane scrollpane;
	    
	    
		for(String i:price.keySet()) {
			//PANEL
			
			JPanel dishes = new JPanel();
			frame.add(dishes);
			dishes.setLayout(null);
			dishes.setBounds(350 ,j,800,150);
			dishes.setBackground(Color.WHITE);
//			dishes.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
			
			//IMAGE
			
		    JLabel img = new JLabel();  
		    ImageIcon img1 = new ImageIcon(images.get(k));
		    img.setIcon(img1);
		    dishes.add(img);
		    img.setBounds(0,0,150,150);
		    
		    //NAME AND PRICE
		     
		    JLabel name = new JLabel(i);
		    name.setBounds(160,20,300,30);
		    name.setFont(new Font("Okara", Font.BOLD, 20));
		    name.setForeground(Color.BLACK);
		    dishes.add(name);
		    menulist.add(i);
		    
		    JLabel cost = new JLabel("₹ "+price.get(i));
		    cost.setBounds(160,60,100,20);
		    cost.setForeground(Color.BLACK);
		    cost.setFont(new Font("Okara", Font.PLAIN, 15));
			dishes.add(cost);
			pricelist.add(price.get(i));
			
			j = j+ 160 ;
			k++;
			
		//JcheckBox
			
			JCheckBox select = new JCheckBox();
			select.setBounds(720,35,30,30);
			dishes.add(select);
			box.add(select);
			
			//JSpinner
			
		    int min = 0;
		    int max = 1;
		    int step = 1;
		    int n = 0;
			
		    SpinnerModel value = new SpinnerNumberModel(n, min, max, step);
			JSpinner spinner = new JSpinner();
			spinner.setBounds(650,30, 50, 40);
			dishes.add(spinner);
			spin.add(spinner);
			
			
		}
		
		   for(int i = 0;i<6;i++) {
			   int[] num = {i};
	            box.get(i).addItemListener(new ItemListener() {
					
	          
					@Override
					public void itemStateChanged(ItemEvent e) {
						try {
							// TODO Auto-generated method stub
							if (e.getStateChange() == 1) {
								 spin.get(num[0]).setValue(Integer.valueOf(1));
								 if(cartItems.size() <= 3) {
									 Integer spinnerValue = (Integer)spin.get(num[0]).getValue();
									 System.out.println(spinnerValue);
									 Integer totalPrice = pricelist.get(num[0]) * spinnerValue;
									 System.out.println(totalPrice);
									 cartItems.put(menulist.get(num[0]), totalPrice);
								 }
								 else {
									 JOptionPane.showMessageDialog(frame, "max capacity reached", "max limit reached", JOptionPane.INFORMATION_MESSAGE);
								 }
							}
							else {
								spin.get(num[0]).setValue(Integer.valueOf(0));
								if(cartItems.containsKey(menulist.get(num[0]))) {
							       cartItems.remove(menulist.get(num[0])) ;
								}	
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							System.out.println("I am Catched");
							e1.printStackTrace();
						}
			           
					   }
				
	            });
	        spin.get(i).addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					try {
						if(spin.get(num[0]).getValue() ==Integer.valueOf(0) ) {
							box.get(num[0]).setSelected(false);
							if(cartItems.containsKey(menulist.get(num[0]))) {
						           cartItems.remove(menulist.get(num[0])) ;
						   }	
						}
						if((Integer)spin.get(num[0]).getValue() >= 1 ) {
							box.get(num[0]).setSelected(true);
							 if(cartItems.size() <= 3) {
								 Integer spinnerValue = (Integer)spin.get(num[0]).getValue();
								 System.out.println(spinnerValue);
								 Integer totalPrice = pricelist.get(num[0]) * spinnerValue;
								 System.out.println(totalPrice);
								 cartItems.put(menulist.get(num[0]), totalPrice);
							 }
							 else {
								 JOptionPane.showMessageDialog(frame, "max capacity reached", "max limit reached", JOptionPane.INFORMATION_MESSAGE);
							 }
						}
						else {
							JOptionPane.showMessageDialog(frame, "You have entered invalid Qty ", "Invalid", JOptionPane.WARNING_MESSAGE);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						System.out.println("caught");
						e1.printStackTrace();
					}
				}
			});
	            
		   }
			
		
   }

	
}
