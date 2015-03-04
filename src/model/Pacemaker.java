package model;

public class Pacemaker implements PacemakerInterface {

    private static Pacemaker INSTANCE = new Pacemaker();
    private int batteryLife;
    private String mode;

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
    
    public void setStatus(String status) {
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
}
