package model;

import view.ViewMain;

public class MyThreadStart {
	Thread t;
	boolean flag = true;
	public MyThreadStart() throws InterruptedException {
		t = new Thread(new Runnable() {
		     public void run() {
		    	 while(flag) {
		    		 Heart h = Heart.getHeartInstance();
		    		 h.runHeart();
		    		 ViewMain vm = ViewMain.getInstance();
		    		 vm.deleteRate();
		    		 try {
						t.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		    	 }
		     }
		});  
		t.start();
	}
	public void startThread() {
		flag = true;
	}
	
	public void stopThread() {
		flag = false;
	}
}