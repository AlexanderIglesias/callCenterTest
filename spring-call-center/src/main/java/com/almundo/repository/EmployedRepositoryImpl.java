
package com.almundo.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.almundo.model.EmployedDTO;
import com.almundo.utilities.Constants;
import com.almundo.utilities.EmployedJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository(value="repository")
public class EmployedRepositoryImpl implements EmployedRepository {

    /**
     * Method that consults employees and returns them on a map
     * @return Map
     */
    public Map<String, List<EmployedDTO>> getAllEmployees() {

        final Map<String, List<EmployedDTO>> map = new LinkedHashMap<>();

        //Load json file with all employees
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(Constants.JSON_PATH);

        try {
            //Map employees json to List
            final List<EmployedJson> employees = new ObjectMapper().readValue(resourceAsStream,
                    new TypeReference<List<EmployedJson>>() {
                    });  
           List<EmployedDTO> listDTO = employees.stream()
        		   .map(EmployedRepositoryImpl::jsonToDto).collect(Collectors.toList()); 
           
           return listToMap(listDTO);

        } catch (final IOException e) {
           System.out.print(e.getMessage());
        }
        return map;
    }
    
	private static EmployedDTO jsonToDto(EmployedJson employedJson) {
		return new EmployedDTO.Builder(employedJson.getName(), employedJson.getType(), employedJson.isAvailable())
				.build();

	}
    
	private static Map<String, List<EmployedDTO>> listToMap(List<EmployedDTO> employees) {
		final Map<String, List<EmployedDTO>> map = new LinkedHashMap<>();
		for (final EmployedDTO employee : employees) {
			final String key = employee.getType().toString();
			final List<EmployedDTO> typeList = map.get(key) != null ? map.get(key) : new ArrayList<>();
			typeList.add(employee);
			map.put(key, typeList);
		}

		return map;

	}
}

