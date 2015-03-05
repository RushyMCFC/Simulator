package model;

import view.ViewMain;

public class RunnablePacemaker implements Runnable {

    private PacemakerInterface p = Pacemaker.getInstance();
    private HeartInterface h = Heart.getHeartInstance();
    boolean flag = true;

    @Override
    public void run() {
        ViewMain vm = ViewMain.getInstance();
        vm.deletePacemakerDetails();
        while(true){
            this.runMode();
        }
    }

    private void runMode()
    {

        if(p.getMode().equals("VDD"))
        {
            this.h.setSA(true);
            this.h.setAV(true);
            h.setAV_delay(500);
            this.setPace(68);

        }
        else  if (((h.getHeartDisease().equals("Sinus Bradycardia")||h.getHeartDisease().equals("None")))&&p.getMode().equals("DOO"))
        {
            if(h.getHeartBeat()<55)
                this.setPace(68);
        }
        else if (p.getMode().equals("AAI") && !h.isSA())
        {
            h.setSA_delay(500);
            this.setPace(65);
        }
    }

    private void setPace(int frequency)
    {
            if(this.h.getHeartBeat()>=frequency+5 )
            {
                h.decreaseHeartRate();
            }
            else if (this.h.getHeartBeat()<=frequency-5)
            {
                h.increaseHeartRate();
            }
            try {
                Thread.sleep(500);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

    }


}