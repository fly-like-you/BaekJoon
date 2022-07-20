def getEachNum(num):
    divid = 10
    listNum = []
    while True:
        if num == 0:
            break
        listNum.append(num % 10)
        num = num // divid
    listNum.reverse()
    return listNum

def creator(num):
    numList = getEachNum(num)
    return sum(numList) + num

N = int(input())
nList = getEachNum(N)

creatorList = []
for i in range(N+1):
    if creator(i) == N:
        creatorList.append(i)
if creatorList != []:
    print(min(creatorList))
else:
    print(0)

