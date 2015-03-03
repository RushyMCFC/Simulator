package model;

public final class Heart implements HeartInterface {
    private int heartbeat;
    private String heartStatus;
    private Disease heartDisease;



    private static Heart INSTANCE = new Heart();

    private Heart()
    {
        this.heartbeat= 67;
        this.heartStatus= "Normal";
        this.heartDisease = new Disease();
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
    public Disease getHeartDisease() {
        return this.heartDisease;

    }

    @Override
    public void setHeartDisease(Disease aDisease) {
        if (aDisease == null)
            throw new NullPointerException("Null disease input");
        else
            this.heartDisease = aDisease;

    }

    @Override
    public String toString() {
        return "Heart{" +
                "heartbeat=" + heartbeat +
                ", heartStatus='" + heartStatus + '\'' +
                ", heartDisease=" + heartDisease +
                '}';
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heart)) return false;

        Heart heart = (Heart) o;

        if (heartbeat != heart.heartbeat) return false;
        if (!heartDisease.equals(heart.heartDisease)) return false;
        if (!heartStatus.equals(heart.heartStatus)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = heartbeat;
        result = 31 * result + heartStatus.hashCode();
        result = 31 * result + heartDisease.hashCode();
        return result;
    }
    @Override
    public void reset() {
        INSTANCE = new Heart();
    }
}