-- 코드를 입력하세요
-- 가장 먼저 들어온 동물

SELECT a.DATETIME AS 시간
FROM ANIMAL_INS a
WHERE a.DATETIME = (
    SELECT MIN(n.DATETIME)
    FROM ANIMAL_INS n
);