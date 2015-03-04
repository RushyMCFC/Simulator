package model;


public class MyThreadStart {
	private Thread t1, t2;
	public MyThreadStart() throws InterruptedException {
//		t = new Thread(new Runnable() {
//		     public void run() {
//		    	 while(flag) {
//		    		 RunnableHeart h = new RunnableHeart();
//                     h.run();
//		    		 ViewMain vm = ViewMain.getInstance();
//		    		 vm.deleteRate();
//		    		 try {
//						t.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//		    	 }
//		     }
//		});
//		t.start();

        t1 = new Thread(new RunnableHeart());
        t1.start();
        
        t2 = new Thread(new RunnablePacemaker());
        t2.start();
	}
}