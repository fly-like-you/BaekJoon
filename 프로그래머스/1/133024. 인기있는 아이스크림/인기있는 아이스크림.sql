-- 코드를 입력하세요
-- 아이스크림의 맛을 총주문량을 기준으로 내림차순 정렬
-- 총주문량이 같다면 출하 번호를 기준으로 오름차순 정렬
SELECT FLAVOR FROM FIRST_HALF ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID;