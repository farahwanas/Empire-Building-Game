/*package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Unit;

public class BattleView extends JPanel{
	private JPanel battle;
	private JPanel attackersarmy;
	private ArrayList<JButton> attackerarmybuttons;
	private ArrayList<JButton> defenderarmybuttons;
	private JPanel defendersarmy;
	private JPanel log;
	private JButton attack;
	private Army theattacker;
	private Army thedefender;
	private JTextArea logg;
	
	public BattleView (Army attacker, Army defender) {
		
		battle= new JPanel();
		battle.setLayout(new GridLayout(4,1));
		attackersarmy=new JPanel();
		theattacker=attacker;
		thedefender=defender;
		//attackersarmy.setBounds(100, 100, 300, 300);
		attackersarmy.setLayout(new GridLayout (4,2));
		defendersarmy=new JPanel();
		attackerarmybuttons=new ArrayList<JButton>();
		defenderarmybuttons=new ArrayList<JButton>();
		attackersarmy.setLayout(new GridLayout (4,2));
		log=new JPanel();
		log.setLayout(new FlowLayout());
		//attackersarmy.setBounds(100, 700, 300, 300);
		attack=new JButton("Attack");
		logg=new JTextArea();
		int i=0;
		int j=0;
		String s="";
		for (Unit x: attacker.getUnits()) {
			//attackersarmy.add(new JButton("Unit"+ i));
			JButton b=new JButton("Attacker Unit");
			
			attackersarmy.add(b);
			attackerarmybuttons.add(b);
			i++;
			if (x instanceof Archer)
			attackersarmy.add(new JTextField("Archer" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));
		    if (x instanceof Infantry)
				attackersarmy.add(new JTextField("Infantry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));
			if (x instanceof Cavalry)
				attackersarmy.add(new JTextField("Cavalry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));
		}
		for (Unit x: defender.getUnits()) {
			//defendersarmy.add(new JButton("Unit"+ j));
			JButton b=new JButton("Defender Unit");
			defendersarmy.add(b);
			defenderarmybuttons.add(b);
			j++;
			if (x instanceof Archer)
			defendersarmy.add(new JTextField("Archer" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));
			if (x instanceof Infantry)
				defendersarmy.add(new JTextField("Infantry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));
			if (x instanceof Cavalry)
				defendersarmy.add(new JTextField("Cavalry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));
		}
		battle.add(attack);
		battle.add(attackersarmy);
		battle.add(defendersarmy);
		battle.add(log);
		log.setBackground(Color.red);
		log.add(logg);
	}
	
	public JTextArea getLogg() {
		return logg;
	}

	public void setLogg(JTextArea logg) {
		this.logg = logg;
	}

	public JPanel getBattle() {
		return battle;
	}
	public void setBattle(JPanel battle) {
		this.battle = battle;
	}
	public JPanel getAttackersarmy() {
		return attackersarmy;
	}
	public void setAttackersarmy(JPanel attackersarmy) {
		this.attackersarmy = attackersarmy;
	}
	public JPanel getDefendersarmy() {
		return defendersarmy;
	}
	public void setDefendersarmy(JPanel defendersarmy) {
		this.defendersarmy = defendersarmy;
	}
	public ArrayList<JButton> getAttackerarmybuttons() {
		return attackerarmybuttons;
	}
	public void setAttackerarmybuttons(ArrayList<JButton> attackerarmybuttons) {
		this.attackerarmybuttons = attackerarmybuttons;
	}
	public ArrayList<JButton> getDefenderarmybuttons() {
		return defenderarmybuttons;
	}
	public void setDefenderarmybuttons(ArrayList<JButton> defenderarmybuttons) {
		this.defenderarmybuttons = defenderarmybuttons;
	}
	public JPanel getLog() {
		return log;
	}
	public void setLog(JPanel log) {
		this.log = log;
	}
	public JButton getAttack() {
		return attack;
	}
	public void setAttack(JButton attack) {
		this.attack = attack;
	}
	public Army getTheattacker() {
		return theattacker;
	}
	public void setTheattacker(Army theattacker) {
		this.theattacker = theattacker;
	}
	public Army getThedefender() {
		return thedefender;
	}
	public void setThedefender(Army thedefender) {
		this.thedefender = thedefender;
		
	}

}*/
package view;


import java.awt.Color;

import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.util.ArrayList;


import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextArea;

import javax.swing.JTextField;


import units.Archer;

import units.Army;

import units.Cavalry;

import units.Infantry;

import units.Unit;


