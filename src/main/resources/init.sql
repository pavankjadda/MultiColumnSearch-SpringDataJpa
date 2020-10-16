CREATE DATABASE IF NOT EXISTS demodb;
use demodb;

create table if not exists employee
(
    id bigint auto_increment
        primary key,
    created_by varchar(100) null,
    created_date datetime(6) null,
    last_modified_by varchar(100) null,
    last_modified_date datetime(6) null,
    address varchar(255) null,
    email varchar(255) null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone varchar(255) null
);





create table project
(
    id bigint auto_increment
        primary key,
    created_by varchar(100) null,
    created_date datetime(6) null,
    last_modified_by varchar(100) null,
    last_modified_date datetime(6) null,
    budget double null,
    location varchar(255) not null,
    name varchar(255) not null,
    type varchar(255) null
);



create table employee_project
(
    employee_id bigint not null,
    project_id bigint not null,
    primary key (employee_id, project_id),
    constraint FK4yddvnm7283a40plkcti66wv9
        foreign key (project_id) references project (id),
    constraint FKb25s5hgggo6k4au4sye7teb3a
        foreign key (employee_id) references employee (id)
);





create view employee_project_view as
select employee_id,
       first_name,
       last_name,
       project_id,
       name     as project_name,
       location as project_location,
       budget   as project_budget
from employee,
     employee_project,
     project
where employee.id = employee_project.employee_id
  and employee_project.project_id = project.id;



INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (1, N'John', N'Doe', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (2, N'Jack', N'Reacher', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (3, N'John', N'Reese', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (4, N'Steve', N'Rogers', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (5, N'Tony', N'Stark', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone)VALUES (6, N'Mark', N'Modaha', null, null, null);

INSERT INTO project (id, name, budget, location, type) VALUES (1, N'HR Management System', 1000, N'DC', N'Internal');
INSERT INTO project (id, name, budget, location, type)VALUES (2, N'Timesheet Managerment', 1000, N'NYC', N'Contract');
INSERT INTO project (id, name, budget, location, type)VALUES (3, N'Online Reservation', 1000, N'LA', N'Contract');
INSERT INTO project (id, name, budget, location, type)VALUES (4, N'Employee Portal', 1000, N'Chicago', N'Internal');
INSERT INTO project (id, name, budget, location, type)VALUES (5, N'PayCheck System', 1000, N'Chicago', N'Internal');
INSERT INTO project (id, name, budget, location, type)VALUES (6, N'401K System', 1000, N'Chicago', N'Internal');


INSERT INTO employee_project (employee_id, project_id) VALUES (1, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 6);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 6);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 6);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 6);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 6);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 6);

FLUSH PRIVILEGES;
