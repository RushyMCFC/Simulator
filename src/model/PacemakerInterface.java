package model;

import java.util.ArrayList;

/**
 * Created by kostas on 04-Mar-15.
 */
public interface PacemakerInterface {

    public String getMode();
    public void setMode(String mode);
    public int getBatteryLife();
    public void setBatterLife(int life);
    public String getStatus();
    public void setStatus();
    public ArrayList<String> getModes();

    }

