package com.training.api.concurrency;

public class SafeCounter extends Counter {

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

}
