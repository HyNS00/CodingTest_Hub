-- 코드를 작성해주세요

-- self join 
SELECT e.ID, COUNT(c.PARENT_ID) AS CHILD_COUNT
FROM ECOLI_DATA e
LEFT OUTER JOIN ECOLI_DATA c ON e.ID = c.PARENT_ID
-- 값이 여러개니까 즉 겹치는 행 있으니 묶어준다.
GROUP BY e.ID
ORDER BY e.ID;