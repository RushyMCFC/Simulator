package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.Heart;


public class ViewMain extends JFrame {
	Heart obj = Heart.getHeartInstance();
	//define
	JPanel actionPanel,jp2, jp3,heartDetailsPanel,jp5,jp6,jp7,jp8;
    JButton detachPacemakerButton,emptyBatteryButton,upButton,downButton,jb5;
    JLabel actionLabel,heartbeatLabel,heartDiseaseLabel,jlb4,jlb5,jlb6,jlb7,jlb8;
    JTextField heartDiseaseText;
    JScrollPane jsp1;
    JComboBox jcb1;
    JList jlist;
    JSplitPane jssp,jssp1,jssp2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewMain a=new ViewMain();
	}
	//function
	public ViewMain()
	{
		// create accessory
		actionPanel=new JPanel(new GridLayout(4,1));
		jp2=new JPanel();
		jp3=new JPanel();
		heartDetailsPanel=new JPanel(new GridLayout(4,1));
		jp5=new JPanel();
		
		actionLabel=new JLabel("Actions");
		detachPacemakerButton =new JButton ("Detach pacemaker");
		emptyBatteryButton =new JButton ("Empty battery");
		JPanel dp_eb = new JPanel();
		dp_eb.add(detachPacemakerButton);
		dp_eb.add(emptyBatteryButton);
		
		heartbeatLabel=new JLabel("heart beat rate");
		upButton =new JButton ("up");
		downButton =new JButton ("down");
		JPanel up_down = new JPanel();
		up_down.add(heartbeatLabel);
		up_down.add(upButton);
		up_down.add(downButton);
		
		heartDiseaseLabel=new JLabel("Select Heart Disease : ");
		JPanel heartDiseasePanel = new JPanel();
		ArrayList<String> diseasesList = obj.getDiseases();
		String allDiseases[] = diseasesList.toArray(new String[diseasesList.size()]);
		final JComboBox<String> heartDiseaseOptions = new JComboBox<String>(allDiseases);
		JButton heartDiseaseButton = new JButton("OK");
		heartDiseasePanel.add(heartDiseaseLabel);
		heartDiseasePanel.add(heartDiseaseOptions);
		heartDiseasePanel.add(heartDiseaseButton);
		
		jlb4=new JLabel("Heart Details");
		jlb5=new JLabel("Pacemaker Details");
		jlb6=new JLabel("Output");
		jlb7=new JLabel("Disease not found");
		jlb8=new JLabel("Image");
		jssp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,heartDetailsPanel,actionPanel);
		jssp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jssp,jp5);
		jssp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,jssp1,jp3);
		
		//Adding Heart Details
		refreshHeartRate();
		
		//Increasing and Decreasing Heart Rate
		upButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                obj.increaseHeartRate();
                heartDetailsPanel.removeAll();
                refreshHeartRate();
                validate();
            }
        });  
		
		downButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                obj.decreaseHeartRate();
                heartDetailsPanel.removeAll();
                refreshHeartRate();
                validate();
            }
        });  
		
		heartDiseaseButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	String diseaseName = heartDiseaseOptions.getSelectedItem().toString();
                obj.setHeartDisease(diseaseName);
                heartDetailsPanel.removeAll();
                refreshHeartRate();
                validate();
            }
        });
		
		//add accessory
		this.add(jssp2);
		actionPanel.add(actionLabel);
		
		actionPanel.add(dp_eb);
		//actionPanel.add(jb1);
		//actionPanel.add(jb2);
		
		actionPanel.add(up_down);
		//actionPanel.add(heartbeatLabel);
		//actionPanel.add(upButton);
		///actionPanel.add(downButton);
		
		actionPanel.add(heartDiseasePanel);
		//actionPanel.add(heartDiseaseLabel);
		//actionPanel.add(heartDiseaseText);
		
		jp2.add(jlb8);
		jp3.add(jlb6);
		jp3.add(jlb7);
		//jp4.add(jlb4);
		jp5.add(jlb5);
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
		this.setTitle("Pacemaker simulater");
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
		JLabel hBeat = new JLabel("Heart beat rate : "+totalBeats+"/min");
		JLabel hStatus = new JLabel("Heart Status : "+status);
		JLabel hDisease = new JLabel("Heart Disease : "+disease);
		heartDetailsPanel.add(jlb4);
		heartDetailsPanel.add(hBeat);
		heartDetailsPanel.add(hStatus);
		heartDetailsPanel.add(hDisease);
	}

}