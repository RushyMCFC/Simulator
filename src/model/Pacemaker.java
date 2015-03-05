package model;

import java.util.ArrayList;

public class Pacemaker implements PacemakerInterface {

    private static Pacemaker INSTANCE = new Pacemaker();
    private Heart h = Heart.getHeartInstance();
    private int batteryLife;
    private String mode;
    private ArrayList<String> modes;
    private String status;
    private boolean flagFail = true;
private String status1;
    private Pacemaker()
    {
        this.modes = new ArrayList<String>();
        this.modes.add("DOO");
        this.modes.add("VDD");
        this.modes.add("AAI");
        this.modes.add("None");
    	this.status = "Not Active";
        this.mode = "None";
    	this.batteryLife=100;
    	this.status1 = "Not Active";
    }

    public int getBatteryLife() {
    	return batteryLife;
    }
    public String getfailStatus(){
    	return this.status1;
    }
    public String getStatus() {
    	return status;
    }
    
    public void setStatus() {
    	if(status.equals("Active")) {
    		this.status = "Not Active";
    		this.mode = "None";
    	}
    	else {
    		this.status = "Active";
    	}
    }

    
    public static Pacemaker getInstance()
    {
        return INSTANCE;
    }
    @Override
    public String getMode() {
        return this.mode;
    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
        this.h.applyHeartDefects();
    }

    @Override
    public void setBatterLife(int life) {
        this.batteryLife = life;
    }

    public ArrayList<String> getModes()
    {
        ArrayList<String> copyOfModes = new ArrayList<String>(this.modes);
        return copyOfModes;
    }

	public String getModeDetails() {
		String details = "";
		
		if(this.mode.equals("None"))
			details = "None";
		else if(this.mode.equals("DOO"))
			details = "Asynchronous Pacing & No Actual Contraction";
		else if(this.mode.equals("VDD"))
			details = "Paces the Ventricle, Sensing both Atrium and Ventricle & triggering a response";
		else if(this.mode.equals("AAI"))
			details = "Paces and Senses the Atrium, if sensing an atrial contraction it inhibits the atrial pace";
		
		return details;
	}
	public void decreaseBatteryLife()
	{
		if(this.batteryLife>0)
			this.batteryLife--;
	}
	
    public void changeFail() {
    	if(this.flagFail == true) {
    		this.flagFail = false;
    	}
    	else {
    		this.flagFail = true;
    	}
    }
    
    public boolean getFailFlag() {
    	return this.flagFail;
    }

}
