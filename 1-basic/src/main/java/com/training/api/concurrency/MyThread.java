package com.training.api.concurrency;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println( "Example with Thread" );
    }
}
