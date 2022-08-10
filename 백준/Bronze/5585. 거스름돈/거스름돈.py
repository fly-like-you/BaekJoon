price = int(input())
currency = [500, 100, 50, 10, 5, 1]
count = 0
price = 1000 - price
for i in currency:
    count += price // i
    price = price % i
print(count)

