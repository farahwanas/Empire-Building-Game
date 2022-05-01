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
import engine.Game;
import engine.Player;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class MarchingArmiesView extends JPanel {
	private JPanel marchingarmiesview;
	 private JButton backtoworldmap;
	public MarchingArmiesView(Game g) {
		marchingarmiesview=new JPanel();
		  
		marchingarmiesview.setLayout(new GridLayout(4,1));
		marchingarmiesview.setBackground(Color.white);
		backtoworldmap=new JButton("Back to World Map");
		 marchingarmiesview.add(backtoworldmap);
		 
		  int i=0;
		  for (Army a: g.getPlayer().getControlledArmies() ) {
			
			
				  if (a.getCurrentStatus().equals(Status.MARCHING)) {
					  marchingarmiesview.add(new JButton("Army" +i ));
					  
							  JTextField t=new JTextField();
							  String s="Target City :" + a.getTarget();
							  
							  for (Unit u: a.getUnits()) {
								  if (u instanceof Archer) 
									  s+= "Archer "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount()  ;
								  if (u instanceof Infantry) 
									  s+= "Infantry "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount();
								  if (u instanceof Cavalry) 
									  s+= "Cavalry "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount();
									  
								  
							  }
						  
						 t.setText(s);
						 marchingarmiesview.add(t);
					  i++;
				  }
		  
		  }
		  marchingarmiesview.setVisible(true);
		  
		 	}

	public JPanel getMarchingarmiesview() {
		return marchingarmiesview;
	}

	public void setMarchingarmiesview(JPanel marchingarmiesview) {
		this.marchingarmiesview = marchingarmiesview;
	}
	public JButton getBacktoworldmap() {
		return backtoworldmap;
	}

	public void setBacktoworldmap(JButton backtoworldmap) {
		this.backtoworldmap = backtoworldmap;
	}

}
