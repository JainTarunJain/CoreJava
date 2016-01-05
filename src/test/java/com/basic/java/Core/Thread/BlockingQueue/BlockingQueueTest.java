package com.basic.java.Core.Thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import junit.framework.TestCase;

public class BlockingQueueTest extends TestCase{

	public void testBlockingQueue(){
		BlockingQueue<Message> 	queue = new ArrayBlockingQueue<Message>(10);
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		new Thread(p).start();
		new Thread(c).start();
		System.out.println("producer and consumner has started");
	}
}
