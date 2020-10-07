package com.pj.multicolumnsearch.service;

import com.pj.multicolumnsearch.domain.EmployeeProjectView;
import com.pj.multicolumnsearch.dto.EmployeeRequestDTO;
import org.springframework.data.domain.Page;

/**
 * @author Pavan Jadda
 */
public interface EmployeeService
{
	Page<EmployeeProjectView> findEmployeeProjectsBySpecification(EmployeeRequestDTO employeeRequestDTO);

	Page<EmployeeProjectView> findEmployeeProjectsExampleMatcher(EmployeeRequestDTO employeeRequestDTO);
}
