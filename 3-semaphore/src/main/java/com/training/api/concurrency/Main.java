package com.training.api.concurrency;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main( String[] args ) throws InterruptedException {
        int permits = 1;
        Semaphore semaphore = new Semaphore( permits );

        Thread thread = new Thread( Main.createThread( semaphore, 10, "Thread1" ) );
        Thread thread2 = new Thread( Main.createThread( semaphore, 5, "Thread2" ) );

        thread.start();
        thread2.start();

        thread2.join();
    }

    public static Runnable createThread( Semaphore semaphore, int seconds, String id ){
        return () ->{
            try {
                semaphore.acquire();
                Thread.sleep( seconds * 1000 );
                System.out.println( "Finish:" + id );
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }


}
