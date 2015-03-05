package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import model.Heart;
import model.MyThreadStart;
import model.Outputs;
import model.Pacemaker;
import model.RunnablePacemaker;


public class ViewMain extends JFrame {
	Heart obj = Heart.getHeartInstance();
	Pacemaker obj2 = Pacemaker.getInstance();
	//define
	JPanel actionPanel,jp2, jp3,heartDetailsPanel,pacemakerPanel,jp6,jp7,jp8;
    JButton detachPacemakerButton,emptyBatteryButton,upButton,downButton,jb5;
    JLabel actionLabel,heartbeatLabel,heartDiseaseLabel,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10;
    JTextField heartDiseaseText;
    JScrollPane jsp1;
    JList jlist;
    JSplitPane jssp,jssp1,jssp2;
    
    JPanel pacemakerModePanel,heartDiseasePanel,dp_eb,up_down;
    String rBattery = "";
    
	Outputs t=new Outputs();
	private static ViewMain a= new ViewMain();
	private ViewMain(){};
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub		
		a.Start();
		//Testing
		MyThreadStart obj2 = new MyThreadStart();
		 JLabel htime = new JLabel(new Date().toString());
	}
	public static ViewMain getInstance()
	{
		return a;
	}
	//function
	public void Start() throws InterruptedException {
		// create accessory
		actionPanel=new JPanel(new GridLayout(5,1));
		jp2=new JPanel();
		jp3=new JPanel();
        jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));
		heartDetailsPanel=new JPanel(new GridLayout(5,1));
		pacemakerPanel=new JPanel(new GridLayout(5,1));
		
		actionLabel=new JLabel("Actions");
		detachPacemakerButton =new JButton ("Attach / Detach pacemaker");
		emptyBatteryButton =new JButton ("Battery Failure");
		dp_eb = new JPanel();
		dp_eb.add(detachPacemakerButton);
		dp_eb.add(emptyBatteryButton);
		
		heartbeatLabel=new JLabel("heart beat rate");
		upButton =new JButton ("up");
		downButton =new JButton ("down");
		up_down = new JPanel();
		up_down.add(heartbeatLabel);
		up_down.add(upButton);
		up_down.add(downButton);
		
		heartDiseaseLabel=new JLabel("Select Heart Disease : ");
		heartDiseasePanel = new JPanel();
		ArrayList<String> diseasesList = obj.getDiseases();
		String allDiseases[] = diseasesList.toArray(new String[diseasesList.size()]);
		final JComboBox<String> heartDiseaseOptions = new JComboBox<String>(allDiseases);
		JButton heartDiseaseButton = new JButton("OK");
		heartDiseasePanel.add(heartDiseaseLabel);
		heartDiseasePanel.add(heartDiseaseOptions);
		heartDiseasePanel.add(heartDiseaseButton);
		
		JLabel pacemakerModeLabel = new JLabel("Select Pacemaker Mode : ");
		pacemakerModePanel = new JPanel();
		ArrayList<String> am = obj2.getModes();
		String allModes[] = am.toArray(new String[am.size()]);
		final JComboBox<String> pacemakerModeOptions = new JComboBox<String>(allModes);
		JButton pacemakerModeButton = new JButton("OK");
		pacemakerModePanel.add(pacemakerModeLabel);
		pacemakerModePanel.add(pacemakerModeOptions);
		pacemakerModePanel.add(pacemakerModeButton);
		
		jlb4=new JLabel("Heart Details");
		jlb5=new JLabel("Pacemaker Details");
		jlb6=new JLabel("Output");
	//	jlb7=new JLabel(diseaseName);
		jlb8=new JLabel("Image");
		jssp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,heartDetailsPanel,actionPanel);
		jssp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jssp,pacemakerPanel);
		jssp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,jssp1,jp3);
		
		//Adding Heart Details
		refreshHeartRate();
		refreshPacemaker();
		
		//Increasing and Decreasing Heart Rate
		upButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {edge();
                //Execute when button is pressed
            	 JLabel htime = new JLabel(new Date().toString());
            	 jp3.add(htime);
            	 obj.increaseHeartRate();
                 heartDetailsPanel.removeAll();
            
              
                jlb9=new JLabel("Current heart rate +1");
                jp3.add(jlb9);  
                refreshHeartRate();
                validate();
           
            }
        });  
		
		downButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {      
            	edge();
            	JLabel htime = new JLabel(new Date().toString());
            	jp3.add(htime);
                //Execute when button is pressed
                obj.decreaseHeartRate();
                heartDetailsPanel.removeAll();
               
               
          
                jlb10=new JLabel("Current heart rate -1");
                
                jp3.add(jlb10);
                refreshHeartRate();
                validate();
            }
        });  
		
		heartDiseaseButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {edge();
                //Execute when button is pressed
            	String diseaseName = heartDiseaseOptions.getSelectedItem().toString();
                obj.setHeartDisease(diseaseName);
             
                heartDetailsPanel.removeAll();
             
                JLabel htime = new JLabel(new Date().toString());
                jlb7=new JLabel("Current disease is"+ diseaseName);
                jp3.add(htime);
                jp3.add(jlb7);
                heartDetailsPanel.removeAll();
                refreshHeartRate();
                validate();
            }
        });
		
		detachPacemakerButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {      edge(); 
            	obj2.setStatus();
            	addPanels();
            	deletePacemakerDetails();
            }
        });  
		
		pacemakerModeButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {      
            	obj2.setMode(pacemakerModeOptions.getSelectedItem().toString());
            	deletePacemakerDetails();
            	deleteRate();
            }
        }); 
		emptyBatteryButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {    int i;  
            	edge();
            	JLabel htime = new JLabel(new Date().toString());
            	jp3.add(htime);
            	JLabel failBattery=new JLabel("battery fail");
            	jp3.add(failBattery);
                //Execute when button is pressed
            	
            	deletePacemakerDetails();
            	
            	obj2.changeFail();
            }
        });  
		
		//add accessory
		this.add(jssp2);
		
		addPanels();
		
		jp2.add(jlb8);
		jp3.add(jlb6);
		//jp3.add(jlb7);
		//jp4.add(jlb4);
		//this.add (jp1,BorderLayout.NORTH);
