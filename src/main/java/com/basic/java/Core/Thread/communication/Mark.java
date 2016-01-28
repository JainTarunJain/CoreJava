package com.basic.java.Core.Thread.communication;

public class Mark implements Runnable {
	
	ThreadCommunication thread;
	String key="Mark-n";
	int x;

	public Mark(ThreadCommunication thread){
		this.thread=thread;
	}
	/**
	 * 
	 * this run method is checking that shared object i.e. thread having  hashobject contains key
	 * if hashobject contains that key then increment it by one otherwise put 
	 * same key in hashobject with value 1
	 */
	public void run() {
		synchronized(thread){
			for(int i=0;i<5;i++){
				try{
					x=0;
					System.out.print(i+" ");
					
					if(thread.data.containsKey(key)){
					x=thread.data.get(key);
					}
					thread.data.put(key, ++x);
					
					thread.wait();
					thread.notify();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}

	}

}
