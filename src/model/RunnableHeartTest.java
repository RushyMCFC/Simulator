package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunnableHeartTest {

    private Heart test = Heart.getHeartInstance();
    private RunnableHeart RunnableTest = new RunnableHeart();
    @Test
    public void testRunHeart() throws Exception {

        System.out.println("SA: "+test.isSA());
        System.out.println("AV: "+test.isAV());
        System.out.println("SA delay: "+test.getSA_delay());
        System.out.println("AV delay: " + test.getAV_delay());
        System.out.println("Heart beat: " + test.getHeartBeat());
        RunnableTest.runHeart();
        System.out.println("---------------");
        System.out.println("SA: "+test.isSA());
        System.out.println("AV: "+test.isAV());
        System.out.println("SA delay: "+test.getSA_delay());
        System.out.println("AV delay: " + test.getAV_delay());
        System.out.println("Heart beat: " + test.getHeartBeat());

        test.setSA(false);
        RunnableTest.runHeart();

        System.out.println("---------------");
        System.out.println("SA: "+test.isSA());
        System.out.println("AV: "+test.isAV());
        System.out.println("SA delay: "+test.getSA_delay());
        System.out.println("AV delay: " + test.getAV_delay());
        System.out.println("Heart beat: " + test.getHeartBeat());

        test.setSA(true);
        RunnableTest.runHeart();

        System.out.println("---------------");
        System.out.println("SA: "+test.isSA());
        System.out.println("AV: "+test.isAV());
        System.out.println("SA delay: "+test.getSA_delay());
        System.out.println("AV delay: " + test.getAV_delay());
        System.out.println("Heart beat: " + test.getHeartBeat());

        test.setAV(false);
        RunnableTest.runHeart();

        System.out.println("---------------");
        System.out.println("SA: "+test.isSA());
        System.out.println("AV: "+test.isAV());
        System.out.println("SA delay: "+test.getSA_delay());
        System.out.println("AV delay: " + test.getAV_delay());
        System.out.println("Heart beat: " + test.getHeartBeat());

    }
}