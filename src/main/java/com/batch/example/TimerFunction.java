package com.batch.example;

import java.util.Date;

import org.springframework.boot.SpringApplication;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;

/**
 * Azure Functions with Timer Trigger.
 */
public class TimerFunction {
   
    @FunctionName("Timer") // Runs every minute
    public void run(@TimerTrigger(name="timerInfo",schedule="0 * * * * *") String timerInfo,
    		final ExecutionContext context) {
        context.getLogger().info("Timer Trigger Input : " + timerInfo);

        int mb = 1024*1024;
        
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
        
        context.getLogger().info("#### Heap utilization statistics [MB] ####");
        
        context.getLogger().info("Used memory : "+ (runtime.totalMemory() - runtime.freeMemory())/mb);
        
        context.getLogger().info("Free memory : " + runtime.freeMemory()/mb);
        
        context.getLogger().info("Total memory : " + runtime.totalMemory()/mb);
        
        context.getLogger().info("Max memory : " + runtime.maxMemory()/mb);
        
        context.getLogger().info("Batch Started at : " + new Date(System.currentTimeMillis()));
        
        SpringApplication.exit(SpringApplication.run(ExampleApplication.class, new String[0]));
        
        context.getLogger().info("Batch Ended at : " + new Date(System.currentTimeMillis()));
        
    }
}
