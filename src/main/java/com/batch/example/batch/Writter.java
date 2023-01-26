package com.batch.example.batch;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;


@Component
public class Writter implements ItemWriter<String>{
	private static final Logger LOGGER = LogManager.getLogger(Writter.class);

	@Override
	public void write(List<? extends String> messages) throws Exception {
		//System.out.println("Data saved for users:" + emps);
		LOGGER.info("Inside Writer()");
		for (String msg : messages) {
			LOGGER.info("Writing the data " + msg);
		}
	}
	
}
