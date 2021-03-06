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

    /**
     *
     * @return true if the sinoatrical is working
     */
    public boolean isSA();

    /**
     * sets the status of sinoatrical
     * @param SA
     */
    public void setSA(boolean SA);

    /**
     *
     * @return the delay of SA contraction
     */
    public int getSA_delay();

    /**
     * sets the delay of the SA contraction
     * @param SA_delay
     */
    public void setSA_delay(int SA_delay);

    /**
     *
     * @return the status of the Atrioventricular
     */
    public boolean isAV();

    /**
     * Sets the atrioventricular status
     * @param AV
     */
    public void setAV(boolean AV);

    /**
     * returns the AV contraction delay
     * @return
     */
    public int getAV_delay();

    /**
     * Sets the AV contraction delay
     * @param AV_delay
     */
    public void setAV_delay(int AV_delay);


    /**
     *
     * @return the heart's natural pacemaker status
     */
    public String getNaturalStatus();

    /**
     * Set the natural pacemaker's status
     * @param naturalStatus
     */
    public void setNaturalStatus(String naturalStatus);

    public void setHeartRate(int rate);

}