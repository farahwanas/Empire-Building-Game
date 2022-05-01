package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Unit;

public class ArmyView extends JPanel{
	private JPanel ArmyView;
	private ArrayList<JButton> unitsbuttonlist;
	//method.indexof
    
	private ArrayList<JButton> armyunitsbuttonslist;
  public ArmyView(Army a) {
	  ArmyView= new JPanel();
	  ArmyView.setLayout(new GridLayout(4,0));
	  int i=0;
	  int j=0;
	  int k=0;
	  for (Unit x : a.getUnits()) {
		  if(x instanceof Archer) {
			  JButton b=new JButton("Archer" + i + " Level: " + x.getLevel() + " CSC:" + x.getCurrentSoldierCount() );
			  ArmyView.add(b);
			  armyunitsbuttonslist.add(b);
			  i++;
			  //create two array of jbuttons 
			  //{ jb1,jb2,jb3}
			  
		  }
		  else if(x instanceof Cavalry) {
			  JButton b=new JButton("Cavalry" + j + " Level: " + x.getLevel() + " CSC:" + x.getCurrentSoldierCount() );
			  ArmyView.add(b);
			  armyunitsbuttonslist.add(b);
					  j++;
		  }
		  else if(x instanceof Infantry) {
			  JButton b=new JButton("Infantry" + k + " Level: " + x.getLevel() + " CSC:" + x.getCurrentSoldierCount() );
			  ArmyView.add(b);
			  armyunitsbuttonslist.add(b);
					  k++;
		  }
	  }
	  ArmyView.setVisible(true);
  }
public JPanel getArmyView() {
	return ArmyView;
}
public void setArmyView(JPanel armyView) {
	ArmyView = armyView;
}
public ArrayList<JButton> getArmyunitsbuttonslist() {
	return armyunitsbuttonslist;
}
public void setArmyunitsbuttonslist(ArrayList<JButton> armyunitsbuttonslist) {
	this.armyunitsbuttonslist = armyunitsbuttonslist;
}
  
  
}


