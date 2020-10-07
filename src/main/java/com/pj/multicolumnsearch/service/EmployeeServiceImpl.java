package com.pj.multicolumnsearch.service;

import com.pj.multicolumnsearch.domain.EmployeeProjectView;
import com.pj.multicolumnsearch.dto.EmployeeRequestDTO;
import com.pj.multicolumnsearch.repository.EmployeeProjectViewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.concurrent.atomic.AtomicReference;

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

	/**
	 * Builds and return specification object that filters data based on search string
	 *
	 * @param employeeRequestDTO Employee Enrollments Request DTO object
	 *
	 * @return Specification with Employee Id and Filter Text
	 */
	private Specification<EmployeeProjectView> getSpecification(EmployeeRequestDTO employeeRequestDTO)
	{
		AtomicReference<String> finalSequenceNumber = new AtomicReference<>();
		try
		{
			finalSequenceNumber.set(NumberUtils.parseNumber(employeeRequestDTO.getFilterText(),Integer.class ).toString());
		}
		catch (Exception e)
		{
			log.debug("Failed to convert Filter Text:{} to number. Search text is not a number", employeeRequestDTO.getFilterText());
			finalSequenceNumber.set(null);
		}

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
