package com.basic.java.Core.Thread.communication;

import junit.framework.TestCase;





public class ThreadCommunicationTest extends TestCase {
	
	public void testThreadCommunicationWithNewKey(){
		ThreadCommunication th = new ThreadCommunication();
		Mark m1 = new Mark(th);
		Sweep s1= new Sweep(th);
		Thread t1=new Thread(m1);
		Thread t2 = new Thread(s1);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int a=0;
		a=th.data.get(s1.newkey);
		assertEquals(5,a);
		
	}
	
	public void testThreadCommunicationWitholdKey(){
		ThreadCommunication th = new ThreadCommunication();
		Mark m1 = new Mark(th);
		Sweep s1= new Sweep(th);
		Thread t1=new Thread(m1);
		Thread t2 = new Thread(s1);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(false,th.data.containsKey(s1.oldkey));
		
	}

}
