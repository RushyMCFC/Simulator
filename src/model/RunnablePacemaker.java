package model;

import view.ViewMain;

public class RunnablePacemaker implements Runnable {

    private PacemakerInterface p = Pacemaker.getInstance();
    private HeartInterface h = Heart.getHeartInstance();
    boolean flag = true;
    private int count=0;

    @Override
    public void run() {
        ViewMain vm = ViewMain.getInstance();
        while(true){
        	vm.deletePacemakerDetails();
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

                this.setPace(68);
        }
        else if (p.getMode().equals("AAI") && !h.isSA())
        {
            h.setSA_delay(500);
            this.setPace(65);
        }
        
        if(p.getStatus().equals("Active")) {
        	
        }
        try {
			Thread.sleep(500);
			if(p.getStatus().equals("Active")) {
				this.count++;
		        if(count == 10 && p.getFailFlag() == true)
		        {
		        	p.decreaseBatteryLife();
		        	this.count=0;
		        }
		        else if(p.getFailFlag() == false) {
		        	p.decreaseBatteryLife();
		        	this.count=0;
		        }
			}   
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

    }


}