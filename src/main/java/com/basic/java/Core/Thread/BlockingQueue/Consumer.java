package com.basic.java.Core.Thread.BlockingQueue;

import java.util.concurrent.BlockingQueue;



public class Consumer implements Runnable {

	
	private BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> queue){
		this.queue=queue;
	}
	
	public void run(){
		Message msg;
		try {
		while(! (msg = queue.take()).getMessage().equalsIgnoreCase("exit")){
			
				Thread.sleep(100);
				System.out.println("consumed: "+msg.getMessage());
		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
