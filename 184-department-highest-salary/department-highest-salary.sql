# Write your MySQL query statement below
SELECT d.name as department,
    e.name as employee,
    e.salary as salary

From employee e
JOIN department d ON e.departmentid = d.id
where e.salary = (
    select max(salary)
    from employee
    where departmentid = e.departmentid
);