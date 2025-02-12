# SQL Practice Sessions
This document contains a structured log of SQL queries practiced over multiple days. The queries cover fundamental database operations, table modifications, and various SQL commands.

# 28-Jan-2025 --> Day 1 : Introduction to SQL & RDBMS and Software installation


# 29-Jan-2025 --> Day 2 : MongoDB Certification - Registeration process & SQL Sub Languages Introduction


# 30-Jan-2025 --> Day 3 : Data Definition Language & Data Manipulation Language

  SHOW DATABASES;
  CREATE DATABASE VIT;
  DROP DATABASE VIT;
  
  USE VIT;
  
  CREATE TABLE CSE (
      s_id INT,
      s_name VARCHAR(30),
      s_mark INT
  );
  
  DROP TABLE CSE;
  SHOW TABLES FROM VIT;
  
  SELECT * FROM CSE;
  
  INSERT INTO CSE VALUES (1001, 'Ram Prasad', 99);
  
  ALTER TABLE CSE ADD (
      s_contact VARCHAR(200)
  );
  
  SHOW DATABASES;
  USE VIT;
  SHOW TABLES FROM VIT;
  SELECT * FROM CSE;
  DESC CSE;
  
  ALTER TABLE CSE DROP COLUMN s_contact;
  
  INSERT INTO CSE VALUES (1002, 'Jayanth', 2008);
  INSERT INTO CSE VALUES (1001, 'Arin', 85, 'UK');
  
  ALTER TABLE CSE ADD (
      s_country VARCHAR(25) DEFAULT 'India'
  );


# 31-Jan-2025 --> Day 4 : DCL and Transaction control language

  USE VIT;
  ALTER TABLE CSE RENAME COLUMN s_country TO s_state;
  DESC CSE;
  
  SELECT * FROM CSE;
  DELETE FROM CSE WHERE s_id = 102;
  
  INSERT INTO CSE VALUES (1002, 'Jayanth', 75), (1003, 'Tsmilarasam', 76);
  UPDATE CSE SET s_name = 'Vishnu' WHERE s_id = 1002;
  UPDATE CSE SET s_mark = s_mark + 1;
  
  SELECT s_id, s_name FROM CSE WHERE s_id = 1002;



  CREATE DATABASE Practice1;
  USE Practice1;
  
  CREATE TABLE Mech (
      s_id INT,
      s_name VARCHAR(25)
  );
  
  START TRANSACTION;
  INSERT INTO Mech VALUES (101, 'Jayanth');
  SAVEPOINT A;
  
  UPDATE Mech SET s_id = 102 WHERE s_id = 101;
  INSERT INTO Mech VALUES (102, 'Kanaya');
  
  SELECT * FROM Mech;
  SAVEPOINT C;
  SELECT * FROM Mech;
  
  ROLLBACK TO SAVEPOINT A;
  SELECT * FROM Mech;
  COMMIT;



# 1-Feb-2025 --> Day 5 :SQL Datatypes, Operators, Where Clause 

  CREATE DATABASE ORG123;
  SHOW DATABASES;
  USE ORG123;
  
  CREATE TABLE Worker (
      WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
      FIRST_NAME CHAR(25),
      LAST_NAME CHAR(25),
      SALARY INT,
      JOINING_DATE DATETIME,
      DEPARTMENT CHAR(25)
  );
  
  INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
  (1, 'Isha', 'Prajapati', 1000000, '2020-02-14 09:00:00', 'SWE'),
  (2, 'Niharika', 'Verma', 80000, '2011-06-14 09:00:00', 'Admin'),
  (3, 'Vishal', 'Singhal', 1000, '2020-02-15 09:00:00', 'HR'),
  (4, 'Barkha', 'Prajapati', 100000, '2020-02-12 09:00:00', 'SWE');
  
  SELECT * FROM Worker;
  SELECT * FROM Worker WHERE SALARY > 100000 AND DEPARTMENT = 'HR';
  SELECT * FROM Worker WHERE SALARY > 2000000;
  SELECT * FROM Worker WHERE SALARY BETWEEN 1000000 AND 200000;
  SELECT * FROM Worker WHERE SALARY NOT BETWEEN 1000000 AND 200000;
  SELECT FIRST_NAME FROM Worker WHERE WORKER_ID IN (2, 4);



  SELECT MIN(SALARY) FROM Worker;
  SELECT MAX(SALARY) FROM Worker;
  
  SELECT DEPARTMENT, FIRST_NAME, LAST_NAME, SALARY
  FROM Worker
  WHERE SALARY = (SELECT MAX(SALARY) FROM Worker);
  
  SELECT COUNT(WORKER_ID) FROM Worker;
  SELECT AVG(SALARY) FROM Worker;
  SELECT SUM(SALARY) FROM Worker;


