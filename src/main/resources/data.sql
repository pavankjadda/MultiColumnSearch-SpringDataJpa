--  Employee insert
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (1, N'John', N'Doe', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (2, N'Jack', N'Reacher', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (3, N'John', N'Reese', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (4, N'Steve', N'Rogers', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone) VALUES (5, N'Tony', N'Stark', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone)VALUES (6, N'Mark', N'Modaha', null, null, null);

--  Project insert
INSERT INTO project (id, name, budget, location, type) VALUES (1, N'HR Management System', 1000, N'DC', N'Internal');
INSERT INTO project (id, name, budget, location, type)VALUES (2, N'Timesheet Managerment', 1000, N'NYC', N'Contract');
INSERT INTO project (id, name, budget, location, type)VALUES (3, N'Online Reservation', 1000, N'LA', N'Contract');
INSERT INTO project (id, name, budget, location, type)VALUES (4, N'Employee Portal', 1000, N'Chicago', N'Internal');
INSERT INTO project (id, name, budget, location, type)VALUES (5, N'PayCheck System', 1000, N'Chicago', N'Internal');
INSERT INTO project (id, name, budget, location, type)VALUES (6, N'401K System', 1000, N'Chicago', N'Internal');


--  Employee Project insert
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
