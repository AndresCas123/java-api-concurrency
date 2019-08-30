package com.training.api.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main( String[] args ) throws ExecutionException, InterruptedException {

        List<Future> futures = new ArrayList<Future>();
        Future future;
        ExecutorService executorService = Executors.newFixedThreadPool( 5 );
        for( int i=0; i<10; i++ ){
            future = executorService.submit( new RegisterLog( new Object() ) );
            futures.add( future );
        }

        for( Future<String> futureItem : futures ){
            System.out.println("Result: " + futureItem.get());
        }
        executorService.shutdown();
    }

}