//	this.add (jp2,BorderLayout.CENTER);
	//	this.add (jp3,BorderLayout.SOUTH);
	//	this.add (jp4,BorderLayout.WEST);
	//	this.add (jp5,BorderLayout.EAST);
	//this.add (jp5,BorderLayout.SOUTH);
	//	this.add (jp6,BorderLayout.CENTER);
	  //  this.add (jp7,BorderLayout.EAST);
	//this.add (jp8,BorderLayout.WEST);
		
		//this.add(jp1,BorderLayout.NORTH);
		//this.add(jp2,BorderLayout.SOUTH);
	//	this.add(jp3,BorderLayout.CENTER);
	//	this.add(jp4,BorderLayout.WEST);
	 //   this.add(jp5,BorderLayout.EAST);
		 //DEFINE PROPERTIES
		this.setTitle("Pacemaker simulator");
		this.setLocation(200,200);
	
		//size
		this.setSize(1000, 1000);
	
		this.setVisible(true);
		
	}
	
	
	private void refreshHeartRate()
	{
		int totalBeats = obj.getHeartBeat();
		String status = obj.getHeartStatus();
		String disease = obj.getHeartDisease();
		String naturalStatus = obj.getNaturalStatus();
		JLabel hBeat = new JLabel("Heart beat rate : "+totalBeats+"/min");
		JLabel hStatus = new JLabel("Heart Status : "+status);
		JLabel hDisease = new JLabel("Heart Disease : "+disease);
		JLabel nStatus = new JLabel("Natural Pacemaker Status : "+naturalStatus);
       // JLabel htime = new JLabel(new Date().toString());
        heartDetailsPanel.add(jlb4);
		heartDetailsPanel.add(hBeat);
		heartDetailsPanel.add(hStatus);
		heartDetailsPanel.add(hDisease);
		heartDetailsPanel.add(nStatus);
		//jp3.add(htime);
	}
	
	public void refreshPacemaker() {
		String status = obj2.getStatus();
		int batteryLife = obj2.getBatteryLife();
		String cMode = obj2.getMode();
		JLabel pStatus = new JLabel("Pacemaker Status : "+status);
		if(obj2.getBatteryLife() > 0) {
			rBattery = "";
		}
		else {
			rBattery = "Battery on Reserve (5 hours left)";
		}
		JLabel pBatteryLife = new JLabel("Battery Life : "+batteryLife+"% "+rBattery);
		JLabel currentMode = new JLabel("Current Mode : "+cMode);
		JLabel modeDetails = new JLabel("Details : "+obj2.getModeDetails());
		pacemakerPanel.add(jlb5);
		pacemakerPanel.add(pStatus);
		pacemakerPanel.add(pBatteryLife);
		pacemakerPanel.add(currentMode);
		pacemakerPanel.add(modeDetails);
	}
	
	
	
	
	
	public void deleteRate() {
		heartDetailsPanel.removeAll();
		refreshHeartRate();
		validate();
	}
	
	public void deletePacemakerDetails() {
		pacemakerPanel.removeAll();
		refreshPacemaker();
		validate();
	}
	
	private void edge()
	{
		if(jp3.getComponentCount()>=20)
   	 {
   		 jp3.remove(1);
   		 jp3.remove(1);
   	 }
	}
	
	private void addPanels() {
		
		actionPanel.removeAll();
		
		actionPanel.add(actionLabel);
		
		actionPanel.add(dp_eb);
		
		actionPanel.add(up_down);
		
		actionPanel.add(heartDiseasePanel);
		
		if(obj2.getStatus().toString().equals("Active"))
			actionPanel.add(pacemakerModePanel);
		else {
			JPanel empty = new JPanel();
			actionPanel.add(empty);
		}
		
		actionPanel.validate();
	}

}