package model;

public class Pacemaker {

    private static Pacemaker INSTANCE = new Pacemaker();
    private int batteryLife;
    private String status;

    private Pacemaker()
    {	
    	status = "Not Active";
    	batteryLife=100;
    }

    public int getBatteryLife() {
    	return batteryLife;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void changeStatus() {
    	if(status.compareTo("Active")==0) {
    		status = "Not Active";
    	}
    	else {
    		status = "Active";
    	}
    }
    
    public void changeBatteryLife() {
    	batteryLife --;
    }
    
    public static Pacemaker getInstance()
    {
        return INSTANCE;
    }
}
