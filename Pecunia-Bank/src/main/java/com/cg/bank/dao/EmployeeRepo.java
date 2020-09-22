package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bank.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
