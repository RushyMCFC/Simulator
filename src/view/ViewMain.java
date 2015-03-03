package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Disease;
import model.Heart;
import model.HeartInterface;


public class ViewMain extends JFrame {
	Heart obj = Heart.getHeartInstance();
	//define
	JPanel jp1,jp2, jp3,jp4,jp5,jp6,jp7,jp8;
    JButton jb1,jb2,jb3,jb4,jb5;
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8;
    JTextField jtf1;
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
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel(new GridLayout(4,1));
		jp5=new JPanel();
		jlb1=new JLabel("Actions");
		jb1 =new JButton ("Detach pacemaker");
		jb2 =new JButton ("Empty battery");
		jlb2=new JLabel("heart beat rate");
		jb3 =new JButton ("up");
		jb4 =new JButton ("down");
		jlb3=new JLabel("add heart disease");
		jtf1=new JTextField(15);
		String []ntl={"heart fault","aaa","bbb"};
		jcb1=new JComboBox(ntl);
		jlb4=new JLabel("Heart details");
		jlb5=new JLabel("Pacemaker Details");
		jlb6=new JLabel("Output");
		jlb7=new JLabel("Disease not found");
		jlb8=new JLabel("Image");
		jssp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp4,jp1);
		jssp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jssp,jp5);
		jssp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,jssp1,jp3);
		
		//Adding Heart Details
		refreshHeartRate();
		
		//Increasing and Decreasing Heart Rate
		jb3.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                obj.increaseHeartRate();
                jp4.removeAll();
                refreshHeartRate();
                validate();
            }
        });  
		jb4.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                obj.decreaseHeartRate();
                jp4.removeAll();
                refreshHeartRate();
                validate();
            }
        });  
		
		//add accessory
		this.add(jssp2);
		jp1.add(jlb1);
		jp1.add(jb1);
		jp1.add(jb2);
		
		jp1.add(jlb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(jlb3);
		jp1.add(jtf1);
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
		Disease disease = obj.getHeartDisease();
		JLabel hBeat = new JLabel("Heart beat rate : "+totalBeats+"/min");
		JLabel hStatus = new JLabel("Heart Status : "+status);
		JLabel hDisease = new JLabel("Heart Disease : "+disease);
		jp4.add(jlb4);
		jp4.add(hBeat);
		jp4.add(hStatus);
		jp4.add(hDisease);
	}

}