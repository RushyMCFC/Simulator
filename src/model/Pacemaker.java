package model;

import java.util.ArrayList;

public class Pacemaker implements PacemakerInterface {

    private static Pacemaker INSTANCE = new Pacemaker();
    private int batteryLife;
    private String mode;
    private ArrayList<String> modes;
    private String status;

    private Pacemaker()
    {
        modes = new ArrayList<String>();
        modes.add("DOO");
        modes.add("VDD");
        modes.add("AAI");
    	status = "Not Active";
    	batteryLife=100;
    }

    public int getBatteryLife() {
    	return batteryLife;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void setStatus() {
    	if(status.equals("Active")) {
    		this.status = "Not Active";
    	}
    	else {
    		this.status = "Active";
    	}
    }
    
    public void changeBatteryLife() {
    	batteryLife --;
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

}
