package contol;

import java.awt.BorderLayout;
import exceptions.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.standard.Fidelity;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import engine.Game;
import units.*;
import view.ArcheryRangeView;
import view.ArmyView;
import view.BarracksView;
import view.BattleView;
import view.BeseigingArmiesView;
import view.CityView;
import view.DefendingArmyView;
import view.EconomicalBuildingsView;
import view.FarmView;
import view.IdleArmiesView;
import view.MarchingArmiesView;
import view.MarketView;
import view.MilitaryBuildingsView;
import view.StableView;
import view.WorldMapView;

public class Controller extends JFrame implements ActionListener {
	private BattleView battleviewpanel;
	private JTextField idlearmiesinfo;
	private JFrame frame;
	private DefendingArmyView defendingArmy;
	private Game game;
	private WorldMapView world;
	private JLabel constants;
	private CityView cairoview;
	private CityView romeview;
	private CityView spartaview;
	private City city;
	private EconomicalBuildingsView eco;
	private FarmView farmview;
	private MarketView marketview;
	private MilitaryBuildingsView milit;
	private ArcheryRangeView archeryrangeview;
	private StableView stableview;
	private BarracksView barracksview;
	private IdleArmiesView idlearmiesview;
	private JButton idlearmy;
	private MarchingArmiesView marchingarmiesview;
	private JButton marchingarmy;
	private BeseigingArmiesView beseigingarmiesview;
	private JButton beseigingarmies;
	//private ArrayList<JButton> buttonslist;
	private String lastbuttonpressed;
	private ArmyView ArmyViewPanel;
	private JButton attackerclickedbutton;
	private JButton defenderclickedbutton;
	private int z1; 
	private JButton endturn;
	private int z2;
	private ArrayList<JButton> attackerarmybuttons;
	private ArrayList<JButton> defenderarmybuttons;
	private ArrayList<JButton> theunitsbuttons;
	private ArrayList<Unit> theunits;
	private String logofwar;
	//private ArrayList<Unit> idlearmies;
	private boolean flag;
	
	
	    public Controller() throws IOException{
		String name= JOptionPane.showInputDialog("please enter your name");
		String s1[] = { "Cairo", "Sparta", "Rome"};
		String cityname= (String)JOptionPane.showInputDialog(null,"please select a city", "starting city", JOptionPane.QUESTION_MESSAGE,null,s1,s1[0]);
		game=new Game(name, cityname);
		System.out.println("h");
		theunits=new ArrayList<Unit>();
		theunitsbuttons=new ArrayList<JButton>();
		logofwar="";
		flag=true;
		int hana=0;
		int farah=0;
		int ayten=0;
		frame= new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		settheworldview(frame);
		constants=new JLabel();
		//buttonslist=new ArrayList<JButton>();
		
	    constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
	    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
	    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
	    frame.getContentPane().add(constants,BorderLayout.NORTH);
	    //endturn=new JButton("End Turn");
		//frame.add(endturn);
	   
	    
		frame.revalidate();
    	frame.repaint();
    	
    	
    	
	}
	    
	    public void setDefendingArmyView(JFrame frame) {
	    	int i=0;
	    	int j=0;
	    	int k=0;
	    	defendingArmy=new DefendingArmyView(city);
	    	frame.getContentPane().add(defendingArmy.getDefendingArmy());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	defendingArmy.getBacktocity().addActionListener(this);
	    	defendingArmy.getInitiateArmy().addActionListener(this);  
	    	//defendingArmy.getRelocatefromdefending().addActionListener(this);
	    	System.out.println(defendingArmy.getButtonslist().size());
	    	for (JButton b: defendingArmy.getButtonslist()) {
	    		b.addActionListener(this);
	    		//theunitsbuttons.add(b);
	    		//System.out.println(b);
	    	}
	    	//System.out.println(theunitsbuttons.size());
	    	
	    	//for (Unit x: defendingArmy.getMycity().getDefendingArmy().getUnits()) {
	    		//theunits.add(x);
	    	}//System.out.println(theunits.size());
	   // } 
	    public void setBattle(BattleView x) {
	    	int i=0;
	    	x.getAttack().addActionListener(this);
	    	for (JButton b: x.getAttackerarmybuttons()) {
				
				b.addActionListener(this);
				
				
				
			}
            for (JButton b: x.getDefenderarmybuttons()) {
				
				b.addActionListener(this);
				
				
			}
            
	    }
	    
	    
	    
	    
	    
	    
	    public void setBeseigingArmiesView( JFrame frame) {
	    	beseigingarmiesview=new BeseigingArmiesView(game);
	    	frame.getContentPane().add(beseigingarmiesview.getBeseigingarmiesview());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	int i=0;
	    	for (Army a: game.getPlayer().getControlledArmies() ) {
				  if (a.getCurrentStatus().equals(Status.BESIEGING)) {
					  JButton b=new JButton("Army" +i ); 
					 
				  
					  b.addActionListener(this);
					  beseigingarmiesview.add(b);
					  i++;
					  
				  }
			  }
	    	beseigingarmiesview.getBacktoworldmap().addActionListener(this);
	    	beseigingarmiesview.setVisible(true);
	    }
	    public void setMarchingArmiesView( JFrame frame) {
	    	marchingarmiesview=new MarchingArmiesView(game);
	    	frame.getContentPane().add(marchingarmiesview.getMarchingarmiesview());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	int i=0;
	    	for (Army a: game.getPlayer().getControlledArmies() ) {
				  if (a.getCurrentStatus().equals(Status.MARCHING)) {
					  JButton b=new JButton("Army" +i ); 
					  b.addActionListener(this);
					  marchingarmiesview.add(b);
					  i++;
					  
				  }
			  }
	    	marchingarmiesview.getBacktoworldmap().addActionListener(this);
	    	marchingarmiesview.setVisible(true);
	    }
	    public void setIdleArmiesView( JFrame frame) {
	    	idlearmiesview=new IdleArmiesView(game);
	    	frame.getContentPane().add(idlearmiesview.getIdlearmiesview());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	int i=0;
	    	/*for (Army a: game.getPlayer().getControlledArmies() ) {
				  if (a.getCurrentStatus().equals(Status.IDLE)) {
					  JButton b=new JButton("IdleArmy" +i ); 
					  b.addActionListener(this);
					  idlearmiesview.add(b);
					  i++;
					  
				  }
			  }*/
	    	  idlearmiesview.getBacktoworldmap().addActionListener(this);
	    	  idlearmiesview.getSettargetcity().addActionListener(this);
			  idlearmiesview.setVisible(true);
			  for (JButton b: idlearmiesview.getAbuts()) {
				  b.addActionListener(this);
			  }
			  /*for (Army a: getidlearmies()) {
				  for (Unit x: a.getUnits()) {
					  theunits.add(x);
				  }
			  }*/
			 	}
		    
