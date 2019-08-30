package com.training.api.concurrency;

public class UnSafeCounter extends Counter{

    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

}
