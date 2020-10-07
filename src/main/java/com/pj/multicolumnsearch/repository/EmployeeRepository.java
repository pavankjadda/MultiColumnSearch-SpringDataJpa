package com.pj.multicolumnsearch.repository;

import com.pj.multicolumnsearch.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavan Jadda
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
