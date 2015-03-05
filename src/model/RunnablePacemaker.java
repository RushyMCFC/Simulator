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

        if(!h.isSA() && p.getMode().equals("VDD"))
        {
            this.h.setSA(true);
            this.h.setAV(true);
            h.setAV_delay(500);
            this.setPace(68);

        }
        else  if ((h.getHeartDisease().equals("Sinus Bradycardia")||h.getHeartDisease().equals("None"))&&p.getMode().equals("DOO"))
        {
            if(h.getHeartBeat()<60){
                while(h.getHeartBeat()<68){
                    h.increaseHeartRate();
                    try {
                        Thread.sleep(500);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

                if(h.getHeartBeat()>68&&h.getHeartDisease().equals("Sinus Bradycardia")){
                    while(h.getHeartBeat()>60)
                    {
                        h.decreaseHeartRate();
                        try {
                            Thread.sleep(500);                 //1000 milliseconds is one second.
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }

                }}
        }
    }

    private void setPace(int frequency)
    {
        while(this.h.getHeartBeat()>=frequency+5 || this.h.getHeartBeat()<=frequency-5)
        {
            if(this.h.getHeartBeat()>=frequency+5 )
            {
                h.decreaseHeartRate();
            }
            else
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


}