-- 중성화: Spayed 또는 Neutered 중성화 안함: Intact
-- 보호소에 들어올 당시에는 중성화되지 않았지만 (ANIMAL_INS에는 중성화지만)
-- 보호소를 나갈 당시에는 중성화된 동물의 (ANIMAL_OUTS에는 중성화 TRUE)
-- 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회
SELECT 
    I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM 
    ANIMAL_INS I INNER JOIN ANIMAL_OUTS O
ON 
    I.ANIMAL_ID = O.ANIMAL_ID
WHERE 
    I.SEX_UPON_INTAKE != O.SEX_UPON_OUTCOME
    
ORDER BY 
    I.ANIMAL_ID