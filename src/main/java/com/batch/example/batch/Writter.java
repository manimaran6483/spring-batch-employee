package com.batch.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.example.model.Employee;
import com.batch.example.repository.EmployeeRepository;

@Component
public class Writter implements ItemWriter<Employee>{
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public Writter(EmployeeRepository empRepo) {
		this.empRepo=empRepo;
	}

	@Override
	public void write(List<? extends Employee> emps) throws Exception {
		//System.out.println("Data saved for users:" + emps);
		System.out.println("Inside Writer()");
		empRepo.saveAll(emps);
	}
	
}
