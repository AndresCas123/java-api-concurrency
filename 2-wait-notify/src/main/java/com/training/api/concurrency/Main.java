package com.training.api.concurrency;

public class Main {

    public static void main( String[] args ) throws InterruptedException {

        int secondsToSleep = 5;
        Object object = new Object();
        Thread thread = new Thread( Main.createThread( object ) );
        thread.start();

        System.out.println("We will notify to the Thread after " + secondsToSleep + " seconds");
        Thread.sleep( secondsToSleep*1000 );

        synchronized (object){
            object.notifyAll();
            System.out.println("Notification successful...");
        }
    }

    public static Runnable createThread( final Object object ){
        return () -> {
            try {

                System.out.println("Waiting for Object");
                synchronized (object){
                    object.wait();
                }
                System.out.println("The Object was notify");
                System.out.println( "Finish Thread" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

}
