package com.fdmgroup.multiThreading;

import java.util.Scanner;

public class WaitNotifyApp implements Runnable{

	private void produce() throws InterruptedException{
		synchronized(this){
		System.out.println("Inside produce ... ... ...");
		wait();
		Thread.sleep(100);
		System.out.println("After wait inside produce ...");
		}
	}
	
	private void consume() throws InterruptedException{
		Scanner scanner = new Scanner (System.in);
		
		synchronized(this){
			notify();
			System.out.println("Inside consume ... ... press Enter");
			scanner.nextLine();
			
			Thread.sleep(100);
			System.out.println("After notify inside consume ...");
			Thread.sleep(100);
			System.out.println("Hello After notify inside consume ...");
			Thread.sleep(100);
			System.out.println("one  notify inside consume ...");
		}
	}
	
	@Override
	public void run(){
		try {
		if(Thread.currentThread().getName().equals("producer"))
			
				produce();
			
		else if (Thread.currentThread().getName().equals("consumer"))
				consume();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WaitNotifyApp wna = new WaitNotifyApp();
		Thread t1= new Thread(wna,"producer");	
		Thread t2= new Thread(wna,"consumer");

		t1.start();
		t2.start();
	}
}