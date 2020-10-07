package com.pj.multicolumnsearch.repository;

import com.pj.multicolumnsearch.domain.EmployeeProjectView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Pavan Jadda
 */
public interface EmployeeProjectViewRepository extends JpaRepository<EmployeeProjectView, Long>,  JpaSpecificationExecutor<EmployeeProjectView>
{
}
