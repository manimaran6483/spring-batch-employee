package com.batch.example.batch;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.example.model.ReaderEmployee;
import com.batch.example.model.Employee;

@Component
public class Processor implements ItemProcessor<String, String>{

//	private static final Map<String, String> Dept_names = new HashMap<>();
//	
//	public Processor() {
//		Dept_names.put("001", "Technololgy");
//		Dept_names.put("002", "Operations");
//		Dept_names.put("003", "Accounts");
//	}

	@Override
	public String process(String data) throws Exception {
		
		
		return data.toUpperCase();
	}

	
}