public class BattleView extends JPanel{

private JPanel battlev;

private JPanel attackersarmy;

private ArrayList<JButton> attackerarmybuttons;

private ArrayList<JButton> defenderarmybuttons;

private JPanel defendersarmy;

//private JPanel log;

private JButton attack;

private Army theattacker;

private Army thedefender;

//private JTextArea logg;

private JPanel resultdisplay;

private JLabel temp;

public BattleView (Army attacker, Army defender) {



resultdisplay=new JPanel();

temp=new JLabel();

temp.setText("initially?");

resultdisplay.setBackground(Color.white);

resultdisplay.setBounds(100,100,200,200);

//resultdisplay.setText("fi eeeeeeeh");

battlev= new JPanel();

battlev.setLayout(new GridLayout(4,1));

attackersarmy=new JPanel();

theattacker=attacker;

thedefender=defender;

//attackersarmy.setBounds(100, 100, 300, 300);

attackersarmy.setLayout(new GridLayout (4,2));

defendersarmy=new JPanel();

attackerarmybuttons=new ArrayList<JButton>();

defenderarmybuttons=new ArrayList<JButton>();

//attackersarmy.setLayout(new GridLayout (4,2));

// log=new JPanel();

// log.setLayout(new FlowLayout());

//attackersarmy.setBounds(100, 700, 300, 300);

attack=new JButton("Attack");

// logg=new JTextArea();

int i=0;

int j=0;

String s="";

for (Unit x: attacker.getUnits()) {

//attackersarmy.add(new JButton("Unit"+ i));

JButton b=new JButton("Attacker Unit");


attackersarmy.add(b);

attackerarmybuttons.add(b);

i++;

if (x instanceof Archer)

attackersarmy.add(new JTextField("Archer" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));

    if (x instanceof Infantry)

attackersarmy.add(new JTextField("Infantry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));

if (x instanceof Cavalry)

attackersarmy.add(new JTextField("Cavalry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));

}

for (Unit x: defender.getUnits()) {

//defendersarmy.add(new JButton("Unit"+ j));

JButton b=new JButton("Defender Unit");

defendersarmy.add(b);

defenderarmybuttons.add(b);

j++;

if (x instanceof Archer)

defendersarmy.add(new JTextField("Archer" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));

if (x instanceof Infantry)

defendersarmy.add(new JTextField("Infantry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));

if (x instanceof Cavalry)

defendersarmy.add(new JTextField("Cavalry" +" level: " + x.getLevel() + " currentsoldiercount= " + x.getCurrentSoldierCount()));

}

battlev.add(attack);

battlev.add(attackersarmy);

battlev.add(defendersarmy);

//battle.add(log);

// log.setBackground(Color.red);

//log.add(logg);

resultdisplay.add(temp);

battlev.add(resultdisplay);


// log.add(resultdisplay);

}






public JLabel getTemp() {

return temp;

}



public void setTemp(String s) {

temp.setText(s);

}






public JPanel getResultdisplay() {

return resultdisplay;

}



public void setResultdisplay(JPanel resultdisplay) {

this.resultdisplay = resultdisplay;

}




//public JTextArea getLogg() {

// return logg;

//}


//public void setLogg(JTextArea logg) {

// this.logg = logg;

//}




public JPanel getAttackersarmy() {

return attackersarmy;

}

public JPanel getBattlev() {
	return battlev;
}






public void setBattlev(JPanel battlev) {
	this.battlev = battlev;
}






public void setAttackersarmy(JPanel attackersarmy) {

this.attackersarmy = attackersarmy;

}

public JPanel getDefendersarmy() {

return defendersarmy;

}

public void setDefendersarmy(JPanel defendersarmy) {

this.defendersarmy = defendersarmy;

}

public ArrayList<JButton> getAttackerarmybuttons() {

return attackerarmybuttons;

}

public void setAttackerarmybuttons(ArrayList<JButton> attackerarmybuttons) {

this.attackerarmybuttons = attackerarmybuttons;

}

public ArrayList<JButton> getDefenderarmybuttons() {

return defenderarmybuttons;

}

public void setDefenderarmybuttons(ArrayList<JButton> defenderarmybuttons) {

this.defenderarmybuttons = defenderarmybuttons;

}

//public JPanel getLog() {

// return log;

//}

//public void setLog(JPanel log) {

// this.log = log;

//}

public JButton getAttack() {

return attack;

}

public void setAttack(JButton attack) {

this.attack = attack;

}

public Army getTheattacker() {

return theattacker;

}

public void setTheattacker(Army theattacker) {

this.theattacker = theattacker;

}

public Army getThedefender() {

return thedefender;

}

public void setThedefender(Army thedefender) {

this.thedefender = thedefender;


}


}


