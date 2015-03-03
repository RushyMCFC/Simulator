package model;


import java.util.ArrayList;
import java.util.Random;

public final class Heart implements HeartInterface {
    private int heartbeat;
    private String heartStatus;
    //Sinoatrical
    private boolean SA;
    //Atrioventricular
    private boolean AV;
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

    private Heart()
    {
        this.currentDisease = "None";
        this.SA = true;
        this.AV = true;
        this.heartbeat= 67;
        this.heartStatus= "Normal";
        this.diseases = new ArrayList<String>();
        diseases.add("arrhythmia");
        diseases.add("bradyarrhythmia");
        diseases.add("bradyarrhythmia");
        diseases.add("tachyarrhythmia");
    }

    public static Heart getHeartInstance()
    {
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
    public String getHeartDisease() {return this.currentDisease; }

    @Override
    public void setHeartDisease(String aDisease) {
        if (aDisease == null)
            throw new NullPointerException("Null disease input");
        if(aDisease == "")
            this.currentDisease= "None";
        else
            this.currentDisease = aDisease;

        this.applyDiseaseEffects();

    }

    @Override
    public void increaseHeartRate() {
        if(this.heartbeat<120)
        this.heartbeat++;
        this.updateStatus();
    }



    @Override
    public void decreaseHeartRate() {
        if(this.heartbeat>0)
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
    public void reset(){ INSTANCE = new Heart();
    }

    private void applyDiseaseEffects()
    {
        if(this.currentDisease.equals("bradyarrhythmia"))
        {
            Random heartBeatLow = new Random();
            this.heartbeat= heartBeatLow.nextInt(50);
        }
        else if(this.currentDisease.equals("tachyarrhythmia"))
        {
            Random heartBeatLow = new Random();
            this.heartbeat= heartBeatLow.nextInt(25) + 100;
        }
        else if(this.currentDisease.equals("sinoatrical block"))
        {
            this.AV = false;
        }
        else
        {
            throw new IllegalArgumentException("Disease not recognised");
        }
        this.updateStatus();
    }
    public ArrayList<String> getDiseases()
    {
         ArrayList<String> copyOfDiseases = new ArrayList<String>(this.diseases);
        return copyOfDiseases;
    }
    private void updateStatus()
    {
       if (this.heartbeat<50 && this.heartbeat>=25)
       {
           this.setHeartStatus("Slower than normal");
       }
       else if (this.heartbeat<25)
       {
           this.setHeartStatus("Too slow needs urgent help!");
       }
       else if (this.heartbeat>100 && this.heartbeat<120)
       {
           this.setHeartStatus("Faster than normal");
       }
       else if (this.heartbeat>=120)
       {
           this.setHeartStatus("Too fast needs urgent help!");
       }
       else
       {
           this.setHeartStatus("Normal");
       }

    }
}