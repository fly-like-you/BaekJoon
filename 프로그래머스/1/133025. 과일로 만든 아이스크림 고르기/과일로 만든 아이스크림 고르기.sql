-- 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회
SELECT i.FLAVOR
FROM FIRST_HALF f INNER JOIN ICECREAM_INFO i
ON f.FLAVOR = i.FLAVOR
WHERE f.TOTAL_ORDER > 3000 AND i.INGREDIENT_TYPE = 'fruit_based';