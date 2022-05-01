package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buildings.ArcheryRange;
import buildings.EconomicBuilding;
import buildings.Market;
import buildings.MilitaryBuilding;
import engine.City;

public class ArcheryRangeView extends JPanel{
	private JPanel archeryrange;
	 private City mycity;
	 private JButton backtomilitarybuilding;
	 private JButton upgradebutton;
	 private JButton recruitbutton;
	 private JLabel info;
	 public ArcheryRangeView(City c) {
		  archeryrange=new JPanel();
		  
		  archeryrange.setLayout(new BorderLayout());
		  archeryrange.setBackground(Color.white);
		  mycity=c;
		  backtomilitarybuilding=new JButton("Back to Military Buildings");
		  upgradebutton=new JButton("Upgrade ArcheryRange");
		  upgradebutton.setPreferredSize(new Dimension (200,200));
		  recruitbutton= new JButton("Recruit Archer");
		  recruitbutton.setPreferredSize(new Dimension (200,200));
		  archeryrange.add(backtomilitarybuilding,BorderLayout.PAGE_START);
		  archeryrange.add(upgradebutton,BorderLayout.EAST);
		  archeryrange.add(recruitbutton,BorderLayout.WEST);
		  archeryrange.setBackground(Color.white);
		  info=new JLabel();
		  
		  for (MilitaryBuilding b:c.getMilitaryBuildings()) {
			  if (b instanceof ArcheryRange) {
				  info.setText("level is " + b.getLevel()+ "\n" + " upgrade cost is " + b.getUpgradeCost() + "\n"+" recruitment cost is" + b.getRecruitmentCost());
			  }
		  }
		  archeryrange.add(info,BorderLayout.CENTER);
		  archeryrange.setVisible(true);
	    }
	public JPanel getArcheryrange() {
		return archeryrange;
	}
	public void setArcheryrange(JPanel archeryrange) {
		this.archeryrange = archeryrange;
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
