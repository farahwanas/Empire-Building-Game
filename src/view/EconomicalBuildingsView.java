package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import engine.City;

public class EconomicalBuildingsView extends JPanel{
	  private JPanel economical;
	  private JButton backtocity;
	 private City mycity;
	 private JButton farmbutton;
	 private JButton marketbutton;
	 
  public EconomicalBuildingsView (City c) {
	  economical=new JPanel();
	  mycity=c;
	  economical.setLayout(new FlowLayout());
	  backtocity=new JButton("Back to City View");
	  economical.add(backtocity);
	  economical.setBackground(Color.white);

    for (EconomicBuilding b : mycity.getEconomicalBuildings()) {
			
		   if (b instanceof Farm ) {
			  farmbutton= new JButton("Farm");
			economical.add(farmbutton);
		   
		   
		   }
		   if (b instanceof Market) {
			   marketbutton=new JButton("Market");
			   economical.add(marketbutton);
		   }
    }
	  economical.setVisible(true);
  }
  
public JButton getFarmbutton() {
	return farmbutton;
}

public void setFarmbutton(JButton farmbutton) {
	this.farmbutton = farmbutton;
}

public JButton getMarketbutton() {
	return marketbutton;
}

public void setMarketbutton(JButton marketbutton) {
	this.marketbutton = marketbutton;
}

public JButton getBacktocity() {
	return backtocity;
}

public void setBacktocity(JButton backtocity) {
	this.backtocity = backtocity;
}

public City getMycity() {
	return mycity;
}

public void setMycity(City mycity) {
	this.mycity = mycity;
}

public JPanel getEconomical() {
	return economical;
}
public void setEconomical(JPanel economical) {
	this.economical = economical;
}
}
