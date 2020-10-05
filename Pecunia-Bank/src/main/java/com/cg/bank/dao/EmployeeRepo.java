package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bank.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
