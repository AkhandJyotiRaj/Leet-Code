SELECT 
    visited_on,
    SUM(amount) OVER(
        ORDER BY visited_on 
        ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
    ) AS amount,
    
    ROUND(
        SUM(amount) OVER(
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) / 7, 
    2) AS average_amount

FROM
(
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
) AS daily

LIMIT 100000 OFFSET 6;