package com.almundo.controller;

import com.almundo.manager.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutionException;


@Controller
public class CallControllerImpl implements  CallController{

    @Autowired
    private Dispatcher dispatcher;

    @Override
    public Integer startProcess(final Integer callNumber) throws ExecutionException, InterruptedException {
        return dispatcher.dispatchCall(callNumber);
    }
}
