package model;

public class MyRunnable implements Runnable{

	private int x;
	
	public MyRunnable(int x) {
		this.x = x;
	}
	
	@Override
	public void run() {
		while(true)
			{
		System.out.println("Hello");
			}
	}
	
}
