
-- employees who makes less than 30000 and there managers <> employee_id 

SELECT 
    e.employee_id
FROM 
    employees e
LEFT JOIN 
    employees m 
ON 
    e.manager_id = m.employee_id 
WHERE 
    m.employee_id IS NULL 
AND 
    e.salary < 30000
AND 
    e.manager_id IS NOT NULL 
ORDER BY 
    employee_id