WITH ranked_scores AS (
    SELECT 
        score,
        DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
    FROM Scores
)

SELECT score, `rank`
FROM ranked_scores
ORDER BY score DESC;