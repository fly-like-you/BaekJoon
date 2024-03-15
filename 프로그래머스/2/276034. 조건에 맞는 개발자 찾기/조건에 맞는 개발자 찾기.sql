-- 테이블에서 Python이나 C# 스킬을 가진 개발자의 정보를 조회
-- 결과는 ID를 기준으로 오름차순 정렬
-- 개발자의 ID, 이메일, 이름, 성을 조회
-- CONV(15, 10, 2) 십진수 15를 2진수로 변환

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE 
(
    SELECT SUM(CODE)
    FROM SKILLCODES
    WHERE NAME = 'C#'
) & SKILL_CODE
OR
(
    SELECT SUM(CODE)
    FROM SKILLCODES
    WHERE NAME = 'Python'
) & SKILL_CODE
ORDER BY ID;