package model;

public interface HeartInterface {

    /**
     *
     * @return heart beat
     */
    public int getHeartBeat();

    /**
     *
     * @return heart status
     */
    public String getHeartStatus();

    /**
     *
     * @return heart disease
     */
    public String getHeartDisease();

    /**
     * Add a disease to the heart
     * @param aDisease
     */
    public void setHeartDisease(String aDisease);

    /**
     * increases heart rate by 1
     */
    public void increaseHeartRate();

    /**
     * decreases heart rate by 1
     */
    public void decreaseHeartRate();

    /**
     * reset the state of the heart
     */
    public void reset();
}