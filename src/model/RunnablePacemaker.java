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

        if(p.getMode().equals("DOO"))
        {
            h.setHeartRate(65);
            h.setAV_delay(500);
            h.setSA_delay(500);
        }

	}

}