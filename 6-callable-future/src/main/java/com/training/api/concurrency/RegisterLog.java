package com.training.api.concurrency;

import java.util.concurrent.Callable;

public class RegisterLog implements Callable<String> {

    private Object object;

    public RegisterLog(Object object) {
        this.object = object;
    }

    public String call() throws Exception {
        //TODO: Register in log
        Thread.sleep( 1000 );
        return "operation successful for object:" + object.hashCode();
    }

}
