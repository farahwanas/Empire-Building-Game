package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondWindow extends JFrame {
	
	JLabel label= new JLabel("hELLO");
	SecondWindow(){
		label.setBounds(0,0,100,50);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420,420);
		this.setVisible(true);
		this.add(label);
		
	}
	public static void main(String[] args) {

     	SecondWindow w1 = new SecondWindow();
     	w1.setVisible(true);

     	SecondWindow w2 = new SecondWindow();
     	w2.setVisible(true);











         }
	
}


