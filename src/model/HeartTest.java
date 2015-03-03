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
    }

    @Test
    public void testGetHeartInstance() throws Exception {
            Heart anotherHeart = Heart.getHeartInstance();
        assertEquals(anotherHeart,this.aHeart);
    }

    @Test
    public void testGetHeartStatus() throws Exception {
        assertEquals(this.aHeart.getHeartStatus(),"Problems");
    }

    @Test
    public void testGetHeartDisease() throws Exception {
         aHeart.setHeartDisease("bradyarrhythmia");
        assertEquals(aHeart.getHeartDisease(),"bradyarrhythmia");
    }

    @Test
    public void testIncreaseHeartRate() throws Exception {
        int previousHeartBeat = aHeart.getHeartBeat();
        aHeart.increaseHeartRate();
        assertTrue(previousHeartBeat<aHeart.getHeartBeat());

    }

    @Test
    public void testDecreaseHeartRate() throws Exception {
        int previousHeartBeat = aHeart.getHeartBeat();
        aHeart.decreaseHeartRate();
        assertTrue(previousHeartBeat>aHeart.getHeartBeat());
    }

    @Test
    public void testReset() throws Exception {
        aHeart.reset();
        System.out.print(aHeart);
        //assertEquals(aHeart.getHeartBeat(),67);
    }
}