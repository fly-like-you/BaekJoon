number1 = int(input())
for J in range(number1):
    a = input()
    inspectList = list(a)
    sum = 0
    for i in inspectList:
        if i == '(':
            sum += 1
        elif i == ')':
            sum -= 1
        if sum < 0:
            print("NO")
            break
    if sum == 0:
        print("YES")
    elif sum > 0:
        print("NO")


