
-- Create Employee Project View --
drop view if exists employee_project_view;
create view employee_project_view as
select employee_id,
       first_name,
       last_name,
       project_id,
       name     as prject_name,
       location as prject_location,
       budget   as prject_budget
from employee,
     employee_project,
     project
where employee.id = employee_project.employee_id
  and employee_project.project_id = project.id;



-- Create Employee Table --
create table employee
(
    id bigint identity
        primary key,
    created_by varchar(100),
    created_date datetime2,
    last_modified_by varchar(100),
    last_modified_date datetime2,
    address varchar(255),
    email varchar(255),
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone varchar(255)
)



-- Create Project Table --

create table project
(
    id bigint identity
        primary key,
    created_by varchar(100),
    created_date datetime2,
    last_modified_by varchar(100),
    last_modified_date datetime2,
    budget float,
    location varchar(255) not null,
    name varchar(255) not null,
    type varchar(255)
)


-- Create Employee Project Table --

create table employee_project
(
    employee_id bigint not null
        constraint FKb25s5hgggo6k4au4sye7teb3a
            references employee,
    project_id bigint not null
        constraint FK4yddvnm7283a40plkcti66wv9
            references project,
    primary key (employee_id, project_id)
)



