package com.learning.basics.threads;

public class ThreadBasics {
	
	/*
	 * Process vs Thread
	 * A process is a self contained execution environment and it can be seen as a program or application.
	 * However a program itself contains multiple processes inside it. 
	 * Java runtime environment runs as a single process which contains different classes and programs as processes.
	 * 
	 * Thread can be called lightweight process. 
	 * Thread requires less resources to create and exists in the process, thread shares the process resources.
	 */
	
	/*
	 * Thread Exmaple:
	 * Every java application has at least one thread � main thread. 
	 * Although there are so many other java threads running in background like memory management, system management, signal processing etc.
	 * But from application point of view � main is the first java thread and we can create multiple threads from it.
	 * 
	 * Multithreading refers to two or more threads executing concurrently in a single program.
	 * A computer single core processor can execute only one thread at a time and time slicing is the OS feature to share processor time between different processes and threads.
	 * 
	 * Thread Benefits:
	 * Java Threads are lightweight compared to processes, it takes less time and resource to create a thread.
	 * Threads share their parent process data and code
	 * Context switching between threads is usually less expensive than between processes.
	 * Thread intercommunication is relatively easy than process communication
	 * 
	 */
	
	/*
	 * two ways to create threads:
	 * 1.Implementing Runnable interface
	 * 2. Extending thread class
	 */
	
	/*
	 * To make a class runnable, we can implement java.lang.Runnable interface and provide implementation in public void run() method. 
	 * To use this class as Thread, 
	 * we need to create a Thread object by passing object of this runnable class and then call start() method to execute the run() method in a separate thread.
	 */
	public class HeavyWorkRunnable implements Runnable {

	    @Override
	    public void run() {
	        System.out.println("Doing heavy processing - START "+Thread.currentThread().getName());
	        try {
	            Thread.sleep(1000);
	            //Get database connection, delete unused data from DB
	            doDBProcessing();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Doing heavy processing - END "+Thread.currentThread().getName());
	    }

	    private void doDBProcessing() throws InterruptedException {
	        Thread.sleep(5000);
	    }

	}
	
	/*
	 * We can extend java.lang.Thread class to create our own java thread class and override run() method. 
	 * Then we can create it�s object and call start() method to execute our custom java thread class run method.
	 */
	
	public class MyThread extends Thread {

	    public MyThread(String name) {
	        super(name);
	    }

	    @Override
	    public void run() {
	        System.out.println("MyThread - START "+Thread.currentThread().getName());
	        try {
	            Thread.sleep(1000);
	            //Get database connection, delete unused data from DB
	            doDBProcessing();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("MyThread - END "+Thread.currentThread().getName());
	    }

	    private void doDBProcessing() throws InterruptedException {
	        Thread.sleep(5000);
	    }
	    
	}
	
	public static void main(String[] args){
		Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
        Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");
        System.out.println("Starting MyThreads");
        t3.start();
        t4.start();
        System.out.println("MyThreads has been started");
        
        /*output
         * Starting Runnable threads
		Runnable Threads has been started
	Doing heavy processing - START t1
	Doing heavy processing - START t2
	Starting MyThreads
	MyThread - START Thread-0
	MyThreads has been started
	MyThread - START Thread-1
	Doing heavy processing - END t2
	MyThread - END Thread-1
	MyThread - END Thread-0
	Doing heavy processing - END t1
         */
	}

}
