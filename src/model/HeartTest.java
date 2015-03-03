package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeartTest {

    private Heart aHeart = Heart.getHeartInstance();

    @Test
    public void testSetHeartStatus() throws Exception {
        assertEquals(aHeart.getHeartStatus(), "Normal");
    this.aHeart.setHeartStatus("Problems");
        assertEquals(aHeart.getHeartStatus(), "Problems");
        aHeart.reset();
    }

    @Test
    public void testGetHeartInstance() throws Exception {
            Heart anotherHeart = Heart.getHeartInstance();
        assertEquals(anotherHeart,this.aHeart);
        aHeart.reset();
    }

    @Test
    public void testGetHeartStatus() throws Exception {
        assertEquals(this.aHeart.getHeartStatus(),"Normal");
        aHeart.reset();
    }

    @Test
    public void testGetHeartDisease() throws Exception {
         aHeart.setHeartDisease("bradyarrhythmia");
        assertEquals(aHeart.getHeartDisease(),"bradyarrhythmia");
        aHeart.reset();
    }

    @Test
    public void testIncreaseHeartRate() throws Exception {
        int previousHeartBeat = aHeart.getHeartBeat();
        aHeart.increaseHeartRate();
        assertTrue(previousHeartBeat<aHeart.getHeartBeat());
        aHeart.reset();

    }

    @Test
    public void testDecreaseHeartRate() throws Exception {
        int previousHeartBeat = aHeart.getHeartBeat();
        aHeart.decreaseHeartRate();
        assertTrue(previousHeartBeat>aHeart.getHeartBeat());
        aHeart.reset();
    }

    @Test
    public void testReset() throws Exception {
        aHeart.reset();
        assertEquals(aHeart.getHeartBeat(),67);
    }
}