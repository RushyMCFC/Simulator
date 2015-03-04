package model;


public class MyThreadStart {
    private Thread t;
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

        t = new Thread(new RunnableHeart());
        t.start();
    }
}