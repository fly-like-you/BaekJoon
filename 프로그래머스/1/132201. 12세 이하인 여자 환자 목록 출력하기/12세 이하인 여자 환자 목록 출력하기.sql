-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(TLNO, 'NONE') AS TLNO FROM PATIENT WHERE GEND_CD = "W" AND AGE <= 12 ORDER BY AGE DESC, PT_NAME ASC;

# SELECT pt_name, pt_no, gend_cd, age, ifnull(tlno, 'NONE') from patient
# where age <= 12 and gend_cd = 'W'
# order by age desc, pt_name asc