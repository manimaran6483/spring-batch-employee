package com.batch.example.batch;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<String, String>{

//	private static final Map<String, String> Dept_names = new HashMap<>();
//	
//	public Processor() {
//		Dept_names.put("001", "Technololgy");
//		Dept_names.put("002", "Operations");
//		Dept_names.put("003", "Accounts");
//	}

	private static final Logger LOGGER = LogManager.getLogger(Processor.class);
	
	@Override
	public String process(String data) throws Exception {
		LOGGER.info("Inside Processor");
		
		return data.toUpperCase();
	}

	
}
