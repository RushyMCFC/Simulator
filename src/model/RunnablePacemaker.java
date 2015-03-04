package model;

import view.ViewMain;

public class RunnablePacemaker implements Runnable {

	private Pacemaker p = Pacemaker.getInstance();
	boolean flag = true;
	
	@Override
	public void run() {
		while (flag) {
            ViewMain vm = ViewMain.getInstance();
            vm.deletePacemakerDetails();
            try{
                Thread.sleep(5000);
                this.refreshPacemaker();
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
	}

	private void refreshPacemaker() {
		if(p.getStatus().compareTo("Active")==0) {
    		p.changeBatteryLife();
    	}
    }
}