      /*  public void setArmyView(JFrame frame,Army a) {
        	
        	int i=0;
	    	int j=0;
	    	int k=0;
	    	
	    	ArmyViewPanel=new ArmyView(a);
	    	frame.getContentPane().add(ArmyViewPanel.getArmyView());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	 
	    	for ( Unit x : a.getUnits()) {
				  if(x instanceof Archer) {
					  JButton b=new JButton("Archer" + i );
					  ArmyViewPanel.add(b);
					  b.addActionListener(this);
					  //buttonslist.add(b);
					  i++;
					  //create two array of jbuttons 
					  //{ jb1,jb2,jb3}
					  
				  }
				  else if(x instanceof Cavalry) {
					  JButton b=new JButton("Cavalry" +j );
							  ArmyViewPanel.add(b);
							  b.addActionListener(this);
							  //buttonslist.add(b);
							  j++;
				  }
				  else if(x instanceof Infantry) {
					  JButton b=new JButton("Infantry" +k);
							  ArmyViewPanel.add(b);
							  b.addActionListener(this);
							  //buttonslist.add(b); 
							  k++;
				  }
		
			  }
	    	
        	
        }*/
	    public void setBarracksView( JFrame frame) {
	    	barracksview=new BarracksView(city);
	    	frame.getContentPane().add(barracksview.getBarracks());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	barracksview.getBacktomilitarybuilding().addActionListener(this);
	    	barracksview.getUpgradebutton().addActionListener(this);
	    	barracksview.getRecruitbutton().addActionListener(this);
		    
}
	    public void setArcheryRangeView( JFrame frame) {
	    	archeryrangeview=new ArcheryRangeView(city);
	    	frame.getContentPane().add(archeryrangeview.getArcheryrange());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	archeryrangeview.getBacktomilitarybuilding().addActionListener(this);
	    	archeryrangeview.getUpgradebutton().addActionListener(this);
	    	archeryrangeview.getRecruitbutton().addActionListener(this);
		    
}
	    public void setStableView( JFrame frame) {
	    	stableview=new StableView(city);
	    	frame.getContentPane().add(stableview.getStable());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	stableview.getBacktomilitarybuilding().addActionListener(this);
	    	stableview.getUpgradebutton().addActionListener(this);
	    	stableview.getRecruitbutton().addActionListener(this);
		    
}
	    
