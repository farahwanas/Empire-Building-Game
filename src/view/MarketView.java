package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import engine.City;

public class MarketView extends JPanel {
 private JPanel market;
 private City mycity;
 private JButton backtoeconomicalbuilding;
 private JButton upgradebutton;

 private JLabel info;
  public MarketView(City c) {
	  market=new JPanel();
	  market.setLayout(new BorderLayout());
	  market.setBackground(Color.white);
	  mycity=c;
	  backtoeconomicalbuilding=new JButton("Back to Economical Buildings");
	  upgradebutton=new JButton("Upgrade Market");
	  upgradebutton.setPreferredSize(new Dimension (200,200));
	 
	  market.add(backtoeconomicalbuilding,BorderLayout.PAGE_START);
	  market.add(upgradebutton,BorderLayout.EAST);
	 
	  market.setBackground(Color.white);
	  info=new JLabel();
	  
	  for (EconomicBuilding b:c.getEconomicalBuildings()) {
		  if (b instanceof Market) {
			  info.setText("level is " + b.getLevel()+ "\n" + " upgrade cost is " + b.getUpgradeCost());
		  }
	  }
	  market.add(info,BorderLayout.CENTER);
	  market.setVisible(true);
    }
  

public JPanel getMarket() {
	return market;
}
public void setMarket(JPanel Market) {
	this.market = market;
}
public City getMycity() {
	return mycity;
}
public void setMycity(City mycity) {
	this.mycity = mycity;
}
public JButton getBacktoeconomicalbuilding() {
	return backtoeconomicalbuilding;
}
public void setBacktoeconomicalbuilding(JButton backtoeconomicalbuilding) {
	this.backtoeconomicalbuilding = backtoeconomicalbuilding;
}
public JButton getUpgradebutton() {
	return upgradebutton;
}
public void setUpgradebutton(JButton upgradebutton) {
	this.upgradebutton = upgradebutton;
}

public JLabel getInfo() {
	return info;
}
public void setInfo(JLabel info) {
	this.info = info;
}

}
