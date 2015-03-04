package model;

import java.util.Random;
import view.ViewMain;
/**
 * Created by kostas on 04-Mar-15.
 */
public class RunnableHeart implements Runnable {

    private HeartInterface ourHeart = Heart.getHeartInstance();
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            this.runHeart();
            ViewMain vm = ViewMain.getInstance();
            vm.deleteRate();
//            try{
//                Thread.sleep(1000);
//            }
//            catch(InterruptedException ex)
//            {
//                ex.printStackTrace();
//            }
        }

    }

    static int incrementCount = 0;
    static int decrementCount = 0;

    private void regularHeartBeat() {


            if (incrementCount == 3) {
                this.ourHeart.decreaseHeartRate();
                this.ourHeart.decreaseHeartRate();
                this.ourHeart.decreaseHeartRate();
                incrementCount = 0;
            }
            if (decrementCount == 3) {
                this.ourHeart.increaseHeartRate();
                this.ourHeart.increaseHeartRate();
                this.ourHeart.increaseHeartRate();
                decrementCount = 0;
            }

            Random dice = new Random();
            int choice = dice.nextInt(4);
            if (choice < 2) {
                this.ourHeart.increaseHeartRate();
                incrementCount++;
            } else {
                this.ourHeart.decreaseHeartRate();
                decrementCount++;
            }


    }

    public void runHeart() {

        if(!this.ourHeart.isSA())
        {
            this.ourHeart.setHeartStatus("Arrhythmia");
            this.ourHeart.setNaturalStatus("Pacemaker failed to pulse");
        }
        else if (!this.ourHeart.isAV())
        {
           this.ourHeart.setHeartStatus("Arrhythmia");
           this.ourHeart.setNaturalStatus("Sinoatrical Block");
        }
        else
        {
            this.ourHeart.setSA_state(true);
            try {Thread.sleep(ourHeart.getSA_delay());}
            catch(InterruptedException ex){ ex.printStackTrace();}
            this.ourHeart.setSA_state(false);
            this.ourHeart.setAV_state(true);
            try {Thread.sleep(ourHeart.getAV_delay());}
            catch(InterruptedException ex){ ex.printStackTrace();}
            this.ourHeart.setSA_state(false);
            this.regularHeartBeat();
        }
    }
}
