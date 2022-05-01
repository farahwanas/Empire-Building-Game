package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.EconomicBuilding;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;


public class BarracksView extends JPanel{

	private JPanel barracks;
	 private City mycity;
	 private JButton backtomilitarybuilding;
	 private JButton upgradebutton;
	 private JButton recruitbutton;
	 private JLabel info;
	 public BarracksView(City c) {
	    	barracks=new JPanel();
	    	 barracks.setLayout(new BorderLayout());
			 barracks.setBackground(Color.white);
			 mycity=c;
	    	
	    	
	    	
	    	backtomilitarybuilding=new JButton("Back to Military Buildings");
			  upgradebutton=new JButton("Upgrade Barracks");
			  upgradebutton.setPreferredSize(new Dimension (200,200));
			  recruitbutton= new JButton("Recruit Infantry");
			  recruitbutton.setPreferredSize(new Dimension (200,200));
			  
			barracks.add(backtomilitarybuilding,BorderLayout.PAGE_START);
			  barracks.add(upgradebutton,BorderLayout.EAST);
			  barracks.add(recruitbutton,BorderLayout.WEST);
			  barracks.setBackground(Color.white);
			  info=new JLabel();
			  
			  for (MilitaryBuilding b:c.getMilitaryBuildings()) {
				  if (b instanceof Barracks) {
					  info.setText("level is " + b.getLevel()+ "\n" + " upgrade cost is " + b.getUpgradeCost() + "\n"+" recruitment cost is" + b.getRecruitmentCost());
				  }
				  barracks.add(info,BorderLayout.CENTER);
				  barracks.setVisible(true);
			  }
	    	
	    	
	    }
	public JPanel getBarracks() {
		return barracks;
	}
	public void setBarracks(JPanel Barracks) {
		this.barracks = Barracks;
	}
	public City getMycity() {
		return mycity;
	}
	public void setMycity(City mycity) {
		this.mycity = mycity;
	}

	public JButton getBacktomilitarybuilding() {
		return backtomilitarybuilding;
	}
	public void setBacktomilitarybuilding(JButton backtomilitarybuilding) {
		this.backtomilitarybuilding = backtomilitarybuilding;
	}
	public JButton getUpgradebutton() {
		return upgradebutton;
	}
	public void setUpgradebutton(JButton upgradebutton) {
		this.upgradebutton = upgradebutton;
	}
	public JButton getRecruitbutton() {
		return recruitbutton;
	}
	public void setRecruitbutton(JButton recruitbutton) {
		this.recruitbutton = recruitbutton;
	}
	public JLabel getInfo() {
		return info;
	}
	public void setInfo(JLabel info) {
		this.info = info;
	}
	

	
	
	
	
}