package model;

public class MyThreadStart {
	public MyThreadStart() {
		MyRunnable r = new MyRunnable(100);
		Thread t = new Thread(r);
		t.start();
	}
}