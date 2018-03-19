package com.almundo.springcallcenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.almundo.controller.CallController;

public class SpringCallCenterApplicationTest {

    @Mock
    private CallController callController;

    @InjectMocks
    private SpringCallCenterApplication application;

    @Before
    public void init() {
        application = new SpringCallCenterApplication();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callsProcess() throws Exception {

        final Integer callsNumber = 4;
        Mockito.when(callController.startProcess(callsNumber)).thenReturn(callsNumber);

        final String result = application.callsProcess(callsNumber);

        Assert.assertEquals(result, String.format("Llamadas procesadas: %s ", callsNumber));
    }

}