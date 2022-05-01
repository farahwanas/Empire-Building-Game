package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

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

public class IdleArmiesView extends JPanel {
private JPanel idlearmiesview;
    private JButton backtoworldmap;
    private JButton settargetcity;
    private ArrayList <JButton> abuts;
    private ArrayList <Unit> unitsofidle;
    private ArrayList<JButton> armys;
public IdleArmiesView(Game g) {
idlearmiesview=new JPanel();
//idlearmiesview.setPreferredSize(new Dimension (300,300));
//idlearmiesview.setBounds(r);
idlearmiesview.setLayout(new GridLayout(4,2));
idlearmiesview.setBackground(Color.white);
backtoworldmap=new JButton("Back to World Map");
idlearmiesview.add(backtoworldmap);
settargetcity=new JButton("Set Target City");
 idlearmiesview.add(settargetcity);
 int i=0;
 unitsofidle=new ArrayList<Unit>();
 abuts=new ArrayList <JButton>();
 for (Army a: g.getPlayer().getControlledArmies() ) {
 
 
 
 if (a.getCurrentStatus().equals(Status.IDLE)) {
 idlearmiesview.add(new JButton("Army" +i ));
 
 JTextField t1=new JTextField();
// String s="";
 int j=0;
 for (Unit u: a.getUnits()) {
 JButton t=new JButton("Unit"+j);
 
 
 idlearmiesview.add(t);
 if (u instanceof Archer)
 t1.setText( "Archer "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount());
 if (u instanceof Infantry)
 t1.setText( "Infantry "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount());
 if (u instanceof Cavalry)
 t1.setText( "Cavalry "  + " Level: " +u.getLevel() + " Current Soldier Count: "+ u.getCurrentSoldierCount());
 abuts.add(t);
 unitsofidle.add(u);
 idlearmiesview.add(t1);
 j++;
 }
 
i++;
 }
 }
 idlearmiesview.setVisible(true);
 idlearmiesview.revalidate();
 idlearmiesview.repaint();
 
}

public ArrayList<JButton> getAbuts() {
return abuts;
}



public void setAbuts(ArrayList<JButton> abuts) {
this.abuts = abuts;
}



public JButton getSettargetcity() {
return settargetcity;
}

public void setSettargetcity(JButton settargetcity) {
this.settargetcity = settargetcity;
}

public JPanel getIdlearmiesview() {
return idlearmiesview;
}

public void setIdlearmiesview(JPanel idlearmiesview) {
this.idlearmiesview = idlearmiesview;
}

public ArrayList<Unit> getUnitsofidle() {
	return unitsofidle;
}

public void setUnitsofidle(ArrayList<Unit> unitsofidle) {
	this.unitsofidle = unitsofidle;
}

public JButton getBacktoworldmap() {
return backtoworldmap;
}

public void setBacktoworldmap(JButton backtoworldmap) {
this.backtoworldmap = backtoworldmap;
}

}