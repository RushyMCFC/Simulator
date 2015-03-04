package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunnablePacemakerTest {


    private HeartInterface h = Heart.getHeartInstance();
    private PacemakerInterface p = Pacemaker.getInstance();
    private RunnablePacemaker rp = new RunnablePacemaker();
    @Test
    public void testRun() throws Exception {

        p.setMode("DOO");
        rp.run();
        System.out.println(h.getHeartBeat());
    }
}