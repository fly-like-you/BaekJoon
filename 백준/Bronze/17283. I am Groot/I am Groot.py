L = int(input())
R = int(input())

sum = 0
lench = 2
while True:

    length = int(L * (R / 100))
    L = length
    if L <= 5:
        break
    sum += length * lench
    lench *= 2


print(sum)