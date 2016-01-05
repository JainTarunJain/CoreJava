package com.basic.java.Core.Thread.BlockingQueue;

import java.util.concurrent.BlockingQueue;



public class Producer implements Runnable {
	
	private BlockingQueue<Message> queue;
	
	public Producer(BlockingQueue<Message> q){
		this.queue = q;
	}

	public void run() {
		for(int i=0; i< 25; i++){
			Message msg = new Message(" "+i);
			try{
				Thread.sleep(500);
				queue.put(msg);
				System.out.println(" produced: "+msg.getMessage());
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}

		Message msg1=new Message("exit");
		try {
			queue.put(msg1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
