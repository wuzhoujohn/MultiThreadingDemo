package com.fdmgroup.multiThreading;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class ProducerConsumerApp implements Runnable {

	private LinkedList<Integer> integers = new LinkedList<>();
	private Random random = new Random();
	private final int CAPACITY = 100;
	private Object lock = new Object();

	private void produce() throws InterruptedException{
	
		//both wait() and notify() realeases the lock
		//synchronized(lock) acquires the lock
		while(true){
			synchronized(lock){
				if(integers.size()==CAPACITY){
					lock.wait();
				}
				integers.add(random.nextInt(100));
				System.out.println("produce : Size: "+ integers.size()+ "  ------->  ");
				lock.notify();
				//Thread.sleep(100);
			}
		}
		
	}
	
	private void consume() throws InterruptedException{
		
		while(true){
			synchronized(lock){
				if(integers.size()==0){
					lock.wait();
				}
				System.out.println("Consume: Size: "+ integers.size()+ "  ------->  " + integers.removeFirst());
				lock.notify();
			}
		}
	}
	
	@Override
	public void run(){
		try {
			if(Thread.currentThread().getName().equals("producer")){
				//while(true)
					produce();
			}
			else if (Thread.currentThread().getName().equals("consumer")){
				//while(true)
				consume();
			}
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumerApp pca= new ProducerConsumerApp();
		Thread t1= new Thread(pca,"producer");	
		Thread t2= new Thread(pca,"consumer");
		
		t1.start();
		t2.start();		
	}	
}