import sys

def spendTime(height, list, inventory):
    digging = 0
    covering = 0
    for i in range(len(list)): # 땅파는 시간
        for j in range(len(list[i])):
            if list[i][j] > height:
                digging += list[i][j] - height
            elif list[i][j] < height:
                covering += height - list[i][j]
    if digging + inventory < covering:
        return sys.maxsize
    else:
        return digging * 2 + covering

N, M, B = map(int, input().split())
bitMap = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
minHeight = min(map(min, bitMap))
maxHeight = max(map(max,bitMap))
minTime = spendTime(minHeight, bitMap,B)
height = minHeight
for i in range(minHeight+1, maxHeight+1):
    temp = spendTime(i, bitMap,B)
    if temp <= minTime:
        minTime = temp
        height = i


print(minTime, height)
