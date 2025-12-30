(
    SELECT u.name AS results
    FROM users u
    JOIN movierating m
        ON u.user_id=m.user_id
    GROUP BY u.user_id
    ORDER BY COUNT(u.user_id) DESC, u.name ASC 
    LIMIT 1
)
/*First by rating count (DESC) to get user with most ratings
Then by name (ASC) to get lexicographically smallest in case of tie
*/
UNION ALL
(
    SELECT mo.title AS results
    FROM movies mo
    JOIN movierating m
        ON mo.movie_id=m.movie_id
    WHERE m.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY mo.movie_id, mo.title
    ORDER BY AVG(m.rating) DESC, mo.title ASC 
    LIMIT 1
)
/*
First by average rating (DESC) to get highest rated movie
Then by title (ASC) to get lexicographically smallest in case of tie
*/