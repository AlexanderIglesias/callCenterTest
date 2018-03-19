package com.almundo.controller;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface CallController {

    Integer startProcess(Integer callNumber) throws ExecutionException, InterruptedException;
}
