package model;

import java.util.ArrayList;

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
     * set the heart Status
     */
    public void setHeartStatus(String Status);

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

    /**
     *
     * @return list of diseases
     */
    public ArrayList<String> getDiseases();

}