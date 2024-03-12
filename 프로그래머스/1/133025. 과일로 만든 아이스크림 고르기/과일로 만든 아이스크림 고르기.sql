-- 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회
SELECT f.FLAVOR
FROM FIRST_HALF f
WHERE f.TOTAL_ORDER > 3000 and f.FLAVOR IN (SELECT i.FLAVOR FROM ICECREAM_INFO i WHERE i.INGREDIENT_TYPE = 'fruit_based')