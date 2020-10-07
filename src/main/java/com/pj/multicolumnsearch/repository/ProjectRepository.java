package com.pj.multicolumnsearch.repository;

import com.pj.multicolumnsearch.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavan Jadda
 */
public interface ProjectRepository extends JpaRepository<Project,Long>
{
}
