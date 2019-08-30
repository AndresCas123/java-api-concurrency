package com.training.api.concurrency;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

public class Main {

    public static void main( String[] args ){

        int numberTask = 10;

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Main.addThreadsToExecutorService( executorService, numberTask );
        runExecutorService( executorService );

        executorService = Executors.newFixedThreadPool( 20 );
        Main.addThreadsToExecutorService( executorService, numberTask );
        runExecutorService( executorService );

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool( 20 );
        Main.addThreadsToExecutorService( scheduledExecutorService, numberTask );
        runExecutorService( scheduledExecutorService );

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor( Executors.defaultThreadFactory() );
        Main.addThreadsToExecutorService( scheduledExecutorService, numberTask );
        runExecutorService( scheduledExecutorService );

    }

    private static void addThreadsToExecutorService( ExecutorService executorService, int numberThreads ){
        for( int i=0; i<numberThreads; i++ )
            executorService.submit( createThread() );
    }

    private static Runnable createThread(){
        return () -> {
            try {
                Thread.sleep( 250 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    private static void runExecutorService( ExecutorService executorService ){
        Date start = new Date();

        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        Date finish = new Date();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(start);

        Calendar calendarFinish = Calendar.getInstance();
        calendarFinish.setTime(finish);

        String milliseconds = String.valueOf( calendarFinish.getTimeInMillis() - calendarStart.getTimeInMillis() );
        System.out.println( "Executor:" + executorService.getClass().getName() );
        System.out.println( "The process was executed in " + milliseconds + " milliseconds" );
        System.out.println( "-------------------------------------------------------------" );
    }

}
