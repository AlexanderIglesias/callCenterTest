package com.almundo.manager;

import com.almundo.model.EmployedDTO;
import com.almundo.repository.EmployedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Controller
public class DispatcherImpl implements Dispatcher{

    @Autowired
    private EmployedRepository employedRepository;

    private Map<String, List<EmployedDTO>> employedList = null;

    /**
     * Setup employees list
     */
    @PostConstruct
    public void initEmployees() {
        this.employedList = employedRepository.getAllEmployees();
    }

    /**
     * Method that processes a number of calls
     * @param callsNumber Number of calls
     * @return Integer calls completed
     */
    public Integer dispatchCall(final Integer callsNumber) {
        //processed calls
        int processedCalls = 0;
        //Iterate number calls
        for(int i=1; i <= callsNumber; i++){
            //get available employed
            final EmployedDTO employed = getAvailableEmployed();
            //validate if there are available users
            if(employed != null) {
                //Start individually call
                final RunnableTask task = new RunnableTask(employed);
                task.start();
                //Add call completed
                processedCalls += 1;
            }else{
                System.out.println("Todos los agentes estan ocupados");
            }
        }
        return processedCalls;
    }

    /**
     * method that returns an available user
     * @return Employed
     */
    @Async
    public EmployedDTO getAvailableEmployed(){
        //Iterate all keys for employed type
        for (final Map.Entry<String, List<EmployedDTO>> entry : this.employedList.entrySet()) {
            //Iterate key for all employed type
            for (EmployedDTO employed : entry.getValue()) {
                //Validate available users
                if(employed.isAvailable()) {
                    //Change status employed
                	 employed = new EmployedDTO.Builder(employed.getName(), employed.getType(),false).build();
                    return employed;
                }
            }
        }
        return null;
    }

    public void setEmployedList(Map<String, List<EmployedDTO>> employedList) {
        this.employedList = employedList;
    }
}
