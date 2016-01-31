package com.basic.java.Core.Thread.executors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class MyCallable implements Callable<String> {
	
	public String call() throws Exception {
        Thread.sleep(1000);
       return Thread.currentThread().getName();
    }

	public static void main(String args[]){
        	
        ExecutorService executor = Executors.newFixedThreadPool(10);	//Get ExecutorService from Executors utility class, thread pool size is 10
        	
        List<Future<String>> list = new ArrayList<Future<String>>();	//create a list to hold the Future object associated with Callable
        
        Callable<String> callable = new MyCallable();	//Create MyCallable instance
        for(int i=0; i< 100; i++){
            
            Future<String> future = executor.submit(callable);	//submit Callable tasks to be executed by thread pool
            
            list.add(future);	//add Future to the list, we can get return value using Future
        }
        for(Future<String> fut : list){
            try {
                
                System.out.println(new Date()+ "::"+fut.get());//print the return value of Future, notice the output delay in console because Future.get() waits for task to get completed
            } catch (ExecutionException e) {
                e.printStackTrace();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }
}
