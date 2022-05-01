package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.City;

public class CityView extends JPanel{

	private JPanel city;
private JButton militarybuildings;
private JButton economicalbuildings;
private JButton armies;
//private JComboBox upgradelist;
private JButton backtoworldmap;
private City mycity;
private JButton endturn;
private JTextField text;
//private JButton initiateArmy;
private JButton build;
public CityView(City c) {
	city=new JPanel();
	city.setVisible(true);
	city.setPreferredSize(new Dimension(1000,1000));
	this.mycity =c;
	city.setBackground(Color.white);
	militarybuildings=new JButton("Military Buildings");
	economicalbuildings=new JButton("Economical Buildings");
	armies=new JButton("City Defending Army");
	city.add(militarybuildings);
	city.add(economicalbuildings);
	city.add(armies);
	//initiateArmy=new JButton("Initiate Army");
   //city.add(initiateArmy);
	
	 backtoworldmap=new JButton("Back to World Map");
 build=new JButton("Build");
 city.add(build);
 city.add(backtoworldmap);
 //endturn=new JButton("End Turn");
 //city.add(endturn);
	text=new JTextField();
	city.add(text);
}



/*public JButton getInitiateArmy() {
	return initiateArmy;
}*/



/*public void setInitiateArmy(JButton initiateArmy) {
	this.initiateArmy = initiateArmy;
}*/



public City getMycity() {
	return mycity;
}



public void setMycity(City mycity) {
	this.mycity = mycity;
}




public JButton getBacktoworldmap() {
	return backtoworldmap;
}
public void setBacktoworldmap(JButton backtoworldmap) {
	this.backtoworldmap = backtoworldmap;
}
public JButton getBuild() {
	return build;
}
public void setBuild(JButton build) {
	this.build = build;
}
public JPanel getCity() {
	return city;
}
public void setCity(JPanel city) {
	this.city = city;
}
public JButton getMilitarybuildings() {
	return militarybuildings;
}
public void setMilitarybuildings(JButton militarybuildings) {
	this.militarybuildings = militarybuildings;
}
public JButton getEconomicalbuildings() {
	return economicalbuildings;
}
public void setEconomicalbuildings(JButton economicalbuildings) {
	this.economicalbuildings = economicalbuildings;
}
public JButton getArmies() {
	return armies;
}
public void setArmies(JButton armies) {
	this.armies = armies;
}
}
