stairPointList = []
stairDpList = []
N = int(input())
for i in range(N):
    stairPointList.append(int(input()))

    
stairDpList.append(stairPointList[0])
if N == 1:
    print(stairDpList.pop())
    exit()
stairDpList.append(stairPointList[0] + stairPointList[1])
if N == 2:
    print(stairDpList.pop())
    exit()
stairDpList.append(max(stairPointList[0]+stairPointList[2],stairPointList[1]+stairPointList[2]))
if N == 3:
    print(stairDpList.pop())
    exit()
for i in range(3, N):
    stairDpList.append(max(stairDpList[i-2]+stairPointList[i],
                           stairDpList[i-3]+stairPointList[i-1]+stairPointList[i]))
print(stairDpList.pop())