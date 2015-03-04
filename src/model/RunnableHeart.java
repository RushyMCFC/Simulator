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
//        public void runHeart() {
//
//            if (this.SA && this.AV) {
//                try {
//                    this.wait(this.SA_delay);
//                    this.SA_state = true;
//                } catch (InterruptedException ex) {
//                    Thread.currentThread().interrupt();
//                }
//                if (this.SA_state) {
//                    try {
//                        this.wait(this.AV_delay);
//                        this.AV_state = true;
//                    } catch (InterruptedException ex) {
//                        Thread.currentThread().interrupt();
//                    }
//                }
//            }
        while(flag) {
            this.regularHeartBeat();
            ViewMain vm = ViewMain.getInstance();
            vm.deleteRate();
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {

            }
        }

    }

    static int incrementCount = 0;
    static int decrementCount = 0;
    private void regularHeartBeat() {

        if ( this.ourHeart.isSA()) {
            if (incrementCount == 3) {
                this.ourHeart.increaseHeartRate();
                this.ourHeart.increaseHeartRate();
                this.ourHeart.increaseHeartRate();
                incrementCount = 0;
            }
            if (decrementCount == 3) {
                this.ourHeart.decreaseHeartRate();
                this.ourHeart.decreaseHeartRate();
                this.ourHeart.decreaseHeartRate();
                decrementCount = 0;
            }

            Random dice = new Random();
            int choice = dice.nextInt(3);
            if (choice < 2) {
                this.ourHeart.increaseHeartRate();
                incrementCount++;
            } else {
                this.ourHeart.decreaseHeartRate();
                decrementCount++;
            }
        }

    }
}
