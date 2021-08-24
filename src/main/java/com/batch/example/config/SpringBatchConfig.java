package com.batch.example.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.batch.example.model.*;
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			ItemReader<ReaderEmployee> itemReader,
			ItemProcessor<ReaderEmployee, Employee> itemProcessor,
			ItemWriter<Employee> itemWriter){
		
		Step step= stepBuilderFactory.get("File-load-step-1")
				.<ReaderEmployee,Employee> chunk(10)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		
		return jobBuilderFactory.get("File-Load-Job")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<ReaderEmployee> itemReader(){
//		FlatFileItemReader<ReaderEmployee> flatFileItemReader = new FlatFileItemReader<>();
//		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/EmpRecords.txt"));
//		flatFileItemReader.setName("TXT-Reader");
//		flatFileItemReader.setLinesToSkip(1);
//		flatFileItemReader.setLineMapper(lineMapper());
//		return flatFileItemReader;
		System.out.println("Inside Reader()");
		return new FlatFileItemReaderBuilder<ReaderEmployee>().name("TXT-Reader")
				.resource(new FileSystemResource("src/main/resources/EmpRecord.txt"))
				.linesToSkip(1)
				.delimited() 
				.names(new String[] {"EmpId","FirstName","LastName","Gender",
						"Email","FatherName","MotherName","PhoneNo","City","State","Zip"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<ReaderEmployee>() {{
					setTargetType(ReaderEmployee.class);
				}})
				.build();
	}
	
//	@Bean 
//	public LineMapper<ReaderEmployee> lineMapper(){
//		
//		DefaultLineMapper<ReaderEmployee> defaultLineMapper = new DefaultLineMapper<>();
//		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//		
//		lineTokenizer.setDelimiter(",");;
//		lineTokenizer.setNames("EmpId","FirstName","LastName","Gender",
//				"Email","FatherName","MotherName","PhoneNo","City","State","Zip");
//		
//		BeanWrapperFieldSetMapper<ReaderEmployee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//		fieldSetMapper.setTargetType(ReaderEmployee.class);
//		
//		defaultLineMapper.setLineTokenizer(lineTokenizer);
//		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//		
//		return defaultLineMapper;
//	}
}
