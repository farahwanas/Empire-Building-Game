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
import engine.City;

public class FarmView extends JPanel {
 private JPanel farm;
 private City mycity;
 private JButton backtoeconomicalbuilding;
 private JButton upgradebutton;

 private JLabel info;
  public FarmView(City c) {
	  farm=new JPanel();
	  farm.setLayout(new BorderLayout());
	  farm.setBackground(Color.white);
	  mycity=c;
	  backtoeconomicalbuilding=new JButton("Back to Economical Buildings");
	  upgradebutton=new JButton("Upgrade Farm");
	  upgradebutton.setPreferredSize(new Dimension (200,200));
	  
	  
	  farm.add(backtoeconomicalbuilding,BorderLayout.PAGE_START);
	  farm.add(upgradebutton,BorderLayout.EAST);
	 
	  farm.setBackground(Color.white);
	  info=new JLabel();
	  
	  for (EconomicBuilding b:c.getEconomicalBuildings()) {
		  if (b instanceof Farm) {
			  info.setText("level is " + b.getLevel()+ "\n" + " upgrade cost is " + b.getUpgradeCost());
		  }
	  }
	  farm.add(info,BorderLayout.CENTER);
	  farm.setVisible(true);
    }
public JPanel getFarm() {
	return farm;
}
public void setFarm(JPanel farm) {
	this.farm = farm;
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

}
