package com.pj.multicolumnsearch.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Pavan Jadda
 */
@Entity
@Table(name = "project")
@Data
public class Project extends AbstractAuditingEntity implements Serializable
{
	private static final long serialVersionUID = 3081407365462907799L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "location", nullable = false)
	private String location;

	@Column(name = "type")
	private String type;

	@Column(name = "budget")
	private Double budget;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
	@JsonBackReference
	private Set<Employee> employees=new HashSet<>();

	@Override
	public String toString()
	{
		return "Project{" +
				"id=" + id +
				", name='" + name + '\'' +
				", location='" + location + '\'' +
				", type='" + type + '\'' +
				", budget=" + budget +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Project project = (Project) o;
		return getId().equals(project.getId());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getId());
	}
}
