package com.batch.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.batch.example.model.Employee;

@Component
public class Writter implements ItemWriter<String>{
	

	@Override
	public void write(List<? extends String> messages) throws Exception {
		//System.out.println("Data saved for users:" + emps);
		System.out.println("Inside Writer()");
		for (String msg : messages) {
			System.out.println("Writing the data " + msg);
		}
	}
	
}
