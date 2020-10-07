package com.pj.multicolumnsearch.service;

import com.pj.multicolumnsearch.domain.EmployeeProjectView;
import com.pj.multicolumnsearch.dto.EmployeeRequestDTO;
import com.pj.multicolumnsearch.repository.EmployeeProjectViewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;

/**
 * @author Pavan Jadda
 */
@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService
{
	private final EmployeeProjectViewRepository employeeProjectViewRepository;

	public EmployeeServiceImpl(EmployeeProjectViewRepository employeeProjectViewRepository)
	{
		this.employeeProjectViewRepository = employeeProjectViewRepository;
	}

	@Override
	public Page<EmployeeProjectView> findEmployeeProjectsBySpecification(EmployeeRequestDTO employeeRequestDTO)
	{
		return employeeProjectViewRepository.findAll(getSpecification(employeeRequestDTO), PageRequest.of(employeeRequestDTO.getCurrentPageNumber(), employeeRequestDTO.getPageSize(),
				Sort.by(isNotNullOrEmpty(employeeRequestDTO.getSortDirection()) ? Sort.Direction.fromString(employeeRequestDTO.getSortDirection()) : Sort.Direction.DESC, employeeRequestDTO.getSortColumnName())));
	}

	@Override
	public Page<EmployeeProjectView> findEmployeeProjectsExampleMatcher(EmployeeRequestDTO employeeRequestDTO)
	{
		/* Build Search object */
		EmployeeProjectView employeeProjectView=new EmployeeProjectView();
		employeeProjectView.setEmployeeId(employeeRequestDTO.getEmployeeId());
		employeeProjectView.setLastName(employeeRequestDTO.getFilterText());
		employeeProjectView.setFirstName(employeeRequestDTO.getFilterText());
		try
		{
			employeeProjectView.setProjectId(Long.valueOf(employeeRequestDTO.getFilterText()));
			employeeProjectView.setProjectBudget(Double.valueOf(employeeRequestDTO.getFilterText()));
		}
		catch (Exception e)
		{
			log.debug("Supplied filter text is not a Number");
		}
		employeeProjectView.setProjectName(employeeRequestDTO.getFilterText());
		employeeProjectView.setProjectLocation(employeeRequestDTO.getFilterText());

		/* Build Example and ExampleMatcher object */
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("projectId", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("projectName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("projectLocation", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("projectBudget", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

		Example<EmployeeProjectView> employeeExample= Example.of(employeeProjectView, customExampleMatcher);

		/* Get employees based on search criteria*/
		return employeeProjectViewRepository.findAll(employeeExample, PageRequest.of(employeeRequestDTO.getCurrentPageNumber(),
				employeeRequestDTO.getPageSize(), Sort.by(employeeRequestDTO.getSortColumnName()).descending()));
	}

	/**
	 * Builds and return specification object that filters data based on search string
	 *
	 * @param employeeRequestDTO Employee Enrollments Request DTO object
	 *
	 * @return Specification with Employee Id and Filter Text
	 */
	private Specification<EmployeeProjectView> getSpecification(EmployeeRequestDTO employeeRequestDTO)
	{
		//Build Specification with Employee Id and Filter Text
		return (root, criteriaQuery, criteriaBuilder) ->
		{
			criteriaQuery.distinct(true);
			//Predicate for Employee Id
			Predicate predicateForEmployee = criteriaBuilder.equal(root.get("employeeId"), employeeRequestDTO.getEmployeeId());

			if (isNotNullOrEmpty(employeeRequestDTO.getFilterText()))
			{
				//Predicate for Employee Enrollments data
				Predicate predicateForData = criteriaBuilder.or(
						criteriaBuilder.like(root.get("firstName"), "%" + employeeRequestDTO.getFilterText() + "%"),
						criteriaBuilder.like(root.get("lastName"), "%" + employeeRequestDTO.getFilterText() + "%"),
						criteriaBuilder.like(root.get("projectId").as(String.class), "%" + employeeRequestDTO.getFilterText() + "%"),
						criteriaBuilder.like(root.get("projectName"), "%" + employeeRequestDTO.getFilterText() + "%"),
						criteriaBuilder.like(root.get("projectBudget").as(String.class), "%" + employeeRequestDTO.getFilterText() + "%"),
						criteriaBuilder.like(root.get("projectLocation"), "%" + employeeRequestDTO.getFilterText() + "%"));

				//Combine both predicates
				return criteriaBuilder.and(predicateForEmployee, predicateForData);
			}
			return criteriaBuilder.and(predicateForEmployee);
		};
	}

	public boolean isNotNullOrEmpty(String inputString)
	{
		return inputString != null && !inputString.isBlank() && !inputString.isEmpty() && !inputString.equals("undefined") && !inputString.equals("null") && !inputString.equals(" ");
	}
}
