-- 코드를 작성해주세요
-- 10cm 이하 일 경우에는 LENGTH가 NULL 이다. 
-- LENGHT 에 NULL만 있는 경우는 없다.

SELECT CONCAT(MAX(LENGTH) , 'cm') AS MAX_LENGTH
FROM FISH_INFO;