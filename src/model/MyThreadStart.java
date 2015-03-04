package model;


public class MyThreadStart {
	private Thread t1, t2;
	public MyThreadStart() throws InterruptedException {

        t1 = new Thread(new RunnableHeart());
        t1.start();
        
        t2 = new Thread(new RunnablePacemaker());
        t2.start();
	}
}