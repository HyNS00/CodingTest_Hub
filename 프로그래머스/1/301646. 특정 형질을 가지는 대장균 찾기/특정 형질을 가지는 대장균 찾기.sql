-- 코드를 작성해주세요
-- 이진수 비교는 & 로 하자 그리고 숫자를 그대로 가지고 오자.

SELECT COUNT(*) AS COUNT FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0 
AND (
    (GENOTYPE & 1) > 0 
    OR
    (GENOTYPE & 3) > 0
    OR(GENOTYPE & 5) > 0
);