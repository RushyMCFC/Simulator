package model;

import java.util.Random;
import view.ViewMain;
/**
 * Created by kostas on 04-Mar-15.
 */
public class RunnableHeart implements Runnable {

    private Heart ourHeart = Heart.getHeartInstance();
    boolean flag = true;
    private ViewMain vm = ViewMain.getInstance();

    @Override
    public void run() {

        while (flag) {
            this.runHeart();

            vm.deleteRate();
            try{
                Thread.sleep(1500);
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
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
    private void abnormalHeartBeat() {
        Random dice = new Random();
        int choice;

        if (incrementCount == 4) {
           for(int i=0; i<dice.nextInt(7); i++)
               this.ourHeart.decreaseHeartRate();
            incrementCount = 0;
        }
        if (decrementCount == 4) {
            for(int i=0; i<dice.nextInt(7); i++)
                this.ourHeart.increaseHeartRate();
            decrementCount = 0;
        }


        choice = dice.nextInt(10);
        if (choice < 2) {
            this.ourHeart.increaseHeartRate();
            incrementCount++;

        } else if(choice>=2 && choice <5){
            for(int j=0; j<=2; j++)
                this.ourHeart.increaseHeartRate();

            incrementCount++;
        }
        else if(choice>=5 && choice<8)
        {
            for(int j=0; j<=2; j++)
                this.ourHeart.decreaseHeartRate();
            decrementCount++;
        }
        else
        {
            this.ourHeart.decreaseHeartRate();
            decrementCount++;
        }


    }

    public void runHeart() {

        if(!this.ourHeart.isSA())
        {

            this.ourHeart.setNaturalStatus("Pacemaker failed to pulse");
            this.abnormalHeartBeat();
        }
        else if (!this.ourHeart.isAV())
        {

            this.ourHeart.setNaturalStatus("Sinoatrical Block");
            this.regularHeartBeat();

        }
        else
        {

            this.ourHeart.setNaturalStatus("Normal");
            this.regularHeartBeat();
        }
    }
}
