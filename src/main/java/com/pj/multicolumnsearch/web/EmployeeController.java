package com.pj.multicolumnsearch.web;

import com.pj.multicolumnsearch.domain.EmployeeProjectView;
import com.pj.multicolumnsearch.dto.EmployeeRequestDTO;
import com.pj.multicolumnsearch.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavan Jadda
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController
{
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}

	/*
		Find paginated employee projects
	*/
	@PostMapping("/find/projects/paginated/specification")
	public Page<EmployeeProjectView> findEmployeeProjectsPaginated(@RequestBody EmployeeRequestDTO employeeRequestDTO)
	{
		return employeeService.findEmployeeProjectsBySpecification(employeeRequestDTO);
	}

	/*
		Find paginated employee projects using Example Matcher
	*/
	@PostMapping("/find/projects/paginated/example_matcher")
	public Page<EmployeeProjectView> findEmployeeProjectsExampleMatcher(@RequestBody EmployeeRequestDTO employeeRequestDTO)
	{
		return employeeService.findEmployeeProjectsExampleMatcher(employeeRequestDTO);
	}
}
