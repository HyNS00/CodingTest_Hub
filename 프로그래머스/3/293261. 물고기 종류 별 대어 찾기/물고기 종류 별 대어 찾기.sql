-- 코드를 작성해주세요

-- 물고기 정보 FISH_INFO
-- 물고기 이름 FISH_NAME


/*
일단 그룹 별로 가장 큰거 번호 찾고 그거랑 FISH_NAME이랑 join?
하지만 집계함수는 id를 가져오지 않는다 . 따라서 서브 쿼리를 사용한다.
*/


SELECT i.ID, n.FISH_NAME, i.LENGTH
FROM FISH_INFO i
JOIN FISH_NAME_INFO n
ON i.FISH_TYPE = n.FISH_TYPE
WHERE (i.FISH_TYPE, i.LENGTH) IN 
(
    SELECT s.FISH_TYPE, MAX(s.LENGTH)
    FROM FISH_INFO s
    GROUP BY s.FISH_TYPE
)
ORDER BY i.ID;
