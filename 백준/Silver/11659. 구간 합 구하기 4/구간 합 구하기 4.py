import sys
N,M = map(int, sys.stdin.readline().rstrip().split())

sumList = []
sum = 0

numList = list(map(int, sys.stdin.readline().rstrip().split()))
numList.insert(0,0)

for i in range(N+1):
    sum += numList[i]
    sumList.append(sum)

for i in range(M):
    a,b = map(int, sys.stdin.readline().rstrip().split())
    print(sumList[b] - sumList[a-1])