	    public void setMilitarybuildings( JFrame frame) {
	    	milit=new MilitaryBuildingsView(city);
	    	frame.getContentPane().add(milit.getMilitary());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	milit.getBacktocity().addActionListener(this);
	    	if (milit.getArcheryrangebutton()!=null)
	    		milit.getArcheryrangebutton().addActionListener(this);
	    	if (milit.getBarracksbutton()!=null)
	    		milit.getBarracksbutton().addActionListener(this);
	    	if (milit.getStablebutton()!=null)
	    		milit.getStablebutton().addActionListener(this);
		    
	    }
	    public void setmarketview(JFrame frame) {
	    	marketview= new MarketView(city);
	    	frame.getContentPane().add(marketview.getMarket());
	    	 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	 marketview.getUpgradebutton().addActionListener(this);
	    	 marketview.getBacktoeconomicalbuilding().addActionListener(this);
	    }
	    public void setfarmview(JFrame frame) {
	    	farmview= new FarmView(city);
	    	frame.getContentPane().add(farmview.getFarm());
	    	 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	 farmview.getUpgradebutton().addActionListener(this);
	    	 farmview.getBacktoeconomicalbuilding().addActionListener(this);
	    }
	    public void settheworldview(JFrame frame) {
	    	world=new WorldMapView();
	        frame.getContentPane().add(world.getWorldpanel());
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    world.getIdlearmies().addActionListener(this);
		    world.getMarchingarmies().addActionListener(this);
		    world.getBeseigingarmies().addActionListener(this);
		    world.getCairo().addActionListener(this);
		    world.getRome().addActionListener(this);
		    world.getSparta().addActionListener(this);
		    world.getEndturnbutton().addActionListener(this);
		    
		    
		    
		    
	    }
	    public void seteconomicalbuildings( JFrame frame) {
	    	eco=new EconomicalBuildingsView(city);
	    	frame.getContentPane().add(eco.getEconomical());
	    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	eco.getBacktocity().addActionListener(this);
	    	if (eco.getFarmbutton()!=null)
	    	eco.getFarmbutton().addActionListener(this);
	    	
	    	if (eco.getMarketbutton()!=null)
	    	eco.getMarketbutton().addActionListener(this);
		    
	    }
	    public void setsparta() {
	   
	    	 spartaview=new CityView(game.getPlayer().getControlledCities().get(0));
	    	 frame.getContentPane().add(spartaview.getCity());
	    	 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	 
			 spartaview.getMilitarybuildings().addActionListener(this);
			 spartaview.getEconomicalbuildings().addActionListener(this);
			 spartaview.getArmies().addActionListener(this);
			  spartaview.getBuild().addActionListener(this);
	    	 spartaview.getBacktoworldmap().addActionListener(this);
	    	 //spartaview.getInitiateArmy().addActionListener(this);
	    }
	    public void setrome() {
	    	 
	    	 romeview=new CityView(game.getPlayer().getControlledCities().get(0));
	    	 frame.getContentPane().add(romeview.getCity());
	    	 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	 //world.getIdlearmies().addActionListener(this);
			 romeview.getMilitarybuildings().addActionListener(this);
			 romeview.getEconomicalbuildings().addActionListener(this);
			 romeview.getArmies().addActionListener(this);
			 romeview.getBuild().addActionListener(this);
			 romeview.getBacktoworldmap().addActionListener(this);
			// romeview.getInitiateArmy().addActionListener(this);   
			
	    }
	    public void setcairo() {
	    	//System.out.println(game.getPlayer().getControlledCities().get(0).getName());	
	    	 cairoview=new CityView(game.getPlayer().getControlledCities().get(0));
	    	 frame.getContentPane().add(cairoview.getCity());
	    	 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	 //world.getIdlearmies().addActionListener(this);
			 cairoview.getMilitarybuildings().addActionListener(this);
			 cairoview.getEconomicalbuildings().addActionListener(this);
			 cairoview.getArmies().addActionListener(this);
			 cairoview.getBuild().addActionListener(this);
			 cairoview.getBacktoworldmap().addActionListener(this);
			 //cairoview.getInitiateArmy().addActionListener(this);
			 
			
	    	 
	    }
	public ArrayList<Army> getidlearmies() {
		ArrayList<Army> idlearmies=new ArrayList<Army>();
		for (Army a: game.getPlayer().getControlledArmies() ) {
			
			if(a.getCurrentStatus().equals(Status.IDLE))
				idlearmies.add(a);
			
		}
		return idlearmies;
		
	}
	public ArrayList<Army> getmarchingarmies() {
		ArrayList<Army> marchingarmies=new ArrayList<Army>();
		for (Army a: game.getPlayer().getControlledArmies() ) {
			if(a.getCurrentStatus().equals(Status.MARCHING))
				marchingarmies.add(a);
			
		}
		return marchingarmies;
	}
	public ArrayList<Army> getbeseigingarmies() {
		ArrayList<Army> beseigingarmies=new ArrayList<Army>();
		for (Army a: game.getPlayer().getControlledArmies() ) {
			if(a.getCurrentStatus().equals(Status.BESIEGING))
				beseigingarmies.add(a);
			
		}
		return beseigingarmies;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		/*if(e.getActionCommand().equals("Idle Armies"))
		 {
			
			JOptionPane idlePopUp=new JOptionPane();
			String s="";
		for( Army a : game.getPlayer().getControlledArmies()) {
				s+= "Army->";
				for(Unit u: a.getUnits()) {
					if(u instanceof Archer)
					s+= "Archers"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
					if(u instanceof Cavalry)
						s+= "Cavalry"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
					if(u instanceof Infantry)
						s+= "Infantry"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
					
					
					
				}
				s+="/n";
				
				
			}*/
		/*for(City c: game.getPlayer().getControlledCities()) {
			if (c.getDefendingArmy().getCurrentStatus().equals(Status.IDLE)) {
				s+=c.getName() +"Army";
				for (Unit u: c.getDefendingArmy().getUnits()) {
					if(u instanceof Archer)
						s+= "Archers"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
						if(u instanceof Cavalry)
							s+= "Cavalry"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
						if(u instanceof Infantry)
							s+= "Infantry"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
						
				}
					
			
		}
			s+="/n";
		}
			idlePopUp.showInternalMessageDialog(world, s);			
			}*/
		
		/*if(e.getActionCommand().equals("Marching Armies"))
		 {
			JOptionPane marchingPopUp=new JOptionPane();
			String kolo="";
			
			for(int i=0;i<getmarchingarmies().size();i++) {
				String res ="";
				Army a =getmarchingarmies().get(i);
				
				for(Unit u: a.getUnits()) {
					if(u instanceof Archer)
					res+= "Archers"+"/n" +"level: "+ u.getLevel()+ "/n" + "Current soldier count"+ u.getCurrentSoldierCount()+"/n"+ "max soldier count: " + u.getMaxSoldierCount() +"/n";
					if(u instanceof Cavalry)
						res+= "Cavalry"+ "/n"+"level: "+ u.getLevel()+ "/n" + "Current soldier count"+ u.getCurrentSoldierCount()+"/n"+ "max soldier count: " + u.getMaxSoldierCount() +"/n";
					if(u instanceof Infantry)
						res+= "INFANTRY "+ "/n"+"level: "+ u.getLevel()+ "/n" + "Current soldier count"+ u.getCurrentSoldierCount()+"/n"+ "max soldier count: " + u.getMaxSoldierCount() +"/n";
					
					kolo+=res;
					
				}
				
				
				
				
			}
			marchingPopUp.showInternalMessageDialog(world,kolo);
			
			
			}
		
		if(e.getActionCommand().equals("Beseiging Armies"))
		 {
			
			JOptionPane BeseigingPopUp=new JOptionPane();
			String kolo="";
			
			for(int i=0;i<getmarchingarmies().size();i++) {
				String res ="";
				Army a =getmarchingarmies().get(i);
				
				for(Unit u: a.getUnits()) {
					if(u instanceof Archer)
					res+= "Archers"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
					if(u instanceof Cavalry)
						res+= "Cavalry"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
					if(u instanceof Infantry)
						res+= "Infantry"+ u.getLevel()+ u.getCurrentSoldierCount()+"/n";
					
					kolo+=res;
					
				}
				
				
				
				
			}
			BeseigingPopUp.showInternalMessageDialog(world,kolo);
			
			
			}*/
		if (e.getActionCommand().equals("Cairo")) {
			boolean flag = false;
			for(City c: game.getPlayer().getControlledCities()) {
				if (c.getName().equals("Cairo")) {
					frame.getContentPane().removeAll();
					frame.getContentPane().add(constants,BorderLayout.NORTH);
					
					 this.setcairo();
					 flag=true;
					 city=c;
					  //
					
					cairoview.setVisible(true);
					 frame.setVisible(true);
				}
			}
			if (flag==false) {
				int result = JOptionPane.showConfirmDialog(frame,"You do not control this city ", "Attack",JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
		               System.out.println("ha");}
			}
		}
		if (e.getActionCommand().equals("Rome")) {
			boolean flag = false;
			for(City c: game.getPlayer().getControlledCities()) {
				if (c.getName().equals("Rome")) {
					frame.getContentPane().removeAll();
					frame.getContentPane().add(constants,BorderLayout.NORTH);
					 city=c;
					 this.setrome();
					 flag=true;
					 
					  //
					
					romeview.setVisible(true);
					 frame.setVisible(true);
				}
			}
			if (flag==false) {
				int result = JOptionPane.showConfirmDialog(frame,"You do not control this city ", "Attack",JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
		               System.out.println("ha");}
			}
			/*City attacked = null;
			if (flag==false) {
				//int result = JOptionPane.showConfirmDialog(frame,"You do not control this city, let's attack? ", "Attack",JOptionPane.YES_NO_OPTION,
			               //JOptionPane.QUESTION_MESSAGE);
				String s1[] = {"Beseige the city", "Attack directly"};
				String chosenaction=(String)JOptionPane.showInputDialog(null, "You do not control this city, do you want to ", "", JOptionPane.QUESTION_MESSAGE, null, s1, s1[0]);
				if(chosenaction.equals("Beseige the city")){
					for(City c: game.getAvailableCities()) {
						if (c.getName().equals("Rome")) {
							attacked=c;
						}
			}
					for (Army a: game.getPlayer().getControlledArmies()) {
						if (a.getCurrentLocation().equals("Rome") && attacked!=null) {
							try {
								game.getPlayer().laySiege(a,attacked);
							} catch (TargetNotReachedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (FriendlyCityException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
		}
				
			}*/
		}
		if (e.getActionCommand().equals("Sparta")) {
			boolean flag = false;
			for(City c: game.getPlayer().getControlledCities()) {
				if (c.getName().equals("Sparta")) {
					frame.getContentPane().removeAll();
					frame.getContentPane().add(constants,BorderLayout.NORTH);
					
					 this.setsparta();
					 city=c;
					 flag=true;
					spartaview.setVisible(true);
					 frame.setVisible(true);
					
				}
			}
			System.out.println(flag);
			if (flag==false) {
				int result = JOptionPane.showConfirmDialog(frame,"You do not control this city", "Attack",JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				
			}
		}
		if (e.getActionCommand().equals("Build")) {
			//ask ezay a3rf ana f anhy virw
			String [] s1= {"Farm cost=1000" , "Market cost=1500", "ArcheryRange cost=1500", "Barracks cost=2000","Stable cost=2500"};
			String buildingtype=(String)JOptionPane.showInputDialog(null,"please select a building", "build", JOptionPane.QUESTION_MESSAGE,null,s1,s1[0]);
		    	
			if (buildingtype.equals("Farm cost=1000")) {
			
						try {
							
							game.getPlayer().build("Farm",city.getName());
							//System.out.println(city.getEconomicalBuildings().get(0));
							
						} catch (NotEnoughGoldException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
			if (buildingtype.equals("Market cost=1500")) {
				
				try {
					
					game.getPlayer().build("Market",city.getName());
					//System.out.println(city.getEconomicalBuildings().get(0));
					
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
			if (buildingtype.equals("ArcheryRange cost=1500")) {
				
				try {
					
					game.getPlayer().build("ArcheryRange",city.getName());
					//System.out.println(city.getEconomicalBuildings().get(0));
					
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
			if (buildingtype.equals("Barracks cost=2000")) {
				
				try {
					
					game.getPlayer().build("Barracks",city.getName());
					//System.out.println(city.getEconomicalBuildings().get(0));
					
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
         if (buildingtype.equals("Stable cost=2500")) {
				
				try {
					
					game.getPlayer().build("Stable",city.getName());
					//System.out.println(city.getEconomicalBuildings().get(0));
					
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
         constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
        		    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
        		    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
		}
				/*	}
						if (rncity.getName().equals("romeview")) {
							   
							try {
								game.getPlayer().build(buildingtype, "Rome");
								
							} catch (NotEnoughGoldException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			}
						if (rncity.getName().equals("spartaview")) {
							   
							try {
								game.getPlayer().build(buildingtype,"Sparta");
								
							} catch (NotEnoughGoldException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			}
					}*/
			
			
		if (e.getActionCommand().equals("Back to World Map")) {
			frame.getContentPane().removeAll();
			
			frame.getContentPane().add(constants,BorderLayout.NORTH);
			
			 frame.getContentPane().add(world.getWorldpanel());
		
			 
			
		world.setVisible(true);
			 frame.setVisible(true);
			 frame.revalidate();
			 frame.repaint();
		}
		
	if (e.getActionCommand().equals("Economical Buildings")){
		frame.getContentPane().removeAll();
		
		frame.getContentPane().add(constants,BorderLayout.NORTH);
		
		 
	     this.seteconomicalbuildings(frame);		 
	     	 eco.setVisible(true);
			 frame.setVisible(true);
			 frame.revalidate();
			 frame.repaint();
		}
		
     if(e.getActionCommand().equals("Back to City View")) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(constants,BorderLayout.NORTH);
		if (city.getName().equals("Cairo")) {
		   frame.getContentPane().add(cairoview.getCity());
		   cairoview.setVisible(true);
			 
		}
		if (city.getName().equals("Sparta")) {
			frame.getContentPane().add(spartaview.getCity());
			spartaview.setVisible(true);
		}
		if (city.getName().equals("Rome")) {
			frame.getContentPane().add(romeview.getCity());
			romeview.setVisible(true);
		}
		frame.setVisible(true);
		 frame.revalidate();
		 frame.repaint();
	}
     if (e.getActionCommand().equals("Back to Economical Buildings")) {
    	 frame.getContentPane().removeAll();
 		frame.getContentPane().add(constants,BorderLayout.NORTH);
 		frame.getContentPane().add(eco.getEconomical());
 		frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if(e.getActionCommand().equals("Farm")) {
    	 frame.getContentPane().removeAll();
    	 setfarmview(frame);
    	 frame.getContentPane().add(constants,BorderLayout.NORTH);
    	 
    	 farmview.setVisible(true);
    	 frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if(e.getActionCommand().equals("Market")) {
    	 frame.getContentPane().removeAll();
    	 setmarketview(frame);
    	
    	 frame.getContentPane().add(constants,BorderLayout.NORTH);
    	 
    	 marketview.setVisible(true);
    	 frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if (e.getActionCommand().equals("Military Buildings")){
  		frame.getContentPane().removeAll();
  		frame.getContentPane().add(constants,BorderLayout.NORTH);
  		
  		 
  	     this.setMilitarybuildings(frame);		 
  	         milit.setVisible(true);
  			 frame.setVisible(true);
  			 frame.revalidate();
  			 frame.repaint();
  		}
     
     if (e.getActionCommand().equals("Upgrade Market")) {
    	 for(EconomicBuilding b: city.getEconomicalBuildings()) {
    		 if (b instanceof Market) {
    			
    				try {
						game.getPlayer().upgradeBuilding(b);
					} catch (NotEnoughGoldException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BuildingInCoolDownException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MaxLevelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			 
    		 }
    	 }
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
 			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
 			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
     if (e.getActionCommand().equals("Upgrade Farm")) {
    	 for(EconomicBuilding b: city.getEconomicalBuildings()) {
    		 if (b instanceof Farm) {
    			
    			 
					
						try {
							game.getPlayer().upgradeBuilding(b);
						} catch (NotEnoughGoldException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BuildingInCoolDownException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (MaxLevelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
    			 
    		 }
    	 }
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
 			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
 			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
     if(e.getActionCommand().equals("ArcheryRange")) {
    	 frame.getContentPane().removeAll();
    	 setArcheryRangeView(frame);
    	 frame.getContentPane().add(constants,BorderLayout.NORTH);
    	 
    	 archeryrangeview.setVisible(true);
    	 frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if (e.getActionCommand().equals("Upgrade ArcheryRange")) {
    	 for(MilitaryBuilding b: city.getMilitaryBuildings()) {
    		 if (b instanceof ArcheryRange) {
    			
    			
					try {
						game.getPlayer().upgradeBuilding(b);
						System.out.println(b.getLevel());
					} catch (NotEnoughGoldException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BuildingInCoolDownException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MaxLevelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
    			 
    		 }
    	 }
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
  			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
  			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
     if (e.getActionCommand().equals("Recruit Archer")) {
    	// for (MilitaryBuilding b: city.getMilitaryBuildings()) {
    		// if (b instanceof ArcheryRange)
				
					try {
						game.getPlayer().recruitUnit("Archer", city.getName());
						System.out.println("DEFENDING ARMY LENGTH:-" + city.getDefendingArmy().getUnits().size());
					} catch (BuildingInCoolDownException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MaxRecruitedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughGoldException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/*System.out.println("hana");
				} catch (BuildingInCoolDownException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MaxRecruitedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
    	 
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
  			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
  			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
     if(e.getActionCommand().equals("Stable")) {
    	 frame.getContentPane().removeAll();
    	 setStableView(frame);
    	 frame.getContentPane().add(constants,BorderLayout.NORTH);
    	 
    	 stableview.setVisible(true);
    	 frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }

     if (e.getActionCommand().equals("Upgrade Stable")) {
    	 for(MilitaryBuilding b: city.getMilitaryBuildings()) {
    		 if (b instanceof Stable) {
    			
    			
					try {
						game.getPlayer().upgradeBuilding(b);
						System.out.println(b.getLevel());
					} catch (NotEnoughGoldException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BuildingInCoolDownException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MaxLevelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
    			 
    		 }
    	 }
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
  			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
  			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
     if (e.getActionCommand().equals("Recruit Cavalry")) {
    	 try {
				game.getPlayer().recruitUnit("Cavalry", city.getName());
				System.out.println("DEFENDING ARMY LENGTH:-" + city.getDefendingArmy().getUnits().size());
			} catch (BuildingInCoolDownException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MaxRecruitedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
 			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
 			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
     if(e.getActionCommand().equals("Barracks")) {
    	 frame.getContentPane().removeAll();
    	 setBarracksView(frame);
    	 frame.getContentPane().add(constants,BorderLayout.NORTH);
    	 
    	 barracksview.setVisible(true);
    	 frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if (e.getActionCommand().equals("Recruit Infantry")) {
    	 try {
				game.getPlayer().recruitUnit("Infantry", city.getName());
				System.out.println("DEFENDING ARMY LENGTH:-" + city.getDefendingArmy().getUnits().size());
			} catch (BuildingInCoolDownException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MaxRecruitedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
 			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
 			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
     if (e.getActionCommand().equals("Upgrade Barracks")) {
    	 for(MilitaryBuilding b: city.getMilitaryBuildings()) {
    		 if (b instanceof Barracks) {
    			
    			
					try {
						game.getPlayer().upgradeBuilding(b);
						System.out.println(b.getLevel());
					} catch (NotEnoughGoldException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BuildingInCoolDownException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MaxLevelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
    			 
    		 }
    	 }
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\n "+ 
  			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
  			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
     }
    
     
     
     if (e.getActionCommand().equals("Back to Military Buildings")) {
    	 frame.getContentPane().removeAll();
 		frame.getContentPane().add(constants,BorderLayout.NORTH);
 		frame.getContentPane().add(milit.getMilitary());
 		frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if (e.getActionCommand().equals("Idle Armies")) {
    	 frame.getContentPane().removeAll();
 		frame.getContentPane().add(constants,BorderLayout.NORTH);
 		setIdleArmiesView(frame);
 		frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if (e.getActionCommand().equals("Marching Armies")) {
    	 frame.getContentPane().removeAll();
 		frame.getContentPane().add(constants,BorderLayout.NORTH);
 		setMarchingArmiesView(frame);
 		frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     if (e.getActionCommand().equals("Besieging Armies")) {
    	 frame.getContentPane().removeAll();
 		frame.getContentPane().add(constants,BorderLayout.NORTH);
 		setBeseigingArmiesView(frame);
 		frame.setVisible(true);
 		 frame.revalidate();
 		 frame.repaint();
     }
     /*if (e.getActionCommand().equals("Initiate Army")) {
 		String unittype= JOptionPane.showInputDialog("please enter the Unit type");
 		String level= JOptionPane.showInputDialog("please enter the Unit level");
 	
  
 			for (Unit b: city.getDefendingArmy().getUnits()) {
 				//System.out.println("dana");
 				if  (((b instanceof Archer) && (unittype.toLowerCase().equals("Archer")) && (Integer.parseInt(level)==b.getLevel())) || ((b instanceof Infantry) && (unittype.toLowerCase().equals("Infantry")) && (Integer.parseInt(level)==b.getLevel())) || ((b instanceof Cavalry) && (unittype.toLowerCase().equals("Cavalry")) && (Integer.parseInt(level)==b.getLevel()))) 
 					
				game.getPlayer().initiateArmy(city, b);
						//System.out.println("hana");
					
 			}
 			
 	
	}*/
     if (e.getActionCommand().equals("End Turn")) {
    	 if(game.isGameOver()) {
    		 JOptionPane.showInternalMessageDialog(null, "GAME OVER", "", JOptionPane.INFORMATION_MESSAGE);
    		frame.setVisible(false);
    	 }
    	 else {
    	 game.endTurn();
    	 constants.setText("Player's Name: " +  game.getPlayer().getName() + "     " +"\r"+ 
   			    "Current turn count: "+ String.valueOf(game.getCurrentTurnCount()) + "    " + "\n" +
   			    "Treasury: "+ String.valueOf(game.getPlayer().getTreasury()) +  "     " + "\n" + "Food: "+ String.valueOf(game.getPlayer().getFood()));
    	 
    	 for (City c: game.getAvailableCities()) {
    		 if (c.isUnderSiege()) {
    			 System.out.println("Hana" + c.getName() );
    			 for (Army a: game.getPlayer().getControlledArmies()) {
    				 System.out.println("Hana1" +a.getCurrentLocation() + a.getCurrentStatus() );
    				 if (a.getCurrentLocation().equals(c.getName())) {
    					 if (c.getTurnsUnderSiege()<3) {
    						 String s1[] = {"Dont do anything", "Attack directly"};
    						 String chosenaction="";
    						 if (c.getTurnsUnderSiege()==1)
  			  				chosenaction=(String)JOptionPane.showInputDialog(null, "Your army is besieging " + a.getCurrentLocation() + " for " + c.getTurnsUnderSiege() +" turn "+" do you want to ", "", JOptionPane.QUESTION_MESSAGE, null, s1, s1[0]);
    						 else
    							 chosenaction=(String)JOptionPane.showInputDialog(null, "Your army is besieging " + a.getCurrentLocation() + " for " + c.getTurnsUnderSiege() +" turns "+" do you want to ", "", JOptionPane.QUESTION_MESSAGE, null, s1, s1[0]);
   				
   				 if (chosenaction.equals("Attack directly")) {
   					
   					String s2[] = {"Attack Manually", "AutoResolve"};
   	 				String chosenbattle=(String)JOptionPane.showInputDialog(null, "Choose an Attack type", "", JOptionPane.QUESTION_MESSAGE, null, s2, s2[0]);
   					if (chosenbattle.equals("AutoResolve")) {
   						City attacked1=null;
   						for(City c1: game.getAvailableCities()) {
   	 						if (c1.getName().equals(a.getCurrentLocation())) {
   	 							attacked1=c1;
   	 							break;
   	 						}
   	 			}
   						try {
  							game.autoResolve(a, attacked1.getDefendingArmy());
  							if (a.getUnits().size()!=0) {
  								JOptionPane.showInternalMessageDialog(null, "Congratulations! You Won", "Battle Result", JOptionPane.INFORMATION_MESSAGE);
  							}
  							else {
  								JOptionPane.showInternalMessageDialog(null, "You Lost"+ attacked1.getName(), "Battle Result", JOptionPane.INFORMATION_MESSAGE);
  							}
  						} catch (FriendlyFireException e1) {
  							// TODO Auto-generated catch block
  							e1.printStackTrace();
  						}
   					}
   					else if(chosenbattle.equals("Attack Manually")) {
   						
   						City attacked2=null;
   						for(City c1: game.getAvailableCities()) {
   	 						if (c1.getName().equals(a.getCurrentLocation())) {
   	 							attacked2=c1;
   	 							break;
   	 						}
   						}
   						battleviewpanel=new BattleView(a,attacked2.getDefendingArmy());
   						
   						setBattle(battleviewpanel);
   						frame.getContentPane().removeAll();
   						frame.getContentPane().add(constants);
   						frame.getContentPane().add(battleviewpanel.getBattlev());
   						battleviewpanel.setVisible(true);
   						
   						
   						frame.setVisible(true);
   						frame.repaint();
   						frame.revalidate();
   					/*	if (a.getUnits().isEmpty() || attacked2.getDefendingArmy().getUnits().isEmpty()) {
   							frame.getContentPane().removeAll();
   	   						frame.getContentPane().add(constants);
   	   						frame.getContentPane().add(world.getWorldpanel());
   	   						battleviewpanel.setVisible(false);
   	   						
   	   						
   	   						frame.setVisible(true);
   	   						frame.repaint();
   	   						frame.revalidate();
   						}*/
   					}
   				}
    					 }
    					 else {
    						 String s1[] = { "Attack directly"};
  			  				String chosenaction=(String)JOptionPane.showInputDialog(null, "Your army has beseiged " + a.getCurrentLocation() + " for 3 turns " +"you should ", "", JOptionPane.QUESTION_MESSAGE, null, s1, s1[0]);
  						
   				
   				 if (chosenaction.equals("Attack directly")) {
   					
   					String s2[] = {"Attack Manually", "AutoResolve"};
   	 				String chosenbattle=(String)JOptionPane.showInputDialog(null, "Choose an Attack type", "", JOptionPane.QUESTION_MESSAGE, null, s2, s2[0]);
   					if (chosenbattle.equals("AutoResolve")) {
   						City attacked1=null;
   						for(City c1: game.getAvailableCities()) {
   	 						if (c1.getName().equals(a.getCurrentLocation())) {
   	 							attacked1=c1;
   	 							break;
   	 						}
   	 			}
   						try {
  							game.autoResolve(a, attacked1.getDefendingArmy());
  							if (a.getUnits().size()!=0) {
  								JOptionPane.showInternalMessageDialog(null, "Congratulations! You Won", "Battle Result", JOptionPane.INFORMATION_MESSAGE);
  							}
  							else {
  								JOptionPane.showInternalMessageDialog(null, "You Lost"+ attacked1.getName(), "Battle Result", JOptionPane.INFORMATION_MESSAGE);
  							}
  						} catch (FriendlyFireException e1) {
  							// TODO Auto-generated catch block
  							e1.printStackTrace();
  						}
   					}
   					else if(chosenbattle.equals("Attack Manually")) {
   						
   						City attacked2=null;
   						for(City c1: game.getAvailableCities()) {
   	 						if (c1.getName().equals(a.getCurrentLocation())) {
   	 							attacked2=c1;
   	 							break;
   	 						}
   						}
   						battleviewpanel=new BattleView(a,attacked2.getDefendingArmy());
   						setBattle(battleviewpanel);
   						frame.getContentPane().removeAll();
   						frame.getContentPane().add(constants);
   						frame.getContentPane().add(battleviewpanel.getBattlev());
   						battleviewpanel.setVisible(true);
   						frame.setVisible(true);
   						frame.repaint();
   						frame.revalidate();
  						}
     		 }
    						 
    					 }
    				 }
    			 }
    		 }
    	 }
    	 for (Army a: game.getPlayer().getControlledArmies()) {
    		 if (a.getDistancetoTarget() == 0 && !a.getCurrentStatus().equals(Status.BESIEGING)) {
    			
    			 String s1[] = {"Beseige the city", "Attack directly"};
 				String chosenaction=(String)JOptionPane.showInputDialog(null, "Your army has reached " + a.getCurrentLocation() +" do you want to ", "", JOptionPane.QUESTION_MESSAGE, null, s1, s1[0]);
 				City attacked=null;
 				
 				if(chosenaction.equals("Beseige the city")){
 					for(City c: game.getAvailableCities()) {
 						if (c.getName().equals(a.getCurrentLocation())) {
 							attacked=c;
 							break;
 						}
 			}
 					try {
 						System.out.println(attacked);
 						if (attacked!=null)
						game.getPlayer().laySiege(a, attacked);
 						System.out.println(a.getCurrentStatus());
 						
					} catch (TargetNotReachedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FriendlyCityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 					
 					}
 				else if (chosenaction.equals("Attack directly")) {
 					
 					String s2[] = {"Attack Manually", "AutoResolve"};
 	 				String chosenbattle=(String)JOptionPane.showInputDialog(null, "Choose an Attack type", "", JOptionPane.QUESTION_MESSAGE, null, s2, s2[0]);
 					if (chosenbattle.equals("AutoResolve")) {
 						City attacked1=null;
 						for(City c: game.getAvailableCities()) {
 	 						if (c.getName().equals(a.getCurrentLocation())) {
 	 							attacked1=c;
 	 							break;
 	 						}
 	 			}
 						try {
							game.autoResolve(a, attacked1.getDefendingArmy());
							if (a.getUnits().size()!=0) {
								JOptionPane.showInternalMessageDialog(null, "Congratulations! You Won", "Battle Result", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showInternalMessageDialog(null, "You Lost"+ attacked1.getName(), "Battle Result", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (FriendlyFireException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 					}
 					else if(chosenbattle.equals("Attack Manually")) {
 						
 						City attacked2=null;
 						for(City c: game.getAvailableCities()) {
 	 						if (c.getName().equals(a.getCurrentLocation())) {
 	 							attacked2=c;
 	 							break;
 	 						}
 						}
 						battleviewpanel=new BattleView(a,attacked2.getDefendingArmy());
 						setBattle(battleviewpanel);
 						frame.getContentPane().removeAll();
 						frame.getContentPane().add(constants);
 						frame.getContentPane().add(battleviewpanel.getBattlev());
 						battleviewpanel.setVisible(true);
 						/*if (a.getUnits().isEmpty() || attacked2.getDefendingArmy().getUnits().isEmpty()) {
   							frame.getContentPane().removeAll();
   	   						frame.getContentPane().add(constants);
   	   						frame.getContentPane().add(world.getWorldpanel());
   	   						battleviewpanel.setVisible(false);
   	   						world.setVisible(true);
   						}*/
 						frame.setVisible(true);
 						frame.repaint();
 						frame.revalidate();
 					}
 				}
    		 }
    	 }
     }
     }
	if(e.getActionCommand().equals("City Defending Army")) {
   	 frame.getContentPane().removeAll();
   	 frame.getContentPane().add(constants,BorderLayout.NORTH);
   	 
   	 setDefendingArmyView(frame);
   	 
   	 defendingArmy.setVisible(true);
   	 frame.setVisible(true);
			 frame.revalidate();
			 frame.repaint();
   	 
    }
/*	for (JButton b: buttonslist) {
		
		
		if (b.getText().equals(e.getActionCommand())) {
			lastbuttonpressed=e.getActionCommand();
			
		}
	}
	*/
	
	if (e.getActionCommand().equals("Initiate Army")) {
	    frame.getContentPane().removeAll();
		frame.getContentPane().add(constants,BorderLayout.PAGE_START);
		
		setDefendingArmyView(frame);
		defendingArmy.setVisible(true);
		frame.setVisible(true);
		String unittype= JOptionPane.showInputDialog("please enter the Unit name");
		
		boolean flag=false;
		System.out.println(defendingArmy.getButtonslist().size());
		
		//System.out.println(city.getDefendingArmy().getUnits().size());
		for (int z=0;z<defendingArmy.getButtonslist().size();z++) {
			
			//System.out.println(z + defendingArmy.getButtonslist().get(z).getText());
			if (defendingArmy.getButtonslist().get(z).getText().equals(unittype)) {
				System.out.println(city.getDefendingArmy().getUnits().size());
			Unit unit=city.getDefendingArmy().getUnits().get(z);
			game.getPlayer().initiateArmy(city, unit);
			defendingArmy.getButtonslist().remove(defendingArmy.getButtonslist().get(z));
			//theunitsbuttons.remove(defendingArmy.getButtonslist().get(z));
			//theunitsbuttons.add(defendingArmy.getButtonslist().get(z));
			//theunits.remove(unit);
			//theunits.add(unit);
			flag=true;
			break;
			}
			
		}
		if (flag==false)
			JOptionPane.showInternalMessageDialog(null, "Please enter an available unit", "Error",JOptionPane.ERROR_MESSAGE);
				
		
		 frame.revalidate();
		 frame.repaint();
  }
	
	if (e.getActionCommand().equals("Set Target City")) {
	int count=0;
		for (Army a: game.getPlayer().getControlledArmies() ) {
			  if (a.getCurrentStatus().equals(Status.IDLE)) {
				  count++;
			  }
		}
		String [] armies= new String [count];
		//System.out.println("Hana");
		//System.out.println(count);
		for (int i=0;i<armies.length;i++) {
			String s="IdleArmy"+i;
			armies[i]=s;
			System.out.println(armies[i]);
		}
		
		
		String result=(String) JOptionPane.showInputDialog(frame, "Choose an Army", "Target city", JOptionPane.QUESTION_MESSAGE, null, armies, armies[0]);
		int indexofarmy=0;
		for (int i=0;i<armies.length;i++) {
			if (result.equals(armies[i])) {
				indexofarmy=i;
				break;
			}
		}
		ArrayList<Army> armyy=getidlearmies();
		//System.out.println(armyy.size());
		
		Army army=armyy.get(indexofarmy);
		String[] cities= {"Cairo", "Rome", "Sparta"};
		String citytotarget=(String) JOptionPane.showInputDialog(frame, "Choose a city", "Target city", JOptionPane.QUESTION_MESSAGE, null, cities, cities[0]);
	   // army.setCurrentStatus(Status.MARCHING);
		if (citytotarget.equals(city.getName()))
			JOptionPane.showMessageDialog(frame, "You already control this city", "Error", JOptionPane.ERROR_MESSAGE);
	    game.targetCity(army, citytotarget);
	    
	}
	if (e.getActionCommand().equals("Attacker Unit")) {
		z1=0;
		for (JButton b : battleviewpanel.getAttackerarmybuttons()) {
			
		
		if (e.getSource().equals(b)) {
		attackerclickedbutton=b;
		break;	
		}
		
		z1++;
	}
	}
	if (e.getActionCommand().equals("Defender Unit")) {
		
		z2=0;
		for (JButton b : battleviewpanel.getDefenderarmybuttons()) {
			
		
		if (e.getSource().equals(b)) {
			defenderclickedbutton=b;
		break;	
		}
		
		z2++;
	}
	}
  
	if (e.getActionCommand().equals("Attack")) {
		 
		// if (defenderclickedbutton==null || attackerclickedbutton==null)
		  //JOptionPane.showMessageDialog(frame, "Please choose one unit from each army to attack", "Error", JOptionPane.ERROR_MESSAGE);
		 
			//  while( !battleviewpanel.getTheattacker().getUnits().isEmpty() && !battleviewpanel.getThedefender().getUnits().isEmpty()  ) {
		if(!(battleviewpanel.getTheattacker().getUnits().isEmpty()) && !(battleviewpanel.getTheattacker().getUnits().isEmpty())) {
		if (flag) {
			//if (defenderclickedbutton==null || attackerclickedbutton==null)
				//  JOptionPane.showMessageDialog(frame, "Please choose one unit from each army to attack", "Error", JOptionPane.INFORMATION_MESSAGE);
			//else {
			 Unit attacker= battleviewpanel.getTheattacker().getUnits().get(z1);
				
			  Unit defender= battleviewpanel.getThedefender().getUnits().get(z2);
		  try {
			 
		//System.out.println("whichone");
		attacker.attack(defender);
		setBattle(battleviewpanel);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(constants);
			frame.getContentPane().add(battleviewpanel.getBattlev());
			battleviewpanel.setVisible(true);
		//battleviewpanel.getLog().add(new JLabel("Attacker Unit: " + attacker.getCurrentSoldierCount() +"Defender Unit: "+ defender.getCurrentSoldierCount()));
		//battleviewpanel.getLog().setVisible(true);
		// battleviewpanel
		// battleviewpanel.revalidate();
		 //  battleviewpanel.repaint();
		//battleviewpanel.getLog().add(new JTextField("Defender unit killed the attacker unit"));
		//battleviewpanel.getLog().add(new JTextField("Attacker unit killed the defender unit"));
			  
		} catch (FriendlyFireException e1) {
		JOptionPane.showMessageDialog(frame, "Please choose one unit from the other army", "Error", JOptionPane.ERROR_MESSAGE);
		}
		 
		/* JPanel newresultdisplay=new JPanel();
		 JLabel temp=new JLabel();
		 temp.setText("attacker "+attacker.getCurrentSoldierCount()+" defender "+defender.getCurrentSoldierCount());
		 newresultdisplay.add(temp);
		 battleviewpanel.setResultdisplay(newresultdisplay);
		*/
		 logofwar+="attacker current soldier count: "+attacker.getCurrentSoldierCount()+" defender current soldier count: "+defender.getCurrentSoldierCount() + "\n";
		 JOptionPane.showMessageDialog(null, logofwar, "Log", JOptionPane.INFORMATION_MESSAGE);
		 flag=false; 
		}
		//}
		if (flag==false) {
			 if (battleviewpanel.getTheattacker().getUnits().size() != 0 && battleviewpanel.getThedefender().getUnits().size() != 0) {
					Unit unit1 = battleviewpanel.getTheattacker().getUnits().get((int) (Math.random() * battleviewpanel.getTheattacker().getUnits().size()));
					Unit unit2 = battleviewpanel.getThedefender().getUnits().get((int) (Math.random() * battleviewpanel.getThedefender().getUnits().size()));
			 
					try {
						unit2.attack(unit1);
						setBattle(battleviewpanel);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(constants);
						frame.getContentPane().add(battleviewpanel.getBattlev());
						battleviewpanel.setVisible(true);
					} catch (FriendlyFireException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//  battleviewpanel.setTemp("attacker "+attacker.getCurrentSoldierCount()+" defender "+defender.getCurrentSoldierCount());
					
					 logofwar+="attacker current soldier count: "+unit1.getCurrentSoldierCount()+" defender current soldier count: "+unit2.getCurrentSoldierCount() + "\n";
					JOptionPane.showMessageDialog(null, logofwar, "Log", JOptionPane.INFORMATION_MESSAGE);
		 }
			 flag=true;
		 }
		}
		 System.out.println(flag);
		 attackerclickedbutton=null;
		 defenderclickedbutton=null;
		  //}
			  if(battleviewpanel.getThedefender().getUnits().isEmpty()) {
				  System.out.println(battleviewpanel.getThedefender().getCurrentLocation());
				 game.occupy(battleviewpanel.getTheattacker(),battleviewpanel.getThedefender().getCurrentLocation());
				 
				 JOptionPane.showMessageDialog(null, "YOU WON, you have occupied "+ battleviewpanel.getThedefender().getCurrentLocation(), "WON", JOptionPane.INFORMATION_MESSAGE, null);
				 frame.getContentPane().removeAll();
					
					frame.getContentPane().add(constants,BorderLayout.NORTH);
					
					 frame.getContentPane().add(world.getWorldpanel());
				
					 
					
				world.setVisible(true);
					 frame.setVisible(true);
					 frame.revalidate();
					 frame.repaint();
				  
			  }
			  if((battleviewpanel.getTheattacker().getUnits().isEmpty())) {
				  System.out.println(battleviewpanel.getThedefender().getCurrentLocation());
				  JOptionPane.showMessageDialog(null, "YOU LOST", "LOST", JOptionPane.INFORMATION_MESSAGE, null);
				  frame.getContentPane().removeAll();
					
					frame.getContentPane().add(constants,BorderLayout.NORTH);
					
					 frame.getContentPane().add(world.getWorldpanel());
				
					 
					
				world.setVisible(true);
					 frame.setVisible(true);
					 frame.revalidate();
					 frame.repaint();
				  
			  }
			  
		  
	}
	
   if (e.getActionCommand().equals("Unit0") || e.getActionCommand().equals("Unit1") || e.getActionCommand().equals("Unit2") || e.getActionCommand().equals("Unit3") 
		   || e.getActionCommand().equals("Unit4")  || e.getActionCommand().equals("Unit5")  || e.getActionCommand().equals("Unit6") || e.getActionCommand().equals("Unit7")
		   || e.getActionCommand().equals("Unit8") || e.getActionCommand().equals("Unit9")  ) {
	  
	   
	   
	   int relocateornot=(int)JOptionPane.showInternalConfirmDialog(null, "Do you want to relocate this unit", "Relocate", JOptionPane.YES_NO_OPTION);
	   //System.out.println(relocateornot);
	   if (relocateornot==0) {
		   
	   
	   int index=-1;
	   System.out.println(theunitsbuttons.size());
	   //System.out.println(theunitsbuttons.size());
	   
	 
	   String [] idlearmies= new String[250];
	   //rarecase
	   
	   for (int i=0; i<getidlearmies().size(); i++) {
		   idlearmies[i]="IdleArmy"+i;
		  
	   }
	   String []  cityarmies= new String[3];
	 for(int l=0; l<game.getPlayer().getControlledCities().size();l++) {
		 cityarmies[l]=game.getPlayer().getControlledCities().get(l).getName()+ "Defending Army"; 
	 }
	 for (JButton b: defendingArmy.getButtonslist()) {
		 
	    	if (e.getSource().equals(b)) {
	    		//System.out.println(b);
		   index=defendingArmy.getButtonslist().indexOf(b);
		   //theunitsbuttons.remove(b);
		   //theunitsbuttons.add(b);
		   break;
	    	}  
	   }
	 Unit u=null;
	 System.out.println("trial");
	 for (Unit x: defendingArmy.getUnitbuttonslist()) {
		 System.out.println("unit ");
		 System.out.println(x);
	 }
	 System.out.println("end");
	if (index!=-1) {
	  u=defendingArmy.getUnitbuttonslist().get(index);
	  //theunits.remove(u);
	  // theunits.add(u);
	  //System.out.println(u);
	}
	 else {
		 for (JButton b: idlearmiesview.getAbuts()) {
			 if (e.getSource().equals(b))
				 index=idlearmiesview.getAbuts().indexOf(b);
		 }
		u=idlearmiesview.getUnitsofidle().get(index);
		}
	//System.out.println("index "+ index);
	  // Unit u=theunits.get(index);
	  // System.out.println(u);
	 String[] type= {"Idle Armies", "City Defending Armies"};
	 String armytype=(String)JOptionPane.showInputDialog(null, "Choose where to relocate", "", JOptionPane.QUESTION_MESSAGE, null, type, type[0]);
	 //army0
	 //army1
	 //army2
	 if (armytype.equals("Idle Armies") ) {
	 String selectedone=(String)JOptionPane.showInputDialog(null, "Choose an Army to relocate in ", "", JOptionPane.QUESTION_MESSAGE, null, idlearmies, idlearmies[0]);
	  int indexofarmy=0;
		 for (int i=0; i<idlearmies.length;i++) {
		    	if (idlearmies[i].equals(selectedone)) {
		    		indexofarmy=i;
		    		break;
		    	}
		    }
		 
		
		Army relocatein= getidlearmies().get(indexofarmy);
		System.out.println(relocatein);
		try {
			System.out.println(city.getDefendingArmy());
			System.out.println(u.getParentArmy());
			
			relocatein.relocateUnit(u);
			
			
			setIdleArmiesView(frame);
			System.out.println(u.getParentArmy());
		} catch (MaxCapacityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
   }
	 if (armytype.equals("City Defending Armies") ) {
		 String selectedone=(String)JOptionPane.showInputDialog(null, "Choose an Army to relocate in ", "", JOptionPane.QUESTION_MESSAGE, null, cityarmies, cityarmies[0]);
		 int indexofarmy=0;
		 for (int i=0; i<cityarmies.length;i++) {
		    	if (cityarmies[i].equals(selectedone)) {
		    		indexofarmy=i;
		    		break;
		    	}
		    }
		City c=game.getPlayer().getControlledCities().get(indexofarmy);
		Army relocatein= c.getDefendingArmy();
		try {
			relocatein.relocateUnit(u);
		} catch (MaxCapacityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   
	   }
   
   
   }
   }
	}
	

	public static void main(String[] args) throws IOException {
		new Controller();
	}
}