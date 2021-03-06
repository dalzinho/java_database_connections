DROP TABLE employees;
DROP TABLE departments;
DROP TABLE job_titles;

CREATE TABLE departments(
    ID INTEGER primary key AUTOINCREMENT,
    title VARCHAR(50)
);

CREATE TABLE employees (
  ID INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(50),
  salary REAL,
  department_id INTEGER references departments(id),
  job_title_id INTEGER references job_titles(id)

);

CREATE TABLE job_titles (
ID INTEGER PRIMARY KEY AUTOINCREMENT,
job_title VARCHAR(50)
);