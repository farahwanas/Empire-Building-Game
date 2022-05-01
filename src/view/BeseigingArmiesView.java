package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buildings.ArcheryRange;
import buildings.MilitaryBuilding;
import engine.City;
import engine.Game;
import engine.Player;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class BeseigingArmiesView extends JPanel {
	private JPanel beseigingarmiesview;
	 private JButton backtoworldmap;
	public BeseigingArmiesView(Game g) {
		beseigingarmiesview=new JPanel();
		  
		beseigingarmiesview.setLayout(new GridLayout(4,1));
		beseigingarmiesview.setBackground(Color.white);
		backtoworldmap=new JButton("Back to World Map");
		 beseigingarmiesview.add(backtoworldmap);
		  int i=0;
		  for (Army a: g.getPlayer().getControlledArmies() ) {
			  if (a.getCurrentStatus().equals(Status.BESIEGING)) {
				  beseigingarmiesview.add(new JButton("Army" +i ));
						  JTextField t=new JTextField();
						  String s="City undersiege: "+ a.getCurrentLocation();
						  for (City c: g.getAvailableCities()) {
							  if (c.getName().equals(a.getCurrentLocation())) {
								  s+= " for " +c.getTurnsUnderSiege()+ " turns";
							  }
						  }
						  for (Unit u: a.getUnits()) {
							  if (u instanceof Archer) 
								  s+= "Archer "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount() ;
							  if (u instanceof Infantry) 
								  s+= "Infantry "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount();
							  if (u instanceof Cavalry) 
								  s+= "Cavalry "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount();
								  
							  
						  }
					  
					 t.setText(s);
					 beseigingarmiesview.add(t);
				  i++;
			  }
		  }
		  
		  beseigingarmiesview.setVisible(true);
		  
		 	}
	public JPanel getBeseigingarmiesview() {
		return beseigingarmiesview;
	}
	public void setBeseigingarmiesview(JPanel beseigingarmiesview) {
		this.beseigingarmiesview = beseigingarmiesview;
	}
	public JButton getBacktoworldmap() {
		return backtoworldmap;
	}
	public void setBacktoworldmap(JButton backtoworldmap) {
		this.backtoworldmap = backtoworldmap;
	}


}
