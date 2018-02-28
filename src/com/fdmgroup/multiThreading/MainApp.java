package com.fdmgroup.multiThreading;

public class MainApp {

	public static void main(String[] args) {
/*
		Thread.currentThread().setName("Tauhid Thread");
		Thread.currentThread().setPriority(8);
		
		System.out.println(Thread.currentThread().toString());*/
		CounterThread ct=new CounterThread(10, 100, 100, "---------------->>");
		CounterThread ct2=new CounterThread(100, 1000, 10, "-------------------------->>");
		
		Thread t1=new Thread(ct);
		Thread t2=new Thread(ct2);
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		
		t1.start();
		t2.start();
		
		for (int i=1; i<11; i++)
		{
			System.out.println("-----> " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	//Uncomment this part if you want to run the daemon thread even after the main thread is over. 
		
	/*	try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	}
}
