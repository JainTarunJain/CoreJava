package com.basic.java.Core.Thread.communication;

public class Sweep implements Runnable {

	ThreadCommunication thread;
	String oldkey="Mark-n";
	String newkey= oldkey+"-sweep";
	int x;
	
	public Sweep(ThreadCommunication thread){
		this.thread= thread;
	}
	
	/**
	 * 
	 * this run method is checking that shared object i.e. thread having  hashobject contains oldkey
	 * if hashobject contains that oldkey then remove it and check that it also contain newkey, 
	 * if contains newkey then increment it by one otherwise put 
	 * newkey in hashobject with value 1
	 */
	public void run() {

		synchronized(thread){
			for(int i=0;i<5;i++){
				try{
					x=0;
					//System.out.println(newkey);
					if(thread.data.containsKey(oldkey) && thread.data.get(oldkey) == 1){
						thread.data.remove(oldkey);
						if(thread.data.containsKey(newkey)){
						x = thread.data.get(newkey);
						}
						thread.data.put(newkey,++x );	
					}
					thread.notify();
					thread.wait();
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			
		}
	}

}
