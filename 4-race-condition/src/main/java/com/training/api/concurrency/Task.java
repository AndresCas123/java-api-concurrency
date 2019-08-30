package com.training.api.concurrency;

public class Task<T extends Counter> implements Runnable{

    private T counter;
    private int times;

    public Task(T counter, int times) {
        this.counter = counter;
        this.times = times;
    }

    @Override
    public void run() {
        for( int i=0; i<times; i++ ){
            counter.increment();
        }
    }
}
