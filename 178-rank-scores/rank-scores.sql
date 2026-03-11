# Write your MySQL query statement below

WITH UniqueScores AS (
    SELECT DISTINCT score
    FROM Scores
)
 select score,Dense_rank() over (order by score desc) as "rank" 
 from scores;