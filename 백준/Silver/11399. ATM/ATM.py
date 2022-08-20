import sys

N = int(input())
PList = list(map(int, sys.stdin.readline().rstrip().split()))

PList.sort()
sumi = 0
sumList = []
for i in PList:
    sumi += i
    sumList.append(sumi)


print(sum(sumList))