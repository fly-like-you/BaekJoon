string = input().split("-")
sum = 0
temp = []
for index, key in enumerate(string):
    if index >= 1:
        temp = list(key.split("+"))
        for i in temp:
            sum -= int(i)
    else:
        temp = list(key.split("+"))
        for i in temp:
            sum += int(i)
print(sum)