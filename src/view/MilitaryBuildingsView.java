package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import units.Cavalry;

public class MilitaryBuildingsView extends JPanel {
	  private JPanel military;
	  private JButton backtocity;
	 private City mycity;
	 private JButton archeryrangebutton;
	 private JButton barracksbutton;
	 private JButton stablebutton;
	 
	 
	 public MilitaryBuildingsView(City c ) {
		 military=new JPanel();
		  mycity=c;
		  military.setLayout(new FlowLayout());
		  backtocity=new JButton("Back to City View");
		  military.add(backtocity);
		  military.setBackground(Color.white);
		  
		  
		  for(MilitaryBuilding m: mycity.getMilitaryBuildings() ) {
			  if (m instanceof ArcheryRange) {
				  archeryrangebutton=new JButton("ArcheryRange");
				  military.add(archeryrangebutton);
				  
			  }
			  else 
				  if(m instanceof Barracks) {
					  barracksbutton=new JButton("Barracks");
					  military.add(barracksbutton);
				  }
				 
			  
			  else 
				  if(m instanceof Stable) {
					 stablebutton=new JButton("Stable");
					  military.add(stablebutton);
			  }
		  }
		  }
	 
	 
	 public JButton getArcheryrangebutton() {
		return archeryrangebutton;
	}


	public void setArcheryrangebutton(JButton archeryrangebutton) {
		this.archeryrangebutton = archeryrangebutton;
	}


	public JButton getBarracksbutton() {
		return barracksbutton;
	}


	public void setBarracksbutton(JButton barracksbutton) {
		this.barracksbutton = barracksbutton;
	}


	public JButton getStablebutton() {
		return stablebutton;
	}


	public void setStablebutton(JButton stablebutton) {
		this.stablebutton = stablebutton;
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


		public JPanel getMilitary() {
			return military;
		}


		public void setMilitary(JPanel military) {
			this.military = military;
		}
		

	 }

			  
		  


