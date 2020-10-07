package com.pj.multicolumnsearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Pavan Jadda
 */
@Data
@Entity
@Immutable
@Table(name = "employee_project_view")
public class EmployeeProjectView implements Serializable
{
	private static final long serialVersionUID = 1916548443504880237L;

	@Id
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_budget")
	private Double projectBudget;

	@Column(name = "project_location")
	private String projectLocation;

}
