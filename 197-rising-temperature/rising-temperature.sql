# Write your MySQL query statement below

select id as Id
from (select *,lag(temperature,1) over(order by recordDate) as lagtemp,
lag(recordDate,1) over(order by recordDate) as prevdate
from weather) as newtable
where temperature > lagtemp
and datediff(recordDate, prevdate) = 1
