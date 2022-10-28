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
public interface EmployeeProjectViewRepository extends JpaRepository<EmployeeProjectView, Long>, JpaSpecificationExecutor<EmployeeProjectView> {
    @Query(value = """
            SELECT e FROM EmployeeProjectView as e WHERE e.lastName like %:inputString%
            OR e.firstName like %:inputString% OR (concat(e.projectId,'') like %:inputString%) OR
            e.projectName like %:inputString% OR  (concat(e.projectBudget,'') like %:inputString%) OR
            e.projectLocation like %:inputString%
            """)
    Page<EmployeeProjectView> findAllByInputString(String inputString, Pageable pageable);
}
