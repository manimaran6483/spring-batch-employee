# spring-batch-employee

Sample Data :

EmpId,FirstName,LastName,Gender,Email,FatherName,MotherName,PhoneNo,City,State,Zip
850297,Shawna,Buck,F,shawna.buck@gmail.com,Rosario Buck,Keisha Buck,702-771-7149,Las Vegas,NV,89128
304721,Nathaniel,Burke,M,nathaniel.burke@walmart.com,Derrick Burke,Phoebe Burke,231-765-6923,Irons,MI,49644


Data read using FlatFileItemReader

First and Last Name combined to Fullname,
City,State and Zip combined to Address,
For Gender F is modified to Female and M is modified to Male during Processing with help of ItemProcessor

Chunk of 10 rows is written to H2 Database using ItemWriter

The Job is invoked through a REST Endpoint localhost:8081/load  
