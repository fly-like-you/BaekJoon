def fac(num):
    factorial = 1
    if num == 1:
        return 1
    while True:
        if num == 0: break
        factorial *= num
        num -= 1
    return factorial
a = list(str(fac(int(input()))))
count = 0
for i in range(len(a) - 1, -1, -1):
    if a[i] == '0':
        count += 1
    else:
        break
print(count)
