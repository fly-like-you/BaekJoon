import sys
N,M = map(int, input().split())
neverSeenList = set()
neverHeardList = set()
for i in range(N):
    neverHeardList.add(sys.stdin.readline().rstrip())
for i in range(M):
    neverSeenList.add(sys.stdin.readline().rstrip())

neverSeenHeardList = list(neverHeardList.intersection(neverSeenList))
neverSeenHeardList.sort()
print(len(neverSeenHeardList))
for i in neverSeenHeardList:
    print(i)