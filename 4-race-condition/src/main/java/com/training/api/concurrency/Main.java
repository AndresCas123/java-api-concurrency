package com.training.api.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main( String[] args ){

        int threads = 100;

        SafeCounter safeCounter = new SafeCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for( int i=0; i<threads; i++ )
            executorService.submit( new Thread( new Task( safeCounter, 10 ) ) );
        executorService.shutdown();

        while(!executorService.isTerminated()){
        }

        System.out.println("SafeCounter:" + safeCounter.getCount());

        UnSafeCounter unSafeCounter = new UnSafeCounter();
        executorService = Executors.newFixedThreadPool(threads);
        for( int i=0; i<threads; i++ )
            executorService.submit( new Thread( new Task( unSafeCounter, 10 ) ) );
        executorService.shutdown();

        while(!executorService.isTerminated()){
        }

        System.out.println("UnSafeCounter:" + unSafeCounter.getCount());


    }

}
