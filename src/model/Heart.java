package model;


import java.util.ArrayList;
import java.util.Random;

public final class Heart implements HeartInterface {
    private int heartbeat;
    private String heartStatus;
    private String naturalStatus;
    //Sinoatrical
    private boolean SA;
    //Atrioventricular
    private boolean AV;
    private int SA_delay;
    private int AV_delay;
    private String currentDisease;
    private ArrayList<String> diseases;


    private static Heart INSTANCE = new Heart();


    @Override
    public void setHeartStatus(String status) {
        if (status == null)
            throw new NullPointerException("Null heart status input");
        else if (status.equals(""))
            this.heartStatus = "Normal";
        else
            this.heartStatus = status;
    }

    private Heart() {
        this.SA_delay = 500;
        this.AV_delay = 500;
        this.currentDisease = "None";

        this.naturalStatus = "Normal";
        this.SA = true;
        this.AV = true;
        this.heartbeat = 67;
        this.heartStatus = "Normal";
        this.diseases = new ArrayList<String>();
        diseases.add("Sinus Bradycardia");
        diseases.add("Sinoatrical block");
        diseases.add("Heart failure");
        diseases.add("None");
    }

    public static Heart getHeartInstance() {
        return INSTANCE;
    }

    @Override
    public int getHeartBeat() {
        return this.heartbeat;
    }

    @Override
    public String getHeartStatus() {
        return this.heartStatus;
    }

    @Override
    public String getHeartDisease() {
        return this.currentDisease;
    }

    @Override
    public void setHeartDisease(String aDisease) {
        if (aDisease == null)
            throw new NullPointerException("Null disease input");
        if (aDisease == "")
            this.currentDisease = "None";
        else
            this.currentDisease = aDisease;

        this.applyDiseaseEffects();

    }

    @Override
    public void increaseHeartRate() {
        if (this.heartbeat < 120)
            this.heartbeat++;
        this.updateStatus();
    }


    @Override
    public void decreaseHeartRate() {
        if (this.heartbeat > 0)
            this.heartbeat--;
        this.updateStatus();
    }

    @Override
    public String toString() {
        return "Heart{" +
                "heartbeat=" + heartbeat +
                ", heartStatus='" + heartStatus + '\'' +
                ", SA=" + SA +
                ", AV=" + AV +
                ", currentDisease='" + currentDisease + '\'' +
                '}';
    }

    @Override
    public void reset() {
        this.SA_delay = 500;
        this.AV_delay = 500;
        this.currentDisease = "None";
        this.naturalStatus = "Normal";
        this.SA = true;
        this.AV = true;
        this.heartbeat = 67;
        this.heartStatus = "Normal";
    }

    private void applyDiseaseEffects() {
        if (this.currentDisease.equals("Sinus Bradycardia")) {
            this.SA= true;
            this.AV =false;
            Random heartBeatLow = new Random();
            this.heartbeat = heartBeatLow.nextInt(25)+25;
        } else if (this.currentDisease.equals("Sinoatrical block")) {
            this.SA = true;
            this.AV = false;
            Random delay = new Random();
            this.setAV_delay(delay.nextInt(1500)+500);
            this.setHeartBeat((57*60)/(60+this.getAV_delay()/100));
        } else if (this.currentDisease.equals("Heart failure")){
            this.SA = false;
            Random delay = new Random();
            this.setAV_delay(delay.nextInt(2000)+500);
            this.setSA_delay(delay.nextInt(2000)+500);
            this.setHeartBeat((48*60)/(60+this.getAV_delay()/100+this.getSA_delay()/100));
        } else if (this.currentDisease.equals("None")){
            this.SA = true;
            this.AV = true;
            this.setAV_delay(500);
            this.setSA_delay(500);
            this.setHeartBeat(67);
        }
          else {
            throw new IllegalArgumentException("Disease not recognised");
        }
        this.updateStatus();
    }

    public ArrayList<String> getDiseases() {
        ArrayList<String> copyOfDiseases = new ArrayList<String>(this.diseases);
        return copyOfDiseases;
    }

    private void updateStatus() {
        if (this.heartbeat < 50 && this.heartbeat >= 30) {
            this.setHeartStatus("Slower than normal");
        } else if (this.heartbeat < 30) {
            this.setHeartStatus("Too slow needs urgent help!");
        } else if (this.heartbeat > 80 && this.heartbeat < 110) {
            this.setHeartStatus("Faster than normal");
        } else if (this.heartbeat >= 110) {
            this.setHeartStatus("Too fast needs urgent help!");
        } else {
            this.setHeartStatus("Normal");
        }

    }

    public boolean isSA() {
        return SA;
    }

    public void setSA(boolean SA) {
        this.SA = SA;
    }

    public int getSA_delay() {
        return SA_delay;
    }

    public void setSA_delay(int SA_delay) {
        this.SA_delay = SA_delay;
    }

    public boolean isAV() {
        return AV;
    }

    public void setAV(boolean AV) {
        this.AV = AV;
    }

    public int getAV_delay() {
        return AV_delay;
    }

    public void setAV_delay(int AV_delay) {
        this.AV_delay = AV_delay;
    }

    public String getNaturalStatus() { return naturalStatus;}

    public void setNaturalStatus(String naturalStatus) { this.naturalStatus = naturalStatus;}

    protected void setHeartBeat(int beat)
    {
        this.heartbeat = beat;
    }
}