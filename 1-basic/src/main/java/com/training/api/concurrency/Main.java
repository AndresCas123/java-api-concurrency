package com.training.api.concurrency;

public class Main {

    public static void main( String[] args ){
        //Creating threads
        Thread myThread = new MyThread();
        MyRunnable myRunnable  = new MyRunnable();

        //Executing threads
        Thread thread = new Thread(myThread);
        thread.start();

        thread = new Thread(myRunnable);
        thread.start();
    }

}
