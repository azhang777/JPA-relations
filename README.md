# sample concert-API, Many to Many relationship
![image](https://github.com/azhang777/concert-API/assets/67079259/c2b5d688-91a7-437f-a6a0-de4ca2e45ae7)

# Following Tables

## Employee
| Id   | Name              | Department | Salary | Gender | Age | City   |
|------|-------------------|------------|--------|--------|-----|--------|
| 1001 | John Doe          | IT         | 35000  | Male   | 25  | London |
| 1002 | Mary Smith        | HR         | 45000  | Female | 27  | London |
| 1003 | James Brown       | Finance    | 50000  | Male   | 28  | London |
| 1004 | Mike Walker       | Finance    | 50000  | Male   | 28  | London |
| 1005 | Linda Jones       | HR         | 75000  | Female | 26  | London |
| 1006 | Anurag Mohanty    | IT         | 35000  | Male   | 25  | Mumbai |
| 1007 | Priyanla Dewangan | HR         | 45000  | Female | 27  | Mumbai |
| 1008 | Sambit Mohanty    | IT         | 50000  | Male   | 28  | Mumbai |
| 1009 | Pranaya Kumar     | IT         | 50000  | Male   | 28  | Mumbai |
| 1010 | Hina Sharma       | HR         | 75000  | Female | 26  | Mumbai |

## Projects
| ProjectId | Title                                                | ClientId | EmployeeId | StartDate           | EndDate             |
|-----------|------------------------------------------------------|----------|------------|---------------------|---------------------|
| 1         | Develop e-commerce website from scratch             | 1        | 1003       | 2023-11-11 22:20:14 | 2023-12-11 22:20:14 |
| 2         | WordPress website for our company                  | 1        | 1002       | 2023-11-11 22:20:14 | 2023-12-26 22:20:14 |
| 3         | Manage our company servers                         | 2        | 1007       | 2023-11-11 22:20:14 | 2023-12-26 22:20:14 |
| 4         | Hosting account is not working                     | 3        | 1009       | 2023-11-11 22:20:14 | 2023-11-18 22:20:14 |
| 5         | MySQL database from my desktop application         | 4        | 1010       | 2023-11-11 22:20:14 | 2023-11-26 22:20:14 |
| 6         | Develop new WordPress plugin for my business website| 2        | NULL       | 2023-11-11 22:20:14 | 2023-11-21 22:20:14 |
| 7         | Migrate web application and database to new server | 2        | NULL       | 2023-11-11 22:20:14 | 2023-11-16 22:20:14 |
| 8         | Android Application development                    | 4        | 1004       | 2023-11-11 22:20:14 | 2023-12-11 22:20:14 |
| 9         | Hosting account is not working                     | 3        | 1001       | 2023-11-11 22:20:14 | 2023-11-18 22:20:14 |
| 10        | MySQL database from my desktop application         | 4        | 1008       | 2023-11-11 22:20:14 | 2023-11-26 22:20:14 |
| 11        | Develop new WordPress plugin for my business website| 2        | NULL       | 2023-11-11 22:20:14 | 2023-11-21 22:20:14 |

## Queries
```
SELECT Id as EmployeeID, Name, Department, City, Title as Project, ClientId
FROM Employee 
INNER JOIN Projects 
ON Employee.Id = Projects.EmployeeId;
```
| EmployeeID | Name              | Department | City   | Project                                    | ClientId |
|------------|-------------------|------------|--------|--------------------------------------------|----------|
| 1001       | John Doe          | IT         | London | Hosting account is not working             | 3        |
| 1002       | Mary Smith        | HR         | London | WordPress website for our company          | 1        |
| 1003       | James Brown       | Finance    | London | Develop e-commerce website from scratch    | 1        |
| 1004       | Mike Walker       | Finance    | London | Android Application development            | 4        |
| 1007       | Priyanla Dewangan | HR         | Mumbai | Manage our company servers                 | 2        |
| 1008       | Sambit Mohanty    | IT         | Mumbai | MySQL database from my desktop application | 4        |
| 1009       | Pranaya Kumar     | IT         | Mumbai | Hosting account is not working             | 3        |
| 1010       | Hina Sharma       | HR         | Mumbai | MySQL database from my desktop application | 4        |

```
SELECT Id as EmployeeID, Name, Department, City, Title as Project, ClientId
FROM Employee 
LEFT OUTER JOIN Projects 
ON Employee.Id = Projects.EmployeeId;
```
| EmployeeID | Name              | Department | City   | Project                                    | ClientId |
|------------|-------------------|------------|--------|--------------------------------------------|----------|
| 1001       | John Doe          | IT         | London | Hosting account is not working             | 3        |
| 1002       | Mary Smith        | HR         | London | WordPress website for our company          | 1        |
| 1003       | James Brown       | Finance    | London | Develop e-commerce website from scratch    | 1        |
| 1004       | Mike Walker       | Finance    | London | Android Application development            | 4        |
| 1005       | Linda Jones       | HR         | London | NULL                                       | NULL     |
| 1006       | Anurag Mohanty    | IT         | Mumbai | NULL                                       | NULL     |
| 1007       | Priyanla Dewangan | HR         | Mumbai | Manage our company servers                 | 2        |
| 1008       | Sambit Mohanty    | IT         | Mumbai | MySQL database from my desktop application | 4        |
| 1009       | Pranaya Kumar     | IT         | Mumbai | Hosting account is not working             | 3        |
| 1010       | Hina Sharma       | HR         | Mumbai | MySQL database from my desktop application | 4        |

```
SELECT Employee.Id as EmployeeId, Name, Department, City, Title as Project
FROM Employee 
RIGHT OUTER JOIN Projects 
ON Employee.Id = Projects.EmployeeId;
```
| EmployeeId | Name              | Department | City   | Project                                              |
|------------|-------------------|------------|--------|------------------------------------------------------|
| 1003       | James Brown       | Finance    | London | Develop e-commerce website from scratch               |
| 1002       | Mary Smith        | HR         | London | WordPress website for our company                    |
| 1007       | Priyanla Dewangan | HR         | Mumbai | Manage our company servers                           |
| 1009       | Pranaya Kumar     | IT         | Mumbai | Hosting account is not working                       |
| 1010       | Hina Sharma       | HR         | Mumbai | MySQL database from my desktop application           |
| NULL       | NULL              | NULL       | NULL   | Develop new WordPress plugin for my business website |
| NULL       | NULL              | NULL       | NULL   | Migrate web application and database to new server   |
| 1004       | Mike Walker       | Finance    | London | Android Application development                      |
| 1001       | John Doe          | IT         | London | Hosting account is not working                       |
| 1008       | Sambit Mohanty    | IT         | Mumbai | MySQL database from my desktop application           |
| NULL       | NULL              | NULL       | NULL   | Develop new WordPress plugin for my business website |

