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
import buildings.Stable;
import engine.City;

public class StableView extends JPanel{
	
		private JPanel stable;
		 private City mycity;
		 private JButton backtomilitarybuilding;
		 private JButton upgradebutton;
		 private JButton recruitbutton;
		 private JLabel info;
		 public StableView(City c) {
		    	stable=new JPanel();
		    	 stable.setLayout(new BorderLayout());
				 stable.setBackground(Color.white);
				 mycity=c;
		    	
		    	
		    	backtomilitarybuilding=new JButton("Back to Military Buildings");
				  upgradebutton=new JButton("Upgrade Stable");
				  upgradebutton.setPreferredSize(new Dimension (200,200));
				  recruitbutton= new JButton("Recruit Cavalry");
				  recruitbutton.setPreferredSize(new Dimension (200,200));
				  
				stable.add(backtomilitarybuilding,BorderLayout.PAGE_START);
				  stable.add(upgradebutton,BorderLayout.EAST);
				  stable.add(recruitbutton,BorderLayout.WEST);
				  stable.setBackground(Color.white);
				  info=new JLabel();
				  
				  for (MilitaryBuilding b:c.getMilitaryBuildings()) {
					  if (b instanceof Stable) {
						  info.setText("level is " + b.getLevel()+ "\n" + " upgrade cost is " + b.getUpgradeCost() + "\n"+" recruitment cost is" + b.getRecruitmentCost());
					  }
					  stable.add(info,BorderLayout.CENTER);
					  stable.setVisible(true);
				  }
		    	
		    	
		    }
		 
		 
	
    public JButton getBacktomilitarybuilding() {
			return backtomilitarybuilding;
		}



		public void setBacktomilitarybuilding(JButton backtomilitarybuilding) {
			this.backtomilitarybuilding = backtomilitarybuilding;
		}



	public JPanel getStable() {
			return stable;
		}




		public void setStable(JPanel stable) {
			this.stable = stable;
		}




		public City getMycity() {
			return mycity;
		}




		public void setMycity(City mycity) {
			this.mycity = mycity;
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