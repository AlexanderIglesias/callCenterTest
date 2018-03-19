package com.almundo.springcallcenter;

import com.almundo.controller.CallController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@SpringBootApplication(scanBasePackages={"com.almundo"})
@RestController
public class SpringCallCenterApplication {

	@Autowired
	private CallController callController;

	public static void main(String[] args) {
		SpringApplication.run(SpringCallCenterApplication.class, args);
	}

	/**
	 * Method that processes calls and returns the number that is processed
	 * @param callsNumber Number of calls
	 * @return Number of processed calls
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	@RequestMapping(value= "/call/{callsNumber}", method= RequestMethod.GET)
	public String callsProcess(@PathVariable("callsNumber") final Integer callsNumber) throws ExecutionException, InterruptedException {
		final Integer result = callController.startProcess(callsNumber);
		return String.format("Llamadas procesadas: %s ", result) ;
	}
}
