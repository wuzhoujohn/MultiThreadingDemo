package com.fdmgroup.multiThreading;

public class CounterThread /*extends Thread*/ implements Runnable{

	private int min;
	private int max;
	private int sleepTime;
	private String arrow;
	
	
	public CounterThread(int min, int max, int sleepTime, String arrow) {
		super();
		this.min = min;
		this.max = max;
		this.sleepTime = sleepTime;
		this.arrow = arrow;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public int getSleepTime() {
		return sleepTime;
	}


	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}


	public String getArrow() {
		return arrow;
	}


	public void setArrow(String arrow) {
		this.arrow = arrow;
	}


	@Override
	public void run(){
		for(int i=min; i<=max; i++)
		{
			System.out.println(arrow + " " + i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
