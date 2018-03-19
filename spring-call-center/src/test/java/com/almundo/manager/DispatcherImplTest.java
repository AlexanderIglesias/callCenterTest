package com.almundo.manager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.almundo.model.EmployedDTO;
import com.almundo.utilities.EmployedTypeEnum;

public class DispatcherImplTest {

    @InjectMocks
    private DispatcherImpl dispatcher;

    @Test
    public void initEmployees() throws Exception {
    }

    @Before
    public void init() {
        dispatcher = new DispatcherImpl();
        this.setupEmployees();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void dispatchCallWithMaxNumCall() throws Exception {
        final Integer callsNumber = 10;
        final Integer result = dispatcher.dispatchCall(callsNumber);

        Assert.assertEquals(result, callsNumber);
    }

    @Test
    public void dispatchCallWithMinNumCall() throws Exception {
        final Integer callsNumber = 1;
        final Integer result = dispatcher.dispatchCall(callsNumber);

        Assert.assertEquals(result, callsNumber);
    }

    @Test
    public void callGetAvailableEmployedWithUserNotNull() throws Exception {

        final EmployedDTO availableEmployed = dispatcher.getAvailableEmployed();

        Assert.assertNotNull(availableEmployed);
    }

    @Test
    public void callGetAvailableEmployedWithUserIsNull() throws Exception {

        final List<EmployedDTO> employedList = new ArrayList<>();
        employedList.add(new EmployedDTO.Builder("", EmployedTypeEnum.OPERATOR, false).build());
        employedList.add(new EmployedDTO.Builder("", EmployedTypeEnum.OPERATOR, false).build());

        final Map<String, List<EmployedDTO>> map = new LinkedHashMap<>();
        map.put(EmployedTypeEnum.OPERATOR.toString(), employedList);

        dispatcher.setEmployedList(map);
        final EmployedDTO availableEmployed = dispatcher.getAvailableEmployed();

        Assert.assertNotNull(availableEmployed);
        Assert.assertNull(availableEmployed.getName(), "");

    }

    private void setupEmployees(){

        final List<EmployedDTO> operatorList = new ArrayList<>();
        operatorList.add(new EmployedDTO.Builder("Juan", EmployedTypeEnum.OPERATOR, true).build());
        operatorList.add(new EmployedDTO.Builder("Pedro", EmployedTypeEnum.OPERATOR, true).build());
        operatorList.add(new EmployedDTO.Builder("Manuel", EmployedTypeEnum.OPERATOR, true).build());
        operatorList.add(new EmployedDTO.Builder("Sara", EmployedTypeEnum.OPERATOR, true).build());
        operatorList.add(new EmployedDTO.Builder("Lorena", EmployedTypeEnum.OPERATOR, true).build());
        operatorList.add(new EmployedDTO.Builder("Oscar", EmployedTypeEnum.OPERATOR, true).build());
        operatorList.add(new EmployedDTO.Builder("Julian", EmployedTypeEnum.OPERATOR, true).build());

        final List<EmployedDTO> supervisorList = new ArrayList<>();
        supervisorList.add(new EmployedDTO.Builder("Sandra", EmployedTypeEnum.SUPERVISOR, true).build());
        supervisorList.add(new EmployedDTO.Builder("Jose", EmployedTypeEnum.SUPERVISOR, true).build());

        final List<EmployedDTO> directorList = new ArrayList<>();
        directorList.add(new EmployedDTO.Builder("Ernesto", EmployedTypeEnum.DIRECTOR, true).build());

        final Map<String, List<EmployedDTO>> map = new LinkedHashMap<>();
        map.put(EmployedTypeEnum.OPERATOR.toString(), operatorList);
        map.put(EmployedTypeEnum.SUPERVISOR.toString(), supervisorList);
        map.put(EmployedTypeEnum.DIRECTOR.toString(), directorList);

        dispatcher.setEmployedList(map);
    }

}