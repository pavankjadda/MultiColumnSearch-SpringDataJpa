package com.pj.multicolumnsearch.repository;

import com.pj.multicolumnsearch.domain.EmployeeProjectView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Pavan Jadda
 */
public interface EmployeeProjectViewRepository extends JpaRepository<EmployeeProjectView, Long>,  JpaSpecificationExecutor<EmployeeProjectView>
{
	@Query(value = "SELECT e FROM EmployeeProjectView as e WHERE e.employeeId=:employeeId and (:inputString is null or e.lastName like %:inputString% ) and " +
			"(:inputString is null or e.firstName like %:inputString%) and (:inputString is null or concat(e.projectId,'') like %:inputString%) and " +
			" (:inputString is null or e.projectName like %:inputString%) and  (:inputString is null or concat(e.projectBudget,'') like %:inputString%) and "+
			" (:inputString is null or e.projectLocation like %:inputString%)"
	)
	Page<EmployeeProjectView> findAllByInputString(Long employeeId, String inputString, Pageable pageable);
}
