package model;


import java.util.Random;

public final class Heart implements HeartInterface {
    private int heartbeat;
    private String heartStatus;
    //Sinoatrical
    private boolean SA;
    //Atrioventricular
    private boolean AV;
    private String currentDisease;




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
    }



    @Override
    public void decreaseHeartRate() {
        if(this.heartbeat>0)
        this.heartbeat--;
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
        INSTANCE = new Heart();
    }

    private void applyDiseaseEffects()
    {
        if(this.currentDisease.equals("bradyarrhythmia"))
        {
            Random heartBeatLow = new Random();
            this.heartbeat= heartBeatLow.nextInt(50);
        }
        if(this.currentDisease.equals("tachyarrhythmia"))
        {
            Random heartBeatLow = new Random();
            this.heartbeat= heartBeatLow.nextInt(25) + 100;
        }
        if(this.currentDisease.equals("sinoatrical block"))
        {
            this.AV = false;
        }
        else
        {
            throw new IllegalArgumentException("Disease not recognised");
        }
    }
}