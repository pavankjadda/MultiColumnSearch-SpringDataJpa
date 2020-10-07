package com.pj.multicolumnsearch.service;

import com.pj.multicolumnsearch.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pavan Jadda
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService
{
	private final ProjectRepository projectRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository)
	{
		this.projectRepository = projectRepository;
	}
}
