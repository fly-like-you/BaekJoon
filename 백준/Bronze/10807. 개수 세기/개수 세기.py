num1 = int(input())

numList = list(map(int, input().split()))
findNum = int(input())
count = 0
for i in numList:
    if i == findNum:
        count+=1
        
print(count)