package com.almundo.repository;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.almundo.model.EmployedDTO;


public class EmployedRepositoryImplTest {

    @InjectMocks
    private EmployedRepositoryImpl repository;

    @Before
    public void init() {
        repository = new EmployedRepositoryImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployees() throws Exception {

        final Map<String, List<EmployedDTO>> allEmployees = repository.getAllEmployees();

        Assert.assertNotNull(allEmployees);
        Assert.assertEquals(allEmployees.size(), 3);
    }
}