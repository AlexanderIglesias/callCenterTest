package com.almundo.controller;

import com.almundo.manager.Dispatcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CallControllerImplTest {


    @Mock
    private Dispatcher dispatcher;

    @InjectMocks
    private CallControllerImpl callController;

    @Before
    public void init() {
        callController = new CallControllerImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void startProcess() throws Exception {

        final Integer callsNumber = 4;
        Mockito.when(dispatcher.dispatchCall(callsNumber)).thenReturn(callsNumber);

        final Integer result = callController.startProcess(callsNumber);

        Assert.assertEquals(result, callsNumber);
    }

}