# 2-Feb-2025 --> Day 6 : Order By, Group By and alias name and distinct 

  USE ORG123;
  SELECT DISTINCT(DEPARTMENT) FROM Worker;
  
  -- Alias Example
  SELECT WORKER_ID AS EMP_CODE FROM Worker;
  
  -- UNION Example
  SELECT WORKER_ID FROM Worker
  UNION ALL
  SELECT FIRST_NAME FROM Worker;
  
  SELECT DEPARTMENT, WORKER_ID FROM Worker WHERE SALARY = 1000000
  UNION
  SELECT DEPARTMENT, WORKER_ID FROM Worker WHERE SALARY = 2000000
  ORDER BY WORKER_ID;
  
  -- Case Statement Example
  SELECT WORKER_ID, FIRST_NAME, DEPARTMENT,
      CASE
          WHEN SALARY > 1000000 THEN 'Rich People'
          WHEN SALARY BETWEEN 500000 AND 1000000 THEN 'Middle Class'
          ELSE 'Poor People'
      END AS People_Stage
  FROM Worker;


  SELECT * FROM Worker WHERE DEPARTMENT = 'Admin' ORDER BY SALARY;
  SELECT * FROM Worker WHERE DEPARTMENT = 'Admin' ORDER BY DEPARTMENT DESC;
  SELECT * FROM Worker WHERE DEPARTMENT = 'Admin' ORDER BY DEPARTMENT DESC LIMIT 1;
  
  SELECT DEPARTMENT, COUNT(DEPARTMENT) AS TOTAL_EMPLOYEES
  FROM Worker
  WHERE DEPARTMENT IN ('HR', 'Admin')
  GROUP BY DEPARTMENT;
  
  SELECT DEPARTMENT, COUNT(DEPARTMENT) AS TOTAL_EMPLOYEES
  FROM Worker
  GROUP BY DEPARTMENT
  ORDER BY TOTAL_EMPLOYEES DESC LIMIT 2;




# SQLPractice
CREATE DATABASE ORG123;
SHOW DATABASES;
USE ORG123;

CREATE TABLE Worker (
	WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY INT(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

INSERT INTO Worker 
	(WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		(001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
		(002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
		(003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
		(004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
		(005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
		(006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
		(007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
		(008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');
select * from Worker;
select distinct (department) from worker;
select WORKER_ID as emp_code from worker;
SELECT City, Country FROM Customers
WHERE Country='Germany'
UNION
SELECT City, Country FROM Suppliers
WHERE Country='Germany'
ORDER BY City;
SELECT department, worker_id FROM worker
WHERE salary=100000
UNION
SELECT department, worker_id FROM worker
WHERE salary=200000
ORDER BY worker_id;
SELECT DEPARTMENT, WORKER_ID 
FROM Worker 
WHERE DEPARTMENT = 'HR' 

UNION 

SELECT DEPARTMENT, WORKER_ID 
FROM Worker 
WHERE DEPARTMENT ='Account';

SELECT worker_id, first_name,department,
CASE
    WHEN salary > 300000 THEN 'Rich people'
    WHEN salary <=300000 && salary >=100000 THEN 'Middle stage'
    ELSE 'Poor people'
END 
AS People_stage_wise
FROM worker;

SELECT DISTINCT DEPARTMENT, 
       (SELECT COUNT(*) FROM Worker w WHERE w.DEPARTMENT = Worker.DEPARTMENT) AS TOTAL_EMPLOYEES
FROM Worker
UNION
SELECT 'Total' AS DEPARTMENT, COUNT(*) AS TOTAL_EMPLOYEES FROM Worker;



select * from worker where department='Admin' order by department desc;

(SELECT DEPARTMENT, COUNT(*) AS TOTAL_EMPLOYEES
 FROM Worker
 GROUP BY DEPARTMENT
 ORDER BY TOTAL_EMPLOYEES DESC
 LIMIT 1)
 
UNION

(SELECT DEPARTMENT, COUNT(*) AS TOTAL_EMPLOYEES
 FROM Worker
 GROUP BY DEPARTMENT
 ORDER BY TOTAL_EMPLOYEES ASC LIMIT 1);
 
SELECT DEPARTMENT, COUNT(DEPARTMENT) AS TOTAL_EMPLOYEES  FROM Worker
GROUP BY DEPARTMENT
ORDER BY TOTAL_EMPLOYEES DESC 
LIMIT 2;

CREATE DATABASE ORG123;
SHOW DATABASES;
USE ORG123;

CREATE TABLE Worker (
	WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY INT(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

INSERT INTO Worker 
	(WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		(001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
		(002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
		(003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
		(004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
		(005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
		(006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
		(007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
		(008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');

CREATE TABLE Bonus (
	WORKER_REF_ID INT,
	BONUS_AMOUNT INT(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE);

INSERT INTO Bonus 
	(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES
		(001, 5000, '16-02-20'),
		(002, 3000, '16-06-11'),
		(003, 4000, '16-02-20'),
		(001, 4500, '16-02-20'),
		(002, 3500, '16-06-11');

SELECT * FROM Worker 
WHERE FIRST_NAME NOT IN ('Vipul', 'Satish');

SELECT * FROM Worker 
WHERE FIRST_NAME LIKE '%a';

SELECT * FROM Worker 
WHERE FIRST_NAME LIKE '_h';

SELECT DEPARTMENT, COUNT(*) AS Worker_Count 
FROM Worker 
GROUP BY DEPARTMENT 
ORDER BY Worker_Count DESC;

SELECT * FROM Worker WHERE WORKER_ID = 1
UNION ALL
SELECT * FROM Worker WHERE WORKER_ID = 1;

create table vitBhopal (id int primary key, name varchar(20) not null,
department varchar(25) not null);
insert into vitbhopal values (104,'Karthik','cs'),(103,'Arun','cs');

SELECT department, COUNT(*) AS department_count
FROM worker
GROUP BY department
ORDER BY department_count DESC
LIMIT 1 OFFSET 1;

create table vit (id int primary key, name varchar(20) not null,
college varchar(25) not null);
insert into vit values (104,'Karthik','chennai'),(103,'Arun','bhopal');
select * from vit;

select * from vitbhopal;

select name as WinnerOfTheYear from vitbhopal
where id = (select id from vit where college='bhopal');

