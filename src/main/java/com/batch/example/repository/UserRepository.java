package com.batch.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.example.model.Employee;

@Repository
public interface UserRepository extends JpaRepository<Employee, Integer>{

}
