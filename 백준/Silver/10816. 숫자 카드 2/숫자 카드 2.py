import sys
n = int(sys.stdin.readline().rstrip())
userCardList = sorted(list(map(int, sys.stdin.readline().rstrip().split())))
m = int(sys.stdin.readline().rstrip())
cardList = list(map(int, sys.stdin.readline().rstrip().split()))


cardDic = {}

for i in userCardList:
    if i not in cardDic:
        cardDic[i] = 1
    else:
        cardDic[i] += 1

for i in cardList:
    if i not in cardDic.keys():
        print(0, end=' ')
    else:
        print(cardDic[i], end=' ')