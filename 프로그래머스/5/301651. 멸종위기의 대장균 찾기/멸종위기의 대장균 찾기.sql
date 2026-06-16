-- 코드를 작성해주세요
WITH RECURSIVE CHILD_T AS (

    -- 초기 테이블 만들기
    SELECT ID, PARENT_ID, 1 AS CHILD FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL -- 밑에 재귀문을 반복적으로 실행해서 아래에 붙여야하니까 .
    
    -- 재귀문 , 재귀 쿼리의 반복 루프가 '방금 전 단계에서 새로 찾은 데이터'만을 대상으로 실행된다.
    SELECT E.ID,E.PARENT_ID, T.CHILD +1
    FROM ECOLI_DATA E JOIN CHILD_T T ON
    T.ID = E.PARENT_ID
)


-- SELECT * FROM CHILD_T; 
-- 자식이 없는 걸 골라야한다. 즉 PARENT_ID가 null이 아니다.
SELECT COUNT(CHILD) AS COUNT, t.CHILD
FROM CHILD_T t
-- NOT IN 걸어서 자식이 있는 부모가 아님 == 자식이 없는 부모
WHERE t.ID NOT IN (
    -- 자식이 있는 부모만 뽑음
    SELECT h.PARENT_ID
    FROM CHILD_T h
    WHERE h.PARENT_ID IS NOT NULL
    
)
GROUP BY t.CHILD
ORDER BY t.CHILD;