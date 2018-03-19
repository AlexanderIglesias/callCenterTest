package com.almundo.repository;

import java.util.List;
import java.util.Map;

import com.almundo.model.EmployedDTO;

@FunctionalInterface
public interface EmployedRepository {

    Map<String, List<EmployedDTO>> getAllEmployees();
}
