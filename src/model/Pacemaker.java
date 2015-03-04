package model;

public class Pacemaker {

    private static Pacemaker INSTANCE = new Pacemaker();
    private int batteryLife;
    private String status;

    private Pacemaker()
    {	
    	status = "Active";
    	batteryLife=100;
    }

    public int getBatteryLife() {
    	return batteryLife;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public static Pacemaker getInstance()
    {
        return INSTANCE;
    }
}
