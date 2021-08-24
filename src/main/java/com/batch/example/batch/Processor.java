package com.batch.example.batch;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.example.model.ReaderEmployee;
import com.batch.example.model.Employee;

@Component
public class Processor implements ItemProcessor<ReaderEmployee, Employee>{

//	private static final Map<String, String> Dept_names = new HashMap<>();
//	
//	public Processor() {
//		Dept_names.put("001", "Technololgy");
//		Dept_names.put("002", "Operations");
//		Dept_names.put("003", "Accounts");
//	}

	@Override
	public Employee process(ReaderEmployee emp) throws Exception {
		
		String fullname = emp.getFname() + " " + emp.getLname();
		String address = emp.getCity()+" " + emp.getState()+" " +emp.getZip();
		String gender = emp.getGender().equalsIgnoreCase("M") ? "Male" : "Female";
		
		Employee employee = new Employee(emp.getEmpid(),fullname,gender,emp.getEmail(),emp.getFathername(),emp.getMothername()
				,emp.getPhnno(),address, new Date());
		
		System.out.println(String.format("Converted from [%s] to [%s]", emp.getGender()	,gender));
		System.out.println(String.format("Converted from [%s] to [%s]", emp.getCity()+"," + emp.getState()+" " +emp.getZip()	,address));
		System.out.println(String.format("Converted from [%s] to [%s]", emp.getFname() + "," + emp.getLname()	,fullname));
		return employee;
	}

	
}
