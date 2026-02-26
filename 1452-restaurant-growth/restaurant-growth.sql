# Write your MySQL query statement below

select
t2.visited_on
,sum(c.amount) amount
,round(sum(c.amount)/count(distinct c.visited_on),2) average_amount
from 
(
select visited_on from (
    select
    lead(visited_on,6) over(order by visited_on) as visited_on
    from Customer 
    where visited_on is not null
    group by visited_on
    ) t1
where visited_on is not null
) t2
left join Customer c
on c.visited_on between subdate(t2.visited_on,6) and t2.visited_on 
group by t2.visited_on