package com.almundo.manager;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface Dispatcher {

    Integer dispatchCall(Integer callNumber) throws ExecutionException, InterruptedException;
}
