package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;
import units.Archer;
import units.Cavalry;
import units.Infantry;
import units.Unit;
import buildings.EconomicBuilding;
import engine.City;

public class DefendingArmyView extends JPanel{
	private JPanel defendingArmy;
	private JButton backtocity;
	private JButton initiateArmy;
	private City mycity;
	private JButton lastonepressed;
	private ArrayList<JButton> buttonslist;
	private ArrayList<Unit> unitbuttonslist;
	private JButton endturn;
	//private JButton relocatefromdefending;
	
	
	public DefendingArmyView(City c ) {
		defendingArmy=new JPanel();
		  mycity=c;
		  defendingArmy.setLayout(new GridLayout(4,1));
		  backtocity=new JButton("Back to City View");
		  defendingArmy.add(backtocity);
		  defendingArmy.setBackground(Color.white);
		  buttonslist=new ArrayList<JButton>();
		  initiateArmy=new JButton("Initiate Army");
		  lastonepressed=new JButton("lastonepressed");
		  defendingArmy.add(initiateArmy);
		  endturn=new JButton("End Turn");
		  defendingArmy.add(endturn);
		  unitbuttonslist=new ArrayList<Unit>();
		  //relocatefromdefending= new JButton ("Relocate Unit");
		 // defendingArmy.add(relocatefromdefending);
		  
		  
		  int i=0;
	      int j=0;
	      int k=0;
		  for ( Unit x : mycity.getDefendingArmy().getUnits()) {
			  unitbuttonslist.add(x);
			  if(x instanceof Archer) {
				  JButton b=new JButton("Unit" + i);
				  JTextField t=new JTextField("Type: Archer  Level: "+ x.getLevel()+ "Current Soldier Count: "+ x.getCurrentSoldierCount());
				  defendingArmy.add(b);
				  defendingArmy.add(t);
				  buttonslist.add(b);
				 
				  i++;
				  //create two array of jbuttons 
				  //{ jb1,jb2,jb3}
				  
			  }
			  else if(x instanceof Cavalry) {
				  JButton b=new JButton("Unit" + i);
				  JTextField t=new JTextField("Type:Cavalry Level: "+ x.getLevel()+ "Current Soldier Count: "+ x.getCurrentSoldierCount());
				  defendingArmy.add(b);
				  defendingArmy.add(t);
						  buttonslist.add(b);
						  i++;
			  }
			  else if(x instanceof Infantry) {
				  JButton b=new JButton("Unit" + i );
				  JTextField t=new JTextField("Type :Infantry Level: "+ x.getLevel()+ "Current Soldier Count: "+ x.getCurrentSoldierCount());
				  defendingArmy.add(b);
				  defendingArmy.add(t);
						  buttonslist.add(b);
						  i++;
			  }
	
		  }
		  
		  
			  
		 }

	public JPanel getDefendingArmy() {
		return defendingArmy;
	}

	public void setDefendingArmy(JPanel defendingArmy) {
		this.defendingArmy = defendingArmy;
	}

	public JButton getBacktocity() {
		return backtocity;
	}

	public JButton getLastonepressed() {
		return lastonepressed;
	}

	public void setLastonepressed(JButton lastonepressed) {
		this.lastonepressed = lastonepressed;
	}

	public ArrayList<JButton> getButtonslist() {
		return buttonslist;
	}

	public void setButtonslist(ArrayList<JButton> buttonslist) {
		this.buttonslist = buttonslist;
	}

	public void setBacktocity(JButton backtocity) {
		this.backtocity = backtocity;
	}

	public City getMycity() {
		return mycity;
	}

	

	

	public ArrayList<Unit> getUnitbuttonslist() {
		return unitbuttonslist;
	}

	public void setUnitbuttonslist(ArrayList<Unit> unitbuttonslist) {
		this.unitbuttonslist = unitbuttonslist;
	}

	public void setMycity(City mycity) {
		this.mycity = mycity;
	}

	public JButton getInitiateArmy() {
		return initiateArmy;
	}

	public void setInitiateArmy(JButton initiateArmy) {
		this.initiateArmy = initiateArmy;
	}
	
	

}