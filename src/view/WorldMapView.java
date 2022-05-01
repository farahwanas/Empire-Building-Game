package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WorldMapView extends JPanel{
    private JPanel worldpanel;
    private JButton idlearmies;
    private JPanel idleArmiesPanel;
    private JButton marchingarmies;
    private JButton beseigingarmies;
    private JButton cairo;
    private JButton rome;
    private JButton sparta;
   private JButton endturnbutton;
    public WorldMapView() {
    	worldpanel= new JPanel();
    	worldpanel.setPreferredSize(new Dimension(1000,1000));
		worldpanel.setLayout(null);
		worldpanel.setBackground(Color.white);
    	 cairo=new JButton("Cairo");
    	
    	cairo.setBounds(300,100, 200, 150);
    	worldpanel.add(cairo);
    	 sparta=new JButton("Sparta");
    	
    	//sparta.setPreferredSize(new Dimension(200,200));
    	sparta.setBounds(550,100, 200, 150);
    	worldpanel.add(sparta);
    	 rome=new JButton("Rome");
    	
    	rome.setPreferredSize(new Dimension(200,200));
    	worldpanel.add(rome);
    	rome.setBounds(800,100, 200, 150);
    	idlearmies =new JButton("Idle Armies");
    	idlearmies.setBounds(300,300, 200, 100);
    	//idleArmiesPanel=new JPanel();
    	//cairo.setPreferredSize(new Dimension(200,200));
    	marchingarmies=new JButton("Marching Armies");
    	marchingarmies.setBounds(550,300, 200, 100);
    	//cairo.setPreferredSize(new Dimension(200,200));
    	beseigingarmies=new JButton("Besieging Armies");
    	beseigingarmies.setBounds(800,300, 200, 100);    	
    	//cairo.setPreferredSize(new Dimension(200,200));
    	
        endturnbutton=new JButton("End Turn");
        endturnbutton.setBounds(1300, 50, 100, 50);  
    	worldpanel.add(endturnbutton);
		worldpanel.add(idlearmies);
		worldpanel.add(marchingarmies);
		worldpanel.add(beseigingarmies);
		
    	worldpanel.revalidate();
    	worldpanel.repaint();
    	
    }
    
    
	public JButton getEndturnbutton() {
		return endturnbutton;
	}


	public void setEndturnbutton(JButton endturnbutton) {
		this.endturnbutton = endturnbutton;
	}


	public JButton getCairo() {
		return cairo;
	}


	public void setCairo(JButton cairo) {
		this.cairo = cairo;
	}


	public JButton getRome() {
		return rome;
	}


	public void setRome(JButton rome) {
		this.rome = rome;
	}


	public JButton getSparta() {
		return sparta;
	}


	public void setSparta(JButton sparta) {
		this.sparta = sparta;
	}


	public JPanel getIdleArmiesPanel() {
		return idleArmiesPanel;
	}


	public JButton getIdlearmies() {
		return idlearmies;
	}
	public void setIdlearmies(JButton idlearmies) {
		this.idlearmies = idlearmies;
	}
	public JButton getMarchingarmies() {
		return marchingarmies;
	}
	public void setMarchingarmies(JButton marchingarmies) {
		this.marchingarmies = marchingarmies;
	}
	public JButton getBeseigingarmies() {
		return beseigingarmies;
	}
	public void setBeseigingarmies(JButton beseigingarmies) {
		this.beseigingarmies = beseigingarmies;
	}
	public JPanel getWorldpanel() {
		return worldpanel;
	}
	public void setWorldpanel(JPanel worldpanel) {
		this.worldpanel = worldpanel;
	}
    
}
